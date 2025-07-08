package com.quantumbookstore.test;

import com.quantumbookstore.model.EBook;
import com.quantumbookstore.model.PaperBook;
import com.quantumbookstore.model.ShowcaseBook;
import com.quantumbookstore.store.BookStore;

public class QuantumBookstoreFullTest {

    BookStore store = new BookStore();

    public void runAllTests() {
        System.out.println("Quantum book store: Starting comprehensive tests...\n");

        testAddingBooks();
        testBuyingBooks();
        testRemovingOutdatedBooks();
        testEdgeCases();

        System.out.println("Quantum book store: All tests completed!\n");
    }

    private void testAddingBooks() {
        System.out.println("Quantum book store: Testing adding books...");

        // Create different types of books
        PaperBook paperBook = new PaperBook("PB100", "Java Fundamentals", "X", 2020, 2000, 10);
        EBook eBook = new EBook("EB200", "Clean Code", "Y", 2019, 2000, "pdf");
        ShowcaseBook demoBook = new ShowcaseBook("SB300", "AI Research", "Z", 2021);

        store.addBook(paperBook);
        store.addBook(eBook);
        store.addBook(demoBook);

        System.out.println("Quantum book store: Testing adding books completed");

        store.displayInventory();
        System.out.println();
    }

    private void testBuyingBooks() {
        System.out.println("Quantum book store: Testing buying books...");

        try {
            // Buy paper book
            double amount1 = store.buyBook("PB100", 2, "gawishh@gmail.com", "Cairo, Egypt");
            System.out.println("Quantum book store: Payment received: $" + String.format("%.2f", amount1));

            // Buy eBook
            double amount2 = store.buyBook("EB200", 1, "gawishh@gmail.com", "Cairo");
            System.out.println("Quantum book store: Payment received: $" + String.format("%.2f", amount2));

            // Try to buy showcase book (should fail) because SB3000 not valid isbn
            try {
                store.buyBook("SB3000", 1, "gawishh@gmail.com", "Cairo");
            } catch (IllegalArgumentException e) {
                System.out.println("Quantum book store: Expected error caught: " + e.getMessage());
            }

            // Try to buy more than available stock
            try {
                store.buyBook("PB100", 22, "gawishh@gmail.com", "Giza");
            } catch (IllegalArgumentException e) {
                System.out.println("Quantum book store: Expected error caught: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Quantum book store: Unexpected error: " + e.getMessage());
        }
        System.out.println("Quantum book store: Testing buying books completed");

        store.displayInventory();
        System.out.println();
    }

    private void testRemovingOutdatedBooks() {
        System.out.println("Quantum book store: Testing removing books...");

        store.removeOutdatedBook(10); // removes books older than 10 years
        System.out.println("Quantum book store: Testing removing books completed");
        store.displayInventory();
    }

    private void testEdgeCases() {
        System.out.println();
        System.out.println("Quantum book store: Testing edge cases...");

        // Test buying non-existent book with isbn 12345 => not found because search based on isbn
        try {
            store.buyBook("12345", 1, "gawishh@gmail.com", "Test Address");
        } catch (IllegalArgumentException e) {
            System.out.println("Quantum book store: Expected error caught: " + e.getMessage());
        }

        // Test buying zero quantity
        try {
            store.buyBook("PB100", 0, "gawishh@gmail.com", "Smouha");
        } catch (IllegalArgumentException e) {
            System.out.println("Quantum book store: Expected error caught: " + e.getMessage());
        }

        System.out.println("Quantum book store: Edge case testing completed");
        System.out.println();
    }


}
