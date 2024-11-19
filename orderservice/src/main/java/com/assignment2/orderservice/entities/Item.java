package com.assignment2.orderservice.entities;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class Item {

    private String item_id;
    private String name;
    private int quantity;
    private double price;
    public Item(String item_id, String name, int quantity, double price) {
        this.item_id = item_id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String getItem_id() {
        return item_id;
    }
    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Item [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
