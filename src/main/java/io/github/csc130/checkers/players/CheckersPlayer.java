/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:36 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.checkers.players;

import io.github.csc130.checkers.game.Game;
import io.github.csc130.checkers.game.GameBoard;
import io.github.csc130.players.Player;

public abstract class CheckersPlayer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int piecesLeft;

    public abstract void takeTurn();

    public abstract void takeTurn(GameBoard gameBoard, char playerChar);


    public abstract int getPiecesLeft();

    public abstract void setPiecesLeft(int piecesLeft);

    public abstract void takePiece(int x, int y);

    public abstract void kingPiece(int x, int y);
}
