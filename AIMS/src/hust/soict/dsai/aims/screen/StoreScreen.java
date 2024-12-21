package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.*;

public class StoreScreen extends JFrame{
    private static Store store = new Store();
    private Cart cart = new Cart();

    public static void main(String[] args) {
        init();
        new StoreScreen(store);
    }
    public static void init(){
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
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladdin",
                                                       "Animation",
                                                       19.01f);
        Book book1 = new Book("Nihongo", "Language", 20);
        CompactDisc cd1 = new CompactDisc("Big Bang", "Music", "BigBang", 600);

        Book book4 = new Book("The Great Gatsby", "Fiction", 15.99f);
        Book book2 = new Book("To Kill a Mockingbird", "Classic", 12.99f);
        Book book3 = new Book("1984", "Dystopian", 18.50f);

        store.add(dvd1);
        store.add(dvd2);  
        store.add(dvd3);
        store.add(dvd4);
        store.add(book1);
        store.add(cd1);   
        store.add(book2);
        store.add(book3);
        store.add(book4);
    }

    public StoreScreen(Store store){
        StoreScreen.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
    
    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.decode("#FBB3B3"));

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize((new Dimension(100, 50)));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int size = store.size();
        for(int i = 0; i < size; i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    public class MediaStore extends JPanel{
        private Media media;
        public MediaStore(Media media){
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);
    
            JLabel cost = new JLabel("" + media.getCost() + " $");
            cost.setAlignmentX(CENTER_ALIGNMENT);
    
            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));
    
            JButton addToCartButton = new JButton("Add to cart");
            addToCartButton.addActionListener(e -> cart.add(this.media));;
            container.add(addToCartButton);

            if(media instanceof Playable)
            {
                JButton playButton = new JButton("Play");
                playButton.addActionListener(e -> playDialog(this.media));
                container.add(playButton);
            }
    
            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);
    
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        private void playDialog(Media media){
            JDialog playDialog = new JDialog((Frame) null, "Playing " + media.getTitle(), true);
            playDialog.setSize(400, 300);
            playDialog.setLayout(new BorderLayout());

            JLabel mediaInfo = new JLabel("Now playing: " + media.getTitle(), JLabel.CENTER);
            mediaInfo.setFont(new Font(mediaInfo.getFont().getName(), Font.PLAIN, 18));
            playDialog.add(mediaInfo, BorderLayout.CENTER);

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> playDialog.dispose());
            playDialog.add(closeButton, BorderLayout.SOUTH);

            playDialog.setVisible(true);
        }

    }


}
