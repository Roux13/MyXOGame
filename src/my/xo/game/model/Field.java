package my.xo.game.model;


import my.xo.game.model.exceptions.InvalidPointException;

public class Field {

    private final static int MIN_COORDINATE = 0;

    private final int size;

    private final int maxCoordinate;

    private final Figure[][] figures;

    public Field(int size) {
        this.size = size;
        figures = new Figure[size][size];
        maxCoordinate = size;
    }

    public int getSize() {
        return size;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return figures[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        figures[point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX()) && checkCoordinate(point.getY());

    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}
