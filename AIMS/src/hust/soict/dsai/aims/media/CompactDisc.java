package hust.soict.dsai.aims.media;

import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String category, String artist, float cost) 
    {
        super(title, category, "", 0, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }
    public CompactDisc(String title, float cost) 
    {
        super(title, "Music", "Unknown Artist", 0, cost);
    }
    public CompactDisc(String title) 
    {
        super(title, "Music", "Unknown Artist", 0, 9.99f);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track inputTrack)
    {
        if(tracks.contains(inputTrack))
        {
            System.out.println(inputTrack.getTitle() + " already exists.");
        }
        else
        {
            tracks.add(inputTrack);
            System.out.println(inputTrack.getTitle() + " has been sucessfully added.");
        }
    }

    public void removeAuthor(Track inputTrack)
    {
        if(tracks.contains(inputTrack))
        {
            tracks.remove(inputTrack);
            System.out.println(inputTrack.getTitle() + " has been sucessfully removed.");   
        }
        else
        {
            System.out.println(inputTrack.getTitle() + " does not exist.");
        }
    }

    public int getLength()
    {
        int total = 0;
        for(Track t : tracks)
        {
            total += t.getLength();
        }
        return total;
    };

    public void play()
    {
        for(Track t: tracks)
        {
            t.play();
        }
    }
}
