package backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test1x1 {
    private Field field;

    @Before
    public void setUp() {
        field = new Field(1);
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
    public void testWinCross() {
        field.setCell(0, 0, Figure.CROSS);
        assertTrue(field.getWinner().getFigure().equals(Figure.CROSS));
    }

    @Test
    public void testWinZero() {
        field.setCell(0, 0, Figure.ZERO);
        assertTrue(field.getWinner().getFigure().equals(Figure.ZERO));
    }
}
