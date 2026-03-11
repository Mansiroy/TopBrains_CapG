package com.cg.bean;

public class Book {
    private int isbn;
    private String title;
    private double price;
    private int authorId;

    public Book(int isbn, String title, double price, int authorId) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authorId = authorId;
    }

    public int getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public int getAuthorId() { return authorId; }
}