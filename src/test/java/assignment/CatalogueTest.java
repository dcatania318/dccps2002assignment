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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CatalogueTest {
    
    Book book1, book2, book3, book4;
    Genre fantasyGenre, phiGenre;
    Catalogue catalogue;
    
    @Before
    public void setUp() {
        fantasyGenre = new Genre("Fantasy");
        phiGenre = new Genre("Philosophy");
        book1 = new Book("978443", "The Hobbit", "J.R.R. Tolkien", fantasyGenre, 1937, 2);
        book2 = new Book("944322", "The Lord of the Rings", "J.R.R. Tolkien", fantasyGenre, 1954, 1);
        book3 = new Book("944323", "The Lord of the Rings", "J.R.R. Tolkien", fantasyGenre, 1955, 2);
        book4 = new Book("665322", "Atlas Shrugged", "Ayn Rand", phiGenre, 1957, 1);
        catalogue = Catalogue.getInstance();
    }
    
    @After
    public void tearDown() {
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
        catalogue.addBook(book1);
        catalogue.addBook(book2);
        catalogue.addBook(book3);
        
        assertNotNull(catalogue.searchByISBN("978443"));
        assertNotNull(catalogue.searchByISBN("944322"));
        assertNotNull(catalogue.searchByISBN("944323"));
    }
    
    @Test 
    public void getAllBooksTest() {
        Book[] books = catalogue.getAllBooks();
        
        assertEquals(3,books.length);
    }
    
    @Test
    public void duplicateAddTest() {
        catalogue.addBook(book1);
        
        assertEquals(3,catalogue.getAllBooks().length);
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
        assertEquals(1,phiSearch.length);
        
        for(Book book : fantasySearch) {
            assertEquals("J.R.R. Tolkien",book.getAuthor());
        }
    }
}
