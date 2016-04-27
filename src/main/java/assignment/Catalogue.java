package assignment;

import java.util.HashMap;
        
public class Catalogue
{
    
    private static Catalogue instance = null;
    private static HashMap<String, Book> catalogue = null;
    
    private Catalogue()
    {
        catalogue = new HashMap<String, Book>();
    }
    
    public Catalogue createCatalogue()
    {
        if(instance == null)
        {
            instance = new Catalogue();
        }
        else
        {
            System.err.println("[ERR] A Catalogue instance is already running.");
        }
        
        return instance;
    }
    
    public void addBook(Book book)
    {
        if(catalogue.get(book.getIsbn()) != null)
        {
            System.err.println("[ERR] Duplicate catalogue entries are not allowed.");
            return;
        }
        
        catalogue.put(book.getIsbn(), book);
    }   
}
