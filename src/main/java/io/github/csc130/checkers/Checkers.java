/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:35 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.checkers;
 */
package io.github.csc130.checkers;

import io.github.csc130.checkers.game.GameBoard;

public class Checkers {

    private GameBoard board = new GameBoard(8,8);
    public void startGame() {

    }

    public void movePiece(int x, int y){

    }

    public Boolean checkForWin(){
        return false;
    }

    public Boolean checkIfEmptySpace(int x, int y){
        return false;
    }


    public void resetBoard() {
        for (int i = 0; i < board.getRowSize(); i++) {
            for (int j = 0; j < board.getColumnSize(); j++) {
                board.getBoard()[i][j] = CheckerPiece.BLANK_SPACE;
            }
        }



    }


}
