package com.Quantum.quantum;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library (checking for duplicates based on ISBN)
    public void addBook(Book book) {
        boolean alreadyExists = false;
        for (Book b : books) {
            if (b.getISBN().equals(book.getISBN())) {
                alreadyExists = true;
                break;
            }
        }
        if (!alreadyExists) {
            books.add(book);
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Book with ISBN " + book.getISBN() + " already exists in the library.");
        }
    }

    // Method to remove a book by ISBN
    public void removeBook(String ISBN) {
        Book found = null;
        for (Book b : books) {
            if (b.getISBN().equals(ISBN)) {
                found = b;
                break;
            }
        }
        if (found != null) {
            books.remove(found);
            System.out.println("Book removed: " + found.getTitle());
        } else {
            System.out.println("Book with ISBN " + ISBN + " not found in the library.");
        }
    }

    // Method to find books by title (case-insensitive search)
    public List<Book> findBookByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                result.add(b);
            }
        }
        return result;
    }

    // Method to find books by author (case-insensitive search)
    public List<Book> findBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    // Method to list all books in the library
    public List<Book> listAllBooks() {
        return books;
    }

    // Method to list available books
    public List<Book> listAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.isAvailable()) {
                availableBooks.add(b);
            }
        }
        return availableBooks;
    }

  
}
