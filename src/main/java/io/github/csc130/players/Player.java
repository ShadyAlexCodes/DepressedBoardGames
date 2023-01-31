/**
 * @author Xander
 * @createdOn 1/31/2023 at 1:36 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.players;

public abstract class Player {
    private String name;

    public void takeTurn(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
