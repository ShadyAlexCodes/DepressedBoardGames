/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:35 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.checkers.game;
 */
package io.github.csc130.checkers.game;

import io.github.csc130.checkers.Piece;

public class GameBoard {
    private Piece[][] board;

    public GameBoard(int height, int length) {
        board = new Piece[height][length];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void resetBoard(){

    }
}
