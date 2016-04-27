package assignment;

import java.util.ArrayList;
import java.util.HashMap;

public class Genre
{   
    private static HashMap<String, Genre> handles;
    
    private ArrayList<Book> links;
    private String genreName;
    private String description;
    private int count;
    
    private Genre(String genreName)
    {
        this.genreName = genreName;
        this.links = new ArrayList<Book>();
        this.count = 0;
        this.description = null;
    }
    
    public static Genre createGenre(String genreName)
    {
        if(handles == null) 
        {
            handles = new HashMap<String, Genre>();
        }
        
        if(handles.containsKey(genreName) == false) 
        {
            handles.put(genreName, new Genre(genreName));
        }
        
        return handles.get(genreName);
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
    
    public static Genre getGenreHandle(String genreName) 
    {
        return handles.get(genreName);
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
}