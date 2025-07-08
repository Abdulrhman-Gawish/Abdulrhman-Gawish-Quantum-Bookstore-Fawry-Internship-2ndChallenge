package com.quantumbookstore.model;

public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, String author, int publishYear) {
        super(isbn, title, author, publishYear, 0.0);
    }

    @Override
    protected boolean canPurchase(int quantity) {
        return false;
    }

    @Override
    protected void updateInventory(int quantity) {
        // updateInventory not needed
    }

    @Override
    protected void deliverProduct(String email, String address) {
        // No delivery for showcase books
    }

    @Override
    public String toString() {
        return super.toString() + " ShowCase - Not for sale ";
    }
}