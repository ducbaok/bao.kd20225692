public class StoreTest {
    public static void main(String[] args) {
        store dvdstore = new store();
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

        dvdstore.addDigitalVideoDisc(dvd1);
        dvdstore.addDigitalVideoDisc(dvd2);

        

        dvdstore.displayStore();
        System.out.println();

        dvdstore.removeDigitalVideoDisc(dvd3); //Expected output: Chưa thêm đĩa 3 nên không tìm thấy

        dvdstore.addDigitalVideoDisc(dvd3); //Thêm

        dvdstore.removeDigitalVideoDisc(dvd3); //Expected output: Xóa thành công
        dvdstore.removeDigitalVideoDisc(dvd3); //Expected output: Đã xóa nên không xóa được nữa

        dvdstore.displayStore();
    }
}
