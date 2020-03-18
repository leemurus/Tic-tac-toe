package frontend.controllers;

import frontend.Field;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private Button startButton;
    @FXML
    private Button exitButton;
    @FXML
    private TextField input;

    private boolean validateNumberFromInput() {
        String stringNumber = input.getText();
        return !stringNumber.isEmpty() &&
                Field.MIN_FIELD_SIZE <= Integer.parseInt(stringNumber) &&
                Integer.parseInt(stringNumber) <= Field.MAX_FIELD_SIZE;
    }

    private Integer getNumberFromInput() {
        return Integer.parseInt(input.getText());
    }

    @FXML
    public void initialize() {
        // Force the field to be numeric only
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                input.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    public void clickedOnStartButton() throws IOException {
        if (!validateNumberFromInput()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect number");
            alert.setContentText("Field size must be greater " +
                    Field.MIN_FIELD_SIZE.toString() +
                    " and less " + Field.MAX_FIELD_SIZE);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.show();
            return;
        }

        // Load fxml file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/frontend/fxml/game.fxml"));

        // Create and set size in a game controller
        GameController gameController = new GameController(getNumberFromInput());
        loader.setController(gameController);
        loader.load();

        // Create new stage
        Stage stage = new Stage();

        // Set properties
        stage.setScene(new Scene(loader.getRoot()));
        stage.setTitle("Tic-tac-toe");
        stage.setResizable(false);

        // Show window
        stage.show();
    }

    @FXML
    public void clickedOnExitButton() {
        ((Stage) exitButton.getScene().getWindow()).close();
    }

}
