public class Library {
    private Book[] books;
    private int bookCount;
    private Patron[] patrons;
    public Library(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void add10RealBooks() {
        addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "1925"));
        addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "1960"));
        addBook(new Book("1984", "George Orwell", "9780451524935", "1949"));
        addBook(new Book("Pride and Prejudice", "Jane Austen", "9780141439518", "1813"));
        addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", "1951"));
        addBook(new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227", "1937"));
        addBook(new Book("Fahrenheit 451", "Ray Bradbury", "9781451673319", "1953"));
        addBook(new Book("Brave New World", "Aldous Huxley", "9780060850524", "1932"));
    }

    public void removeBook(String ISBN) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getISBN().equals(ISBN)) {
                books[i] = books[--bookCount];
                books[bookCount] = null;
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("Books in the library:");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].title + " by " + books[i].author + " (ISBN: " + books[i].ISBN + ")");
        }
        System.out.println("--------------------------------------------------");
    }

    public boolean updateBook(String ISBN, String newTitle, String newAuthor, String newPublicationYear) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getISBN().equals(ISBN)) {
                if (newTitle != null && !newTitle.isEmpty()) {
                    books[i].setTitle(newTitle);
                }
                if (newAuthor != null && !newAuthor.isEmpty()) {
                    books[i].setAuthor(newAuthor);
                }
                if (newPublicationYear != null && !newPublicationYear.isEmpty()) {
                    books[i].setPublicationYear(newPublicationYear);
                }
                return true;
            }
        }
        return false;
    }

    public boolean CheckoutBook(String ISBN, Patron patron) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getISBN().equals(ISBN)) {
                if (books[i].isIsAvailable()) {
                    books[i].setCurrentlyIssuedTo(patron);
                    books[i].setIsAvailable(false);
                    return true;
                } else {
                    System.out.println("Book is already checked out.");
                    return false;
                }
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    public boolean ReturnBook(String ISBN) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getISBN().equals(ISBN)) {
                if (!books[i].isIsAvailable()) {
                    books[i].setCurrentlyIssuedTo(null);
                    books[i].setIsAvailable(true);
                    return true;
                } else {
                    System.out.println("Book is already available.");
                    return false;
                }
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    public Book SearchBook(String searchBy, String searchValue) {
        for (int i = 0; i < bookCount; i++) {
            if ((searchBy.equals("title") && books[i].getTitle().equalsIgnoreCase(searchValue)) ||
                (searchBy.equals("author") && books[i].getAuthor().equalsIgnoreCase(searchValue)) ||
                (searchBy.equals("ISBN") && books[i].getISBN().equalsIgnoreCase(searchValue))) {
                System.out.println(books[i]);
                return books[i];
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    public void availableBooks() {
        if (bookCount == 0) {
            System.out.println("No books available in the library.");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            System.out.println("--------------------------------------------------");
            if (books[i].isIsAvailable()) {
                System.out.println(books[i].getTitle() + " by " + books[i].getAuthor() + " (ISBN: " + books[i].getISBN() + ")");
            }
            System.out.println("--------------------------------------------------");
        }
    }

    public void borrowedBooks() {
        for (int i = 0; i < bookCount; i++) {
            if (!books[i].isIsAvailable()) {
                System.out.println("--------------------------------------------------");
                System.out.println(books[i]);
                System.out.println("Currently issued to: " + books[i].getCurrentlyIssuedTo().getName());
                System.out.println("--------------------------------------------------");
            }
        }
    }
}
