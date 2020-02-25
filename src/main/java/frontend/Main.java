package frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Load fxml file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/frontend/game.fxml"));
        loader.load();

        // Set properties
        stage.setScene(new Scene(loader.getRoot()));
        stage.setTitle("Tic tac toe");
        stage.setResizable(false);

        // Show window
        stage.show();
    }
}
