package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class CartScreenController {
    private Cart cart;

    @FXML
    private Label totalcost;

    @FXML
    private TextField tfFilter;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder; // Added button for place order

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        tblMedia.setItems(this.cart.getItemOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        btnPlaceOrder.setVisible(true); // Make the Place Order button visible

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if(newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        updateTotalCost();
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    // Handle Remove button click
    void btnRemovePressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.remove(media);
        updateTotalCost();
    }

    // Handle Play button click (for playable items)
    @FXML
    private void btnPlayPressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if(media instanceof Playable) {
            Playable playableMedia = (Playable) media;
            playableMedia.play(); // Call play method of the Playable media
        }
    }

    // Handle Place Order button click
    @FXML
    private void btnPlaceOrderPressed() {
        if(cart.getItemOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Items in Cart");
            alert.setHeaderText("You must add at least one item to your cart to place an order.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Placed");
            alert.setHeaderText("Your order has been placed successfully!");
            alert.setContentText("Total cost: " + cart.totalCost() + " $");
            alert.showAndWait();
            cart.clear(); // Clear the cart after the order is placed
            updateTotalCost();
            tblMedia.setItems(FXCollections.observableArrayList(cart.getItemOrdered())); // Refresh the table
        }
    }

    // Handle text filtering in the table
    @FXML
    private void showFilteredMedia(String filter) {
        if(filter == null || filter.isEmpty()) {
            tblMedia.setItems(this.cart.getItemOrdered());
            return;
        }
        else if(filterCategory.getSelectedToggle() == radioBtnFilterId) {
            ObservableList<Media> filteredMedia = FXCollections.observableArrayList(this.cart.searchbyID(filter));
            tblMedia.setItems(filteredMedia);
        } else if(filterCategory.getSelectedToggle() == radioBtnFilterTitle) {
            ObservableList<Media> filteredMedia = FXCollections.observableArrayList(this.cart.searchbyQuery(filter));
            tblMedia.setItems(filteredMedia);
        }
    }

    // Update the total cost label
    void updateTotalCost() {
        totalcost.setText(cart.totalCost() + " $");
    }
}
