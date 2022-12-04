/**
 * Attack of Trivia: Game.java
 * 12/15/2022
 */

package TriviaMaze;

import java.io.*;


/**
 * Game displays all necessary information to the player (view), calls the
 * controller class, and saves and loads games
 * View
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Game {

    /**
     * Displays menu for the TriviaMaze.
     */
    protected void gameMenu() {
        System.out.println("Welcome to Trivia Maze");
        System.out.println("Press 1: Start a new game.");
        System.out.println("Press 2: Load game.");
        System.out.println("Press 3: Exit game.");
    }

    /**
     * Displays movement prompt for the Player.
     */
    protected void playerMovement() {
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
    protected void playerMenu() {
        System.out.println("""
                Menu:
                N) New Game
                L) Save Game
                E) Exit Game
                """);
    }

    /**
     * Saves the game.
     * @param theData
     * @param theFileName
     */
    static void saveGame(final Object theData, final String theFileName) {
        try {
            FileOutputStream file = new FileOutputStream(theFileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(theData);
            out.close();
            file.close();
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
    static Object loadGame(final String theFileName) {
        try {
            FileInputStream file = new FileInputStream(theFileName);
            ObjectInputStream in = new ObjectInputStream(file);
            in.close();
            file.close();
            return in.readObject();
        } catch (IOException e) {
            System.out.println("I/O exception:\n");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found:\n");
            e.printStackTrace();
            }

        return null;
    }

}