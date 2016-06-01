package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GenreTest 
{
    Genre testGenre;
    Book testBook;
    
    @Before
    public void setUp()
    {
        testGenre = new Genre("Computing");
        testBook = new Book("9780132350884","Clean Code : A Handbook of Agile Software Craftsmanship", "Robert C. Martin",testGenre,2009,1); 
    }
    
    @After
    public void tearDown()
    {
        testGenre = null;
        testBook = null;
        Runtime.getRuntime().gc();
    }

    /*
    @Test
    public void testCreateGenre()
    {
        assertNotNull(Genre.createGenre("Horror"));
        assertNull(Genre.createGenre("Horror"));
    }
*/

    @Test
    public void testLinksAndContainsAndCount()
    {
        Genre test = testBook.getGenreObject();
        assertEquals(test.containsBook(testBook),false);
        assertEquals(test.getCount(),0);
        test.addLink(testBook);
        assertEquals(test.containsBook(testBook),true);
        assertEquals(test.getCount(),1);
        test.removeLink(testBook);
        assertEquals(test.containsBook(testBook),false);
        assertEquals(test.getCount(),0);        
    }

    @Test
    public void testDescription() 
    {   
        assertEquals(testGenre.getDescription(),"");
        String d = "Computing is any goal-oriented activity requiring, "
                + "benefiting from, or creating a mathematical sequence of "
                + "steps known as an algorithm";
        testGenre.setDescription(d);
        assertEquals(testGenre.getDescription(),d);
    }
    
    @Test
    public void testGenreName()
    {
        assertEquals("Computing",testGenre.getGenreName());
        testGenre.setGenreName("Science");
        assertEquals("Science",testGenre.getGenreName());
    }
    
    @Test
    public void testGetBooks()
    {
        Book testBook2 = new Book("9780321928429","C Primer Plus", "Stephen Prata",testGenre,2013,6); 
        testGenre.addLink(testBook);
        testGenre.addLink(testBook2);
        Book[] books = testGenre.getBooks();
        assertEquals(2,books.length);
        assertEquals(testBook,books[0]);
        assertEquals(testBook2,books[1]);
        testBook2 = null;
    }
}
