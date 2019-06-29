package my.xo.game.model;

import my.xo.game.model.exceptions.AllreadyOccupiedEcxeption;
import my.xo.game.model.exceptions.InvalidPointException;
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

        try {
            field.setFigure(inputPoint, inputFigure);

            final Figure actualFigure = field.getFigure(inputPoint);

            assertEquals(expectedFigure, actualFigure);
        }

        catch (InvalidPointException e) {

        }
    }

    @Test
    void testGetFigureWhenFigureIsNotSet() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    void testGetFigureWhenXIsNegative() {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {
        }
    }

    @Test
    void testGetFigureWhenYIsNegative() {
        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {
        }
    }
    @Test
    void testGetFigureWhenXIsBigger() {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSIZE() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {
        }
    }

    @Test
    void testGetFigureWhenYIsBigger() {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getSIZE() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {
        }
    }

    @Test
    void testGetFigureWhenXAndYIsNegative() {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {
        }
    }

    @Test
    void testGetFigureWhenXAndYIsBigger() {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSIZE() + 1, field.getSIZE() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        }
        catch (final InvalidPointException e) {
        }
    }
}