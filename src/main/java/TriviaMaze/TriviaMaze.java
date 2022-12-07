/**
 * Attack of Trivia: TriviaMaze.java
 * 12/15/2022
 */
package TriviaMaze;

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

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    /** holds maze.*/
    private final Maze myMaze;
    /** holds current game.*/
    private final Game myGame;
    /** holds Scanner for game.*/
    private final Scanner myScanner;
    private final DataBank myDataBank;

    /**
     * Constructor starts the game and initializes the maze.
     *
     * @param theMaze
     */
    public TriviaMaze(final Maze theMaze, final DataBank theDataBank, final Game theGame, final Scanner theScanner) throws Exception {
        startGame();
        this.myMaze = theMaze;
        this.myDataBank = theDataBank;
        this.myGame = theGame;
        this.myScanner = theScanner;
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
        int playerInput = Integer.parseInt(myScanner.nextLine());

        if (playerInput == ONE) {
            System.out.println("Started a new game.\n");
            newGame();
        } else if (playerInput == TWO) {
            System.out.println("Loaded game.");
            Game.loadGame("TriviaMaze.ser");
        } else if (playerInput == THREE) {
            System.out.println("Thank you for playing");
        } else {
            System.out.println("Invalid input:try again");
            myGame.gameMenu();
        }
    }

    private int pickTopic() {
        myGame.triviaTopics();
        int playerInput = Integer.parseInt(myScanner.nextLine());
        int topicChosen = 0;
        if (playerInput == ONE) {
            System.out.println("Topic: Friends");
            topicChosen = 1;
        } else if (playerInput == TWO) {
            System.out.println("Topic: Bollywood");
            topicChosen = 2;
        } else if (playerInput == THREE) {
            System.out.println("Topic: Horror");
            topicChosen = 3;
        } else if (playerInput == FOUR) {
            System.out.println("Topic: Random");
            topicChosen = 4;
        } else {
            System.out.println("Invalid input:try again");
            myGame.triviaTopics();
        }
        return topicChosen;
    }

    /**
     * gets player input.
     *
     * @return input
     */
    private String getPlayerInput() {
        String input;
        input = myScanner.nextLine().toLowerCase();
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
            case "l" -> myGame.saveGame(this.myMaze, "TriviaMaze.ser");
            case "e" -> System.out.println("Thank you for playing");
            default -> playerInput(theInput); //need to System.out.println("""INVALID INPUT(Select a valid option)""");

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

    private boolean askQuestion() {
        Question question = null;
        if (pickTopic() == 1) {
            question = myDataBank.getFriendsQuestion();
            System.out.println(question.promptQuestion());
        } else if (pickTopic() == 2) {
            question = myDataBank.getBollywoodQuestion();
            System.out.println(question.promptQuestion());
        } else if (pickTopic() == 3) {
            question = myDataBank.getHorrorQuestion();
            System.out.println(question.promptQuestion());
        } else if (pickTopic() == 4) {
            question = myDataBank.getRandomQuestion();
            System.out.println(question.promptQuestion());
        }
        assert question != null;
        return question.isCorrect(getPlayerInput());
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