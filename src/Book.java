public class Book {
    String title, author, ISBN, publicationYear;
    Patron currentlyIssuedTo;
    boolean isAvailable = true;

    //#region Constructors
    public Book(String title, String author, String ISBN, String publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }
    //#endregion

    //#region Getters and Setters
    public String getISBN() {
        return ISBN;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
     public Patron getCurrentlyIssuedTo() {
        return currentlyIssuedTo;
    }

    public void setCurrentlyIssuedTo(Patron currentlyIssuedTo) {
        this.currentlyIssuedTo = currentlyIssuedTo;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    //#endregion
    

   

}
