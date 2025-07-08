package com.quantumbookstore.model;

import java.time.LocalDate;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int publishYear;
    protected double price;

    public Book(String isbn, String title, String author, int publishYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
    }

    protected abstract boolean canPurchase(int quantity);

    protected abstract void updateInventory(int quantity);

    protected abstract void deliverProduct(String email, String address);

    protected double calculateTotal(int quantity) {
        return price * quantity;
    }

    public final double processPurchase(int quantity, String email, String address) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantum book store: Cannot purchase " + quantity + " copies of " + title);
        }
        if (!canPurchase(quantity)) {
            throw new IllegalArgumentException("Quantum book store: Cannot purchase " + quantity + " copies of " + title);
        }

        double totalAmount = calculateTotal(quantity);
        updateInventory(quantity);
        deliverProduct(email, address);

        return totalAmount;
    }


    public boolean isOutdated(int years) {
        return LocalDate.now().getYear() - publishYear > years;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s, Title: %s, Author: %s, Year: %d, Price: $%.2f",
                isbn, title, author, publishYear, price);
    }
}
