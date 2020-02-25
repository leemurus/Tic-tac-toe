package frontend;

import backend.Figure;
import backend.Winner;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;


public class GameController {
    private Figure turn;
    private boolean isFinishedGame;
    private backend.Field backendField;
    private frontend.Field frontendField;

    @FXML private AnchorPane anchorPane;
    @FXML private Pane pane;

    @FXML
    public void initialize() {
        isFinishedGame = false;
        turn = Figure.CROSS;
        initializeField(3);
        setActionsOnField();
    }

    private void initializeField(int size) {
        backendField = new backend.Field(size);
        frontendField = new frontend.Field(size);
        anchorPane.setPrefSize(size * Tile.TILE_SIZE, size * Tile.TILE_SIZE);
        pane.setPrefSize(size * Tile.TILE_SIZE, size * Tile.TILE_SIZE);
        frontendField.addToPane(pane);
    }

    private void restartGame() {
        pane.getChildren().clear();
        initialize();
    }

    private void setActionsOnField() {
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
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
            }
        });
    }
}
