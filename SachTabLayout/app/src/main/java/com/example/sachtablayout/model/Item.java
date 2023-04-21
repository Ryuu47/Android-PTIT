package com.example.sachtablayout.model;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String title, author, category, date;
    private int price;

    public Item() {
    }

    public Item(int id, String title, String author, String category, int price, String date) {
        this.id = id;
        this.title = title;
        this.author= author;
        this.category = category;
        this.price = price;
        this.date = date;
    }

    public Item(String title, String author, String category, int price, String date) {
        this.title = title;
        this.author= author;
        this.category = category;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
