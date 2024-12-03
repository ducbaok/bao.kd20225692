package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    
    private List<String> authors = new ArrayList<String>();


    public Book(String title, String category, float cost){
        super(title, category, cost);
    };
    public Book(String title)
    {
        super(title, "Unknown", 0f);
    }
    public void addAuthor(String authorName)
    {
        if(authors.contains(authorName))
        {
            System.out.println(authorName + " already exists.");
        }
        else
        {
            authors.add(authorName);
            System.out.println(authorName + " has been sucessfully added.");
        }
    }

    public void removeAuthor(String authorName)
    {
        if(authors.contains(authorName))
        {
            authors.remove(authorName);
            System.out.println(authorName + " has been sucessfully removed.");   
        }
        else
        {
            System.out.println(authorName + " does not exist.");
        }
    }
    public void play()
    {
        System.out.println("Error.");
    }
}
