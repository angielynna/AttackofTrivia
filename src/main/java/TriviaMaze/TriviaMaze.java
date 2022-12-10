/**
 * Attack of Trivia: TriviaMaze.java
 * 12/15/2022
 */
package TriviaMaze;

import java.util.ArrayList;
import java.util.List;
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




    /** holds current game.*/
    private final Game myGame;
    /** holds Scanner for game.*/
    private final Scanner myScanner;
    private final DataBank myDataBank;
    private Maze myMaze;

    /**
     * Constructor starts the game and initializes the maze.
     *
     */
    public TriviaMaze(final DataBank theDataBank, final Game theGame, final Scanner theScanner) throws Exception {
        this.myDataBank = theDataBank;
        this.myGame = theGame;
        this.myScanner = theScanner;
        startGame();
    }


    /**
     * print maze out and the player movement instructions
     * depending on player input create a newGame,saveGame,or exitGame.
     */
    private void newGame() throws Exception {
        myGame.playerMovement();
        myGame.moreOptions();
        myGame.triviaTopics();
        List<Question> list = pickTopic(getPlayerInputInt());
        System.out.println(list.hashCode());
        this.myMaze = new Maze(list);
        do {

                System.out.print(myMaze.toString());
                System.out.println("\nWhich direction do you want to move:");
                playerInput(getPlayerInput());

            if(getPlayerInput() == "e"){
                break;
            }

        }while(!endGame());
    }

    /**
     * Takes player input and determines how the player will play.
     */
    private void startGame() throws Exception {
        myGame.gameMenu();
        int input = Integer.parseInt(myScanner.nextLine());
        if (input == ONE) {
            System.out.println("Started a new game.\n");
            newGame();
        } else if (input == TWO) {
            System.out.println("Loaded game.");
            Game.loadGame("TriviaMaze.ser");
        } else if (input == THREE) {
            System.out.println("Thank you for playing");
            System.exit(0);
        } else {
            System.out.println("Invalid input:try again");
            myGame.gameMenu();
        }
    }

    private List<Question> pickTopic(final int theInput) {
        List<Question> list = new ArrayList<Question>();
        switch (theInput) {
            case 1 -> {
                System.out.println("Topic: Friends");
                list = myDataBank.getFriendsQuestions();

            } case 2 -> {
                System.out.println("Topic: Bollywood");
                list = myDataBank.getBollywoodQuestions();

            } case 3 -> {
                System.out.println("Topic: Horror");
                list = myDataBank.getHorrorQuestions();

            } case 4 -> {
                System.out.println("Topic: Random");
                list = myDataBank.getRandomQuestions();

            } default -> {
                System.out.println("INVALID INPUT(Select a valid option):\n");
                myGame.triviaTopics();


            }
        }
        return list;

    }


//    private void chosenTopic(int theInput) {
//        Question question = null;
//        if (theInput == 1) {
//            question = myDataBank.getFriendsQuestion();
//            System.out.println(question.promptQuestion());
//            System.out.println("Enter your answer a,b,c,d:\n");
//
//        } else if (theInput == 2) {
//            question = myDataBank.getBollywoodQuestion();
//            System.out.println(question.promptQuestion());
//            System.out.println("Enter your answer a,b,c,d:\n");
//        }else if (theInput == 3) {
//            question = myDataBank.getHorrorQuestion();
//            System.out.println(question.promptQuestion());
//            System.out.println("Enter your answer a,b,c,d:\n");
//        } else if (theInput == 4) {
//            question = myDataBank.getRandomQuestion();
//            System.out.println(question.promptQuestion());
//            System.out.println("Enter your answer a,b,c,d:\n");
//        } else {
//            System.out.println("Invalid Input: Try Again");
//
//        }
//        assert question != null;
//        return question.isCorrect(myScanner.nextLine().toUpperCase());
//
//    }

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
            case "e" -> {System.out.println("Thank you for playing");
                System.exit(0);
            }
            default -> {playerInput(theInput);
                System.out.println("INVALID INPUT(Select a valid option)");
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
        } else {
            if (askQuestion()) {
                System.out.println("You can continue");
                myMaze.move('S');
            } else {
                System.out.println("INCORRECT ANSWER, DOOR HAS BEEN LOCKED");
                myMaze.isLocked('S');
            }
        }
    }

    private boolean askQuestion() {
//        myMaze.[door],.promptQuestion();
//        playerAnswer = whatever
//        Return playerAnswer == myMaze.[door].isCorrect();
        int myInput = myMaze.getQuestionType();
        Question question = null;
        if (myInput == 1) {
            question = myDataBank.getFriendsQuestion();
            System.out.println(question.promptQuestion());
            System.out.println("Enter your answer a,b,c,d:\n");

        } else if (myInput == 2) {
            question = myDataBank.getBollywoodQuestion();
            System.out.println(question.promptQuestion());
            System.out.println("Enter your answer a,b,c,d:\n");
        }else if (myInput == 3) {
            question = myDataBank.getHorrorQuestion();
            System.out.println(question.promptQuestion());
            System.out.println("Enter your answer a,b,c,d:\n");
        } else if (myInput == 4) {
            question = myDataBank.getRandomQuestion();
            System.out.println(question.promptQuestion());
            System.out.println("Enter your answer a,b,c,d:\n");
        } else {
            System.out.println("Invalid Input: Try Again");

        }
        assert question != null;
        return question.isCorrect(myScanner.nextLine().toUpperCase());
    }

    private int getPlayerInputInt() {
        int input;
        input = Integer.parseInt(myScanner.nextLine());
        return input;
    }


    /**
* ends the game when the player has reached the end or lost.
*
* @return false
*/
    private boolean endGame() {
        if (myMaze.atLastRoom()) {
            System.out.println("You've won the game!!!");
            return true;
        }
//        } else if (myMaze.isLocked('N') && myMaze.isLocked('S')
//            && myMaze.isLocked('E') && myMaze.isLocked('W')) {
//        System.out.println("You've LOST the game");

    return false;

    }

}