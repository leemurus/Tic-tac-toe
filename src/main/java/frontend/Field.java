package frontend;

import backend.Figure;
import backend.Winner;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Modality;


/**
 * Frontend field class. That synchronize backend field with window.
 */
public class Field {
    public static final Integer MIN_FIELD_SIZE = 3;
    public static final Integer MAX_FIELD_SIZE = 20;
    private Integer size;
    private Tile [][]field;

    /**
     * Constructor that create field and sets Tile object in cells.
     * @param size;
     */
    public Field(int size) {
        this.size = size;
        field = new Tile[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = new Tile();
            }
        }
    }

    /**
     * Function sets figure in cell.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param figure;
     */
    public void setCell(int x, int y, Figure figure) {
        field[x][y].draw(figure);
    }

    /**
     * Draw frontend field on window.
     * @param pane;
     */
    public void addToPane(Pane pane) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j].setTranslateX(j * Tile.TILE_SIZE);
                field[i][j].setTranslateY(i * Tile.TILE_SIZE);
                pane.getChildren().add(field[i][j]);
            }
        }
    }

    /**
     * Draw line or show exception about draw.
     * @param winner;
     * @param pane;
     */
    public void drawWinner(Winner winner, Pane pane) {
        if (winner == null) {
            return;
        }

        if (winner.getFigure().equals(Figure.EMPTY)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game is finished");
            alert.setHeaderText(null);
            alert.setContentText("Draw!");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.show();
        } else {
            Line line = new Line();
            line.setStroke(Color.RED);
            line.setStrokeWidth(5);
            line.setStartX(winner.getLeftY() * Tile.TILE_SIZE + (double)Tile.TILE_SIZE / 2);
            line.setStartY(winner.getLeftX() * Tile.TILE_SIZE + (double)Tile.TILE_SIZE / 2);
            line.setEndX(winner.getRightY() * Tile.TILE_SIZE + (double)Tile.TILE_SIZE / 2);
            line.setEndY(winner.getRightX() * Tile.TILE_SIZE + (double)Tile.TILE_SIZE / 2);
            pane.getChildren().add(line);
        }
    }
}
