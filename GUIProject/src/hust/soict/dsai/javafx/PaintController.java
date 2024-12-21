package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaintController {

    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;

    @FXML
    private Pane drawingAreaPane;

    private ToggleGroup toolGroup;

    @FXML
    public void initialize() {
        toolGroup = new ToggleGroup();
        penButton.setToggleGroup(toolGroup);
        eraserButton.setToggleGroup(toolGroup);
    }

    @FXML
    public void drawingAreaMouseDragged(MouseEvent event) {
        if (toolGroup.getSelectedToggle() == penButton) {
            Circle circle = new Circle(event.getX(), event.getY(), 5, Color.BLACK);
            drawingAreaPane.getChildren().add(circle);
        } else if (toolGroup.getSelectedToggle() == eraserButton) {
            Circle eraser = new Circle(event.getX(), event.getY(), 10, Color.WHITE);
            drawingAreaPane.getChildren().add(eraser);
        }
    }

    @FXML
    public void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }
}
