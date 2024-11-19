package com.assignment2.orderservice.entities;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class DeliveryAddress {

    public String street;
    public String city;
    public String state;
    public String zip_code;
    public String country;

    public DeliveryAddress() {
    }

    public DeliveryAddress(String street, String city, String state, String zip_code, String country) {
      this.street = street;
      this.city = city;
      this.state = state;
      this.zip_code = zip_code;
      this.country = country;
    }

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public String getZip_code() {
      return zip_code;
    }

    public void setZip_code(String zip_code) {
      this.zip_code = zip_code;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    @Override
    public String toString() {
      return "delivery_address [street=" + street + ", city=" + city + ", state=" + state + ", zip_code=" + zip_code
          + ", country=" + country + "]";
    }
    
}

