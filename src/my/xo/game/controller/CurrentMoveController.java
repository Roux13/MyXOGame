package my.xo.game.controller;

import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.InvalidPointException;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointException {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                Point point = new Point(i, j);
                if (field.getFigure(point) == null) {
                    continue;
                }
                if (field.getFigure(point).equals(Figure.X)) {
                    countX++;
                }
                if (field.getFigure(point).equals(Figure.O)) {
                    countO++;
                }
            }
        }
        if (countO + countX == field.getSize() * field.getSize()) {
            return null;
        }
        else if (countX == countO) {
            return Figure.X;
        }
        else  {
            return Figure.O;
        }
    }

}
