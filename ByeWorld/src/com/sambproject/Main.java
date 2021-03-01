package com.sambproject;


public class Main {
    public static void main(String[] args) {
        Book[] warAndPiece = new Book[1];
        warAndPiece[0] = new Book("Война и мир. Том 1", "Л.Н. Толстой", "Роман", "A");
        Library libOne = new Library(warAndPiece);
        libOne.addBook(new Book("Война и мир. Том 2", "Л.Н. Толстой", "Роман", "C"));
//        libOne.deleteBook("Война и мир", "", "", "");
        libOne.addBook(new Book ("Война и мир. Том 3", "Л.Н. Толстой", "Роман", "nnn"));
        libOne.changeShelf(2, "C");
        libOne.findBook("", "","","");

    }
}
