package assignment;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
        
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
        return catalogue.values().toArray(new Book[catalogue.size()]);
    }
    
    public Book searchByISBN(String isbn) {
        return catalogue.get(isbn);
    }
    
    public Book[] searchByTitle(String title) {
        Iterator i = catalogue.values().iterator();
        ArrayList<Book> result = new ArrayList<Book>();
        Book search;
        
        while(i.hasNext()) {
            search = (Book)i.next();
            if(search.getTitle().toUpperCase().equals(title)) {
                result.add(search);
            }
        }
        
        return result.toArray(new Book[result.size()]);
    }
    
    public Book[] searchByYearOfPublication(int year) {
        Iterator i = catalogue.values().iterator();
        ArrayList<Book> result = new ArrayList<Book>();
        Book search;
        
        while(i.hasNext()) {
            search = (Book)i.next();
            if(search.getYearOfPublication() == year) {
                result.add(search);
            }
        }
        
        return result.toArray(new Book[result.size()]);
    }
    
    public Book[] searchByGenre(Genre genre) {
        return (Book[])genre.getBooks();
    }
}
