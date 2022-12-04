/**
 * Attack of Trivia: TriviaMaze.java
 * 12/15/2022
 */
package TriviaMaze;

import java.io.Serializable;
import java.util.Scanner;

//I was thinking we could connect our SQLite DataBase to TriviaMaze
//So that when player is trying to move through a door I can ask a question
//And depending on how they answer I'll either lock or unlock the door

/**
 * TriviaMaze takes in player input and runs the game
 * Controller
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class TriviaMaze {
    /** holds maze.*/
    private final Maze myMaze;
    /** holds current game.*/
    private final Game myGame = new Game();
    /** holds Scanner for game.*/
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructor starts the game and initializes the maze.
     *
     * @param theMaze
     */
    protected TriviaMaze(final Maze theMaze) throws Exception {
        startGame();
        this.myMaze = theMaze;

    }

    /**
     * print maze out and the player movement instructions
     * depending on player input create a newGame,saveGame,or exitGame.
     */
    private void newGame() throws Exception {
        System.out.print(this.myMaze);
        myGame.playerMovement();
        myGame.playerMenu();
        playerInput(getPlayerInput());

    }

    /**
     * Takes player input and determines how the player will play.
     */
    private void startGame() throws Exception {
        myGame.gameMenu();
        int playerInput = Integer.parseInt(scanner.nextLine());

        if (playerInput == 1) {
            System.out.println("Started a new game.\n");
            newGame();
        } else if (playerInput == 2) {
            System.out.println("Loaded game.");
            //load game
        } else if (playerInput == 3) {
            System.out.println("Thank you for playing");
        } else {
            System.out.println("Invalid input");
        }
    }

    /**
     * gets player input.
     *
     * @return input
     */
    private String getPlayerInput() {
        String input;
        input = scanner.nextLine().toLowerCase();
        return input;
    }

    /**
     * moves player depending on input.
     *
     * @param theInput
     */
    private void playerInput(final String theInput) throws Exception {
        switch (theInput) {
            case "w" -> movePlayerNorth();
            case "a" -> movePlayerWest();
            case "s" -> movePlayerSouth();
            case "d" -> movePlayerEast();
            case "n" -> startGame();
            case "l" -> myGame.saveGame();
            case "e" -> System.out.println("Thank you for playing");
            default -> {
                throw new Exception("ERROR! Incorrect input!");
            }
        }
    }

    /**
     * sets player location to default location: (0, 0).
     */
    private void setPlayerLocation() {
        myMaze.setLocation(0, 0);
    }

    /**
     * Moves player North.
     */
    private void movePlayerNorth() {
        if (myMaze.isLocked('N')) {
            System.out.println("You cannot move North");
        } else if (askQuestion()) {
            System.out.println("You can continue");
            myMaze.move('N');
        } else {
            System.out.println("INCORRECT ANSWER, DOOR HAS BEEN LOCKED");
            myMaze.isLocked('N');
        }
    }

    /**
     * Moves player West.
     */
    private void movePlayerWest() {
        if (myMaze.isLocked('W')) {
            System.out.println("You cannot move West");
        } else if (askQuestion()) {
            System.out.println("You can continue");
            myMaze.move('W');
        } else {
            System.out.println("INCORRECT ANSWER, DOOR HAS BEEN LOCKED");
            myMaze.isLocked('W');
        }
    }

    /**
     * Moves player East.
     */
    private void movePlayerEast() {
        if (myMaze.isLocked('E')) {
            System.out.println("You cannot move East");
        } else if (askQuestion()) {
            System.out.println("You can continue");
            myMaze.move('E');
        } else {
            System.out.println("INCORRECT ANSWER, DOOR HAS BEEN LOCKED");
            myMaze.isLocked('E');
        }
    }

    /**
     * Moves player South.
     */
    private void movePlayerSouth() {
        if (myMaze.isLocked('S')) {
            System.out.println("You cannot move South");
        } else if (askQuestion()) {
            System.out.println("You can continue");
            myMaze.move('S');
        } else {
            System.out.println("INCORRECT ANSWER, DOOR HAS BEEN LOCKED");
            myMaze.isLocked('S');
        }
    }

    /**
     * Asks the player a question.
     *
     * @return getPlayerInput().equals("A");
     */
    private boolean askQuestion() {
        System.out.println("Is 2 an even number");
        System.out.println("Press A: for true");
        System.out.println("Press B: for false");
        return getPlayerInput().equals("A");
    }

    /**
     * ends the game when the player has reached the end or lost.
     *
     * @return false
     */
    private boolean endGame() {
        if (myMaze.atLastRoom()) {
            System.out.println("You've won the game!!!");
        } else if (myMaze.isLocked('N') && myMaze.isLocked('S')
                && myMaze.isLocked('E') && myMaze.isLocked('W')) {
            System.out.println("You've LOST the game");
        }
        return false;

    }

}