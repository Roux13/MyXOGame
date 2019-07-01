package my.xo.game.controller;

import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.InvalidPointException;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointException {
        int countFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            countFigure += countFigureInTheRow(field, i);
        }
        if (countFigure == field.getSize() * field.getSize()) {
            return null;
        }
        else if (countFigure % 2 == 0) {
            return Figure.X;
        }
        else  {
            return Figure.O;
        }
    }

    private int countFigureInTheRow(final Field field, final int row) throws InvalidPointException {
        int countFigure = 0;
        for (int j = 0; j < field.getSize(); j++) {
            final Point point = new Point(row, j);
            if (field.getFigure(point) != null) {
                countFigure++;
            }
        }
        return  countFigure;
    }

}
