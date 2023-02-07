/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:35 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.checkers.game;
 */
package io.github.csc130.checkers.game;

import io.github.csc130.checkers.players.CheckersAI;
import io.github.csc130.checkers.players.CheckersHuman;
import io.github.csc130.checkers.players.CheckersPlayer;
import io.github.csc130.checkers.players.Player;
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
                    players.add(new CheckersHuman(Utils.getStringInput("Enter the first players name: ", false), Utils.getCharInput("Enter the first players character: ")));
                    players.add(new CheckersHuman(Utils.getStringInput("Enter the second players name: ", false), Utils.getCharInput("Enter the second players character: ")));
                    playingGame = true;
                }
                case 2 -> {
                    players.add(new CheckersHuman(Utils.getStringInput("Enter the first players name: ", false), Utils.getCharInput("Enter the first players character: ")));
                    players.add(new CheckersAI(Utils.getStringInput("Enter the computers name: ", false), Utils.getCharInput("Enter the computers character: ")));
                    playingGame = true;
                }
                case 3 -> {
                    players.add(new CheckersAI(Utils.getStringInput("Enter the first computers name: ", false), Utils.getCharInput("Enter the first computers character: ")));
                    players.add(new CheckersAI(Utils.getStringInput("Enter the second computers name: ", false), Utils.getCharInput("Enter the second computers character: ")));
                    playingGame = true;
                }
                default -> {
                    Utils.writeLn("You did not enter a valid game type.");
                }

            }
        } while (!playingGame);

        turn = 0;
        gameBoard.initializeBoard(players.get(0), players.get(1));

        Player winner = null, loser = null;

        do {
            CheckersPlayer player = players.get(turn);

            gameBoard.printBoard();

            player.takeTurn(gameBoard);

            // Check for game end
            if (gameEnd(player)) {
                System.out.println(player.getName() + " wins!");

                playingGame = false;
            }

//            if(gameBoard.checkWin()) {
//                playingGame = false;
//                loser = player;
//                if(++turn == players.size()) turn = 0;
//                winner = players.get(turn);
//            }

            if(++turn == players.size()) turn = 0;
        } while(playingGame);

    }

    private boolean gameEnd(CheckersPlayer currentPlayer) {
        // Check if current player has no more pieces on the board
        for (int i = 0; i < gameBoard.getRowSize(); i++) {
            for (int j = 0; j < gameBoard.getColumnSize(); j++) {
                if (gameBoard.getBoard()[i][j] == currentPlayer.getCharacter()) {
                    return false;
                }
            }
        }
        return true;
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
