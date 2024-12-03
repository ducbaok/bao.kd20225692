package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    
    
    
    

    
    public DigitalVideoDisc(String title) {
        super(title, "Unknown", "Unknown", 0, 0);
        setTitle(title);
    }
    public DigitalVideoDisc(String title,String category,float cost){
        super(title, category, "Unknown", 0, cost);
    }
    public DigitalVideoDisc(String title,String director,float cost,String category){
        super(title, category, director, 0, cost);
    }
    public DigitalVideoDisc(String title,String category,String director,int length,float cost){
        super(title, category, director, length, cost);
    }

    

    public boolean isExist(String title, String category, String director, int length, float cost)
    {
        if(getTitle() == title && getCategory() == category && getDirector() == director && getLength() == length && getCost() == cost) return true;
        return false;
    };

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }    
}