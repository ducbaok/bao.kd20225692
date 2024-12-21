package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddDVDScreenController extends AddItemScreenController {

    @FXML
    private TextField tfDirector;
    @FXML
    private TextField tfLength;

    public AddDVDScreenController(Store store) {
        super(store);
    }

    @Override
    protected boolean validateFields() {
        try {
            Integer.parseInt(tfLength.getText());
            Float.parseFloat(tfCost.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected void saveItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
        store.add(dvd);
    }
}
