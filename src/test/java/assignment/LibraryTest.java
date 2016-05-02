package assignment;

import java.util.Date;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LibraryTest
{    
    static Book book1, book2, book3, book4;
    static User user1, user2;
    static Genre fantasyGenre, phiGenre;
    static Catalogue catalogue;
    static Library library;
    
    @Before
    public void setUp()
    {
        fantasyGenre = new Genre("Fantasy");
        phiGenre = new Genre("Philosophy");
        book1 = new Book("978443", "The Hobbit", "J.R.R. Tolkien", fantasyGenre, 1937, 2);
        book2 = new Book("944322", "The Lord of the Rings", "J.R.R. Tolkien", fantasyGenre, 1954, 1);
        book3 = new Book("944323", "The Lord of the Rings", "J.R.R. Tolkien", fantasyGenre, 1955, 2);
        book4 = new Book("665322", "Atlas Shrugged", "Ayn Rand", phiGenre, 1957, 1);
        user1 = new User("83294M", "Connor Attard", "Atlantis", 55552222, 99446655);
        user2 = new User("43495M", "Daniel Catania", "Babylon", 55557878, 99885522);
        
        catalogue = Catalogue.getInstance();        
        catalogue.addBook(book1);
        catalogue.addBook(book2);
        catalogue.addBook(book3);
        catalogue.addBook(book4);
        
        library = Library.getInstance();
        library.addUser(user1);
        library.addUser(user2);
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
        user1 = null;
        user2 = null;
        
        Catalogue.dropCatalogue();
        Library.dropLibrary();
        
        System.gc();
    }
    
    @Test
    public void addTest()
    {
        assertThat(library.getAllUsers().length,is(2));
    }
    
    @Test
    public void duplicateAddTest()
    {
        library.addUser(user1);
        library.addUser(user2);
        
        assertThat(library.getAllUsers().length,is(2));
    }
    
    @Test
    public void removeUserTest()
    {
        library.removeUser(user1);
        
        assertThat(library.getAllUsers().length,is(1));
        assertNull(library.searchByID("83294M"));
    }
    
    @Test
    public void removeUserWithLoansTest()
    {
        library.loanBookTo(book1, user1);
        library.removeUser(user1);
        
        assertThat(library.getAllUsers().length,is(2));
        assertNotNull(library.searchByID("83294M"));
    }
    
    @Test
    public void searchByIDTest()
    {
        User search = library.searchByID("83294M");
        
        assertThat(search.getFullName(),is("Connor Attard"));
        assertThat(search.getAddress(),is("Atlantis"));
    }
    
    @Test
    public void loanTest()
    {
        library.loanBookTo(book1, user1);
        library.loanBookTo(book2, user2);
        library.loanBookTo(book3, user1);
        library.loanBookTo(book4, user2);
        
        assertThat(book1.getUserLoanedTo(),is(user1));
        assertThat(book2.getUserLoanedTo(),is(user2));
        assertThat(book3.getUserLoanedTo(),is(user1));
        assertThat(book4.getUserLoanedTo(),is(user2));
        assertThat(user1.getLoanedBooks().length,is(2));
        assertThat(user2.getLoanedBooks().length,is(2));
    }
    
    @Test
    public void loanBookOnLoanTest()
    {
        library.loanBookTo(book1, user1);
        library.loanBookTo(book1, user2);
         
        assertThat(book1.getUserLoanedTo(),is(user1));
        assertThat(user1.getLoanedBooks().length,is(1));
        assertThat(user2.getLoanedBooks().length,is(0));
    }
    
    @Test
    public void exceedLoanLimitTest()
    {
        library.loanBookTo(book1, user1);
        library.loanBookTo(book2, user1);
        library.loanBookTo(book3, user1);
        library.loanBookTo(book4, user1);
        
        assertThat(user1.getLoanedBooks().length,is(3));
        assertNull(book4.getUserLoanedTo());
    }
    
    @Test
    public void returnTest()
    {
        library.loanBookTo(book1, user1);
        library.loanBookTo(book2, user2);
        
        library.returnBook(book1);
        assertNull(book1.getUserLoanedTo());
        assertThat(user1.getLoanedBooks().length,is(0));
        
        assertNotNull(book2.getUserLoanedTo());
        assertThat(user2.getLoanedBooks().length,is(1));
    }
    
    @Test
    public void overdueTest()
    {
        library.loanBookTo(book1, user1);
        
        book1.setDueDate(new Date(book1.getDateLoanedOut().getTime()-2419200000l));
        
        library.loanBookTo(book2, user1);
        assertNull(book2.getUserLoanedTo());
    }
}
