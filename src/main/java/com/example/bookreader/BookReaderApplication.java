package com.example.bookreader;

import com.example.bookreader.services.BookService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookReaderApplication {

    public static void main(String[] args) {

        BookService bookService = new BookService();
        bookService.printBookDetails("bestsellers with categories.csv");
        bookService.getBooksAndPricesByAuthor("bestsellers with categories.csv", "James Clear");
        bookService.getBooksByRating("bestsellers with categories.csv" ,4);
    }

}
