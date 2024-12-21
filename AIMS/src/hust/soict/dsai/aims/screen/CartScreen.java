package hust.soict.dsai.aims.screen;

import java.io.IOException;
import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        // Set up the JFXPanel for embedding JavaFX into Swing
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(800, 600); // Set an appropriate size
        this.setVisible(true);

        // Run JavaFX code on the JavaFX thread
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("hust/soict/dsai/aims/screen/fxml/cart.fxml"));
                    Parent root = loader.load();
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Main method to run the Swing + JavaFX application
    public static void main(String[] args) {
        // Initialize the JavaFX toolkit
        // This is necessary when integrating JavaFX into Swing
        javafx.application.Application.launch(JavaFXLauncher.class, args);
    }
}
