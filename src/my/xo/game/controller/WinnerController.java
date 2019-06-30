package my.xo.game.controller;

import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.InvalidPointException;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException{
        if (checkFigureForWinner(field, Figure.X)) {
            return Figure.X;
        }
        if (checkFigureForWinner(field, Figure.O)) {
            return Figure.O;
        }
        return null;
    }

    private boolean checkFigureForWinner(final Field field, final Figure figure) throws InvalidPointException {
        return checkLine(field, figure) || checkColumn(field, figure) || checkMainDiagonal(field, figure) || checkSecondaryDiagonal(field, figure);
    }

    private boolean checkLine (final Field field, final Figure targetFigure) throws InvalidPointException {
        int figuresCount;
        for(int i = 0; i < field.getSize(); i++) {
            figuresCount = 0;
            for (int j = 0; j < field.getSize(); j++) {
                Figure currentFigure = field.getFigure(new Point(i, j));
                if (currentFigure == null) {
                    break;
                }
                if (targetFigure.equals(currentFigure)) {
                    figuresCount++;
                }
            }
            if (figuresCount == field.getSize()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn (final Field field, final Figure targetFigure) throws InvalidPointException {
        int figuresCount;
        for(int j = 0; j < field.getSize(); j++) {
            figuresCount = 0;
            for (int i = 0; i < field.getSize(); i++) {
                Figure currentFigure = field.getFigure(new Point(i, j));
                if (currentFigure == null) {
                    break;
                }
                if (targetFigure.equals(currentFigure)) {
                    figuresCount++;
                }
            }
            if (figuresCount == field.getSize()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkMainDiagonal (final Field field, final Figure targetFigure) throws InvalidPointException {
        int figuresCount = 0;
        boolean hasNull = false;
        for(int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (i == j) {
                    Figure currentFigure = field.getFigure(new Point(i, j));
                    if (currentFigure == null) {
                        return false;
                    }
                    if (targetFigure.equals(currentFigure)) {
                        figuresCount++;
                    }
                }
            }
        }
        return figuresCount == field.getSize();
    }

    private boolean checkSecondaryDiagonal (final Field field, final Figure targetFigure) throws InvalidPointException {
        int figuresCount = 0;
        boolean hasNull = false;
        for(int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (i + j == field.getSize() - 1) {
                    Figure currentFigure = field.getFigure(new Point(i, j));
                    if (currentFigure == null) {
                        return false;
                    }
                    if (targetFigure.equals(currentFigure)) {
                        figuresCount++;
                    }
                }
            }
        }
        return figuresCount == field.getSize();
    }

}
