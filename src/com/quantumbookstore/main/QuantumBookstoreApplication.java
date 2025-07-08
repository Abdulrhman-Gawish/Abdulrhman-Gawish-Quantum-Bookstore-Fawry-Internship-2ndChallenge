package com.quantumbookstore.main;

import com.quantumbookstore.test.QuantumBookstoreFullTest;

public class QuantumBookstoreApplication {
    public static void main(String[] args) {
        System.out.println("Quantum book store: Welcome to Quantum Bookstore System!");
        System.out.println("Quantum book store: ==========================================");

        QuantumBookstoreFullTest test = new QuantumBookstoreFullTest();
        test.runAllTests();
    }
}
