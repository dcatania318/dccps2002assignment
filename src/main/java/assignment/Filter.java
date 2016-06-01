package assignment;

public class Filter {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int yearOfPublication;
    private int edition;
    
    public Filter() {
        this.isbn = null;
        this.title = null;
        this.author = null;
        this.genre = null;
        this.yearOfPublication = -1;
        this.edition = -1;
    }
    
    public String getIsbn()
    {
        return (isbn == null) ?  null : isbn.toLowerCase();
    }
    
    public String getTitle()
    {
        return (title == null) ? null : title.toLowerCase();
    }
    
    public String getAuthor()
    {
        return (author == null) ? null : author.toLowerCase();
    }
    
    public String getGenre()
    {
        return (genre == null) ? null : genre.toLowerCase();
    }
    
    public int getYearOfPublication()
    {
        return yearOfPublication;
    }
    
    public int getEdition()
    {
        return edition;
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
}
