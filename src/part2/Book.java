package part2;

/**
 * This class contains some methods that deals with specific book.
 */
public class Book {

    String title;
    boolean borrowed;

    //constructor
    public Book(String bookTitle) {
        // Implement this method
        this.title = bookTitle;
    }

    //Marks the book as borrowed
    public void borrowed() {
        //Implement this method
        borrowed = true;
    }


    // Marks the book as available, i.e., not borrowed
    public void returned() {
        //Implement this method
        borrowed = false;
    }

    //Returns true if the book is borrowed, false otherwise
    public boolean isBorrowed() {
        //Implement this method
        return borrowed;
    }

    //Returns the title of the book
    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        //Small test on the part2.Book class
        Book example = new Book("Harry Potter");
        System.out.println("Title (Should be Harry Potter): " + example.getTitle());
        System.out.println("Borrowed? (should be false:) " + example.isBorrowed());
        example.borrowed();
        System.out.println("Borrowed? (should be true:) " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false:) " + example.isBorrowed());
    }
}
