package com.assignment2.userservice2.entities;

import java.util.Arrays;

public class UserEmailChangeResponse {
    private int userId;
    private String[] emails;
    
    public UserEmailChangeResponse(int userId, String[] emails) {
        this.userId = userId;
        this.emails = emails;
    }
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String[] getEmails() {
        return emails;
    }
    public void setEmails(String[] emails) {
        this.emails = emails;
    }
    @Override
    public String toString() {
        return "UserEmailChangeResponse [userId=" + userId + ", emails=" + Arrays.toString(emails) + "]";
    }
}
