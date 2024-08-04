package com.example.phonestoreapp;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String whatsappContact;
    private String phoneContact;

    public Product(int id, String name, String description, double price, String imageUrl, String whatsappContact, String phoneContact) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.whatsappContact = whatsappContact;
        this.phoneContact = phoneContact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getWhatsappContact() {
        return whatsappContact;
    }

    public String getPhoneContact() {
        return phoneContact;
    }
}
