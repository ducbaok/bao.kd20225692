package hust.soict.dsai.test.cart;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart cart = new Cart();

            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                                                       "Animation",
                                                       "Roger Allers",
                                                       87,
                                                       19.95f);
            cart.add(dvd1);

            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                                                       "Science Fiction",
                                                       "George Lucas",
                                                       87,
                                                       24.95f);
            cart.add(dvd2);

            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                                                       "Animation",
                                                       18.99f);


            DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladdin",
                                                       "Animation",
                                                       19.01f);
            cart.add(dvd3);
            Book book1 = new Book("Nihongo", "Language", 20);
            cart.add(book1);
            cart.add(dvd4);
            CompactDisc cd1 = new CompactDisc("Big Bang", "Music", "BigBang", 600);
            cart.add(cd1);
            cart.display();
            cart.SortTitleCost();
            cart.display();
            /*try (Scanner sc = new Scanner(System.in)) {
    
                System.out.println("Search by id");
                int searchedId = sc.nextInt();
                cart.search(searchedId);
            }*/
            
        
    }

    
}