/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author dcata
 */
public class Book
{
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int yearOfPublication;
    private int edition;
    // user pointer
    // date
    
    public Book(String isbn_in, String title_in, String author_in, String genre_in, int yearOfPublication_in, int edition_in)
    {
        isbn = isbn_in;
        title = title_in;
        author = author_in;
        genre = genre_in;
        yearOfPublication = yearOfPublication_in;
        edition = edition_in;
    }
    
    public void setIsbn(String isbn_in)
    {
        isbn = isbn_in;
    }
    public void setTitle(String title_in)
    {
        title = title_in;
    }
    public void setAuthor(String author_in)  
    {
        author = author_in;
    }
    public void setGenre(String genre_in)
    {
        genre = genre_in;
    }
    public void setYearOfPublication(int yearOfPublication_in)
    {
        yearOfPublication = yearOfPublication_in;
    }
    public void setEdition(int edition_in)
    {
        edition = edition_in;
    }
    
    public String getIsbn()
    {
        return isbn;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getGenre()
    {
        return genre;
    }
    public int getYearOfPublication()
    {
        return yearOfPublication;
    }
    public int getEdition()
    {
        return edition;
    }
}
