package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddCompactDiscScreenController extends AddItemScreenController {

    @FXML
    private TextField tfArtist;
    @FXML
    private TextField tfTracks;

    public AddCompactDiscScreenController(Store store) {
        super(store);
    }

    @Override
    protected boolean validateFields() {
        try {
            Integer.parseInt(tfTracks.getText());
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
        CompactDisc cd = new CompactDisc(title, category, "Unknown", cost);
        store.add(cd);
    }
}
