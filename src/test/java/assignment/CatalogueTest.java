/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Connor
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CatalogueTest {
    
    static Book book1, book2, book3, book4;
    static Genre fantasyGenre, phiGenre;
    static Catalogue catalogue;
    
    @BeforeClass
    public static void setGlobalEnvironment() {
        fantasyGenre = new Genre("Fantasy");
        phiGenre = new Genre("Philosophy");
        book1 = new Book("978443", "The Hobbit", "J.R.R. Tolkien", fantasyGenre, 1937, 2);
        book2 = new Book("944322", "The Lord of the Rings", "J.R.R. Tolkien", fantasyGenre, 1954, 1);
        book3 = new Book("944323", "The Lord of the Rings", "J.R.R. Tolkien", fantasyGenre, 1955, 2);
        book4 = new Book("665322", "Atlas Shrugged", "Ayn Rand", phiGenre, 1957, 1);
        
        catalogue = Catalogue.getInstance();
    }
    
    @Before
    public void setUp() {
        catalogue.addBook(book1);
        catalogue.addBook(book2);
        catalogue.addBook(book3);
        catalogue.addBook(book4);
    }
    
    @After
    public void tearDown() {
        catalogue.removeBook(book1);
        catalogue.removeBook(book2);
        catalogue.removeBook(book3);
        catalogue.removeBook(book4);
    }
    
    @AfterClass
    public static void cleanup() {
        fantasyGenre = null;
        phiGenre = null;
        book1 = null;
        book2 = null;
        book3 = null;
        book4 = null;
        
        Runtime.getRuntime().gc();
    }
    
    @Test
    public void addAndSearchTest() {
        assertNotNull(catalogue.searchByISBN("978443"));
        assertNotNull(catalogue.searchByISBN("944322"));
        assertNotNull(catalogue.searchByISBN("944323"));
        assertNotNull(catalogue.searchByISBN("665322"));
    }
    
    @Test 
    public void getAllBooksTest() {
        assertEquals(4,catalogue.getAllBooks().length);
    }
    
    @Test
    public void duplicateAddTest() {
        catalogue.addBook(book1);
        
        assertEquals(4,catalogue.getAllBooks().length);
    }
    
    @Test
    public void removeTest() {
        catalogue.removeBook(book1);
        catalogue.removeBook(book4);
        
        assertNull(catalogue.searchByISBN("978443"));
        assertNull(catalogue.searchByISBN("665322"));
        
        assertEquals(2,catalogue.getAllBooks().length);
    }
    
    @Test
    public void searchByYearOfPublicationTest() {
        Book[] search = catalogue.searchByYearOfPublication(1957);
        
        assertEquals(1,search.length);
        assertEquals("Ayn Rand",search[0].getAuthor());
    }
    
    @Test
    public void searchByTitleTest() {
        Book[] search = catalogue.searchByTitle("The Lord of the Rings");
        
        assertEquals(2,search.length);
        
        for(Book book : search) {
            assertEquals("The Lord of the Rings", book.getTitle());
        }
    }
    
    @Test
    public void searchByGenreTest() {
        Book[] fantasySearch = catalogue.searchByGenre(fantasyGenre);
        Book[] phiSearch = catalogue.searchByGenre(phiGenre);
        
        assertEquals(3,fantasySearch.length);
        assertEquals("Ayn Rand",phiSearch[0].getAuthor());
        
        for(Book book : fantasySearch) {
            assertEquals("J.R.R. Tolkien",book.getAuthor());
        }
    }
}
