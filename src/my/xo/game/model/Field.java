package my.xo.game.model;

public class Field {

    private final int SIZE = 3;

    private Figure[][] figures = new Figure[SIZE][SIZE];

    public int getSIZE() {
        return SIZE;
    }

    public Figure[][] getFigures() {
        return figures;
    }

    public void setFigures(Figure[][] figures) {
        this.figures = figures;
    }
}
