package my.xo.game.controller;

import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {

    @Test
    void currentMoveXWhenNewField() throws InvalidPointException {
        Field field = new Field(3);
        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure expectedFigure = Figure.X;
        Figure actualFigure = currentMoveController.currentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void currentMoveWhenMoveEnded() throws InvalidPointException {
        Field field = new Field(3);
        CurrentMoveController currentMoveController = new CurrentMoveController();
        int countFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (countFigure % 2 == 0) {
                    field.setFigure(new Point(i, j), Figure.X);
                    countFigure++;
                }
                else if (countFigure % 2 != 0) {
                    field.setFigure(new Point(i, j), Figure.O);
                    countFigure++;
                }
            }
        }
        Figure actualFigure = currentMoveController.currentMove(field);

        assertNull(actualFigure);
    }

    @Test
    void currentMove() throws InvalidPointException {
        Field field = new Field(3);
        CurrentMoveController currentMoveController = new CurrentMoveController();
        int countFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (countFigure % 2 == 0) {
                    field.setFigure(new Point(i, j), Figure.X);
                    countFigure++;
                }
                else if (countFigure % 2 != 0) {
                    field.setFigure(new Point(i, j), Figure.O);
                    countFigure++;
                }
                if (countFigure < field.getSize() * field.getSize()) {
                    if (countFigure % 2 == 0) {
                        Figure actualFigure = currentMoveController.currentMove(field);
                        Figure expectedFigure = Figure.X;

                        assertEquals(expectedFigure, actualFigure);
                    } else if (countFigure % 2 != 0) {
                        Figure actualFigure = currentMoveController.currentMove(field);
                        Figure expectedFigure = Figure.O;

                        assertEquals(expectedFigure, actualFigure);
                    }
                }
            }
        }

    }
}