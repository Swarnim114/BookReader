package com.example.bookreader;

import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.util.ArrayList;


@Getter
@Setter
public class Driver {
    DataReader dr =  new DataReader();



    public   void printBooks(String fileName){
        ArrayList<Book> books = dr.getBooks(fileName);
        for(Book book:books){
            book.printDetails();
        }
    }


}
