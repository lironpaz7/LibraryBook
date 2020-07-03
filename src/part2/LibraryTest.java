package part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    void addBook() {
        Library l = new Library("test");
        l.addBook(new Book("myBook"));
        assertEquals(2, l.booksList.size());
    }

    @Test
    void testAddBook() {

    }
}