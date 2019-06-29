package my.xo.game.controller;

import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.InvalidPointException;

public class WinnerController {

    public Figure getWinner(Field field) throws InvalidPointException{
        if (checkLine(field, Figure.X) || checkColumn(field, Figure.X)) {
            return Figure.X;
        }
        if (checkLine(field, Figure.O) || checkColumn(field, Figure.O)) {
            return Figure.O;
        }
        return null;
    }

    private boolean checkLine (Field field, Figure targetFigure) throws InvalidPointException {
        int figuresCount;
        for(int i = 0; i < field.getSIZE(); i++) {
            figuresCount = 0;
            for (int j = 0; j < field.getSIZE(); j++) {
                Figure currentFigure = field.getFigure(new Point(i, j));
                if (currentFigure.equals(targetFigure)) {
                    figuresCount++;
                }
            }
            if (figuresCount == field.getSIZE()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn (Field field, Figure targetFigure) throws InvalidPointException {
        int figuresCount;
        for(int j = 0; j < field.getSIZE(); j++) {
            figuresCount = 0;
            for (int i = 0; i < field.getSIZE(); i++) {
                Figure currentFigure = field.getFigure(new Point(i, j));
                if (currentFigure.equals(targetFigure)) {
                    figuresCount++;
                }
            }
            if (figuresCount == field.getSIZE()) {
                return true;
            }
        }
        return false;
    }

}
