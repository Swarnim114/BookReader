package com.example.bookreader.repositories;

import com.example.bookreader.models.Book;

import java.util.List;
// any type of data (csv , json , database) can be used to get the book data
public interface BookDataSource {
    List<List<String>> getBooks();
}
