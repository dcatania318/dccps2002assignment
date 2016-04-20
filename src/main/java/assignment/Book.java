/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Date;

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
    private User loanedTo; //Should be decoupled from individual book record IMO. Might cut down on memory usage.
    private Date dateLoanedOut; //Ditto
    
    public Book(String isbn, String title, String author, String genre, int yearOfPublication, int edition)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.edition = edition;
        this.loanedTo = null;
        this.dateLoanedOut = null;
    }
    
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setAuthor(String author)  
    {
        this.author = author;
    }
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    public void setYearOfPublication(int yearOfPublication)
    {
        this.yearOfPublication = yearOfPublication;
    }
    public void setEdition(int edition)
    {
        this.edition = edition;
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
    
    public void loan(User user, Date currentDate)
    {
        loanedTo = user;
        dateLoanedOut = currentDate;
    }
    public void returned()
    {
        loanedTo = null;
        dateLoanedOut = null;
    }
    public User getUserLoanedTo()
    {
        return loanedTo;
    }
    public Date getDateLoanedOut()
    {
        return dateLoanedOut;
    }
}