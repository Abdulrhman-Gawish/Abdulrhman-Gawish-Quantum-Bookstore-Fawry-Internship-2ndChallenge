package com.quantumbookstore.store;

import com.quantumbookstore.model.Book;
import com.quantumbookstore.model.ShowcaseBook;

import java.util.*;

public class BookStore {
    private Map<String, Book> inventory;

    public BookStore() {
        this.inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book '" + book.getTitle() + "'");
    }

    public List<Book> removeOutdatedBook(int years) {
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();

            if (book.isOutdated(years)) {
                removedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book.toString());
            }else{
                System.out.println("Quantum book store: Not Removed because not found any outdated book ");
                break;


            }
        }

        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Quantum book store: Book with ISBN " + isbn + " not found");
        }

        if (book instanceof ShowcaseBook) {
            throw new IllegalArgumentException("Quantum book store: Showcase books are not for sale");
        }

        try {
            double totalAmount = book.processPurchase(quantity, email, address);
            System.out.println("Quantum book store: Successfully purchased " + quantity + " copies of " + book.getTitle() +
                    " for $" + String.format("%.2f", totalAmount));
            return totalAmount;
        } catch (IllegalArgumentException e) {
            System.out.println("Quantum book store: Purchase failed - " + e.getMessage());
            throw e;
        }
    }
    public void displayInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        System.out.println("=====================================");
        if (inventory.isEmpty()) {
            System.out.println("Quantum book store: No books in inventory");
        } else {
            for (Book book : inventory.values()) {
                System.out.println("- Quantum book store: " + book.toString());
            }
        }
        System.out.println("=====================================");
//        System.out.println();
    }

}
