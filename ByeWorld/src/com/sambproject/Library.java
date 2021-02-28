package com.sambproject;

import java.util.HashMap;

public class Library {
//    Вариант 21 -- библиотека
//
//    Хранит информацию о книгах и позволяет их искать. Для каждой книги хранится название, автор и жанр, а также
//    код полки, на которой она лежит (например, А3 или Г4.
//    Вы можете сами придумать реалистичную систему кодирования полок).
//
//    Операции: конструктор, добавить/удалить книгу, изменить существующую книгу,
//    переместить книгу на другую полку, поиск книг по разным признакам (по автору, по названию,
//    по словам из названия, по жанру, по коду полки, по комбинации этих признаков).

    HashMap<Integer, Book> lib = new HashMap<>();

    HashMap<String, Integer> shelves = new HashMap<>();


    int id = 0;
    public Library(Book[] books) {
        for (Book book : books) {
            lib.put(id, book);
            id++;
        }
    }

    public void addBook(String name, String author, String genre, String shelf) {
        Book book = new Book(name, author, genre, shelf);
        lib.put(id, book);
        id++;
    }

    public void changeBook (int id, String newName, String newAuthor, String newGenre) {
        Book bookToChange = lib.get(id);
        if (!newName.isEmpty()) bookToChange.name = newName;
        if (!newAuthor.isEmpty()) bookToChange.author = newName;
        if (!newGenre.isEmpty()) bookToChange.genre = newName;
        System.out.println("Теперь эта книга выглядит так: ");
        bookToChange.showBook();
    }

    public void deleteBook(String name, String author, String genre, String shelf) {
        HashMap<Integer, Book> booksToDelete = findBook(name, author, genre, shelf);
        for (int deleteKey : booksToDelete.keySet()) {
            System.out.println("Книга \"" + booksToDelete.get(deleteKey).getName() + "\" удалена");
            lib.remove(deleteKey);
        }
    }

    public HashMap<Integer, Book> findBook (String name, String author, String genre, String shelf) {
        //Если не надо учитывать при поиске, оставьте пустое значение
        return findByName(name, findByAuthor(author, findByGenre(genre, findByShelf(shelf, lib))));
    }

    private HashMap<Integer, Book> findByAuthor(String author, HashMap<Integer, Book> lib) {
        if (author.isEmpty()) return lib;
        HashMap<Integer, Book> localLib = new HashMap<>();
        for (int keyBook : lib.keySet()) {
            Book bookInstance = lib.get(keyBook);
            if (bookInstance.getAuthor().equals(author)) {
                localLib.put(bookInstance.getId(), bookInstance);
            }
        }
        return localLib;
    }

    private HashMap<Integer, Book> findByGenre(String genre, HashMap<Integer, Book> lib) {
        if (genre.isEmpty()) return lib;
        HashMap<Integer, Book> localLib = new HashMap<>();
        for (int keyBook : lib.keySet()) {
            Book bookInstance = lib.get(keyBook);
            if (bookInstance.getGenre().equals(genre)) {
                localLib.put(bookInstance.getId(), bookInstance);
            }
        }
        return localLib;
    }
    private HashMap<Integer, Book> findByShelf(String shelf, HashMap<Integer, Book> lib) {
        if (shelf.isEmpty()) return lib;
        HashMap<Integer, Book> localLib = new HashMap<>();
        for (int keyBook : lib.keySet()) {
            Book bookInstance = lib.get(keyBook);
            if (bookInstance.getShelf().contains(shelf)) {
                localLib.put(bookInstance.getId(), bookInstance);
            }
        }
        return localLib;
    }

    private HashMap<Integer, Book> findByName(String name, HashMap<Integer, Book> lib) {
        if (name.isEmpty()) return lib;
        HashMap<Integer, Book> localLib = new HashMap<>();
        for (int keyBook : lib.keySet()) {
            Book bookInstance = lib.get(keyBook);
            if (bookInstance.getName().contains(name)) {
                localLib.put(bookInstance.getId(), bookInstance);
            }
        }
        return localLib;
    }

}

