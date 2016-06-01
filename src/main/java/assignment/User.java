package assignment;

import java.util.LinkedList;

public class User extends Observer
{    
    private String ID;
    private String fullName;
    private String address;
    private int telephoneNo;
    private int mobileNo;
    
    private LinkedList<Book> loans;
    
    public User(String ID, String fullName, String address, int telephoneNo, int mobileNo)
    {
        this.ID = ID;
        this.fullName = fullName;
        this.address = address;
        this.telephoneNo = telephoneNo;
        this.mobileNo = mobileNo;
        
        loans = new LinkedList<Book>();
    }
    
    @Override
    public void update(int pos) {
        System.out.println(" "); 
    }
    
    public void loan(Book book)
    {
        if(loans.size() == 3)
        {
            System.out.println("You cannot check out more than three books.");
            return;
        }
        
        for(Book search : loans)
        {
            if(search.isOverdue())
            {
                System.out.println("Please return any overdue books before checking out another.");
                return;
            }
        }
        
        loans.add(book);
        book.setLoanedTo(this);
    }
    
    public void unloan(Book book)
    {
        loans.remove(book);
    }
    
    public void setID(String ID)
    {
        this.ID = ID;
    }
    
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public void setTelephoneNo(int telephoneNo)
    {
        this.telephoneNo = telephoneNo;
    }
    
    public void setMobileNo(int mobileNo)
    {
        this.mobileNo = mobileNo;
    }
    
    public String getID()
    {
        return ID;
    }
    
    public String getFullName()
    {
        return fullName;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public int getTelephoneNo()
    {
        return telephoneNo;
    }
    
    public int getMobileNo()
    {
        return mobileNo;
    }
    
    public Book[] getLoanedBooks()
    {
        return loans.toArray(new Book[loans.size()]);
    }
    
    public int getNumberOfLoans()
    {
        return loans.size();
    }
}
