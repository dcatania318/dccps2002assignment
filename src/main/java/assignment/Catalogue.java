package assignment;

import java.util.TreeMap;
import java.util.Map;
import java.util.Collection;
import java.util.ArrayList;
        
public class Catalogue
{
    
    private static Catalogue instance = null;
    private Map<String, Book> catalogue = null;
    
    private Catalogue()
    {
        catalogue = new TreeMap<String, Book>();
    }
    
    public static Catalogue getInstance()
    {
        if(instance == null)
            instance = new Catalogue();
        
        return instance;
    }
    
    public static void dropCatalogue()
    {
        instance = null;
    }
    
    public void addBook(Book book)
    {
        if(catalogue.containsKey(book.getIsbn()))
        {
            System.err.println("[ERR] Duplicate catalogue entries are not allowed.");
            return;
        }
        
        catalogue.put(book.getIsbn(), book);
        book.getGenreObject().addLink(book);
    }
    
    public void removeBook(Book book)
    {
        if(catalogue.remove(book.getIsbn()) == null)
            System.err.println("[ERR] Book not found.");
    }
    
    public Book[] getAllBooks()
    {
        return catalogue.values().toArray(new Book[catalogue.size()]);
    }
    
    public Book[] searchForBooks(Filter f)
    {
        Collection<Book> values = catalogue.values();
        ArrayList<Book> result = new ArrayList<Book>();
        
        for(Book book : values)
        {
            if(f.getIsbn() != null)
            {
                if(!book.getIsbn().equals(f.getIsbn()))
                    continue;
            }
            
            if(f.getTitle() != null)
            {
                if(!(book.getTitle().toLowerCase()).contains(f.getTitle()))
                    continue;
            }
            
            if(f.getAuthor() != null)
            {
                if(!(book.getAuthor().toLowerCase()).contains(f.getAuthor()))
                    continue;
            }
            
            if(f.getGenre() != null)
            {
                if(!(book.getGenre().toLowerCase()).contains(f.getGenre()))
                    continue;
            }
            
            if(f.getYearOfPublication() != -1)
            {
                if(book.getYearOfPublication() != f.getYearOfPublication())
                    continue;
            }
            
            if(f.getEdition() != -1)
            {
                if(book.getEdition() != f.getEdition())
                    continue;
            }
            result.add(book);
        }
        return result.toArray(new Book[result.size()]);
    }
}
