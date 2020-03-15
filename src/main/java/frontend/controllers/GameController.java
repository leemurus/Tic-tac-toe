package frontend.controllers;

import backend.Figure;
import backend.Winner;
import frontend.Tile;
import javafx.fxml.FXML;
import javafx.scene.layout.*;

/**
 * Controller of game.fxml file.
 */
class GameController {
    private int size;
    private Figure turn;
    private boolean isFinishedGame;
    private backend.Field backendField;
    private frontend.Field frontendField;

    @FXML private AnchorPane anchorPane;
    @FXML private Pane pane;

    GameController(int size) {
        this.size = size;
    }

    /**
     * FXML function that sets fields and actions.
     */
    @FXML
    private void initialize() {
        isFinishedGame = false;
        turn = Figure.CROSS;
        initializeField(size);
        setActionsOnField();
    }

    /**
     * Function creates backend and frontend fields and sets size for window.
     * @param size;
     */
    private void initializeField(int size) {
        backendField = new backend.Field(size);
        frontendField = new frontend.Field(size);
        anchorPane.setPrefSize(size * Tile.TILE_SIZE, size * Tile.TILE_SIZE);
        pane.setPrefSize(size * Tile.TILE_SIZE, size * Tile.TILE_SIZE);
        frontendField.addToPane(pane);
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

            int x = (int) mouseEvent.getSceneY() / Tile.TILE_SIZE;
            int y = (int) mouseEvent.getSceneX() / Tile.TILE_SIZE;
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
