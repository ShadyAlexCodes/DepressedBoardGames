/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:36 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.checkers.players;

import io.github.csc130.checkers.CheckerPiece;
import io.github.csc130.checkers.game.Game;
import io.github.csc130.checkers.game.GameBoard;
import io.github.csc130.players.Player;

public abstract class CheckersPlayer {

    private String name;
    private char character;

    public CheckersPlayer(String name, char character) {
        this.name = name;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public abstract void takeTurn(GameBoard gameBoard);
}
