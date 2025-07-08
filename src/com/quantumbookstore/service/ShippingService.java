package com.quantumbookstore.service;

import com.quantumbookstore.model.PaperBook;

public class ShippingService {
    public void ship(PaperBook book, String address) {
        System.out.println("Quantum book store: Shipping " + book.getTitle() + " to address: " + address);
    }
}
