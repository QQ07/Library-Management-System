import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Library Management System");
        Library library = new Library(100); // Initialize library with a capacity of 100 books
        library.add10RealBooks();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. View Available Books");
            System.out.println("6. View Borrowed Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Add book logic
                    System.out.print("Enter book title: ");
                    String title = scanner.next();
                    System.out.print("Enter book author: ");
                    String author = scanner.next();
                    System.out.print("Enter book ISBN: ");
                    String ISBN = scanner.next();
                    System.out.print("Enter book publication year: ");
                    String publicationYear = scanner.next();
                    Book newBook = new Book(title, author, ISBN, publicationYear);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    // Issue book logic
                    System.out.print("Enter book ISBN to issue: ");
                    String issueISBN = scanner.next();
                    System.out.print("Enter patron name: ");
                    String patronName = scanner.next();
                    Patron patron = new Patron(patronName);
                    if (library.CheckoutBook(issueISBN, patron)) {
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Failed to issue book.");
                    }
                    break;
                case 3:
                    // Return book logic
                    System.out.print("Enter book ISBN to return: ");
                    String returnISBN = scanner.next();
                    if (library.ReturnBook(returnISBN)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Failed to return book.");
                    }
                    break;
                case 4:// Search book logic    
                    System.out.print("How do you want to search?: ");
                    System.out.print("1. Using ISBN: ");
                    System.out.print("2. Using Title: ");
                    System.out.print("3. Using Author: ");
                    int searchChoice = scanner.nextInt();
                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter ISBN: ");
                            String searchISBN = scanner.next();
                            Book foundBookByISBN = library.SearchBook("ISBN", searchISBN);
                            if (foundBookByISBN != null) {
                                System.out.println("Book found: " + foundBookByISBN.getTitle() + " by " + foundBookByISBN.getAuthor());
                            } else {
                                System.out.println("Book not found.");
                            }
                            break;
                        case 2:
                            System.out.print("Enter Title: ");
                            String searchTitle = scanner.next();
                            Book foundBookByTitle = library.SearchBook("title", searchTitle);
                            if (foundBookByTitle != null) {
                                System.out.println("Book found: " + foundBookByTitle.getTitle());
                                System.out.println("ISBN: " + foundBookByTitle.getISBN());
                            } else {
                                System.out.println("Book not found.");
                            }
                            break;
                        case 3:
                            System.out.print("Enter Author: ");
                            String searchAuthor = scanner.next();
                            Book foundBookByAuthor = library.SearchBook("author", searchAuthor);
                            if (foundBookByAuthor != null) {
                                System.out.println("Book found: " + foundBookByAuthor.getTitle());
                                System.out.println("ISBN: " + foundBookByAuthor.getISBN());
                            } else {
                                System.out.println("Book not found.");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 5:
                    // View available books logic
                    System.out.println("Available books:");
                    library.availableBooks();

                    break;
                case 6:
                    // View borrowed books logic
                    System.out.println("Borrowed books:");
                    library.borrowedBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
