/**
 * Attack of Trivia: Maze.java
 * 12/15/2022
 */

package TriviaMaze;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


/**
 * Maze stores a 2D array of Room, the players current row and column index,
 * and a reference to the database
 * Controller
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Maze implements Serializable {
    private static final long serialVersionUID = 4;

    /** 2D array of Room.*/
    private final Room[][] myMaze;

    /** 2D char array for displaying the maze*/
    private final char[][] myDisplayMaze;

    /** Holds data.*/
    private String myData;  //can change, probably will lol

    /** current player row index.*/
    private int myRow;

    /** current player column index.*/
    private int myCol;

    private List<Question> myQuestion;

    private final String myTopic;

    /**
     * default maze constructor, for when no params are sent: 4 by 4 by default
     */
    public Maze(List<Question> theQuestions, String theTopic) throws Exception {
        this(4, 4,theQuestions, theTopic);
        myQuestion = theQuestions;
    }

    /**
     * Constructor initializes maze based off of parameters.
     *
     * @param theRows
     * @param theCols
     */
    public Maze(final int theRows, final int theCols, List<Question> theQuestions, String theTopic) throws Exception {
        if(theRows < 1 || theCols < 1) {
            throw new IllegalArgumentException("ERROR! Number of rows and/or columns"
                    + " cannot be zero or less!");
        }
        myQuestion = theQuestions;
        myTopic = theTopic;
        myMaze = buildMaze(theRows, theCols);
        myRow = 0;
        myCol = 0;
        myDisplayMaze = buildDisplay(theRows, theCols);

    }

    /**
     * Builds 2D array of Room objects.
     *
     * @param theRows
     * @param theCols
     * @return maze
     */
    private Room[][] buildMaze(final int theRows, final int theCols) throws Exception {
        final Room[][] maze = new Room[theRows][theCols];
        int count = 0;
        System.out.println(myQuestion.toString());
        for (int i = 0; i < theRows; i++) {
            for (int j = 0; j < theCols; j++) {
                //break down of logic:
                if (i == 0) {                          //If top row:
                    if (j == 0) {                      //at first position: S, E
                        maze[i][j] = new Room(null, myQuestion.get(count), null, myQuestion.get(count++));
                        //insert stuff here
                    } else if (j == theCols - 1) {  // at last position: S, W
                        maze[i][j] = new Room(null, null, myQuestion.get(count++), myQuestion.get(count++));
                    } else {                        //other positions: S, W, E <- default
                        maze[i][j] = new Room(null, myQuestion.get(count++), myQuestion.get(count++), myQuestion.get(count++));
                    }
                } else if(j == 0 && i > 0) {        //If first column
                    if(i == theRows - 1) {          //if last row: N, E
                        maze[i][j] = new Room(myQuestion.get(count++), myQuestion.get(count++), null, null);
                    } else {                        //other positions: N, E, S <- default
                        maze[i][j] = new Room(myQuestion.get(count++), myQuestion.get(count++), null, myQuestion.get(count++));
                    }
                } else if (j > 0 && i == theRows - 1) { //if last row:
                    if (j == theCols - 1) {             //if last column: N, W
                        maze[i][j] = new Room(myQuestion.get(count++), null, myQuestion.get(count++), null);
                    } else {                           //other positions: N, E, W <- default
                        maze[i][j] = new Room(myQuestion.get(count++), myQuestion.get(count++), myQuestion.get(count++), null);
                    }
                } else if (j == theCols - 1 && (i > 0 && i < theRows - 1)) {// Last column
                    maze[i][j] = new Room(myQuestion.get(count++), null, myQuestion.get(count++), myQuestion.get(count++));
                    //N, S, W
                } else {            //in middle of it all, has all rooms
                    maze[i][j] = new Room(myQuestion.get(count++), myQuestion.get(count++), myQuestion.get(count++), myQuestion.get(count++));
                    //N, E, W, S
                }
            }
            count++;
            System.out.println(count);
        }
        //recall: the last room is the exit point, so there are no questions
        maze[theRows - 1][theCols - 1] = new Room(null, null, null, null);
        //stuff
        return maze;
    }

    private char[][] buildDisplay(int theRows, int theCols) {
        final char[][] displayArr = new char[theRows][theCols];
        for (char[] arr : displayArr) {
            Arrays.fill(arr, '*');
        }
        displayArr[0][0] = 'P';
        return displayArr;
    }

    /**
     * sets the player location.
     *
     * @param theRow
     * @param theCol
     */
    void setLocation(final int theRow, final int theCol) {
        if (theRow >= myMaze.length || theCol >= myMaze[0].length
                || theRow < 0 || theCol < 0) {
            throw new IllegalArgumentException("Provided invalid row or column.");
        }
        myDisplayMaze[myRow][myCol] = ' ';
        myRow = theRow;
        myCol = theCol;
        myDisplayMaze[theRow][theCol] = 'P';
    }

    char setLocked(final int theRow, final int theCol){
        return myDisplayMaze[theRow][theCol] = 'X';
    }

    /**
     * Changes player location.
     * "Moves player."
     *
     * @param theDirection
     */
    protected void move(final char theDirection) {

        char ch = Character.toUpperCase(theDirection);
        if (ch == 'S' && canMoveSouth()) {
            myRow++;
        } else if (ch == 'E' && canMoveEast()) {
            myCol++;
        } else if (ch == 'W' && canMoveWest()) {
            myCol--;
        } else if (ch == 'N' && canMoveNorth()) {
            myRow--;
        } else {
            throw new IllegalArgumentException("Can not move in the direction provided.");
        }
    }

    /**
     * Verifies that the player can move South.
     *
     * @return boolean
     */
    boolean canMoveSouth() {
        if ((myRow + 1 >= myMaze.length) || myMaze[myRow + 1][myCol].mySouth == null
                || myMaze[myRow+1][myCol].mySouth.isLocked()) {  //if it contains south door
            return false;
        } else {
            return true;
        }
    }

    /**
     * Verifies that the player can move North.
     *
     * @return boolean
     */
    boolean canMoveNorth() {
        if ((myRow - 1 < 0)
                || myMaze[myRow-1][myCol].myNorth.isLocked()) {  //if it contains north door
            return false;
        } else {
            return true;
        }
    }

    /**
     * Verifies that the player can move East.
     *
     * @return boolean
     */
    boolean canMoveEast() {
        if ((myCol + 1 >= myMaze[0].length)
                || myMaze[myRow][myCol+1].myEast.isLocked()) {  //if it contains east door
            return false;
        } else {
            return true;
        }
    }

    /**
     * Verifies that the player can move West.
     *
     * @return boolean
     */
    boolean canMoveWest() {
        if ((myCol - 1 < 0)
                || myMaze[myRow][myCol-1].myWest.isLocked()) {  //if it contains west door
            return false;
        } else {
            return true;
        }
    }

    /**
     * Determines whether the player has made it to the last room in the maze.
     *
     * @return myRow == myMaze.length - 1 && myCol == myMaze[0].length - 1;
     */
    boolean atLastRoom() {
        return myRow == myMaze.length - 1 && myCol == myMaze[0].length - 1;
    }

    /**
     * Checks to see if the door (specified in the parameter) is locked
     *
     * @param theDirection
     * @return boolean
     */
    public boolean isLocked(final char theDirection) {
        if (Character.toUpperCase(theDirection) == 'N') {
            return myMaze[myRow][myCol].myNorth.isLocked();
        } else if (Character.toUpperCase(theDirection) == 'E') {
            return myMaze[myRow][myCol].myEast.isLocked();
        }  else if (Character.toUpperCase(theDirection) == 'S') {
            return myMaze[myRow][myCol].mySouth.isLocked();
        } else if (Character.toUpperCase(theDirection) == 'W') {
            return myMaze[myRow][myCol].myWest.isLocked();
        } else {
            throw new IllegalArgumentException("ERROR! Direction is invalid.");
        }
    }
    public boolean locked(final char theDirection) {
        if (Character.toUpperCase(theDirection) == 'N') {
            return myMaze[myRow][myCol].myNorth.lockDoor();
        } else if (Character.toUpperCase(theDirection) == 'E') {
            return myMaze[myRow][myCol].myEast.lockDoor();
        }  else if (Character.toUpperCase(theDirection) == 'S') {
            return myMaze[myRow][myCol].mySouth.lockDoor();
        } else if (Character.toUpperCase(theDirection) == 'W') {
            return myMaze[myRow][myCol].myWest.lockDoor();
        } else {
            throw new IllegalArgumentException("ERROR! Direction is invalid.");
        }
    }

    char[][] getDisplayMaze() {
        return Arrays.copyOf(myDisplayMaze, myDisplayMaze.length);
    }

    String getQuestionType(){
        return myTopic;
    }

    /**
     * returns players current row.
     *
     * @return myRow
     */
    public int getRow() {
        return myRow;
    }

    /**
     * returns players current column.
     *
     * @return myCol
     */
    public int getCol() {
        return myCol;
    }

    /**
     * returns a copy of maze array
     *
     * @return Arrays.copyOf(myMaze, myMaze.length);
     */
    public Room[][] getMaze() {
        return Arrays.copyOf(myMaze, myMaze.length);
    }

    boolean isValidMove(int theRow, int theCol) {
        return (theRow < myMaze.length && theCol < myMaze[0].length
                    && theRow >= 0 && theCol >= 0);
    }


    /**
     * returns String representation of maze
     *
     * @return sb.toString()
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("__________\n");
        for(int i = 0; i < myDisplayMaze.length; i++) {
            sb.append("|");
            for (int j = 0; j < myDisplayMaze[0].length; j++) {
                sb.append(myDisplayMaze[i][j]);
                sb.append(" ");
            }
            sb.append("|\n");
        }
        sb.append("----------\n");
        return sb.toString();
    }
}