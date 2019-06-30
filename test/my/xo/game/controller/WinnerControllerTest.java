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
        final Field field = new Field();
        final WinnerController winnerController = new WinnerController();
        final Figure actualWinner = winnerController.getWinner(field);

        assertNull(actualWinner);
    }

    @Test
    void getWinnerWhenLineWinnerIsX() throws InvalidPointException {
        final Field field = new Field();
        Figure currentFigure = Figure.X;
        for (int j = 0; j < field.getSIZE(); j++) {
            for (int i = 0; i < field.getSIZE(); i++) {
                field.setFigure(new Point(j, i), currentFigure);
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertEquals(expectedWinner, actualWinner);
        }
    }

    @Test
    void getWinnerWhenLineWinnerIsO() throws InvalidPointException {
        final Field field = new Field();
        final Figure currentFigure = Figure.O;
        for (int j = 0; j < field.getSIZE(); j++) {
            for (int i = 0; i < field.getSIZE(); i++) {
                field.setFigure(new Point(j, i), currentFigure);
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertEquals(expectedWinner, actualWinner);
            for (int k = 0; k < field.getSIZE(); k++) {
                field.setFigure(new Point(j, k), null);
            }
        }
    }

    @Test
    void getWinnerWhenColumnWinnerIsX() throws InvalidPointException {
        final Field field = new Field();
        Figure currentFigure = Figure.X;
        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
                field.setFigure(new Point(j, i), currentFigure);
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertEquals(expectedWinner, actualWinner);
            for (int k = 0; k < field.getSIZE(); k++) {
                field.setFigure(new Point(k, i), null);
            }
        }
    }

    @Test
    void getWinnerWhenColumnWinnerIsO() throws InvalidPointException {
        final Field field = new Field();
        Figure currentFigure = Figure.O;
        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
                field.setFigure(new Point(j, i), currentFigure);
            }
            final WinnerController winnerController = new WinnerController();
            final Figure actualWinner = winnerController.getWinner(field);
            final Figure expectedWinner = currentFigure;

            assertEquals(expectedWinner, actualWinner);
            for (int k = 0; k < field.getSIZE(); k++) {
                field.setFigure(new Point(k, i), null);
            }
        }
    }

    @Test
    void getWinnerWhenMainDiagonalWinnerIsX() throws InvalidPointException {
        final Field field = new Field();
        Figure currentFigure = Figure.X;
        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
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
    void getWinnerWhenMainDiagonalWinnerIsO() throws InvalidPointException {
        final Field field = new Field();
        Figure currentFigure = Figure.O;
        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
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
        final Field field = new Field();
        Figure currentFigure = Figure.X;
        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
                if (i + j == field.getSIZE() - 1){
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
    void getWinnerWhenSecondaryDiagonalWinnerIsO() throws InvalidPointException {
        final Field field = new Field();
        Figure currentFigure = Figure.O;
        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
                if (i + j == field.getSIZE() - 1){
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