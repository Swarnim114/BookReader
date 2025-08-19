package com.example.bookreader.services;

import com.example.bookreader.convertor.BookMaker;
import com.example.bookreader.models.Book;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class BookService {

    //  Print details of all books
    public void printBookDetails(String filepath) {
        BookMaker bookMaker = new BookMaker();
        try {
            bookMaker.getBooks(filepath).forEach(book -> {
                book.printDetails();
                System.out.println("----------------------------");
            });
        } catch (Exception e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    //  Total number of books by an author
    public int getTotalBooksByAuthor(String filepath, String author) {
        BookMaker bookMaker = new BookMaker();
        try {
            List<Book> books = bookMaker.getBooks(filepath);
            return (int) books.stream()
                    .filter(book -> book.isByAuthor(author))
                    .count();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        }
    }

    //  All authors in the dataset
    public Set<String> getAllAuthors(String filepath) {
        BookMaker bookMaker = new BookMaker();
        Set<String> authors = new HashSet<>();
        try {
            List<Book> books = bookMaker.getBooks(filepath);
            books.forEach(book -> authors.add(book.getAuthor()));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return authors;
    }

    //  Names of all the books by an author
    public List<String> getBooksByAuthor(String filepath, String author) {
        BookMaker bookMaker = new BookMaker();
        try {
            List<Book> books = bookMaker.getBooks(filepath);
            return books.stream()
                    .filter(book -> book.isByAuthor(author))
                    .map(Book::getTitle)  // changed to title
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return List.of();
        }
    }

    // ✅ Classify books with a user rating
    public List<Book> getBooksByRating(String filepath, float rating) {
        BookMaker bookMaker = new BookMaker();
        try {
            List<Book> books = bookMaker.getBooks(filepath);
            return books.stream()
                    .filter(book -> book.hasRating(rating))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return List.of();
        }
    }

    //  Price of all the books by an author
    public List<String> getBooksAndPricesByAuthor(String filepath, String author) {
        BookMaker bookMaker = new BookMaker();
        try {
            List<Book> books = bookMaker.getBooks(filepath);
            return books.stream()
                    .filter(book -> book.isByAuthor(author))
                    .map(book -> book.getTitle() + " - $" + book.getPrice()) // changed to title + price
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return List.of();
        }
    }
}
