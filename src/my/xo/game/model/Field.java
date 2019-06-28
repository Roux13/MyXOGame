package my.xo.game.model;

public class Field {

    private final static int SIZE = 3;

    private final Figure[][] figures = new Figure[SIZE][SIZE];

    public int getSIZE() {
        return SIZE;
    }

    public Figure getFigure(final Point point) {
        return figures[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) {
        figures[point.getX()][point.getY()] = figure;
    }
}
