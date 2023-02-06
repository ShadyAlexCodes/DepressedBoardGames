package io.github.csc130.checkers.players;

import io.github.csc130.checkers.CheckerPiece;
import io.github.csc130.checkers.Piece;
import io.github.csc130.checkers.game.GameBoard;
import io.github.csc130.utils.Utils;

public class CheckersHuman extends CheckersPlayer{


    public CheckersHuman(String name, char character) {
        super(name, character);
    }

    @Override
    public void takeTurn(GameBoard board) {
        boolean validMove = false;

        while(!validMove) {

            int fromRow = Utils.getIntInput("(" + getName() + ") From Row: ", Utils.TextColor.BLUE);
            int fromCol = Utils.getIntInput("(" + getName() + ") From Col: ", Utils.TextColor.BLUE);
            int toRow = Utils.getIntInput("(" + getName() + ") To Row: ", Utils.TextColor.CYAN);
            int toCol = Utils.getIntInput("(" + getName() + ") To Col: ", Utils.TextColor.CYAN);

            if (isValidMove(board, fromRow, fromCol, toRow, toCol)) {
                validMove = true;
                board.getBoard()[toRow][toCol] = board.getBoard()[fromRow][fromCol];
                board.getBoard()[fromRow][fromCol] = ' ';
            } else {
                Utils.writeLn("You made an invalid move!", Utils.TextColor.RED);
                board.printBoard();
            }
        }

    }


    private boolean isValidMove(GameBoard board, int fromRow, int fromCol, int toRow, int toCol) {
        // Check if from position is occupied by current player's character
        if (board.getBoard()[fromRow][fromCol] != getCharacter()) {
            return false;
        }

        // Check if to position is within bounds of the board
        if (toRow < 0 || toRow >= board.getRowSize() || toCol < 0 || toCol >= board.getColumnSize()) {
            return false;
        }

        // Check if move is a valid diagonal move
        if (Math.abs(fromRow - toRow) != Math.abs(fromCol - toCol)) {
            return false;
        }

        return true;
    }

}
