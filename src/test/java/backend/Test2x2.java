package backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test2x2 {
    private Field field;

    @Before
    public void setUp() {
        field = new Field(2);
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
        assertTrue(field.getWinner().getFigure().equals(Figure.CROSS));
    }

    @Test
    public void testWinCrossRightDiagonal() {
        field.setCell(0, 1, Figure.CROSS);
        field.setCell(1, 0, Figure.CROSS);
        assertTrue(field.getWinner().getFigure().equals(Figure.CROSS));
    }

    @Test
    public void testWinCrossUpperRow() {
        field.setCell(0, 0, Figure.CROSS);
        field.setCell(0, 1, Figure.CROSS);
        assertTrue(field.getWinner().getFigure().equals(Figure.CROSS));
    }

    @Test
    public void testWinCrossDownRow() {
        field.setCell(0, 0, Figure.CROSS);
        field.setCell(0, 1, Figure.CROSS);
        assertTrue(field.getWinner().getFigure().equals(Figure.CROSS));
    }

    @Test
    public void testWinCrossLeftCol() {
        field.setCell(0, 0, Figure.CROSS);
        field.setCell(1, 0, Figure.CROSS);
        assertTrue(field.getWinner().getFigure().equals(Figure.CROSS));
    }

    @Test
    public void testWinCrossRightCol() {
        field.setCell(0, 1, Figure.CROSS);
        field.setCell(1, 1, Figure.CROSS);
        assertTrue(field.getWinner().getFigure().equals(Figure.CROSS));
    }
}
