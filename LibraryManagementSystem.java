import java.io.*;
import java.util.*;

/**
 Sebastian R. Foster
 Course: Software Development 1, CRN - 15339
 Date: September 2024

 Class: LibraryManagementSystem
 This class contains the main method that runs the Library Management System (LMS).
 The LMS is a console-based application designed to manage a library's collection of books.
 Users can load books from a text file, add or remove books, view the current list of books,
 and search for books by title. The system continuously loops until the user chooses to exit.
 */

public class LibraryManagementSystem {

    // List to store all the books in the library system.
    static List<Book> books = new ArrayList<>();

    /**
     Method: main
     The main method runs the program, displaying a menu and allowing users to choose
     between different options like loading books from a file, adding/removing books,
     or searching for a book by its title.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Library Management System!");

        // Prompt the user to enter the path of the text file with book data
        System.out.println("Please enter the path of the text file with book data:");
        String filePath = scanner.nextLine();
        loadBooksFromFile(filePath); // Load books from the specified file

        boolean exit = false; // Control loop to keep program running until the user exits

        // Main loop to display the menu and handle user choices
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add New Book");
            System.out.println("2. Remove Book by ID");
            System.out.println("3. Display All Books");
            System.out.println("4. Book Lookup by Title");
            System.out.println("5. Exit");

            // Get user choice and act accordingly
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after integer input

            // Switch case to handle the different menu options
            switch (choice) {
                case 1:
                    addNewBook(scanner); // Call to add a new book
                    break;
                case 2:
                    removeBook(scanner); // Call to remove a book by ID
                    break;
                case 3:
                    displayBooks(); // Call to display all books
                    break;
                case 4:
                    bookLookUp(scanner); // Call to search for a book by title
                    break;
                case 5:
                    exit = true; // Exit the loop and end the program
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        System.out.println("Exiting the system. Goodbye!");
    }

    /**
     Method: loadBooksFromFile
     This method reads book data from a specified text file. Each line in the file
     is expected to contain a book's ID, title, and author, separated by commas.
     Each book is parsed and added to the system's collection.
     */

    public static void loadBooksFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(","); // Split the line by commas
                books.add(new Book(Integer.parseInt(details[0]), details[1], details[2])); // Create and add book
            }
            System.out.println("Books loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    /**
     Method: addNewBook
     This method prompts the user to enter the details for a new book,
     such as the ID, title, and author. It then adds the new book to the system's collection.
     */

    public static void addNewBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt(); // Get book ID from user
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine(); // Get book title
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine(); // Get book author
        books.add(new Book(id, title, author)); // Add new book to the collection
        System.out.println("Book added successfully.");
    }

    /**
     Method: removeBook
     This method removes a book from the system's collection based on the user's input of the book's ID.
     If the book exists, it is removed from the list.
     */

    public static void removeBook(Scanner scanner) {
        System.out.print("Enter Book ID to remove: ");
        int id = scanner.nextInt(); // Get book ID from user
        books.removeIf(book -> book.getId() == id); // Remove book with matching ID
        System.out.println("Book removed if it existed.");
    }

    /**
     Method: displayBooks
     This method displays all the books currently in the system's collection.
     If no books are available, a message is printed.
     */

    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available."); // Notify user if no books are present
        } else {
            books.forEach(System.out::println); // Print each book in the collection
        }
    }

    /**
     Method: bookLookUp
     This method allows the user to search for a book by its title.
     If a book with the specified title is found, it is displayed; otherwise, a 'not found' message is shown.
     */

    public static void bookLookUp(Scanner scanner) {
        System.out.print("Enter Book Title to search: ");
        String title = scanner.nextLine(); // Get title from user
        books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title)) // Filter books by title
                .findFirst()
                .ifPresentOrElse(
                        book -> System.out.println("Book found: " + book), // Display book if found
                        () -> System.out.println("Book not found.") // Notify user if book not found
                );
    }
}
