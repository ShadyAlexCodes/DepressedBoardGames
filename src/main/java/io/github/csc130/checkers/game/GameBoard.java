/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:35 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.checkers.game;
 */
package io.github.csc130.checkers.game;

import io.github.csc130.checkers.players.CheckersPlayer;
import io.github.csc130.utils.Utils;

public class GameBoard {
    private final char[][] board;
    private final int rowSize;
    private final int columnSize;

    public GameBoard(int row, int column) {
        this.rowSize = row;
        this.columnSize = column;

        board = new char[rowSize][columnSize];


    }

    public char[][] getBoard() {
        return board;
    }

    public void initializeBoard(CheckersPlayer playerOne, CheckersPlayer playerTwo) {
        // Create rows
        for (int i = 0; i < rowSize; i++) {
            // Create columns
            for (int j = 0; j < columnSize; j++) {
                if ((i + j) % 2 == 0) {
                    if (i < 3) {
                        board[i][j] = playerOne.getCharacter();
                    } else if (i > 4) {
                        board[i][j] = playerTwo.getCharacter();
                    } else {
                        board[i][j] = ' ';
                    }
                } else {
                    board[i][j] = ' ';
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 1; i < columnSize + 1; ++i) {
            Utils.write("   " + i);
        }
        Utils.writeLn("");

        for (int i = 0; i < columnSize + 1; ++i)
            Utils.write("+---");
        Utils.writeLn("+");

        for (int i = 0; i < rowSize; i++) {
            Utils.write((i + 1) + " ");
            for (int j = 0; j < columnSize; j++) {
                Utils.write("| ");
                Utils.write(String.valueOf(board[i][j]), Utils.TextColor.RED);
                Utils.write(" ");
            }
            Utils.writeLn("| ");
            for (int k = 0; k < columnSize + 1; k++)
                Utils.write("+---");
            Utils.writeLn("+");
        }

    }


    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }
//
//    public void displayBoard() {
//        for (int row = 0; row < rowSize; row++) {
//            for(int col = 0; col < columnSize; col++) {
//                if(board[row][col].equals(CheckerPiece.BLANK_SPACE)) Utils.write(" | ");
//                if(col < columnSize - 1) Utils.write(" | ", Utils.TextColor.WHITE);
//            }
//            if(row < rowSize - 1) Utils.writeLn("---|---|---|---|", Utils.TextColor.YELLOW);
//        }
//    }
}
