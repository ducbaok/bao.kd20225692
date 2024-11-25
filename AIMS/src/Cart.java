import java.util.ArrayList;
public class Cart {
    private int qtyOrdered=0;
    public static final int MAX_NUMBER_ORDERED =20;
    private ArrayList<DigitalVideoDisc> dvd = new ArrayList<>();
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered<MAX_NUMBER_ORDERED){
            dvd.add(disc);
            qtyOrdered++;
            System.out.println("The disc has been sucessfully added.");
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
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList){
       
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
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if(qtyOrdered<MAX_NUMBER_ORDERED){
            dvd.add(dvd1);
            qtyOrdered++;
            System.out.println("Disc " + dvd1.getTitle() + " has been sucessfully added.");
        }
        else{
            System.out.println("Error. The cart is full.");
        }
        if(qtyOrdered<MAX_NUMBER_ORDERED){
            dvd.add(dvd2);
            qtyOrdered++;
            System.out.println("Disc " + dvd2.getTitle() + " has been sucessfully added.");
        }
        else{
            System.out.println("Error. The cart is full.");
        }
    }
   
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if(dvd.remove(disc)){
            qtyOrdered--;
            System.out.println("The disc has been sucessfully removed.");
        }
        else{
            System.out.println("Error. The disc is not found.");
        }
    }
    public float totalCost() {
        float total=0;
        for(DigitalVideoDisc disc : dvd){
            total+=disc.getCost();
        }    
        return total;
    }
    public void display(){
        System.out.println("DVDs in cart:");
        for(DigitalVideoDisc disc: dvd){
            System.out.printf("%-30s| %-20s| %-20s| %-5d | %-5g$\n", disc.getTitle(), disc.getCategory(), disc.getDirector(), disc.getLength(), disc.getCost());
        }
    }
}