package my.xo.game.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void getX() {
        final int inputValue = 1;
        final int expectedValue = inputValue;

        Point point = new Point(inputValue, 0);

        final int actualValue = point.getX();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    void getY() {
        final int inputValue = 1;
        final int expectedValue = inputValue;

        Point point = new Point(0, inputValue);

        final int actualValue = point.getY();

        assertEquals(expectedValue, actualValue);
    }
}