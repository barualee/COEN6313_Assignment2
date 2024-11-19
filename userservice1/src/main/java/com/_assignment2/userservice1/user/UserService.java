package com._assignment2.userservice1.user;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com._assignment2.userservice1.entities.AddressChangeMsg;
import com._assignment2.userservice1.entities.DeliveryAddress;
import com._assignment2.userservice1.entities.EmailsChangeMsg;
import com._assignment2.userservice1.entities.User;
import com._assignment2.userservice1.errorhandling.AlreadyExistsException;
import com._assignment2.userservice1.errorhandling.NotFoundException;


@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, AddressChangeMsg> kafkaTemplateAddressChange;

    @Autowired
    private KafkaTemplate<String, EmailsChangeMsg> kafkaTemplateEmailsChange;
    
    public User getUser(int userId){
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new NotFoundException("User with ID: "+userId+" not found");
        }
        return userOptional.get();
    }

    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();

        if(userList.size() == 0){
            throw new NotFoundException("Users not found");
        }
        return userList;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User createUser(User user){
        Optional<User> fetchUser = userRepository.findById(user.getUserId());

        if (fetchUser.isEmpty()){
            return saveUser(user);
        }
        throw new AlreadyExistsException("User with ID: "+user.getUserId()+" already exist");
    }

    public User updateUserAddress(int userId, DeliveryAddress deliveryAddress) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            User fetchUser = user.get();
            fetchUser.setDeliveryAddress(deliveryAddress);
            
            //send the message to broker
            sendAddressChangeMessage(userId, deliveryAddress);

            return saveUser(fetchUser);
        }
        throw new NotFoundException("User with ID: "+userId+" not found");
    }

    public User updateEmailAddress(int userId, String oldEmail, String newEmail) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            User fetchUser = user.get();
            String[] emailList = fetchUser.getEmails();
            
            if(emailList.length > 0){
                for(int i=0;i<emailList.length;i++){
                    if(emailList[i].equals(oldEmail)){
                        emailList[i] = newEmail;
                        fetchUser.setEmails(emailList);
                        
                        //send the message
                        sendEmailsChangeMessage(userId, fetchUser.getEmails());
                        return saveUser(fetchUser);
                    }
                }
                throw new NotFoundException("User with ID: "+userId+" does not have email: "+oldEmail);
            } else {
                String[] newList = new String[]{newEmail};
                emailList = newList;
                
                fetchUser.setEmails(emailList);
                return saveUser(fetchUser);
            }
        }
        throw new NotFoundException("User with ID: "+userId+" not found");
    }

    private void sendAddressChangeMessage(Integer user_id, DeliveryAddress newDeliveryAddress) {
        
        CompletableFuture<SendResult<String, AddressChangeMsg>> future = kafkaTemplateAddressChange.send("userDeliveryAddressChange", new AddressChangeMsg(user_id, newDeliveryAddress));
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + new AddressChangeMsg(user_id, newDeliveryAddress).toString() + 
                    "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + 
                    new AddressChangeMsg(user_id, newDeliveryAddress).toString()  + "] due to : " + ex.getMessage());
            }
        });
    }

    private void sendEmailsChangeMessage(Integer user_id, String[] newEmails) {
        
        CompletableFuture<SendResult<String, EmailsChangeMsg>> future = kafkaTemplateEmailsChange.send("userEmailChange", new EmailsChangeMsg(user_id, newEmails));
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + new EmailsChangeMsg(user_id, newEmails).toString() + 
                    "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + 
                    new EmailsChangeMsg(user_id, newEmails).toString()  + "] due to : " + ex.getMessage());
            }
        });
    }
}

