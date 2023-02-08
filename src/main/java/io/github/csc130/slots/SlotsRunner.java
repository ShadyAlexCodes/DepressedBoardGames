/**
 * @author Xander
 * @createdOn 2/6/2023 at 2:01 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.slots;
 */
package io.github.csc130.slots;

import io.github.csc130.utils.Utils;

public class SlotsRunner {
        public void startGame() {
                Machine m = new Machine();
                boolean play = true;
                do {
                        m.pull();
                        play  = Utils.getBooleanInput("Play again? y/n","y","n", Utils.TextColor.BLUE);
                }while (play);
        }
}
