package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int qtyOrdered = 0;
    public static final int MAX_NUMBER_ORDERED = 20;
    private ObservableList<Media> itemOrdered = FXCollections.observableArrayList();

    public void add(Media media) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemOrdered.add(media);
            qtyOrdered++;
            System.out.println(media.getClass().getSimpleName() + " has been successfully added.");
        } else {
            System.out.println("Error. The cart is full.");
        }
    }

    public ObservableList<Media> getItemOrdered() {
        return itemOrdered;
    }

    // Modified search method to return a List<Media>
    public List<Media> searchbyQuery(String query) {
        List<Media> matchedItems = new ArrayList<>();
        for (Media media : itemOrdered) {
            if (media.isMatch(query)) {
                matchedItems.add(media);
            }
        }
        return matchedItems;
    }

    public List<Media> searchbyID(String query) {
        List<Media> matchedItems = new ArrayList<>();
        for (Media media : itemOrdered) {
            if(media.getId() == Integer.parseInt(query)) matchedItems.add(media);
        }
        return matchedItems;
    }

    public void remove(Media media) {
        if (itemOrdered.remove(media)) {
            qtyOrdered--;
            System.out.println("Item has been successfully removed.");
        } else {
            System.out.println("Error. Item is not found.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void clear() {
        itemOrdered.clear();
        qtyOrdered = 0;
        System.out.println("The cart has been cleared.");
    }

    public void SortTitleCost()
    {
        itemOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }
    
    public void SortCostTitle()
    {
        itemOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public void display(){
        System.out.println("Items in cart:");
        for(Media media: itemOrdered){
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost());
    }
}
