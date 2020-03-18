package frontend.controllers;

import backend.Figure;
import backend.Winner;
import javafx.fxml.FXML;
import javafx.scene.layout.*;

/**
 * Controller of game.fxml file.
 */
class GameController {
    private Figure turn;
    private Integer sizeOfTile;
    private Integer sizeOfField;
    private boolean isFinishedGame;
    private backend.Field backendField;
    private frontend.Field frontendField;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane pane;


    private static Integer getSizeOfTile(Integer sizeOfField) {
        return 700 / sizeOfField;
    }

    GameController(Integer sizeOfField) {
        this.sizeOfField = sizeOfField;
        this.sizeOfTile = getSizeOfTile(sizeOfField);
    }

    /**
     * FXML function that sets fields and actions.
     */
    @FXML
    private void initialize() {
        isFinishedGame = false;
        turn = Figure.CROSS;
        initializePane();
        initializeField();
        setActionsOnField();
    }

    /**
     * Function sets size for window
     */
    private void initializePane() {
        pane.setPrefSize(sizeOfField * sizeOfTile, sizeOfField * sizeOfTile);
        anchorPane.setPrefSize(sizeOfField * sizeOfTile, sizeOfField * sizeOfTile);
    }

    /**
     * Function creates backend and frontend fields.
     */
    private void initializeField() {
        backendField = new backend.Field(sizeOfField);
        frontendField = new frontend.Field(sizeOfField, sizeOfTile);
        frontendField.drawOn(pane);
    }

    /**
     * Clear pane and restart initialize.
     */
    private void restartGame() {
        pane.getChildren().clear();
        initialize();
    }

    /**
     * Function sets actions that should happen.
     * (More exact it sets mouse clicks on pane)
     */
    private void setActionsOnField() {
        pane.setOnMouseClicked(mouseEvent -> {
            if (isFinishedGame) {
                restartGame();
                return;
            }

            Integer x = (int) mouseEvent.getSceneY() / sizeOfTile;
            Integer y = (int) mouseEvent.getSceneX() / sizeOfTile;
            if (backendField.setCell(x, y, turn)) {
                frontendField.setCell(x, y, turn);
                turn = (turn.equals(Figure.CROSS) ? Figure.ZERO : Figure.CROSS);

                Winner winner = backendField.getWinner();
                if (winner != null) {
                    isFinishedGame = true;
                    frontendField.drawWinner(winner, pane);
                }
            }
        });
    }
}
