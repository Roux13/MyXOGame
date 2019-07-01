package my.xo.game.controller;

import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.InvalidPointException;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointException {
        int countFIgure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                final Point point = new Point(i, j);
                if (field.getFigure(point) != null) {
                    countFIgure++;
                }
            }
        }
        if (countFIgure == field.getSize() * field.getSize()) {
            return null;
        }
        else if (countFIgure % 2 == 0) {
            return Figure.X;
        }
        else  {
            return Figure.O;
        }
    }

}
