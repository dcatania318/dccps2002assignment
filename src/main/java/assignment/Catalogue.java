package assignment;

import java.util.TreeMap;
import java.util.Map;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
        
public class Catalogue
{
    
    private static Catalogue instance = null;
    private Map<String, Book> catalogue = null;
    
    private Catalogue() {
        catalogue = new TreeMap<String, Book>();
    }
    
    public static Catalogue getInstance() {
        if(instance == null) {
            instance = new Catalogue();
        }
        
        return instance;
    }
    
    public void addBook(Book book) {
        if(catalogue.containsKey(book.getIsbn())) {
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
        return catalogue.values().toArray(new Book[catalogue.size()]);
    }
    
    public Book searchByISBN(String isbn) {
        return catalogue.get(isbn);
    }
    
    public Book[] searchByTitle(String title) {
        Collection<Book> values = catalogue.values();
        ArrayList<Book> result = new ArrayList<Book>();
        
        for(Book ptr : values) {
            if(ptr.getTitle().equals(title)) {
                result.add(ptr);
            }
        }
        
        return result.toArray(new Book[result.size()]);
    }
    
    public Book[] searchByYearOfPublication(int year) {
        Collection<Book> values = catalogue.values();
        ArrayList<Book> result = new ArrayList<Book>();
        
        for(Book ptr : values) {
            if(ptr.getYearOfPublication() == year) {
                result.add(ptr);
            }
        }
        
        return result.toArray(new Book[result.size()]);
    }
    
    public Book[] searchByGenre(Genre genre) {
        return genre.getBooks();
    }
}
