package frontend;

import backend.Figure;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class Tile extends StackPane {
    private static final int FONT_SIZE = 50;
    static final int TILE_SIZE = 150;
    private Text text = new Text();

    public Tile() {
        Rectangle border = new Rectangle(TILE_SIZE, TILE_SIZE);
        text.setFont(Font.font(FONT_SIZE));
        border.setFill(null);                   // Fill null color inside
        border.setStroke(Color.BLACK);          // Set color for border
        getChildren().addAll(border, text);     // Add to pane
    }

    public void draw(Figure figure) {
        if (figure.equals(Figure.ZERO)) {
            text.setText("O");
        } else {
            text.setText("X");
        }
    }
}