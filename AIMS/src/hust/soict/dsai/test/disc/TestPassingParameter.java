package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;


public class TestPassingParameter {
    public static void main(String[] args)
    {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        correctlyswap(jungleDVD, cinderellaDVD);
        System.out.println("How it should be done");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());


        
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        
    }
    public static void swap(Object o1, Object o2)
    {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title)
    {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void correctlyswap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
    {
        DigitalVideoDisc temp = new DigitalVideoDisc(dvd1.getTitle(), dvd1.getCategory(), dvd1.getDirector(), dvd1.getLength(), dvd1.getCost());
        dvd1.setTitle(dvd2.getTitle());
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setLength(dvd2.getLength());
        dvd1.setCost(dvd2.getCost());
        dvd2.setTitle(temp.getTitle());
        dvd2.setCategory(temp.getCategory());
        dvd2.setDirector(temp.getDirector());
        dvd2.setLength(temp.getLength());
        dvd2.setCost(temp.getCost());
    }
}
