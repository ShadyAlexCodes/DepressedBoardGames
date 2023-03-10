package io.github.csc130;

import io.github.csc130.checkers.Checkers;
import io.github.csc130.connectfour.ConnectFourRunner;
import io.github.csc130.connectfour.Player;
import io.github.csc130.slots.SlotsRunner;
import io.github.csc130.sudoku.SudokuRunner;
import io.github.csc130.tictactoe.TicTacToeRunner;
import io.github.csc130.utils.Utils;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        boolean gameInMotion = false;

        Person player = null;

        while (player == null) {
            if(Utils.getBooleanInput("Do you have a code? (Yes, No)", "yes", "no")) {
                player = new Person(Utils.getStringInput("Please enter your name:", false), Utils.getIntInput("Please enter how much money you're spending"), true);
            } else {
                player = new Person(Utils.getStringInput("Please enter your name:", false), Utils.getIntInput("Please enter how much money you're spending"), false);
            }
        }

        if(player.isFree()) Utils.writeLn("Congratulations! You're playing for free today!", Utils.TextColor.RED);

        do {
            int selection = displayMainMenu();
            switch (selection) {
                case 0 -> gameInMotion = true;
                case 1 -> new Checkers().startGame();
                case 2 -> new ConnectFourRunner().startGame();
                case 3 -> new SlotsRunner().startGame();

                case 4 -> {
                    Application.launch(SudokuRunner.class,args);
                    break;
                }
                case 5 -> new TicTacToeRunner().startGame();
                default -> {

                }
            }

        } while(!gameInMotion);
    }

    public static int displayMainMenu() {
        int selection = -1;
        do {
            Utils.writeLn("Select a option to play", Utils.TextColor.GREEN);
            Utils.writeLn("""
                    0. Exit the casino
                    1. Checkers
                    2. Connect Four
                    3. Slots
                    4. Sudoku
                    5. TicTacToe
                    """);

            selection = Utils.getIntInput("Your selection?");
            if (selection < 0 || selection > 5) {
                selection = -1;
                Utils.writeLn("Invalid Option! Choose an option between 1 and 5");
            }
        } while (selection == -1);
        return selection;
    }
}