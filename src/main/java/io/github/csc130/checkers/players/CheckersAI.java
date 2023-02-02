package io.github.csc130.checkers.players;

import io.github.csc130.checkers.game.GameBoard;
import io.github.csc130.utils.Utils;

public class CheckersAI extends CheckersPlayer{
    public CheckersAI(String stringInput) {
        super();
    }

    @Override
    public void takeTurn() {

    }

    @Override
    public void takeTurn(GameBoard gameBoard, char playerChar) {

    }



    private static boolean isValidMove(char[][] board, int fromRow, int fromCol, int toRow, int toCol, char player) {
        // Check if from and to positions are on the board
        if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7 || toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            return false;
        }

        // Check if the from position is occupied by the player's piece
        if (board[fromRow][fromCol] != player) {
            return false;
        }

        // Check if the to position is empty
        if (board[toRow][toCol] != ' ') {
            return false;
        }

        // Check if the move is a diagonal move of the correct distance
        if (Math.abs(fromRow - toRow) != 1 || Math.abs(fromCol - toCol) != 1) {
            return false;
        }

        return true;
    }



    @Override
    public int getPiecesLeft() {
        return 0;
    }

    @Override
    public void setPiecesLeft(int piecesLeft) {

    }

    @Override
    public void takePiece(int x, int y) {

    }

    @Override
    public void kingPiece(int x, int y) {

    }
}
