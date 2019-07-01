package my.xo.game.view;

import my.xo.game.controller.CurrentMoveController;
import my.xo.game.controller.MoveController;
import my.xo.game.controller.WinnerController;
import my.xo.game.model.Field;
import my.xo.game.model.Figure;
import my.xo.game.model.Game;
import my.xo.game.model.Point;
import my.xo.game.model.exceptions.AllreadyOccupiedEcxeption;
import my.xo.game.model.exceptions.InvalidPointException;

import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show (final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        printSeparator();
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            printLine(field, x);
            printSeparator();
        }
    }

    public boolean move (final Game game) {
        Field field = game.getField();
        try {
            final Figure figure = currentMoveController.currentMove(field);
            if (figure == null) {
                final Figure currentFigure = winnerController.getWinner(field);
                if (currentFigure == null) {
                    System.out.println("No Winner, no moves. Game ended :(");
                    return false;
                }
                else {
                    System.out.format("Winner is %s\n", winnerController.getWinner(field));
                    return false;
                }
            }
            else {
                System.out.format("Next move is %s\n", figure);
                final Point point = askPoint();
                moveController.applyFigure(field, point, figure);
            }
        }
        catch (InvalidPointException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        catch (AllreadyOccupiedEcxeption e) {
            System.out.println("This point is already occupied, please input other point");
        }
        return true;

    }

    private Point askPoint() {
        return new Point(askCoordinate("X"), askCoordinate("Y"));
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please, input %s:   ", coordinateName);
        final Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void printLine(Field field, int x) {
        for (int y = 0; y < field.getSize(); y++) {
            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
                System.out.print("| ");
                System.out.print(figure != null ? figure + " ": " " + " ");
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
        System.out.println("|");
    }

    private void printSeparator() {
        System.out.println("-------------");
    }
}
