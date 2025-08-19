package com.example.bookreader.services;

import com.example.bookreader.convertor.BookMaker;

public class BookService {

    public void printBookDetails(String filepath) {
       BookMaker bookMaker = new BookMaker();
        try {
            bookMaker.getBooks(filepath).forEach(book -> {
                book.printDetails();
                System.out.println("----------------------------");
            });
        } catch (Exception e) {
            System.err.println("Error processing file: " + e.getMessage());
            return;
        }



    }
}
