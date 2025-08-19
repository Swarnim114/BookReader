package com.example.bookreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookReaderApplication {

    public static void main(String[] args) {
        Driver d = new Driver();
        d.printBooks("bestsellers with categories.csv");
    }

}
