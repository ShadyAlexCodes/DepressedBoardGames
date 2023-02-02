/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:35 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.checkers.game;
 */
package io.github.csc130.checkers.game;

import io.github.csc130.checkers.CheckerPiece;
import io.github.csc130.checkers.Piece;
import io.github.csc130.utils.Utils;

public class GameBoard {
    private final Piece[][] board;
    private final int rowSize;
    private final int columnSize;

    public GameBoard(int row, int column) {
        this.rowSize = row;
        this.columnSize = column;

        board = new Piece[rowSize][columnSize];


    }

    public Piece[][] getBoard() {
        return board;
    }

    public void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (i < 3) {
                        board[i][j] = CheckerPiece.RED_CHECKER;
                    } else if (i > 4) {
                        board[i][j] = CheckerPiece.BLACK_CHECKER;
                    } else {
                        board[i][j] = CheckerPiece.BLANK_SPACE;
                    }
                } else {
                    board[i][j] =CheckerPiece.BLANK_SPACE;
                }
            }
        }
    }

 /*   public void printBoard() {
        System.out.println("  A B C D E F G H");
        for (int i = 0; i < 8; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }*/


    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void displayBoard() {
        for (int row = 0; row < rowSize; row++) {
            for(int col = 0; col < columnSize; col++) {
                if(board[row][col].equals(CheckerPiece.BLANK_SPACE)) Utils.write(" | ");
                if(col < columnSize - 1) Utils.write(" | ", Utils.TextColor.WHITE);
            }
            if(row < rowSize - 1) Utils.writeLn("---|---|---|---|", Utils.TextColor.YELLOW);
        }
    }
}
