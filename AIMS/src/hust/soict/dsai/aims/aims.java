package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;

public class aims {

    public static Store store = new Store();
    public static Cart cart = new Cart();
    public static Scanner scanner = new Scanner(System.in);
    static ArrayList<Media> queryRes = new ArrayList<Media>();
        public static void main(String[] args) {
            defaultStore();
            mainP();
        }
        public static void mainP()
        {
            
                    
    
            while(26 != 27)
            {
                showMenu();     
                int choice = scanner.nextInt();
                scanner.nextLine();
    
                switch (choice)
                {
                    case 1:
                        viewStore();
                        continue;
                    case 2:
                        updateStore();
                        continue;
                    case 3:
                        seeCurrentCart();
                        continue;
                    case 0:
                        System.out.println("Exiting program....");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    
        public static void showMenu() {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
        }
    
        public static void storeMenu() { //AIMS.1
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
        }
    
        public static void mediaDetailsMenu() { //AIMS.1.1
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
        }
    
        public static Media getChosen()
        {
            System.out.println("Enter item title you want");
            String query = scanner.nextLine();
            queryRes = store.searchByTitle(query);
            System.out.println("Query result");
            if(!queryRes.isEmpty())
            {
                for(Media m : queryRes)
                {
                    System.out.println(m.toString());
                }
            }
            else
            {
                System.out.println("Not found.");
                return null;
            }
            System.out.println("-----------------------------");
            System.out.println("Enter number of item you want");
            int number = scanner.nextInt();
            Media chosen = queryRes.get(number);
            return chosen;
        }
    
        public static void filterMenu() {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart by id");
            System.out.println("2. Filter medias in cart by title");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
        }

        public static void filter(){
            while(26 != 27)
            {
                filterMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice)
                {
                    case 1:
                        System.out.println("Enter id");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        cart.search(id);
                        continue;
                    case 2:
                        System.out.println("Enter title");
                        String title = scanner.nextLine();
                        cart.search(title);
                        continue;
                    case 0:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    
        public static void sortMenu() {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart by cost");
            System.out.println("2. Filter medias in cart by title");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
        }
        
        public static void sort(){
            while(26 != 27)
            {
                cart.display();
                sortMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice)
                {
                    case 1:
                        cart.SortCostTitle();
                        continue;
                    case 2:
                        cart.SortTitleCost();
                        continue;
                    case 0:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
            
        }

    public static void viewStore() {
            
            while(26 != 27)
            {
                store.displayStore();
                storeMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
    
                switch (choice)
                {
                    case 1:
                        seeMediaDetails();
                        continue;
                    case 2:
                        addToCart();
                        continue;
                    case 3:
                        Media chosen = getChosen();
                        chosen.play();
                    case 4:
                        seeCurrentCart();
                        continue;

                    case 0:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
        
    public static void seeMediaDetails() //done
        {
            
            
            
            while(26 != 27){
                Media chosen = getChosen();
                mediaDetailsMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice)
                {
                    
                    case 1:
                        
                        cart.add(chosen);
                        continue;
                    case 2:
                        
                        String gclass = chosen.getClass().getSimpleName();
                        if(!gclass.equals("DigitalVideoDisc") && !gclass.equals("CompactDisc"))
                        {
                            System.out.println("Can not play due to kind of item.");
                        }
                        else
                        {
                            chosen.play();
                        }
                        continue;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
            
        }
    
    public static void addToCart()
    {
            System.out.println("Enter item title you want");
            String query = scanner.nextLine();
            queryRes = store.searchByTitle(query);
            System.out.println("Query result");
            if(queryRes != null)
            {
                for(Media m : queryRes)
                {
                    System.out.println(m.toString());
                }
            }
            else
            {
                System.out.println("Not found.");
                return;
            }
            System.out.println("-----------------------------");
            System.out.println("Enter number of item you want");
            int number = scanner.nextInt();
            cart.add(queryRes.get(number));
            System.out.println("Current number of items in cart: " + cart.getItemOrdered());
            return;
    }


    
    public static void updateStoreMenu(){ //AIMS.2
        System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
    }

    public static void updateStore()
    {
        while(26 != 27)
        {
            store.displayStore();
            updateStoreMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice)
                {
                    case 1:
                        addMediaToStore();
                        continue;
                    case 2:
                        removeMediafStore();
                        continue;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
        }
    }   

    public static void addMediaToStore()
    {
        System.out.println("Please enter title.");
        String title = scanner.nextLine();

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a book");
        System.out.println("2. Add a CD");
        System.out.println("3. Add a DVD");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        int option = scanner.nextInt();
        scanner.nextLine();
        
        Media media;
        switch(option){
            case 1: 
                media = new Book(title);
                break;
            case 2:
                media = new CompactDisc(title);
                break;
            case 3:
                media = new DigitalVideoDisc(title);
            case 0:
                return;
            default:
                System.out.println("Invalid option.");
                return;
        }
        store.add(media);
    }

    public static void removeMediafStore()
    {
        System.out.println("Please enter title.");
        String title = scanner.nextLine();
        store.remove(title);
    }

    public static void defaultStore()
    {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                                                       "Animation",
                                                       "Roger Allers",
                                                       87,
                                                       19.95f);
                                                
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                                                       "Science Fiction",
                                                       "George Lucas",
                                                       87,
                                                       24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                                                       "Animation",
                                                       18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladdin",
                                                       "Animation",
                                                       19.01f);
        Book book1 = new Book("Nihongo", "Language", 20);
        CompactDisc cd1 = new CompactDisc("Big Bang", "Music", "BigBang", 600);
        store.add(dvd1);
        store.add(dvd2);  
        store.add(dvd3);
        store.add(dvd4);
        store.add(book1);
        store.add(cd1);                                                 
    }
    
    public static void playMedia(Media chosen)
    {
        String gclass = chosen.getClass().getSimpleName();
        if(!gclass.equals("DigitalVideoDisc") && !gclass.equals("CompactDisc"))
        {
            System.out.println("Can not play due to kind of item.");
        }
        else
        {
            chosen.play();
        }
    }
    

    public static void cartMenu() { //AIMS.3
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void seeCurrentCart()
    {
        while(26 != 27)
        {
            cart.display();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    filter();
                    continue;
                case 2:
                    sort();
                    continue;
                case 3:
                    removeMediafCart();
                    continue;
                case 4:
                    Media chosen = getChosen();
                    chosen.play();
                    continue;
                case 5:
                    cart.clear();
                    continue;
                case 0:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public static void removeMediafCart(){
        Media chosen = getChosen();
        cart.remove(chosen);
    }
        
    

    
}