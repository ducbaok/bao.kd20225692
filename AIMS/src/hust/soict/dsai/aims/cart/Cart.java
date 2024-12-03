package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
public class Cart {
    private int qtyOrdered=0;
    public static final int MAX_NUMBER_ORDERED =20;
    private ArrayList<Media> itemOrdered = new ArrayList<Media>();
    public void add(Media media){
        if(qtyOrdered<MAX_NUMBER_ORDERED){
            itemOrdered.add(media);
            qtyOrdered++;
            System.out.println(media.getClass().getSimpleName() + " has been sucessfully added.");
        }
        else{
            System.out.println("Error. The cart is full.");
        }
    }
    /*public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
       
        for(DigitalVideoDisc disc : dvdList)
        {
            if(qtyOrdered<MAX_NUMBER_ORDERED){
                dvd.add(disc);
                qtyOrdered++;
                System.out.println("Disc " + disc.getTitle() + " has been sucessfully added.");
            }
            else
            {
                System.out.println("Error. The cart is full.");
                break;
            }
        }
    }*/
    public ArrayList<Media> getItemOrdered() {
        return itemOrdered;
    }
    public void add(Media... mediaList){
       
        for(Media media : mediaList)
        {
            if(qtyOrdered<MAX_NUMBER_ORDERED){
                itemOrdered.add(media);
                qtyOrdered++;
                System.out.println(media.getTitle() + " has been sucessfully added.");
            }
            else
            {
                System.out.println("Error. The cart is full.");
                break;
            }
        }
    }
    public void add(Media media1, Media media2){
        if(qtyOrdered<MAX_NUMBER_ORDERED){
            itemOrdered.add(media1);
            qtyOrdered++;
            System.out.println(media1.getTitle() + " has been sucessfully added.");
        }
        else{
            System.out.println("Error. The cart is full.");
        }
        if(qtyOrdered<MAX_NUMBER_ORDERED){
            itemOrdered.add(media2);
            qtyOrdered++;
            System.out.println(media2.getTitle() + " has been sucessfully added.");
        }
        else{
            System.out.println("Error. The cart is full.");
        }
    }
   
    public void remove(Media media){
        if(itemOrdered.remove(media)){
            qtyOrdered--;
            System.out.println("Item has been sucessfully removed.");
        }
        else{
            System.out.println("Error. Item is not found.");
        }
    }
    public float totalCost() {
        float total=0;
        for(Media media : itemOrdered){
            total+=media.getCost();
        }    
        return total;
    }

    public void display(){
        System.out.println("Items in cart:");
        for(Media media: itemOrdered){
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost());
    }

    /*public void printCart(){
        System.out.println("***********************CART************************\r\n" + "Ordered Items:\r\n");
        for(DigitalVideoDisc disc : dvd)
        {
            System.out.println(disc.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }*/
    
    public void search(int id)
    {
        for(Media media : itemOrdered)
        {
            if(media.getId() == id)
            {
                //System.out.println(disc.toString());
                return;
            }
        }
        System.out.println("Error. Item is not found.");
    }

    public void search(String query)
    {
        int count = 0;
        for(Media m : itemOrdered)
        {
            if(m.isMatch(query))
            {
                count++;
                System.out.println(m.toString());
            }
        }
        if(count == 0) System.out.println("Error. Item is not found.");
    }
    public void SortTitleCost()
    {
        itemOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }
    
    public void SortCostTitle()
    {
        itemOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }
    public void clear() {
        itemOrdered.clear();  // Clears all items from the cart
        qtyOrdered = 0;       // Resets the quantity of items ordered to 0
        System.out.println("The cart has been cleared.");
    }
}