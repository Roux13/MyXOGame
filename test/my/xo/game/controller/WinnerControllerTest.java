package my.xo.game.controller;

import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    void getWinnerWhenAllFieldsIsNull() throws InvalidPointException {
        final Field field = new Field(3);
        final WinnerController winnerController = new WinnerController();
        final Figure actualWinner = winnerController.getWinner(field);

        assertNull(actualWinner);
    }

    @Test
    void getWinnerWhenLineWinnerIsX() throws InvalidPointException {
        Field field = new Field(3);
        Figure currentFigure = Figure.X;
        for (int j = 0; j < field.getSize(); j++) {
            field = new Field(3);
            for (int i = 0; i < field.getSize(); i++) {
                field.setFigure(new Point(j, i), currentFigure);
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertEquals(expectedWinner, actualWinner);
        }
    }

    @Test
    void getWinnerWhenLineWinnerIsNotX() throws InvalidPointException {
        Field field = new Field(3);
        Figure currentFigure = Figure.X;
        Figure anotherFigure = Figure.O;
        for (int j = 0; j < field.getSize(); j++) {
            field = new Field(3);
            for (int i = 0; i < field.getSize(); i++) {
                if (i == field.getSize() - 1) {
                    field.setFigure(new Point(j, i), anotherFigure);
                }
                else {
                    field.setFigure(new Point(j, i), currentFigure);
                }
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertNull(actualWinner);
        }
    }

    @Test
    void getWinnerWhenLineWinnerIsO() throws InvalidPointException {
        Field field = new Field(3);
        final Figure currentFigure = Figure.O;
        for (int j = 0; j < field.getSize(); j++) {
            field = new Field(3);
            for (int i = 0; i < field.getSize(); i++) {
                field.setFigure(new Point(j, i), currentFigure);
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertEquals(expectedWinner, actualWinner);
            //for (int k = 0; k < field.getSize(); k++) {
            //    field.setFigure(new Point(j, k), null);
            //}
        }
    }

    @Test
    void getWinnerWhenColumnWinnerIsX() throws InvalidPointException {
        Field field = new Field(3);
        Figure currentFigure = Figure.X;
        for (int i = 0; i < field.getSize(); i++) {
            field = new Field(3);
            for (int j = 0; j < field.getSize(); j++) {
                field.setFigure(new Point(j, i), currentFigure);
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertEquals(expectedWinner, actualWinner);
            /*for (int k = 0; k < field.getSize(); k++) {
                field.setFigure(new Point(k, i), null);
            }*/
        }
    }

    @Test
    void getWinnerWhenColumnWinnerIsNotX() throws InvalidPointException {
        Field field = new Field(3);
        Figure currentFigure = Figure.X;
        Figure anotherFigure = Figure.O;
        for (int i = 0; i < field.getSize(); i++) {
            field = new Field(3);
            for (int j = 0; j < field.getSize(); j++) {
                if (j == field.getSize() - 1) {
                    field.setFigure(new Point(j, i), anotherFigure);
                }
                else {
                    field.setFigure(new Point(j, i), currentFigure);
                }
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertNull(actualWinner);
            /*for (int k = 0; k < field.getSize(); k++) {
                field.setFigure(new Point(k, i), null);
            }*/
        }
    }

    @Test
    void getWinnerWhenColumnWinnerIsO() throws InvalidPointException {
        Field field = new Field(3);
        Figure currentFigure = Figure.O;
        for (int i = 0; i < field.getSize(); i++) {
            field = new Field(3);
            for (int j = 0; j < field.getSize(); j++) {
                field.setFigure(new Point(j, i), currentFigure);
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertEquals(expectedWinner, actualWinner);
            /*for (int k = 0; k < field.getSize(); k++) {
                field.setFigure(new Point(k, i), null);
            }*/
        }
    }

    @Test
    void getWinnerWhenMainDiagonalWinnerIsX() throws InvalidPointException {
        final Field field = new Field(3);
        Figure currentFigure = Figure.X;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (i == j){
                    field.setFigure(new Point(j, i), currentFigure);
                }
            }
        }
        final WinnerController winnerController = new WinnerController();
        final Figure actualWinner = winnerController.getWinner(field);
        final Figure expectedWinner = currentFigure;

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    void getWinnerWhenMainDiagonalWinnerIsNotX() throws InvalidPointException {
        final Field field = new Field(3);
        Figure currentFigure = Figure.X;
        Figure anotherFigure = Figure.O;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (i == j){
                    if (i == field.getSize() - 1) {
                        field.setFigure(new Point(j, i), anotherFigure);
                    }
                    else {
                        field.setFigure(new Point(j, i), currentFigure);
                    }
                }
            }
        }
        final WinnerController winnerController = new WinnerController();
        final Figure actualWinner = winnerController.getWinner(field);
        final Figure expectedWinner = currentFigure;

        assertNull(actualWinner);
    }

    @Test
    void getWinnerWhenMainDiagonalWinnerIsO() throws InvalidPointException {
        final Field field = new Field(3);
        Figure currentFigure = Figure.O;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (i == j){
                    field.setFigure(new Point(j, i), currentFigure);
                }
            }
        }
        final WinnerController winnerController = new WinnerController();
        final Figure actualWinner = winnerController.getWinner(field);
        final Figure expectedWinner = currentFigure;

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    void getWinnerWhenSecondaryDiagonalWinnerIsX() throws InvalidPointException {
        final Field field = new Field(3);
        Figure currentFigure = Figure.X;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (i + j == field.getSize() - 1){
                    field.setFigure(new Point(j, i), currentFigure);
                }
            }
        }
        final WinnerController winnerController = new WinnerController();
        final Figure actualWinner = winnerController.getWinner(field);
        final Figure expectedWinner = currentFigure;

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    void getWinnerWhenSecondaryDiagonalWinnerIsNotX() throws InvalidPointException {
        final Field field = new Field(3);
        Figure currentFigure = Figure.X;
        Figure anotherFigure = Figure.O;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (i + j == field.getSize() - 1){
                    if (i == field.getSize() - 1) {
                        field.setFigure(new Point(j, i), anotherFigure);
                    }
                    else {
                        field.setFigure(new Point(j, i), currentFigure);
                    }
                }
            }
        }
        final WinnerController winnerController = new WinnerController();
        final Figure actualWinner = winnerController.getWinner(field);
        final Figure expectedWinner = currentFigure;

        assertNull(actualWinner);
    }

    @Test
    void getWinnerWhenSecondaryDiagonalWinnerIsO() throws InvalidPointException {
        final Field field = new Field(3);
        Figure currentFigure = Figure.O;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (i + j == field.getSize() - 1){
                    field.setFigure(new Point(j, i), currentFigure);
                }
            }
        }
        final WinnerController winnerController = new WinnerController();
        final Figure actualWinner = winnerController.getWinner(field);
        final Figure expectedWinner = currentFigure;

        assertEquals(expectedWinner, actualWinner);
    }
}