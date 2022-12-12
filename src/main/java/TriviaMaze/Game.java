/**
 * Attack of Trivia: Game.java
 * 12/15/2022
 */

package TriviaMaze;

import java.io.*;
import java.io.Serializable;

/**
 * Game displays all necessary information to the player (view), calls the
 * controller class, and saves and loads games
 * View
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Game implements Serializable {
    private static final long serialVersionUID = 5;
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
                """);
    }

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
     * Saves the game.
     * @param theData
     * @param theFileName
     */
    static void saveGame(final Maze myMaze) {
        try {
            FileOutputStream file = new FileOutputStream("TriviaMaze.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(myMaze);
            out.close();
            file.close();
            System.out.println("Game has been Saved");
        } catch (IOException e) {
            System.out.println("I/O exception:\n");
            e.printStackTrace();
        }
    }

    /**
     * Loads a previously saved game./
     * @param theFileName
     * @return in.readObject();
     */
    static Object loadGame() {
        Maze myMaze = null;
        try {
            FileInputStream file = new FileInputStream("TriviaMaze.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            myMaze = (Maze) in.readObject();
            in.close();
            file.close();


        } catch (IOException e) {
            System.out.println("I/O exception:\n");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found:\n");
            e.printStackTrace();
            }

        return myMaze;
    }

}