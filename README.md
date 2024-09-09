Sebastian Foster 
Software Development 1 
CRN: 15339

Key Features:
Load Books from a Text File:
Users can provide the path to a text file containing book data (with each line containing a book's ID, title, and author separated by commas).
The system reads the file, parses the information, and adds each book to the library's collection.

Add New Book:
Users can manually add a new book by entering its ID, title, and author.
The new book is stored in a list of Book objects.

Remove Book by ID:
Users can remove a book from the system by providing its ID.
The system searches for the book by its ID and removes it if it exists.

Display All Books:
Users can view all the books currently stored in the system.
Each book's ID, title, and author are displayed.

Search for a Book by Title:
Users can search for a book by entering its title.
The system searches the collection and displays the book if it finds a match. If no book is found, a message indicates this.

Exit the System:
Users can choose to exit the system, which terminates the program.

Components:
Main Class: LibraryManagementSystem:
This class is responsible for the main operations of the system, such as loading books, adding/removing books, searching for books, and handling user input through a menu-driven interface.

Helper Class: Book:
This class represents a book entity with three properties: id, title, and author.
It includes getter methods and a toString method for printing the book's details.

Program Flow:
The program starts by asking the user to provide the path to a file containing book data.
It enters a loop where it displays a menu with options (add book, remove book, display books, search by title, and exit).
Based on the user's input, the system performs the corresponding operation.
The loop continues until the user chooses to exit.
