package assignment;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CatalogueTest
{   
    static Book book1, book2, book3, book4;
    static Genre fantasyGenre, phiGenre;
    static Catalogue catalogue;
    Filter f;
    
    @Before
    public void setUp()
    {
        fantasyGenre = new Genre("Fantasy");
        phiGenre = new Genre("Philosophy");
        book1 = new Book("978443", "The Hobbit", "J.R.R. Tolkien", fantasyGenre, 1937, 2);
        book2 = new Book("944322", "The Lord of the Rings", "J.R.R. Tolkien", fantasyGenre, 1954, 1);
        book3 = new Book("944323", "The Lord of the Rings", "J.R.R. Tolkien", fantasyGenre, 1955, 2);
        book4 = new Book("665322", "Atlas Shrugged", "Ayn Rand", phiGenre, 1957, 1);
        
        catalogue = Catalogue.getInstance();
        catalogue.addBook(book1);
        catalogue.addBook(book2);
        catalogue.addBook(book3);
        catalogue.addBook(book4);
        
        f = new Filter();
    }
    
    @After
    public void tearDown()
    {
        fantasyGenre = null;
        phiGenre = null;
        book1 = null;
        book2 = null;
        book3 = null;
        book4 = null;
        f = null;
        Catalogue.dropCatalogue();
        
        System.gc();
    }
    
    @Test 
    public void getAllBooksTest()
    {
        assertEquals(4,catalogue.getAllBooks().length);
    }
    
    @Test
    public void duplicateAddTest()
    {
        catalogue.addBook(book1);
        
        assertEquals(4,catalogue.getAllBooks().length);
    }
    
    @Test
    public void removeTest()
    {
        catalogue.removeBook(book1);
        catalogue.removeBook(book4);
        
        Book[] books;
        String[] s = {"978443","665322"};
        
        for (String item : s)
        {
            f.setIsbn(item);
            books = catalogue.searchForBooks(f);
            assertEquals(0,books.length);
        }
        
        assertEquals(2,catalogue.getAllBooks().length);
    }
    
    @Test
    public void removeInexistentTest()
    {
        catalogue.removeBook(book1);
        catalogue.removeBook(book1);
        
        assertEquals(3,catalogue.getAllBooks().length);
    }
    
    @Test
    public void allPassFilterTest()
    {
        Book[] books = catalogue.searchForBooks(f);
        assertThat(books.length, is(4));
    }
    
    @Test
    public void searchByTitleTest()
    {
        f.setTitle("Atlas");
        Book[] books = catalogue.searchForBooks(f);
        
        assertEquals(1,books.length);
        
        for(Book book : books)
            assertEquals("Atlas Shrugged", book.getTitle());
    }
    
    @Test
    public void searchByISBNTest()
    {
        f.setIsbn("944322");
        Book[] books = catalogue.searchForBooks(f);
        
        assertThat(books.length, is(1));
        assertThat(books[0].getIsbn(), is("944322"));
    }
    
    @Test
    public void searchNoResultsTest()
    {
        f.setTitle("Moby Dick");
        f.setYearOfPublication(1937);
        Book[] books = catalogue.searchForBooks(f);
        
        assertThat(books.length, is(0));
    }
    
    @Test
    public void searchByTwoFieldsTest()
    {
        f.setTitle("Lord of the Rings");
        f.setYearOfPublication(1955);
        Book[] books = catalogue.searchForBooks(f);
        
        assertEquals(1,books.length);
        assertEquals("The Lord of the Rings",books[0].getTitle());
        assertEquals(1955,books[0].getYearOfPublication());
    }
    
    @Test
    public void searchMultipleTest()
    {
        f.setGenre("fantasy");
        f.setAuthor("Tolkien");
        f.setEdition(2);
        Book[] books = catalogue.searchForBooks(f);
        
        assertEquals(2,books.length);
        assertEquals("J.R.R. Tolkien",books[0].getAuthor());
        assertEquals("J.R.R. Tolkien",books[1].getAuthor());
        assertEquals(2,books[0].getEdition());
        assertEquals(2,books[1].getEdition());
    }
    
    @Test
    public void searchAllFieldsTest()
    {
        f.setTitle("Lord of the Rings");
        f.setGenre("Fantasy");
        f.setAuthor("Tolkien");
        f.setEdition(2);
        f.setYearOfPublication(1955);
        Book[] books = catalogue.searchForBooks(f);
        
        assertThat(books.length, is(1));
    }
}
