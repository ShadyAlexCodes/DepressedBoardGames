package io.github.csc130.checkers.players;

import io.github.csc130.checkers.CheckerPiece;
import io.github.csc130.checkers.Piece;
import io.github.csc130.checkers.game.GameBoard;
import io.github.csc130.utils.Utils;

public class CheckersHuman extends CheckersPlayer{
    public CheckersHuman(String name) {
        super();
    }


    @Override
    public void takeTurn() {

    }

    @Override
    public void takeTurn(GameBoard board, CheckerPiece playerChar) {
        String firstMove = Utils.getStringInput("Player " + playerChar + ", enter first character to move (e.g. a2 a3): ", false);
        String secondMove = Utils.getStringInput("Player " + playerChar + ", enter the location for your character to move (e.g. a2 a3): ", false);


        int fromRow = 8 - (firstMove.charAt(1) - '0');
        int fromCol = firstMove.charAt(0) - 'a';
        int toRow = 8 - (secondMove.charAt(1) - '0');
        int toCol = secondMove.charAt(0) - 'a';

        if (isValidMove(board.getBoard(), fromRow, fromCol, toRow, toCol, CheckerPiece.RED_CHECKER)) {
            board.getBoard()[toRow][toCol] = board.getBoard()[fromRow][fromCol];
            board.getBoard()[fromRow][fromCol] = CheckerPiece.BLANK_SPACE;
        } else {
            System.out.println("Invalid move, try again");
            takeTurn(board, playerChar);
        }
    }

    private static boolean isValidMove(Piece[][] board, int fromRow, int fromCol, int toRow, int toCol, CheckerPiece player) {
        // Check if from and to positions are on the board
        if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7 || toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            return false;
        }

        // Check if the from position is occupied by the player's piece
        if (board[fromRow][fromCol] != player) {
            return false;
        }

        // Check if the to position is empty
        if (board[toRow][toCol] != CheckerPiece.BLACK_CHECKER) {
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
