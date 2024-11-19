package com._assignment2.userservice1.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("user")
public class User {

    @Id
    @Field("_id")
    private int userId;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    private String[] emails;

    @Field("delivery_address")
    private DeliveryAddress deliveryAddress;

    public User(int userId, String firstName, String lastName, String[] emails, DeliveryAddress deliveryAddress) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emails = emails;
        this.deliveryAddress = deliveryAddress;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    
}
