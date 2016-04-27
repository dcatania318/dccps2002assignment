package assignment;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest
{
    
    Book book;
    
    @Before
    public void setUp()
    {
        book = new Book("9780132350884","Clean Code : A Handbook of Agile Software Craftsmanship",
                        "Robert C. Martin","Computing",2009,1);
    }
    
    @After
    public void tearDown()
    {
        book = null;
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
    public void testGenre() {
        assertEquals("Computing",book.getGenre());
        String str = "Motor Cars";
        book.setGenre(str);
        assertEquals(str,book.getGenre());
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
        Date date = new Date();
        book.loan(user, date);
        assertEquals(user,book.getUserLoanedTo());
        assertEquals(date,book.getDateLoanedOut());
    }

    @Test
    public void testReturned()
    {
        book.returned();
        assertEquals(null,book.getUserLoanedTo());
        assertEquals(null,book.getDateLoanedOut());
    }
    
}
