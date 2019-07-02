package my.xo.game.view;

import my.xo.game.controller.CurrentMoveController;
import my.xo.game.controller.MoveController;
import my.xo.game.controller.WinnerController;
import my.xo.game.model.*;
import my.xo.game.model.exceptions.AllreadyOccupiedEcxeption;
import my.xo.game.model.exceptions.InvalidPointException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show (final Game game) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
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
                    System.out.format("Winner is figure %s\n", currentFigure);
                    return false;
                }
            }
            else {
                System.out.format("Next move is figure %s\n", figure);
                System.out.println();
                final Point point = askPoint();
                moveController.applyFigure(field, point, figure);
                final Figure isWinner = winnerController.getWinner(field);
                if (isWinner != null) {
                    System.out.println();
                    System.out.format("Winner is figure %s\n", isWinner);
                    System.out.println();
                    printWinnerName(game, isWinner);
                    return false;
                }
            }
        }
        catch (InvalidPointException e) {
            System.out.println("The coordinate can be from 0 to 2");
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
        System.out.println();
        System.out.format("Please, input a coordinate %s:   ", coordinateName);
        final Scanner sc = new Scanner(System.in);
        int inputCoordinate = 0;
        try {
            inputCoordinate = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Please, enter number from 0 to 2");
        }
        return inputCoordinate;
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

    private void printWinnerName(Game game, Figure figure) {
        Player winner = null;
        for (int i = 0; i < 2; i++) {
            if (game.getPlayers(i).getFigure().equals(figure)) {
                winner = game.getPlayers(i);
            }
        }
        String winnerName = winner.getName();
        System.out.format("Winner name is %s! Congratulations!!!", winnerName);
    }
}
