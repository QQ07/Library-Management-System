
import java.util.List;

public class Patron {
    String name;
    List<Book> borrowedBooks;
    
    public Patron(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
