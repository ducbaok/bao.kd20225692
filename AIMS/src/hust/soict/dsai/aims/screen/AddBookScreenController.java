package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;


public class AddBookScreenController extends AddItemScreenController {

    public AddBookScreenController(Store store) {
        super(store);
    }

    @Override
    protected boolean validateFields() {
        try {
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
        Book book = new Book(title, category, cost);
        store.add(book);
    }
}
