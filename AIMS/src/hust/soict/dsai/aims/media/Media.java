package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public boolean stateofdel = false;
    private static int nb = 0;
    public Media(String title, String category, float cost)
    {
        this.id = nb++;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    @Override
    public String toString() {
        return new StringBuilder()
                .append(getClass().getSimpleName())
                .append(" Title: ").append(title)
                .append(", Category: ").append(category)
                .append(", Cost: ").append(cost).toString();
    }
    public abstract void play();
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    @Override
    public boolean equals(Object o){
        if(o == this) return true;

        if(o == null || o.getClass() != getClass()) return false;

        Media m = (Media) o;
        if(this.title == m.title) return true;
        return false;
    }
    public boolean isMatch(String query)
    {
        String[] queryWords = query.toLowerCase().split("\\s+");  
        for (String word : queryWords) {
            if (getTitle().toLowerCase().contains(word)) {
                return true;
            }
        }

        return false;
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
