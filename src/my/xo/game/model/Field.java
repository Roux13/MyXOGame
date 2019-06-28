package my.xo.game.model;


import my.xo.game.model.exceptions.InvalidPointException;
import my.xo.game.model.exceptions.AllreadyOccupiedEcxeption;

public class Field {

    private final static int SIZE = 3;

    private final static int MIN_COORDINATE = 0;
    private final static int MAX_COORDINATE = SIZE;

    private final Figure[][] figures = new Figure[SIZE][SIZE];

    public int getSIZE() {
        return SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return figures[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException, AllreadyOccupiedEcxeption {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        if (figures[point.getX()][point.getY()] != null) {
            throw new AllreadyOccupiedEcxeption();
        }
        figures[point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX()) && checkCoordinate(point.getY());

    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }
}
