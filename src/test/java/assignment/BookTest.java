package assignment;

import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest
{
    Genre genre;
    Book book;
    
    @Before
    public void setUp()
    {
        genre = new Genre("Software");
        book = new Book("9780132350884","Clean Code : A Handbook of Agile Software Craftsmanship","Robert C. Martin",genre,2009,1);
    }
    
    @After
    public void tearDown()
    {
        book = null;
        genre = null;
        Runtime.getRuntime().gc();
    }

    @Test
    public void testIsbn()
    {
        assertEquals("9780132350884",book.getIsbn());
        String str = "9783832798284";
        book.setIsbn(str);
        assertEquals(str,book.getIsbn());
    }

    @Test
    public void testTitle()
    {
        assertEquals("Clean Code : A Handbook of Agile Software Craftsmanship",book.getTitle());
        String str = "The Classic Cars Book";
        book.setTitle(str);
        assertEquals(str,book.getTitle());
    }

    @Test
    public void testAuthor()
    {
        assertEquals("Robert C. Martin",book.getAuthor());
        String str = "Jurgen Lewandoski";
        book.setAuthor(str);
        assertEquals(str,book.getAuthor());
    }

    @Test
    public void testSetGenre()
    {
        assertEquals("Software",book.getGenre());
        Genre newGenre = new Genre("ICT");
        book.setGenre(newGenre);
        assertEquals("ICT",book.getGenre());
        assertFalse(genre.containsBook(book));
        assertTrue(newGenre.containsBook(book));
    }

    @Test
    public void testYearOfPublication()
    {
        assertEquals(2009,book.getYearOfPublication());
        int i = 2014;
        book.setYearOfPublication(i);
        assertEquals(i,book.getYearOfPublication());
    }

    @Test
    public void testEdition()
    {
        assertEquals(1,book.getEdition());
        int i = 1;
        book.setEdition(i);
        assertEquals(i,book.getEdition());
    }

    @Test
    public void testLoan()
    {
        User user = new User("83294M","Connor Attard","Marsaskala",21249200,79249200);
        book.setLoanedTo(user);
        assertEquals(user,book.getUserLoanedTo());
        //assertEquals(0,Calendar.getInstance().getTime().compareTo(book.getDateLoanedOut()));
    }

    @Test
    public void testReturned()
    {
        book.returned();
        assertEquals(null,book.getUserLoanedTo());
        assertEquals(null,book.getDateLoanedOut());
    }  
}
