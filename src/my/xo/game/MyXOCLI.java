package my.xo.game;

import my.xo.game.model.*;
import my.xo.game.view.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyXOCLI {
    public static void main(final String[] args) {

        String gameName = "MyXO";

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final Player[] players = new Player[2];
        System.out.println("Input player1 name:");
        try {
            final String playerName1 = reader.readLine();
            final Player player1 = new Player(playerName1, Figure.X);
            players[0] = player1;
        } catch (IOException e) {
            System.out.println("Введите буквы или цифры");
        }
        System.out.println("Input player2 name:");
        try {
            final String playerName2 = reader.readLine();
            final Player player2 = new Player(playerName2, Figure.O);
            players[1] = player2;

        } catch (IOException e) {
            System.out.println("Введите буквы или цифры");
        }
        final Field field = new Field(3);
        final Game game = new Game(gameName, players, field);
        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while (consoleView.move(game)) {
            consoleView.show(game);
        }

    }
}
