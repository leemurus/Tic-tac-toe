package backend;

import java.util.ArrayList;

public class Field {
    private int size;
    private Figure[][] field;

    public Field(int size) {
        this.size = size;
        field = new Figure[size][size];
        this.clear();
    }

    public Integer getSize() {
        return size;
    }

    public Figure[][] getField() {
        return field.clone();
    }

    public boolean setCell(int x, int y, Figure figure) {
        checkCoordinates(x, y);
        if (field[x][y].equals(Figure.EMPTY)) {
            field[x][y] = figure;
            return true;
        }
        return false;
    }

    public Figure getCell(int x, int y) {
        checkCoordinates(x, y);
        return field[x][y];
    }

    public Winner getWinner() {
        ArrayList<Winner> answers = new ArrayList<>() {{
           add(checkRows());
           add(checkColumns());
           add(checkLeftDiagonal());
           add(checkRightDiagonal());
           add(checkDraw());
        }};

        for (Winner answer : answers) {
            if (answer != null) {
                return answer;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = Figure.EMPTY;
            }
        }
    }

    private Winner checkRows() {
        for (int i = 0; i < size; i++) {
            ArrayList<Figure> sequence = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                sequence.add(field[i][j]);
            }

            Figure figure = getWinnerFromSequence(sequence);
            if (figure != null) {
                return new Winner(i, 0, i, size - 1, figure);
            }
        }
        return null;
    }

    private Winner checkColumns() {
        for (int j = 0; j < size; j++) {
            ArrayList<Figure> sequence = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                sequence.add(field[i][j]);
            }

            Figure figure = getWinnerFromSequence(sequence);
            if (figure != null) {
                return new Winner(0, j, size - 1, j, figure);
            }
        }
        return null;
    }

    private Winner checkLeftDiagonal() {
        ArrayList<Figure> sequence = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            sequence.add(field[i][i]);
        }
        Figure figure = getWinnerFromSequence(sequence);
        return (figure == null ? null : new Winner(0, 0, size - 1, size - 1, figure));
    }

    private Winner checkRightDiagonal() {
        ArrayList<Figure> sequence = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            sequence.add(field[i][size - i - 1]);
        }
        Figure figure = getWinnerFromSequence(sequence);
        return (figure == null ? null : new Winner(0, size - 1, size - 1, 0, figure));
    }

    private Winner checkDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j].equals(Figure.EMPTY)) {
                    return null;
                }
            }
        }
        return new Winner(-1, -1, -1, -1, Figure.EMPTY);
    }

    private Figure getWinnerFromSequence(ArrayList<Figure> sequence) {
        Figure curFigure = (!sequence.isEmpty() ? sequence.get(0) : Figure.EMPTY);
        for (Figure figure : sequence) {
            if (!figure.equals(curFigure) || figure.equals(Figure.EMPTY)) {
                return null;
            }
        }
        return curFigure;
    }

    private void checkCoordinates(int x, int y) {
        if (-1 >= x || x >= field.length || -1 >= y || y >= field[x].length) {
            throw new IllegalArgumentException("Wrong coordinates for fields");
        }
    }
}
