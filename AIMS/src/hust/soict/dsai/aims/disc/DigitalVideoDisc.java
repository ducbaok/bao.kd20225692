package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;
    public boolean stateofdel = false;
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " - " + cost + "$";
    }

    public float getCost() {
        return cost;
    }
    public DigitalVideoDisc(String title) {
        super();
        this.id = nbDigitalVideoDiscs++;
        this.title = title;
    }
    public DigitalVideoDisc(String title,String category,float cost){
        super();
        this.id = nbDigitalVideoDiscs++;
        this.title=title;
        this.category=category;
        this.cost=cost;
    }
    public DigitalVideoDisc(String title,String director,float cost,String category){
        super();
        this.id = nbDigitalVideoDiscs++;
        this.title=title;
        this.director=director;
        this.cost=cost;
        this.category=category;
    }
    public DigitalVideoDisc(String title,String category,String director,int length,float cost){
        super();
        this.id = nbDigitalVideoDiscs++;
        this.title=title;
        this.director=director;
        this.cost=cost;
        this.length=length;
        this.category=category;
    }

    public boolean isMatch(String query)
    {
        String[] queryWords = query.toLowerCase().split("\\s+");  
        for (String word : queryWords) {
            if (title.toLowerCase().contains(word)) {
                return true;
            }
        }

        return false;
    }

    public boolean isExist(String title, String category, String director, int length, float cost)
    {
        if(this.title == title && this.category == category && this.director == director && this.length == length && this.cost == cost) return true;
        return false;
    }
}