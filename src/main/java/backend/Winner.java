package backend;

public class Winner {
    Figure figure;
    int leftX, leftY;    // left top point
    int rightX, rightY;  // right bottom point

    public Winner(int leftX, int leftY, int rightX, int rightY, Figure figure) {
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.rightY = rightY;
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getLeftY() {
        return leftY;
    }

    public int getRightX() {
        return rightX;
    }

    public int getRightY() {
        return rightY;
    }
}
