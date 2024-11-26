import java.util.Scanner;

public class CartTest {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart cart = new Cart();

            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                                                       "Animation",
                                                       "Roger Allers",
                                                       87,
                                                       19.95f);
            cart.addDigitalVideoDisc(dvd1);

            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                                                       "Science Fiction",
                                                       "George Lucas",
                                                       87,
                                                       24.95f);
            cart.addDigitalVideoDisc(dvd2);

            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                                                       "Animation",
                                                       18.99f);
            cart.addDigitalVideoDisc(dvd3);


            cart.printCart();

            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Search by title");
                String searchedTitle = sc.nextLine();
                cart.search(searchedTitle);
    
                System.out.println("Search by id");
                int searchedId = sc.nextInt();
                cart.search(searchedId);
            }
            
        
    }

    
}