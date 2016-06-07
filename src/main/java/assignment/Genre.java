package assignment;

import java.util.ArrayList;

public class Genre
{    
    private ArrayList<Book> links;
    private String genreName;
    private String description;
    private int count;
    
    public Genre(String genreName)
    {
        this.genreName = genreName;
        this.links = new ArrayList<Book>();
        this.count = 0;
        this.description = "";
    }
    
    public void addLink(Book book) 
    {
        links.add(book);
        this.count++;
    }
    
    public void removeLink(Book book) 
    {
        links.remove(book);
        this.count--;
    }
    
    public void setGenreName(String genreName)
    {
        this.genreName = genreName;
    }
    
    public void setDescription(String description) 
    {
        this.description = description;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public String getGenreName()
    {
        return this.genreName;
    }
    
    public boolean containsBook(Book book)
    {
        return links.contains(book);
    }
    
    public int getCount()
    {
        return this.count;
    }
    
    public Book[] getBooks()
    {
        return links.toArray(new Book[links.size()]);
    }
}
