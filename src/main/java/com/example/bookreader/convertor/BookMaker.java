package com.example.bookreader.convertor;

import com.example.bookreader.models.Book;
import com.example.bookreader.repositories.BookDataSource;
import com.example.bookreader.repositories.CsvBookDataSource;

import java.util.ArrayList;
import java.util.List;

// This class is intended to convert a String representation of a book into a Book object.
public class BookMaker {
    public List<Book> getBooks(String filePath) {
        List<Book> books = new ArrayList<>();
        BookDataSource bookDataSource = new CsvBookDataSource(filePath);
        List<List<String>> bookData = bookDataSource.getBooks();


        // logic to parse the book data and convert it to Book objects
        for(List<String> book : bookData){
            if (book.size() < 7) {
                System.err.println("Invalid book data: " + book);
                continue; // Skip invalid entries
            }
            String title = book.get(0);
            String author = book.get(1);
            float rating = Float.parseFloat(book.get(2));
            int no_of_reviews = Integer.parseInt(book.get(3));
            float price = Float.parseFloat(book.get(4));
            int published_year = Integer.parseInt(book.get(5));
            String genre = book.get(6);

            Book bookObj = new Book(title, author, rating, no_of_reviews, price, published_year, genre);
            books.add(bookObj);

        }

        return books;
    }
}
