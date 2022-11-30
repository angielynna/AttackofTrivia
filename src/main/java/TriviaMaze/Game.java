package TriviaMaze;

import java.util.Scanner;

public class Game {

    //This will print out the menu for the TriviaMaze
    protected void gameMenu(){
        System.out.println("Welcome to Trivia Maze");
        System.out.println("Press 1: Start a new game.");
        System.out.println("Press 2: Load game.");
        System.out.println("Press 3: Exit game.");
    }
    //prints out the movement prompt for the Player
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
    protected void playerMenu() {
        System.out.println("""
                Menu:
                N) New Game
                L) Save Game
                E) Exit Game
                """);
    }


    //Saves the game
    protected void saveGame(){
        //Need to figure out how we will save the game.
    }

    //loads the saved game
    private void loadGame(){
        //After figuring out how to save, we'll then figure out how to load the saved game.
    }



}