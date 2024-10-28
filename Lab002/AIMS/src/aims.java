
public class aims {
    public static void main(String[] args) {
        Cart newOrd = new Cart();
        DigitalVideoDisc disc1 = new DigitalVideoDisc("The lion king","Animation","Roger Allers",87,19.95f);
        newOrd.addDigitalVideoDisc(disc1);
        DigitalVideoDisc disc2 = new DigitalVideoDisc("Star Wars","Science fiction","George Lucas",87,24.95f);
        newOrd.addDigitalVideoDisc(disc2);
        DigitalVideoDisc disc3 = new DigitalVideoDisc("Aladin");
        disc3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        newOrd.addDigitalVideoDisc(disc3);
        System.out.println("Total cost is: "+ newOrd.totalCost());
        newOrd.display();
        newOrd.removeDigitalVideoDisc(disc3);
        newOrd.removeDigitalVideoDisc(disc3); //check if disc3 was removed or not
    }
}