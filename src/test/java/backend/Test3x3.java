package backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test3x3 {
    private Field field;

    @Before
    public void setUp() {
        field = new Field(3);
    }

    @After
    public void tearDown() {
        field = null;
    }

    @Test
    public void testEmpty() {
        assertTrue(field.getWinner() == null);
    }

    @Test
    public void testWinCrossLeftDiagonal() {
        field.setCell(0, 0, Figure.CROSS);
        field.setCell(1, 1, Figure.CROSS);
        field.setCell(2, 2, Figure.CROSS);
        assertTrue(field.getWinner().getFigure().equals(Figure.CROSS));
    }

    @Test
    public void testWinCrossRightDiagonal() {
        field.setCell(0, 2, Figure.CROSS);
        field.setCell(1, 1, Figure.CROSS);
        field.setCell(2, 0, Figure.CROSS);
        assertTrue(field.getWinner().getFigure().equals(Figure.CROSS));
    }

    @Test
    public void testDraw() {
        field.setCell(0, 0, Figure.ZERO);
        field.setCell(0, 1, Figure.CROSS);
        field.setCell(0, 2, Figure.CROSS);
        field.setCell(1, 0, Figure.CROSS);
        field.setCell(1, 1, Figure.CROSS);
        field.setCell(1, 2, Figure.ZERO);
        field.setCell(2, 0, Figure.ZERO);
        field.setCell(2, 1, Figure.ZERO);
        field.setCell(2, 2, Figure.CROSS);
        assertTrue(field.getWinner().getFigure().equals(Figure.EMPTY));
    }
}
