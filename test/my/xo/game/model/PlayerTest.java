package my.xo.game.model;

import static org.junit.Assert.*;

public class PlayerTest {

    @org.junit.Test
    public void getName() {
        final String inputValue = "TestName";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @org.junit.Test
    public void getFigure() {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);
    }
}