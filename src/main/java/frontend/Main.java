package frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class, that starts game.
 */
public class Main extends Application {
    /**
     * Main function
     * @param args;
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * It is override function from Application class.
     * Function loads start.fxml and shows window.
     * @param stage;
     * @throws IOException;
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load fxml file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/frontend/fxml/start.fxml"));
        loader.load();

        // Set properties
        stage.setScene(new Scene(loader.getRoot()));
        stage.setTitle("Tic-tac-toe");
        stage.setResizable(false);

        // Show window
        stage.show();
    }
}
