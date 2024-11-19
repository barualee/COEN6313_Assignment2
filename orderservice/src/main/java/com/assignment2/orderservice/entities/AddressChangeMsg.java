package com.assignment2.orderservice.entities;

public class AddressChangeMsg {
    private int userId;
    private DeliveryAddress deliveryAddress;
    
    public AddressChangeMsg() {
    }

    public AddressChangeMsg(int userId, DeliveryAddress deliveryAddress) {
        this.userId = userId;
        this.deliveryAddress = deliveryAddress;
    }

    public int getUserId() {
        return userId;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public String toString() {
        return "AddressChangeMsg [userId=" + userId + ", deliveryAddress=" + deliveryAddress + "]";
    }
}

