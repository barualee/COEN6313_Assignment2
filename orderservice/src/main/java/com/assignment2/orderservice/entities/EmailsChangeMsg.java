package com.assignment2.orderservice.entities;

import java.util.Arrays;

public class EmailsChangeMsg {
    private int userId;
    private String[] emails;
    
    public EmailsChangeMsg() {
    }

    public EmailsChangeMsg(int userId, String[] emails) {
        this.userId = userId;
        this.emails = emails;
    }

    public int getUserId() {
        return userId;
    }

    public String[] getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        return "EmailsChangeMsg [userId=" + userId + ", emails=" + Arrays.toString(emails) + "]";
    }
}

