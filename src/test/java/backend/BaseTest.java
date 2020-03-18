package backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseTest {
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
    public void testGetMethodBigNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            field.getCell(3, 3);
            field.getCell(1, 20);
            field.getCell(20, 1);
            field.getCell(20, 20);
        });
    }

    @Test
    public void testGetMethodNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            field.getCell(-10, 10);
            field.getCell(10, -10);
            field.getCell(-10, -10);
        });
    }

    @Test
    public void testSetMethodBigNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            field.setCell(3, 3, Figure.CROSS);
            field.setCell(1, 20, Figure.CROSS);
            field.setCell(20, 1, Figure.CROSS);
            field.setCell(20, 20, Figure.CROSS);
        });
    }

    @Test
    public void testSetMethodNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            field.setCell(-20, 1, Figure.CROSS);
            field.setCell(1, -20, Figure.CROSS);
            field.setCell(-20, -20, Figure.CROSS);
        });
    }

    @Test
    public void testGetSetMethods() {
        field.setCell(0, 0, Figure.ZERO);
        assertEquals(field.getCell(0, 0), Figure.ZERO);
    }
}
