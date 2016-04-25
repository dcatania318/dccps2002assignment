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

import java.util.ArrayList;
import java.util.HashMap;

public class Genre
{
    /* No longer necessary. Genres can be created without having to recompile program
    public static enum GenreType
    {
        FICTION, BIOGRAPHY, COMEDY, DRAMA, HISTORICAL, 
        ROMANCE, SATIRE, TRAGEDY, HORROR, CRIME, OTHER
    }
    */
    
    private static HashMap<String, Genre> handles;
    
    private ArrayList<Book> links;
    private String genreName;
    private String description;
    private int count;
    
    private Genre(String genreName) {
        this.genreName = genreName;
        this.count = 0;
    }
    
    public static Genre createGenre(String genreName) {
        if(handles == null) {
            handles = new HashMap<String, Genre>();
        }
        
        if(handles.containsKey(genreName) == false) {
            handles.put(genreName, new Genre(genreName));
            
            return handles.get(genreName);
        }
        else {
            System.err.println("A genre of this kind has already been created.");
            
            return null;
        }
    }
    
    public void addLink(Book book) {
        links.add(book);
        this.count++;
    }
    
    public void removeLink(Book book) {
        links.remove(book);
        count--;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}