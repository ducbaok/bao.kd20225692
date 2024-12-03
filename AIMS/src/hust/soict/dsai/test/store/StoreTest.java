package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store dvdstore = new Store();
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

        dvdstore.add(dvd1);
        dvdstore.add(dvd2);

        

        dvdstore.displayStore();
        System.out.println();

        dvdstore.remove(dvd3.getTitle()); //Expected output: Chưa thêm đĩa 3 nên không tìm thấy

        dvdstore.add(dvd3); //Thêm

        dvdstore.remove(dvd3.getTitle()); //Expected output: Xóa thành công
        dvdstore.remove(dvd3.getTitle()); //Expected output: Đã xóa nên không xóa được nữa

        dvdstore.displayStore();
    }
}
