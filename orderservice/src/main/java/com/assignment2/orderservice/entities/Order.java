package com.assignment2.orderservice.entities;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("order")
public class Order {
    
    @Id
    @Field("_id")
    private int orderId;

    @Field("user_id")
    private int userId;
    
    @Field("user_emails")
    private String[] userEmails;

    @Field("delivery_address")
    private DeliveryAddress deliveryAddress;
    
    @Field("order_status")
    private String orderStatus;

    private Item[] items;

    public Order(int userId, String[] userEmails, DeliveryAddress deliveryAddress, String orderStatus,
            Item[] items) {
        this.userId = userId;
        this.userEmails = userEmails;
        this.deliveryAddress = deliveryAddress;
        this.orderStatus = orderStatus;
        this.items = items;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public String[] getUserEmails() {
        return userEmails;
    }

    public void setUserEmails(String[] userEmails) {
        this.userEmails = userEmails;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", items=" + Arrays.toString(items) + "]";
    }
}
