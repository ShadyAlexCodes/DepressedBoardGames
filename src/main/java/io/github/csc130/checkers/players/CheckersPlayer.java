/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:36 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.checkers.players;

import io.github.csc130.players.Player;

public class CheckersPlayer extends Player {
    private int picesLeft;

    public int getPicesLeft() {
        return picesLeft;
    }

    public void setPicesLeft(int picesLeft) {
        this.picesLeft = picesLeft;
    }
}
