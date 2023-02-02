/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:35 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.checkers;
 */
package io.github.csc130.checkers;

import io.github.csc130.checkers.game.Game;
import io.github.csc130.checkers.game.GameBoard;

public class Checkers {

    public void startGame() {

        new Game(8, 8).startGame();
    }


}
