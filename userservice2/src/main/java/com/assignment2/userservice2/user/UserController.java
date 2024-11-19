package com.assignment2.userservice2.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment2.userservice2.entities.DeliveryAddress;
import com.assignment2.userservice2.entities.User;
import com.assignment2.userservice2.entities.UserAddressChangeResponse;
import com.assignment2.userservice2.entities.UserEmailChangeResponse;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    @ResponseBody
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}")
    @ResponseBody
    public User getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createUser")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updateUserAddress/{userId}")
    @ResponseBody
    public UserAddressChangeResponse updateAddress(@PathVariable int userId, @RequestBody DeliveryAddress address) {
        return userService.updateUserAddress(userId, address);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updateUserEmail/{userId}")
    @ResponseBody
    public UserEmailChangeResponse updateUserEmail(@PathVariable int userId, @RequestParam String oldEmail, @RequestParam String newEmail) {
        return userService.updateEmailAddress(userId, oldEmail, newEmail);
    }
}

