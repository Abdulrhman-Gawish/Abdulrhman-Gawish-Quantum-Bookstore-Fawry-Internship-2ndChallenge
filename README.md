Quantum Bookstore
==================

This Java project simulates an online bookstore system as part of the Fawry Quantum Internship Challenge. It demonstrates Object-Oriented Programming (OOP), clean code practices, and class extensibility.

Overview
--------

The system allows:
- Adding books to the inventory
- Buying different types of books
- Removing outdated books based on their publish year
- Handling special cases like invalid ISBNs or insufficient stock

Book Types
----------

1. PaperBook:
   - Has a stock quantity
   - Can be purchased and shipped to a physical address

2. EBook:
   - Delivered via email
   - Has no stock limitation

3. ShowcaseBook:
   - Not for sale
   - Only displayed in the inventory

Main Classes
------------

- `Book`: Abstract parent class for all books
- `PaperBook`, `EBook`, `ShowcaseBook`: Extend the `Book` class
- `BookStore`: Handles inventory, adding, buying, and removing books
- `ShippingService`: Simulates shipping logic (prints address)
- `MailService`: Simulates email delivery (prints email)
- `QuantumBookstoreFullTest`: Runs all the test cases

Test Scenarios in QuantumBookstoreFullTest
------------------------------------------

1. **Adding Books**
   - Add one `PaperBook`, one `EBook`, and one `ShowcaseBook` to the store
   - Display full inventory

2. **Buying Books**
   - Buy 2 copies of a PaperBook (should reduce stock and print shipping info)
   - Buy 1 EBook (should print email sent info)
   - Attempt to buy a book with invalid ISBN (should throw error)
   - Attempt to buy more than available quantity of PaperBook (should throw error)

3. **Removing Outdated Books**
   - Remove all books older than 10 years
   - Display remaining inventory

4. **Edge Cases**
   - Try buying a book with an ISBN that doesn’t exist (e.g., "12345")
   - Try buying 0 quantity of a book (should throw error)

Output Example (Simplified)
---------------------------

Quantum book store: Starting comprehensive tests...

Quantum book store: Testing adding books completed  
Available: Java Fundamentals  
Available: Clean Code  
Available: AI Research  

Quantum book store: Payment received: $4000.00  
Quantum book store: Payment received: $2000.00  
Quantum book store: Expected error caught: Book with ISBN SB3000 not found  
Quantum book store: Expected error caught: Not enough stock for PaperBook

Quantum book store: Testing removing books...  
Book published before 2013 removed: Clean Code

Quantum book store: Expected error caught: Book with ISBN 12345 not found  
Quantum book store: Expected error caught: Quantity must be at least 1

Quantum book store: All tests completed!
