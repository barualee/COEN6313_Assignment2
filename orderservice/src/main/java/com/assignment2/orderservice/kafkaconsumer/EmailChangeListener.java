package com.assignment2.orderservice.kafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.assignment2.orderservice.entities.EmailsChangeMsg;
import com.assignment2.orderservice.order.OrderService;

@EnableKafka
@Service
public class EmailChangeListener {
    
    @Autowired
    private OrderService orderService;

    @KafkaListener(
    topics = "userEmailChange", 
    containerFactory = "kafkaListenerContainerFactoryEmailsChange")
    public void addressChangeListener(EmailsChangeMsg emailsChangeMsg) {
        System.out.println("Received Message: ["+emailsChangeMsg.toString()+"]");
        orderService.updateOrderEmails(emailsChangeMsg.getUserId(), emailsChangeMsg.getEmails());
    }
}
