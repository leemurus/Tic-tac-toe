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
        assertNull(field.getWinner());
    }

    @Test
    public void testWinCross() {
        field.setCell(0, 0, Figure.CROSS);
        assertEquals(field.getWinner().getFigure(), Figure.CROSS);
    }

    @Test
    public void testWinZero() {
        field.setCell(0, 0, Figure.ZERO);
        assertEquals(field.getWinner().getFigure(), Figure.ZERO);
    }
}
