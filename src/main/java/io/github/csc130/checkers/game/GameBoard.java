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
