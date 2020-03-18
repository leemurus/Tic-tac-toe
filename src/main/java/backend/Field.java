package backend;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Backend Field class. Engine of game.
 */
public class Field {
    private Integer size;
    private Figure[][] field;

    /**
     * Constructor that sets size, field variables.
     *
     * @param size;
     */
    public Field(Integer size) {
        this.size = size;
        field = new Figure[size][size];
        this.clear();
    }

    /**
     * Getter that return size.
     *
     * @return size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Getter that return field.
     *
     * @return field
     */
    public Figure[][] getField() {
        return field.clone();
    }

    /**
     * Function sets figure in cell and return true else false.
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param figure;
     * @return True or False
     */
    public boolean setCell(Integer x, Integer y, Figure figure) {
        checkCoordinates(x, y);
        if (field[x][y].equals(Figure.EMPTY)) {
            field[x][y] = figure;
            return true;
        }
        return false;
    }

    /**
     * Function get figure in field[x][y].
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return Figure
     */
    Figure getCell(Integer x, Integer y) {
        checkCoordinates(x, y);
        return field[x][y];
    }

    /**
     * Return Winner class with information who won and coordinates.
     *
     * @return Winner or null
     */
    public Winner getWinner() {
        Winner[] answers = new Winner[]{
                checkRows(),
                checkColumns(),
                checkLeftDiagonal(),
                checkRightDiagonal(),
                checkDraw()
        };

        for (Winner answer : answers) {
            if (answer != null) {
                return answer;
            }
        }
        return null;
    }

    /**
     * Clear all figure in field.
     */
    private void clear() {
        for (Integer i = 0; i < size; i++) {
            for (Integer j = 0; j < size; j++) {
                field[i][j] = Figure.EMPTY;
            }
        }
    }

    /**
     * Function checks that some row has only crosses or zeros.
     *
     * @return Winner or null
     */
    private Winner checkRows() {
        for (Integer i = 0; i < size; i++) {
            ArrayList<Figure> sequence = new ArrayList<>(Arrays.asList(field[i]).subList(0, size));

            Figure figure = getWinnerFromSequence(sequence);
            if (figure != null) {
                return new Winner(i, 0, i, size - 1, figure);
            }
        }
        return null;
    }

    /**
     * Function checks that some column has only crosses or zeros.
     *
     * @return Winner or null
     */
    private Winner checkColumns() {
        for (Integer j = 0; j < size; j++) {
            ArrayList<Figure> sequence = new ArrayList<>();
            for (Integer i = 0; i < size; i++) {
                sequence.add(field[i][j]);
            }

            Figure figure = getWinnerFromSequence(sequence);
            if (figure != null) {
                return new Winner(0, j, size - 1, j, figure);
            }
        }
        return null;
    }

    /**
     * Function checks that main diagonal has only crosses or zeros.
     *
     * @return Winner or null
     */
    private Winner checkLeftDiagonal() {
        ArrayList<Figure> sequence = new ArrayList<>();
        for (Integer i = 0; i < size; i++) {
            sequence.add(field[i][i]);
        }
        Figure figure = getWinnerFromSequence(sequence);
        return (figure == null ? null : new Winner(0, 0, size - 1, size - 1, figure));
    }

    /**
     * Function checks that second diagonal has only crosses or zeros.
     *
     * @return Winner or null
     */
    private Winner checkRightDiagonal() {
        ArrayList<Figure> sequence = new ArrayList<>();
        for (Integer i = 0; i < size; i++) {
            sequence.add(field[i][size - i - 1]);
        }
        Figure figure = getWinnerFromSequence(sequence);
        return (figure == null ? null : new Winner(0, size - 1, size - 1, 0, figure));
    }

    /**
     * Function checks that all cells are not empty.
     *
     * @return Winner or null
     */
    private Winner checkDraw() {
        for (Integer i = 0; i < size; i++) {
            for (Integer j = 0; j < size; j++) {
                if (field[i][j].equals(Figure.EMPTY)) {
                    return null;
                }
            }
        }
        return new Winner(-1, -1, -1, -1, Figure.EMPTY);
    }

    /**
     * Function checks that all sequence has only crosses or zeros.
     *
     * @param sequence sequence of figures
     * @return Figure or null
     */
    private Figure getWinnerFromSequence(ArrayList<Figure> sequence) {
        Figure curFigure = (!sequence.isEmpty() ? sequence.get(0) : Figure.EMPTY);
        for (Figure figure : sequence) {
            if (!figure.equals(curFigure) || figure.equals(Figure.EMPTY)) {
                return null;
            }
        }
        return curFigure;
    }

    /**
     * Validate function check that x, y coordinates are normal and exist in field.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private void checkCoordinates(Integer x, Integer y) {
        if (-1 >= x || x >= field.length || -1 >= y || y >= field[x].length) {
            throw new IllegalArgumentException("Wrong coordinates for fields");
        }
    }
}
