/**
 * Attack of Trivia: Game.java
 * 12/15/2022
 */

package triviamaze;

import java.io.Serial;
import java.io.Serializable;

/**
 * View.
 * Game displays all necessary information to the player (view), calls the
 * controller class, and saves and loads games.
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Game implements Serializable {
    /**Serial version ID.*/
    @Serial
    private static final long serialVersionUID = 5;

    /**
     * Prints welcome message.
     */
    void welcomeMessage() {
        System.out.println("Welcome to Attack of Trivia!\n"
                + "Where we provide you with random trivia questions"
                + " within four topics (which you get to choose from.)\n"
                + "Here we will test your trivia knowledge while you"
                + " try to make your way out of a 4 by 4 maze. Be careful"
                + " you don’t get trapped! That’ll make you lose the game.\n"
                + "Are you prepared?\n");
    }
    /**
     * Displays menu for the TriviaMaze.
     */
    void gameMenu() {
        System.out.println("Welcome to Trivia Maze");
        System.out.println("Press 1: Start a new game.");
        System.out.println("Press 2: Load game.");
        System.out.println("Press 3: Exit game.");
    }

    /**
     * Displays movement prompt for the Player.
     */
    void playerMovement() {
        System.out.println("\n");
        System.out.println("""
                How to move:
                W) Move North
                A) Move West
                S) Move South
                D) Move East
                """);
    }

    /**
     * Displays player menu.
     */
    void moreOptions() {
        System.out.println("""
                More Options:
                N) New Game
                L) Save Game
                E) Exit Game
                Q) Immediately win the game (cheat)
                """);
    }
    /**
     * Displays topic menu.
     */
    void triviaTopics() {
        System.out.println("""
                Pick a Topic:
                1) Friends
                2) Bollywood
                3) Horror
                4) Random
                """);
    }
    /**
     * Displays Game guide.
     */
    void gameGuide() {
        System.out.println("""
                Game Guide:
                "P" Player
                "T" You've been there
                "*" Haven't been there
                "E" Exit point of the maze
                "(#)" number of doors that are still not locked for that room
                """);
    }

}
