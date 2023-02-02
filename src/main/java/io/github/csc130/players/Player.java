/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:36 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.players;

import io.github.csc130.checkers.game.GameBoard;

public abstract class Player {
    private String name;

    public void takeTurn(GameBoard gameBoard){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
