package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaintController{
    private boolean UsingPen;
    @FXML
    private VBox drawingAreaPane;
//a
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = UsingPen ? Color.BLACK : Color.WHITE;
        Circle newCircle = new Circle(event.getX(), event.getY(), 5, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void onPressMouse(ActionEvent e)
    {
        UsingPen = true;
    }

    @FXML
    void onEraserPress(ActionEvent e)
    {
        UsingPen = false;
    }

}

