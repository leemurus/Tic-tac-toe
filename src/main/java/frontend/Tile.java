package frontend;

import backend.Figure;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Frontend class for draw and save information.
 */
class Tile extends StackPane {
    private Text text = new Text();

    /**
     * Constructor that create frontend tile and draw on window.
     */
    Tile(Integer sizeOfTile) {
        setAlignment(Pos.CENTER);
        StackPane pane = new StackPane();
        pane.setPrefSize(sizeOfTile, sizeOfTile);
        text.setFont(Font.font("Daniel", sizeOfTile / 1.2));
        getChildren().addAll(pane, text);     // Add to pane
    }

    /**
     * Function draw figure inside the tile.
     *
     * @param figure;
     */
    void draw(Figure figure) {
        if (figure.equals(Figure.ZERO)) {
            text.setText("O");
            text.setFill(Color.BLACK);
        } else {
            text.setText("X");
            text.setFill(Color.WHITE);
        }
    }
}