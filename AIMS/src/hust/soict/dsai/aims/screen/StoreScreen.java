package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import hust.soict.dsai.aims.store.*;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.*;

public class StoreScreen extends JFrame {
    private static Store store = new Store();
    private Cart cart = new Cart();

    public static void main(String[] args) {
        initStore();
        // Launch JavaFX in the proper thread
        SwingUtilities.invokeLater(() -> new StoreScreen(store));
    }

    public static void initStore() {
        // Adding sample media items
        store.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.add(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.add(new DigitalVideoDisc("Aladdin", "Animation", 18.99f));
        store.add(new DigitalVideoDisc("Aladdin", "Animation", 19.01f));
        store.add(new Book("Nihongo", "Language", 20));
        store.add(new CompactDisc("Big Bang", "Music", "BigBang", 600));
        store.add(new Book("The Great Gatsby", "Fiction", 15.99f));
        store.add(new Book("To Kill a Mockingbird", "Classic", 12.99f));
        store.add(new Book("1984", "Dystopian", 18.50f));
    }

    public StoreScreen(Store store) {
        StoreScreen.store = store;
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorthPanel(), BorderLayout.NORTH);
        cp.add(createCenterPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    // Create North Panel with Menu Bar and Header
    JPanel createNorthPanel() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(createMenuBar());
        northPanel.add(createHeader());
        return northPanel;
    }

    // Create Menu Bar
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        // Add menu items for adding media
        JMenuItem addBook = createMenuItem("Add Book", e -> openAddBookScreen());
        JMenuItem addCD = createMenuItem("Add CD", e -> openAddCDScreen());
        JMenuItem addDVD = createMenuItem("Add DVD", e -> openAddDVDScreen());

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    // Utility to create a JMenuItem with event handler
    private JMenuItem createMenuItem(String text, ActionListener listener) {
        JMenuItem item = new JMenuItem(text);
        item.addActionListener(listener);
        return item;
    }

    // Create Header with Title and Cart Button
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.decode("#FBB3B3"));

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // Create Center Panel to display media items
    JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 2, 2));

        for (Media media : store.getItemsInStore()) {
            MediaStore mediaCell = new MediaStore(media);
            centerPanel.add(mediaCell);
        }
        return centerPanel;
    }

    // Class representing a media item in the store
    public class MediaStore extends JPanel {
        private Media media;

        public MediaStore(Media media) {
            this.media = media;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel titleLabel = new JLabel(media.getTitle());
            titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
            titleLabel.setAlignmentX(CENTER_ALIGNMENT);

            JLabel costLabel = new JLabel(String.format("%.2f $", media.getCost()));
            costLabel.setAlignmentX(CENTER_ALIGNMENT);

            JButton addToCartButton = new JButton("Add to cart");
            addToCartButton.addActionListener(e -> cart.add(this.media));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(addToCartButton);

            if (media instanceof Playable) {
                JButton playButton = new JButton("Play");
                playButton.addActionListener(e -> playDialog(this.media));
                buttonPanel.add(playButton);
            }

            add(Box.createVerticalGlue());
            add(titleLabel);
            add(costLabel);
            add(Box.createVerticalGlue());
            add(buttonPanel);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        private void playDialog(Media media) {
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

    // Methods for opening screens to add items (Book, CD, DVD)
    private void openAddBookScreen() {
        openFXMLScreen("/hust/soict/dsai/aims/screen/fxml/AddBookScreen.fxml", new AddBookScreenController(store), "Add Book");
    }

    private void openAddCDScreen() {
        openFXMLScreen("/hust/soict/dsai/aims/screen/fxml/AddCDScreen.fxml", new AddCompactDiscScreenController(store), "Add Compact Disc");
    }

    private void openAddDVDScreen() {
        openFXMLScreen("/hust/soict/dsai/aims/screen/fxml/AddDVDScreen.fxml", new AddDVDScreenController(store), "Add DVD");
    }

    private void openFXMLScreen(String fxmlPath, Object controller, String title) {
        // Ensure JavaFX components are accessed on the JavaFX thread
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
                loader.setController(controller);
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle(title);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
