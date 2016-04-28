package assignment;

import java.util.HashMap;
        
public class Catalogue
{
    
    private static Catalogue instance = null;
    private HashMap<String, Book> catalogue = null;
    
    private Catalogue() {
        catalogue = new HashMap<String, Book>();
    }
    
    public static Catalogue getInstance() {
        if(instance == null) {
            instance = new Catalogue();
        }
        
        return instance;
    }
    
    public void addBook(Book book) {
        if(catalogue.containsKey(book.getIsbn()) == true) {
            System.err.println("[ERR] Duplicate catalogue entries are not allowed.");
            return;
        }
        
        catalogue.put(book.getIsbn(), book);
        book.getGenreObject().addLink(book);
    }
    
    public void removeBook(Book book) {
        if(catalogue.remove(book.getIsbn()) == null) {
            System.err.println("[ERR] Book not found.");
        }
    }
    
    public Book[] getAllBooks() {
        return (Book[])catalogue.values().toArray();
    }
}
