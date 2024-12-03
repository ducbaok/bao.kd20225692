package hust.soict.dsai.aims.media;

public class Disc extends Media{
    
    private int length;
    private String director;
    
    public Disc(String title, String category, String director, int length, float cost) 
    {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public boolean isExist(String title, String category, String director, int length, float cost)
    {
        if(getTitle() == title && getCategory() == category && getDirector() == director && getLength() == length && getCost() == cost) return true;
        return false;
    };
    
    public void play()
    {
        System.out.println("Error.");
    }
}
