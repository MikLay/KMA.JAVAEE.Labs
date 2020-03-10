package com.example.demo.model;

import lombok.Data;

@Data
public class Book {
    private String name;
    private String isbn;
    private String author;

    public Book() {
    }

    public Book(String name, String isbn, String author) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
    }
}
