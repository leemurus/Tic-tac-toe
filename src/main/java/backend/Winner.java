package backend;

/**
 * Class for information about winner.
 */
public class Winner {
    private Figure figure;
    private Integer leftX, leftY;    // left top point
    private Integer rightX, rightY;  // right bottom point

    /**
     * Constructor that take coordinates of left top point and right bottom point of line.
     *
     * @param leftX;
     * @param leftY;
     * @param rightX;
     * @param rightY;
     * @param figure;
     */
    Winner(Integer leftX, Integer leftY, Integer rightX, Integer rightY, Figure figure) {
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.rightY = rightY;
        this.figure = figure;
    }

    /**
     * Get figure of winner.
     *
     * @return Figure
     */
    public Figure getFigure() {
        return figure;
    }

    /**
     * Get left top x coordinate.
     *
     * @return x-coordinate
     */
    public Integer getLeftX() {
        return leftX;
    }

    /**
     * Get left top y coordinate.
     *
     * @return y-coordinate
     */
    public Integer getLeftY() {
        return leftY;
    }

    /**
     * Get right bottom x coordinate.
     *
     * @return x-coordinate
     */
    public Integer getRightX() {
        return rightX;
    }

    /**
     * Get right bottom y coordinate.
     *
     * @return y-coordinate
     */
    public Integer getRightY() {
        return rightY;
    }
}
