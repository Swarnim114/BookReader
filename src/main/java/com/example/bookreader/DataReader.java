package com.example.bookreader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
// this class is used to read data from a CSV and make it in a list
public  class DataReader{
    public ArrayList<Book> getBooks(String filename) {
        ArrayList<Book> books = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            List<String[]> rows = reader.readAll();

            boolean header = true;
            for (String[] row : rows) {
                if (header) {
                    header = false; // skip header
                    continue;
                }

                String name = row[0];
                String author = row[1];
                float rating = Float.parseFloat(row[2]);
                int reviews = Integer.parseInt(row[3]);
                float price = Float.parseFloat(row[4]);
                int year = Integer.parseInt(row[5]);
                String genre = row[6];

                books.add(new Book(name, author, rating, reviews, price, year, genre));
            }
        } catch (FileNotFoundException e) {
            System.err.println("❌ File not found: " + filename);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return books;
    }

}
