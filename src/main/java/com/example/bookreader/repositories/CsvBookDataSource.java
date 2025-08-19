package com.example.bookreader.repositories;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvBookDataSource implements BookDataSource {
    private final String filePath;

    public CsvBookDataSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<List<String>> getBooks() {
        List<List<String>> books = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;

            // skip the header
            reader.readNext();

            // read actual book data
            while ((line = reader.readNext()) != null) {
                books.add(Arrays.asList(line));
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }

        return books;
    }
}
