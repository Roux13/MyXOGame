package my.xo.game.controller;

import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.AllreadyOccupiedEcxeption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveControllerTest {

    @Test
    void applyFigureWhenFieldIsOccupied() throws Exception{
        final Field field = new Field(3);
        final Figure occupierFigure = Figure.X;
        final Point testPoint = new Point(0, 0);
        final MoveController moveController = new MoveController();
        field.setFigure(testPoint, occupierFigure);

        try {
            moveController.applyFigure(field, testPoint, occupierFigure);
            fail();
        }
        catch (AllreadyOccupiedEcxeption e) {

        }
    }

    @Test
    void applyFigureWhenFieldIsEmpty() throws Exception{
        final Field field = new Field(3);
        final Figure inputFigure = Figure.X;
        final Point testPoint = new Point(0, 0);
        final MoveController moveController = new MoveController();

        moveController.applyFigure(field, testPoint, inputFigure);

        final Figure actualFigure = field.getFigure(testPoint);
        final Figure expectedFigure = inputFigure;

        assertEquals(expectedFigure, actualFigure);
    }
}