package io.github.csc130;

import io.github.csc130.checkers.Checkers;
import io.github.csc130.utils.Utils;

public class Main {
    public static void main(String[] args) {
        new Checkers();
    }

    public static int displayMainMenu() {
        int selection = -1;
        do {
            Utils.writeLn("Select a option to play", Utils.TextColor.GREEN);
            Utils.writeLn("""
                    0. Previous Menu
                    1. Player Versus Player (PVP)
                    2. Player Versus Computer (PVC)
                    3. Computer Versus Computer (CVC)
                    """);

            selection = Utils.getIntInput("Your selection?");
            if (selection < 0 || selection > 3) {
                selection = -1;
                Utils.writeLn("Invalid Option! Choose an option between 1 and 31");
            }
        } while (selection == -1);
        return selection;
    }
}