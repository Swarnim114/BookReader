package com.example.bookreader;


import lombok.Getter;
import lombok.Setter;

import java.time.Year;
@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private float rating;
    private int no_of_reviews ;
    private float price ;
    private int published_year;
    private String genre;

    public Book(String title , String author , float rating, int no_of_reviews , float price , int published_year, String genre) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.no_of_reviews = no_of_reviews;
        this.price = price;
        this.published_year = published_year;
        this.genre = genre;
    }

    public void printDetails(){
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Rating: " + this.rating);
        System.out.println("No of Reviews: " + this.no_of_reviews);
        System.out.println("Price: " + this.price);
        System.out.println("Published Year: " + this.published_year);
        System.out.println("Genre: " + this.genre);
    }
}
