package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;

import java.util.List;

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
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;



    public CartScreenController(Cart cart){
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize(){
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        tblMedia.setItems(this.cart.getItemOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) 
                {
                    if(newValue != null)
                    {
                        updateButtonBar(newValue);
                    }
                }
            });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                showFilteredMedia(newValue);
            }
        });

        updateTotalCost();
    }

    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else
        {
            btnPlay.setVisible(false);
        }
    } 

    void btnRemovePressed(){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.remove(media);
    }

    @FXML
private void showFilteredMedia(String filter) {
    
    if(filter == null || filter.isEmpty())
    {
        tblMedia.setItems(this.cart.getItemOrdered());
        return;
    }
    else if(filterCategory.getSelectedToggle() == radioBtnFilterId)
    {
        List<Media> matchedItems = this.cart.searchbyID(filter);
        ObservableList<Media> filteredMedia = FXCollections.observableArrayList(matchedItems);
        tblMedia.setItems(filteredMedia);
    }
    else if(filterCategory.getSelectedToggle() == radioBtnFilterTitle)
    {
        List<Media> matchedItems = this.cart.searchbyQuery(filter);
        ObservableList<Media> filteredMedia = FXCollections.observableArrayList(matchedItems);
        tblMedia.setItems(filteredMedia);
    }
}
    
    void updateTotalCost(){
        totalcost.setText(cart.totalCost() + " $");
    }

}
