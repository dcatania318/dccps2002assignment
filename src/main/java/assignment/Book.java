package assignment;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Book
{
    private String isbn;
    private String title;
    private String author;
    private Genre genre;
    private int yearOfPublication;
    private int edition;
    private User loanedTo;
    private LocalDate dateLoanedOut;
    private LocalDate dueDate;
    
    public Book(String isbn, String title, String author, Genre genre, int yearOfPublication, int edition)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.edition = edition;
        this.loanedTo = null;
        this.dateLoanedOut = null;
        this.dueDate = null;
    }
    
    public boolean isOverdue() {
        return !(loanedTo == null || dueDate.isAfter(LocalDate.now()));
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
    
    public void setGenre(Genre genre)
    {
        this.genre.removeLink(this);
        this.genre = genre;
        genre.addLink(this);
    }
    
    public void setLoanedTo(User user) {
        this.loanedTo = user;
        this.dateLoanedOut = LocalDate.now();
        this.dueDate = dateLoanedOut.plus(4, ChronoUnit.WEEKS);
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
        return genre.getGenreName();
    }
    
    public Genre getGenreObject()
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
    
    public void returned()
    {
        loanedTo = null;
        dateLoanedOut = null;
        dueDate = null;
    }
    
    public User getUserLoanedTo()
    {
        return loanedTo;
    }
    
    public LocalDate getDateLoanedOut()
    {
        return dateLoanedOut;
    }
}