package com.quantumbookstore.model;

import com.quantumbookstore.service.ShippingService;

public class PaperBook extends Book {
    private int stock;
    private ShippingService shippingService;

    public PaperBook(String isbn, String title, String author, int publishYear, double price, int stock) {
        super(isbn, title, author, publishYear, price);
        this.stock = stock;
        this.shippingService = new ShippingService();
    }

    @Override
    protected boolean canPurchase(int quantity) {
        return stock >= quantity;
    }

    @Override
    protected void updateInventory(int quantity) {
        if (quantity > stock)
            throw new RuntimeException("Quantum book store: Not enough stock for ISBN " + isbn);
        stock -= quantity;
    }

    @Override
    protected void deliverProduct(String email, String address) {
        shippingService.ship(this, address);
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Stock: %d", stock);
    }
}
