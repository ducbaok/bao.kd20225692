package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class AddItemScreenController {
    protected Store store;

    @FXML
    protected Button btnSave;
    @FXML
    protected TextField tfTitle;
    @FXML
    protected TextField tfCategory;
    @FXML
    protected TextField tfCost;
    
    private boolean allFieldsFilled = false;

    public AddItemScreenController(Store store) {
        this.store = store;
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        if (validateFields()) {
            saveItem();
            clearFields();
            showConfirmation();
        } else {
            showError("Please fill all fields.");
        }
    }

    protected abstract boolean validateFields();  // Each subclass will define validation logic

    protected abstract void saveItem();  // Each subclass will define how to save the item to the store

    private void clearFields() {
        tfTitle.clear();
        tfCategory.clear();
        tfCost.clear();
    }

    private void showConfirmation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Item has been added to the store!");
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    private void checkFieldsFilled() {
        if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfCost.getText().isEmpty()) {
            allFieldsFilled = true;
        } else {
            allFieldsFilled = false;
        }
        btnSave.setDisable(!allFieldsFilled);
    }
}

