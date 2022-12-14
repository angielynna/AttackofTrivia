/**
 * Attack of Trivia: Main.java
 * 12/15/2022
 */
package triviamaze;

import java.util.Scanner;

/**
 * Main runs the entire game.
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Main {
    /**
     * Main method.
     *
     * @param theArgs
     * @throws Exception
     */
    public static void main(final String[] theArgs) throws Exception {
        Game g = new Game();
        g.welcomeMessage();
        new TriviaMaze(new DataBank(), g, new Scanner(System.in));
    }
}
