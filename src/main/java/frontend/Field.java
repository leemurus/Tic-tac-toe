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
    private Integer sizeOfField;
    private Integer sizeOfTile;
    private Tile[][] field;

    /**
     * Constructor that create field and sets Tile object in cells.
     *
     * @param sizeOfField;
     * @param sizeOfTile;
     */
    public Field(Integer sizeOfField, Integer sizeOfTile) {
        this.sizeOfField = sizeOfField;
        this.sizeOfTile = sizeOfTile;
        field = new Tile[sizeOfField][sizeOfField];

        for (Integer i = 0; i < sizeOfField; i++) {
            for (Integer j = 0; j < sizeOfField; j++) {
                field[i][j] = new Tile(sizeOfTile);
            }
        }
    }

    /**
     * Function sets figure in cell.
     *
     * @param x       x-coordinate
     * @param y       y-coordinate
     * @param figure;
     */
    public void setCell(Integer x, Integer y, Figure figure) {
        field[x][y].draw(figure);
    }

    /**
     * Create line object (borders in field)
     *
     * @param x;
     * @param y;
     * @param x2;
     * @param y2;
     * @return line;
     */
    private Line getLineForBorder(Integer x, Integer y, Integer x2, Integer y2) {
        Line line = new Line();
        line.setStroke(Color.WHITESMOKE);
        line.setStrokeWidth(2);
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(x2);
        line.setEndY(y2);
        return line;
    }

    /**
     * Draw frontend field on window.
     *
     * @param pane;
     */
    public void drawOn(Pane pane) {
        // Vertical lines
        for (Integer i = 1; i < sizeOfField; i++) {
            pane.getChildren().add(getLineForBorder(
                    i * sizeOfTile,
                    10,
                    i * sizeOfTile,
                    sizeOfField * sizeOfTile - 10
            ));
        }

        // Horizontal lines
        for (Integer i = 1; i < sizeOfField; i++) {
            pane.getChildren().add(getLineForBorder(
                    10,
                    i * sizeOfTile,
                    sizeOfField * sizeOfTile - 10,
                    i * sizeOfTile
            ));
        }

        // Tiles
        for (Integer i = 0; i < sizeOfField; i++) {
            for (Integer j = 0; j < sizeOfField; j++) {
                field[i][j].setTranslateX(j * sizeOfTile);
                field[i][j].setTranslateY(i * sizeOfTile);
                pane.getChildren().add(field[i][j]);
            }
        }
    }

    /**
     * Draw line or show exception about draw.
     *
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
            line.setStrokeWidth(3);
            line.setStartX(winner.getLeftY() * sizeOfTile + (double) sizeOfTile / 2);
            line.setStartY(winner.getLeftX() * sizeOfTile + (double) sizeOfTile / 2);
            line.setEndX(winner.getRightY() * sizeOfTile + (double) sizeOfTile / 2);
            line.setEndY(winner.getRightX() * sizeOfTile + (double) sizeOfTile / 2);
            pane.getChildren().add(line);
        }
    }
}
