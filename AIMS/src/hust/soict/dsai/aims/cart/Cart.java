package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
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

    public void printCart(){
        System.out.println("***********************CART************************\r\n" + "Ordered Items:\r\n");
        for(DigitalVideoDisc disc : dvd)
        {
            System.out.println(disc.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
    public void search(int id)
    {
        for(DigitalVideoDisc disc : dvd)
        {
            if(disc.getId() == id)
            {
                System.out.println(disc.toString());
                return;
            }
        }
        System.out.println("Error. The disc is not found.");
    }

    public void search(String query)
    {
        int count = 0;
        for(DigitalVideoDisc disc : dvd)
        {
            if(disc.isMatch(query))
            {
                count++;
                System.out.println(disc.toString());
            }
        }
        if(count == 0) System.out.println("Error. The disc is not found.");
    }
    

}