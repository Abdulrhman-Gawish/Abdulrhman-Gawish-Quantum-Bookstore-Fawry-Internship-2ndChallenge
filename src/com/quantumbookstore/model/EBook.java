package com.quantumbookstore.model;

import com.quantumbookstore.service.MailService;

public class EBook extends Book {
    private String fileType;
    private MailService mailService;

    public EBook(String isbn, String title, String author, int publishYear, double price, String fileType) {
        super(isbn, title, author, publishYear, price);
        this.fileType = fileType;
        this.mailService = new MailService();
    }

    @Override
    protected boolean canPurchase(int quantity) {
        return quantity > 0;
    }

    @Override
    protected void updateInventory(int quantity) {
        // updateInventory method not needed for digital Books
    }

    @Override
    protected void deliverProduct(String email, String address) {
        mailService.sendEmail(this, email);
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File Type: %s", fileType);
    }
}

