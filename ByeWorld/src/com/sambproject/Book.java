package com.sambproject;

public class Book {
    String name;
    String author;
    String genre;
    String shelf;
    int id;

    public Book (String name, String author, String genre, String shelf) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.shelf = shelf;
    }

    public void showBook() {
        System.out.println("Книга №" + id + "\n" + name + "\nЖанр: " + genre + "\nАвтор: " +
                author + "\nПолка: " + shelf); //Пробовал со StringBuilder, но IDEA рекомендует использовать String
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public String getShelf() {
        return shelf;
    }

    public int getId() {
        return id;
    }
}
