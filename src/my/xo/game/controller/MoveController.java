package my.xo.game.controller;

import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.AllreadyOccupiedEcxeption;
import my.xo.game.model.exceptions.InvalidPointException;

public class MoveController {

    public void applyFigure(Field field, Point point, Figure figure) throws InvalidPointException, AllreadyOccupiedEcxeption {
        if (field.getFigure(point) != null) {
                throw new AllreadyOccupiedEcxeption();
            }
            field.setFigure(point, figure);
    }

}
