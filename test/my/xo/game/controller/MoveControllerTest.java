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
        Field field = new Field(3);
        Figure occupierFigure = Figure.X;
        Point testPoint = new Point(0, 0);
        MoveController moveController = new MoveController();
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
        Field field = new Field(3);
        Figure inputFigure = Figure.X;
        Point testPoint = new Point(0, 0);
        MoveController moveController = new MoveController();

        moveController.applyFigure(field, testPoint, inputFigure);

        Figure actualFigure = field.getFigure(testPoint);
        Figure expectedFigure = inputFigure;

        assertEquals(expectedFigure, actualFigure);
    }
}