package my.xo.game.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSIZE() {
        final Field field = new Field();

        assertEquals(3, field.getSIZE());

    }

    @Test
    void setFigure() {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(expectedFigure, actualFigure);
    }
}