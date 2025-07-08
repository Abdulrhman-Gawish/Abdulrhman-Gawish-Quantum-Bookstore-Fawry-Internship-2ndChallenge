package com.quantumbookstore.service;

import com.quantumbookstore.model.EBook;

public class MailService {
    public void sendEmail(EBook book, String email) {
        System.out.println("Quantum book store: Sending " + book.getTitle() + " to email: " + email);
    }
}