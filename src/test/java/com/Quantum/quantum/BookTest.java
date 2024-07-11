package com.Quantum.quantum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testGettersAndSetters() {
        Book book = new Book("Harry Potter", "J.K. Rowling", "9780545582889", "Fantasy", 1997, "Fiction");

        assertEquals("Harry Potter", book.getTitle());
        assertEquals("J.K. Rowling", book.getAuthor());
        assertEquals("9780545582889", book.getISBN());
        assertEquals("Fantasy", book.getGenre());
        assertEquals(1997, book.getPublicationYear());
        assertEquals("Fiction", book.getDepartment());

        book.setTitle("New Title");
        book.setAuthor("New Author");

        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
    }

    @Test
    public void testToStringMethod() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227", "Fantasy", 1937, "Fiction");

        String expectedString = "Book{title='The Hobbit', author='J.R.R. Tolkien', ISBN='9780547928227', " +
                "genre='Fantasy', publicationYear=1937, department='Fiction', available=true}";

        assertEquals(expectedString, book.toString());
    }
}
