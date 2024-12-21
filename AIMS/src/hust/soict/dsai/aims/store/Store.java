package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

public class Store {

    public static final int MAX_AMOUNT = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore(){
        return itemsInStore;
    }
    private int mediaCount = 0;
    public void add(Media media){
        if(mediaCount < 100)
        {
            itemsInStore.add(media);
            mediaCount++;
            System.out.println(media.getClass().getSimpleName() + " " + media.getTitle() + " has been sucessfully added.");
        }
        else
        {
            System.out.println("Error. Store is full.");
        }
        
    } 
   
    public void remove(String title){
        boolean removed = false;
        for(Media m : itemsInStore)
        {
            if(m.getTitle() == title)
            {
            if(m.stateofdel == true)
                {
                    System.out.println("Error. " + m.getClass().getSimpleName() + " " + m.getTitle() + " has already been deleted.");
                }
            m.stateofdel = true;
            System.out.println(m.toString() + " has been successfully deleted.");
            }
        }
        if(!removed)
        {
            System.out.println("Error. No item found.");
        }
    }

    public void displayStore()
    {
        System.out.println("Store:");
        for(Media m : itemsInStore)
        {
            if(!m.stateofdel)
            {
                System.out.println(m.toString());
            }
        }
    }

    public ArrayList<Media> searchByTitle(String query)
    {
        ArrayList<Media> queryResult = new ArrayList<Media>();
        for(Media m : itemsInStore)
        {
            if(!m.stateofdel && m.isMatch(query))
            {
                queryResult.add(m);
            }
        }
        return queryResult;
    }

    public int size()
    {
        return itemsInStore.size();
    }
}
