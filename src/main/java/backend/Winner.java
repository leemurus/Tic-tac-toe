package backend;

/**
 * Class for information about winner.
 */
public class Winner {
    Figure figure;
    int leftX, leftY;    // left top point
    int rightX, rightY;  // right bottom point

    /**
     * Constructor that take coordinates of left top point and right bottom point of line.
     * @param leftX
     * @param leftY
     * @param rightX
     * @param rightY
     * @param figure
     */
    public Winner(int leftX, int leftY, int rightX, int rightY, Figure figure) {
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.rightY = rightY;
        this.figure = figure;
    }

    /**
     * Get figure of winner.
     * @return Figure
     */
    public Figure getFigure() {
        return figure;
    }

    /**
     * Get left top x coordinate.
     * @return x-coordinate
     */
    public int getLeftX() {
        return leftX;
    }

    /**
     * Get left top y coordinate.
     * @return y-coordinate
     */
    public int getLeftY() {
        return leftY;
    }

    /**
     * Get right bottom x coordinate.
     * @return x-coordinate
     */
    public int getRightX() {
        return rightX;
    }

    /**
     * Get right bottom y coordinate.
     * @return y-coordinate
     */
    public int getRightY() {
        return rightY;
    }
}
