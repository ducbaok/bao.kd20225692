package hust.soict.dsai.aims.screen;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXLauncher extends Application {
    @Override
    public void start(Stage primaryStage) {
        // JavaFX launcher class to initialize the JavaFX toolkit
        // No actual UI is needed here since it's being embedded in the Swing frame
    }

    // You can also add an optional main method to launch directly
    public static void main(String[] args) {
        launch(args);  // Launches JavaFX
    }
}
