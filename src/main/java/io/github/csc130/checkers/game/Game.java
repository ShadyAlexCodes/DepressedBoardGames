/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:35 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.checkers.game;
 */
package io.github.csc130.checkers.game;

import io.github.csc130.checkers.CheckerPiece;
import io.github.csc130.checkers.players.CheckersAI;
import io.github.csc130.checkers.players.CheckersHuman;
import io.github.csc130.checkers.players.CheckersPlayer;
import io.github.csc130.players.Player;
import io.github.csc130.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final GameBoard gameBoard;
    private final List<CheckersPlayer> players = new ArrayList<>();

    private int turn;

    public Game(int numOfRows, int numOfCols) {
        gameBoard = new GameBoard(numOfRows, numOfCols);
    }



    public void startGame() {
        boolean playingGame = false;
        do {
            int selection = displayMainMenu();
            switch(selection) {
                case 1 -> {
                    players.add(new CheckersHuman(Utils.getStringInput("Enter the first players name: ", true)));
                    players.add(new CheckersHuman(Utils.getStringInput("Enter the second players name: ", true)));
                    playingGame = true;
                }
                case 2 -> {
                    players.add(new CheckersHuman(Utils.getStringInput("Enter the players name: ", true)));
                    players.add(new CheckersAI(Utils.getStringInput("Enter the computers name: ", true)));
                    playingGame = true;
                }
                case 3 -> {
                    players.add(new CheckersAI(Utils.getStringInput("Enter the first computers name: ", true)));
                    players.add(new CheckersAI(Utils.getStringInput("Enter the second computers name: ", true)));
                    playingGame = true;
                }
                default -> {
                    Utils.writeLn("You did not enter a valid game type.");
                }

            }
        } while (!playingGame);

        turn = 0;
        gameBoard.initializeBoard();

        Player winner = null, loser = null;

        do {
            CheckersPlayer player = players.get(turn);

            gameBoard.displayBoard();

            player.takeTurn(gameBoard, CheckerPiece.RED_CHECKER);

//            if(gameBoard.checkWin()) {
//                playingGame = false;
//                loser = player;
//                if(++turn == players.size()) turn = 0;
//                winner = players.get(turn);
//            }

            if(++turn == players.size()) turn = 0;
        } while(playingGame);

    }

    public static int displayMainMenu() {
        int selection = -1;
        do {
            Utils.writeLn("Select a option to play", Utils.TextColor.GREEN);
            Utils.writeLn("""
                    0. Previous Menu
                    1. Player Versus Player (PVP)
                    2. Player Versus Computer (PVC)
                    3. Computer Versus Computer (CVC)
                    """);

            selection = Utils.getIntInput("Your selection?");
            if (selection < 0 || selection > 3) {
                selection = -1;
                Utils.writeLn("Invalid Option! Choose an option between 1 and 31");
            }
        } while (selection == -1);
        return selection;
    }
}
