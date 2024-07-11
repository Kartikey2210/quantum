package com.Quantum.quantum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 1925, "Fiction");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 1960, "Fiction");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.listAllBooks();

        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    public void testAddDuplicateBook() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 1925, "Fiction");
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 1925, "Fiction");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.listAllBooks();

        assertEquals(1, books.size()); // Only one book should be added (no duplicates)
    }

    @Test
    public void testRemoveBook() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 1925, "Fiction");

        library.addBook(book1);
        library.removeBook("9780743273565");

        List<Book> books = library.listAllBooks();

        assertEquals(0, books.size());
    }

    @Test
    public void testFindBookByTitle() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 1925, "Fiction");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 1960, "Fiction");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> foundBooks = library.findBookByTitle("To Kill a Mockingbird");

        assertEquals(1, foundBooks.size());
        assertEquals("To Kill a Mockingbird", foundBooks.get(0).getTitle());
    }

    @Test
    public void testFindBookByAuthor() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 1925, "Fiction");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 1960, "Fiction");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> foundBooks = library.findBookByAuthor("Harper Lee");

        assertEquals(1, foundBooks.size());
        assertEquals("To Kill a Mockingbird", foundBooks.get(0).getTitle());
    }

    @Test
    public void testListAllBooks() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 1925, "Fiction");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 1960, "Fiction");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> allBooks = library.listAllBooks();

        assertEquals(2, allBooks.size());
    }

    @Test
    public void testListAvailableBooks() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 1925, "Fiction");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 1960, "Fiction");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> availableBooks = library.listAvailableBooks();

        assertEquals(2, availableBooks.size());

        // Set one book as unavailable
        book1.setAvailable(false);

        availableBooks = library.listAvailableBooks();

        assertEquals(1, availableBooks.size());
        assertEquals("To Kill a Mockingbird", availableBooks.get(0).getTitle());
    }
}
