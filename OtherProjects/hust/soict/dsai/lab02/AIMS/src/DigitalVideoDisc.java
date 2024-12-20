package hust.soict.dsai.lab02.AIMS.src;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }
    public DigitalVideoDisc(String title,String category,float cost){
        super();
        this.title=title;
        this.category=category;
        this.cost=cost;
    }
    public DigitalVideoDisc(String title,String director,float cost,String category){
        super();
        this.title=title;
        this.director=director;
        this.cost=cost;
        this.category=category;
    }
    public DigitalVideoDisc(String title,String category,String director,int length,float cost){
        super();
        this.title=title;
        this.director=director;
        this.cost=cost;
        this.length=length;
        this.category=category;
    }
}