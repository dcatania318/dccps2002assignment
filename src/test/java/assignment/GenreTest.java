package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GenreTest 
{
    Genre g;
    Book b;
    
    @Before
    public void setUp()
    {
        g = null;
        b = new Book("9780132350884","Clean Code : A Handbook of Agile Software Craftsmanship",
                        "Robert C. Martin","Computing",2009,1);
    }
    
    @After
    public void tearDown()
    {
        g = null;
        b = null;
    }

    @Test
    public void testCreateGenre()
    {
        String genre = "Horror";
        assertEquals(Genre.getGenreHandle(genre),null);
        Genre test = Genre.createGenre(genre);
        assertEquals(Genre.getGenreHandle(genre),test);        
    }

    @Test
    public void testLinksAndContainsAndCount()
    {
        Genre test = b.getGenreObject();
        assertEquals(test.containsBook(b),false);
        assertEquals(test.getCount(),0);
        test.addLink(b);
        assertEquals(test.containsBook(b),true);
        assertEquals(test.getCount(),1);
        test.removeLink(b);
        assertEquals(test.containsBook(b),false);
        assertEquals(test.getCount(),0);        
    }

    @Test
    public void testDescription() 
    {
        Genre test = Genre.createGenre("Computing");
        assertEquals(test.getDescription(),"");
        String d = "Computing is any goal-oriented activity requiring, "
                + "benefiting from, or creating a mathematical sequence of "
                + "steps known as an algorithm";
        test.setDescription(d);
        assertEquals(test.getDescription(),d);
    }
}
