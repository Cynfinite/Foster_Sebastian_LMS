/**
 Sebastian R. Foster
 Course: Software Development 1, CRN - 15339
 Date: September 2024

 Class: Book
 This class represents a book entity in the system. It stores the ID, title, and author
 of a book and includes basic getter methods and a string representation for display.
 */

class Book {
    private int id;
    private String title;
    private String author;

    /**
     Constructor: Book
     This constructor initializes a new book with its ID, title, and author.
     */

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getter for the book's ID
    public int getId() {
        return id;
    }

    // Getter for the book's title
    public String getTitle() {
        return title;
    }

    // Getter for the book's author
    public String getAuthor() {
        return author;
    }

    /**
     Method: toString
     Returns a string representation of the book's details, including its ID, title, and author.
     */

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}
