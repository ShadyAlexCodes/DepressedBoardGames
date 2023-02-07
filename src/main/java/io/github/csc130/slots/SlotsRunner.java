/**
 * @author Xander
 * @createdOn 2/6/2023 at 2:01 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.slots;
 */
package io.github.csc130.slots;

public class SlotsRunner {
        public static void main(String[] args) {
                Machine m = new Machine();
                m.setStrEmojis();
                m.printConsoleResults();
        }
}
