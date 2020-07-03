package part2;

import java.util.ArrayList;

/**
 * This class contains objects of type Book and has some method that deals with those object.
 */
public class Library {
    // Add the missing implementation to this class
    // Instance variables for the Library class
    private final String libraryAddress;
    public final ArrayList<Book> booksList;

    //constructor
    public Library(String s) {
        this.libraryAddress = s;
        this.booksList = new ArrayList<Book>();
    }

    /**
     * This function adds the given book into the library only if it does not exist yet.
     *
     * @param bookName
     */
    public void addBook(Book bookName) {
        if (!booksList.contains(bookName)) {
            booksList.add(bookName);
        }
    }

    /**
     * This function prints the library open hours.
     */
    private static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9:00 to 17:00.");
    }

    /**
     * This function prints the address of the library.
     */
    private void printAddress() {
        System.out.println(libraryAddress);
    }

    /**
     * This function tries to borrow the given book and follows these conditions:
     * If the book is already borrowed then print a message about it.
     * If the book is not borrowed then print a message about it and update the book status.
     * Otherwise (if the book doesn't exist in the library catalog) print a message about it.
     *
     * @param bookName
     */
    private void borrowBook(String bookName) {
        for (Book book : booksList) {
            if (book.getTitle().equals(bookName)) {
                if (book.isBorrowed()) {
                    System.out.println("Sorry, this book is already borrowed.");
                } else {
                    System.out.println("You successfully borrowed " + book.getTitle());
                    book.borrowed();
                }
                return;
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }

    /**
     * This function prints the available (not borrowed) books in the library.
     * If there are no books in the library catalog then print a message about it.
     */
    private void printAvailableBooks() {
        if (booksList.size() == 0) {
            System.out.println("No books in catalog.");
        } else {
            int countAvailable = 0;
            for (Book book : booksList) {
                if (!book.isBorrowed()) {
                    countAvailable++;
                    System.out.println(book.getTitle());
                }
            }
            if (countAvailable == 0) {
                System.out.println("No books in catalog.");
            }
        }
    }

    /**
     * This function tries to return the given book and follows these conditions:
     * If the book is borrowed then print a message about it and update book status.
     * If the book is not in the catalog then print a message about it.
     * Otherwise (book is already in the library) do nothing.
     *
     * @param bookName
     */
    private void returnBook(String bookName) {
        for (Book book : booksList) {
            if (book.getTitle().equals(bookName)) {
                if (book.isBorrowed()) {
                    System.out.println("You successfully returned " + book.getTitle());
                    book.returned();
                }
                return;
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }

    public static void main(String[] args) {
        //Create two libraries
        Library firstLibrary = new Library("CS Faculty");
        Library secondLibrary = new Library("IE&M Faculty");
        //Add four books to the first library
        firstLibrary.addBook(new Book("Harry Potter"));
        firstLibrary.addBook(new Book("To Kill a Mockingbird"));
        firstLibrary.addBook(new Book("JAVA"));
        firstLibrary.addBook(new Book("Calculus For Dummies"));
        //Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        //Try to borrow Harry Potter from both libraries
        System.out.println("Borrowing Harry Potter:");
        firstLibrary.borrowBook("Harry Potter");
        firstLibrary.borrowBook("Harry Potter");
        secondLibrary.borrowBook("Harry Potter");
        System.out.println();
        //Print the title of all available books from both libraries
        System.out.println("Books available in the first library");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library");
        secondLibrary.printAvailableBooks();
        System.out.println();
        //Return Harry Potter
        System.out.println("Returning Harry Potter");
        firstLibrary.returnBook("Harry Potter");
        System.out.println();
        // Print the titles of available books from the first library
        System.out.println("Books available in the first library");
        firstLibrary.printAvailableBooks();
    }
}
