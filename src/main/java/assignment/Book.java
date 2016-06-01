package assignment;

import java.util.Date;
import java.util.LinkedList;
import java.util.Calendar;

public class Book
{
    private String isbn;
    private String title;
    private String author;
    private Genre genre;
    private int yearOfPublication;
    private int edition;
    private User loanedTo;
    private Date dateLoanedOut;
    private Date dueDate;
    
    private LinkedList<Observer> observers;
    
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
        
        observers = new LinkedList<Observer>();
    }
    
    /*
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }
    */

   public void attach(Observer observer) {
      observers.add(observer);		
   }

   public void notifyObservers(){
      for (Observer observer : observers) {
         observer.update(observers.indexOf(observer));
      }
   }
    
    public boolean isOverdue() {
        return !(loanedTo == null || dueDate.after(Calendar.getInstance().getTime()));
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
    
    public void setLoanedTo(User user)
    {
        this.loanedTo = user;
        this.dateLoanedOut = Calendar.getInstance().getTime();
        this.dueDate = new Date(2419200000l+dateLoanedOut.getTime());
    }
    
    public void setYearOfPublication(int yearOfPublication)
    {
        this.yearOfPublication = yearOfPublication;
    }
    
    public void setEdition(int edition)
    {
        this.edition = edition;
    }
    
    //For testing purposes only
    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
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
        
        User next = (User)observers.pollFirst();
        
        if(next != null) {
            Library.getInstance().loanBookTo(this, next);
            notifyObservers();
        }
    }
    
    public User getUserLoanedTo()
    {
        return loanedTo;
    }
    
    public Date getDateLoanedOut()
    {
        return dateLoanedOut;
    }
    
    public Date getDueDate() {
        return dueDate;
    }
}
