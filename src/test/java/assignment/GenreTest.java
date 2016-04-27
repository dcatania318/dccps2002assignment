package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GenreTest 
{
    Genre g;
    
    @Before
    public void setUp()
    {
        g = null;
    }
    
    @After
    public void tearDown()
    {
        g = null;
    }

    @Test
    public void testCreateGenre() {
        System.out.println("createGenre");
        String genreName = "";
        Genre expResult = null;
        Genre result = Genre.createGenre(genreName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLink method, of class Genre.
     */
    @Test
    public void testAddLink() {
        System.out.println("addLink");
        Book book = null;
        Genre instance = null;
        instance.addLink(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeLink method, of class Genre.
     */
    @Test
    public void testRemoveLink() {
        System.out.println("removeLink");
        Book book = null;
        Genre instance = null;
        instance.removeLink(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Genre.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Genre instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
