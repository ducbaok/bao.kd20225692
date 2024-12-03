package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private String title;
    private int length;
    public Track(String title)
    {
        this.title = title;
    }
    public Track(String title, int length)
    {
        this.title = title;
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public String getTitle() {
        return title;
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    } 
    @Override
    public boolean equals(Object t){
        if(t == this) return true;

        if(t == null || t.getClass() != getClass()) return false;

        Track track = (Track) t;

        if(this.title == track.title && this.length == track.length) return true;
        return false;
    }
}
