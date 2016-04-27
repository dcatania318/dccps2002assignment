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
            return handles.get(genreName);
        }
        else
        {
            System.err.println("A genre of this kind has already been created.");
            return null;
        }
    }
    
    public void addLink(Book book)
    {
        links.add(book);
        this.count++;
    }
    
    public void removeLink(Book book)
    {
        links.remove(book);
        count--;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
}