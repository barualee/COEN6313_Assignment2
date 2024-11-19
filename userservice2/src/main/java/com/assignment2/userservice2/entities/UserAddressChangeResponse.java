package com.assignment2.userservice2.entities;

public class UserAddressChangeResponse {
    private int userId;
    private DeliveryAddress deliveryAddress;
    
    public UserAddressChangeResponse(int userId, DeliveryAddress deliveryAddress) {
        this.userId = userId;
        this.deliveryAddress = deliveryAddress;
    }
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    @Override
    public String toString() {
        return "UserAddressChangeResponse [userId=" + userId + ", deliveryAddress=" + deliveryAddress + "]";
    }
}
