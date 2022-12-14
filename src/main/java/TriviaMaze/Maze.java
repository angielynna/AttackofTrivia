/**
 * Attack of Trivia: Maze.java
 * 12/15/2022
 */

package TriviaMaze;

import java.io.Serial;
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
    /**Serial version ID.*/
    @Serial
    private static final long serialVersionUID = 4;

    /** 2D array of Room.*/
    private final Room[][] myMaze;

    /** 2D char array for displaying the maze*/
    private final char[][] myDisplayMaze;

    /** current player row index.*/
    private int myRow;

    /** current player column index.*/
    private int myCol;

    /** Holds a list of questions*/
    private List<Question> myQuestion;

    /** Holds the Topic*/
    private final String myTopic;


    /**
     * default maze constructor, for when no params are sent: 4 by 4 by default
     * @param theQuestions
     * @param theTopic
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
     * @param theQuestions
     * @param theTopic
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
        }
        //recall: the last room is the exit point, so there are no questions
        maze[theRows - 1][theCols - 1] = new Room(null, null, null, null);
        //stuff
        return maze;
    }
    /**
     * Builds and displays
     * the maze.
     *
     * @param theRows
     * @param theCols
     * @return displayArr
     */
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


    /**
     * Changes player location.
     * "Moves player."
     *
     * @param theDirection
     */
    protected void move(final char theDirection) {
        myDisplayMaze[myRow][myCol] = 'T';
        char ch = Character.toUpperCase(theDirection);
        if (ch == 'S') {
            myRow++;
        } else if (ch == 'E') {
            myCol++;
        } else if (ch == 'W') {
            myCol--;
        } else if (ch == 'N') {
            myRow--;
        } else {
            throw new IllegalArgumentException("Can not move in the direction provided.");
        }
        myDisplayMaze[myRow][myCol] = 'P';
    }

    /**
     * Verifies that the player can move South.
     *
     * @return boolean
     */
    boolean canMoveSouth(Room[][] theMaze, int theRow, int theCol) {
        if ((theRow + 1 >= theMaze.length) ||
                theMaze[theRow][theCol].mySouth.isLocked()) {  //if it contains south door
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
    boolean canMoveNorth(Room[][] theMaze, int theRow, int theCol) {
        if ((theRow - 1 < 0)
                || theMaze[theRow][theCol].myNorth.isLocked()) {  //if it contains north door
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
    boolean canMoveEast(Room[][] theMaze, int theRow, int theCol) {
        if ((theCol + 1 >= theMaze[0].length)
                || theMaze[theRow][theCol].myEast.isLocked()) {  //if it contains east door
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
    boolean canMoveWest(Room[][] theMaze, int theRow, int theCol) {
        if ((theCol - 1 < 0)
                || theMaze[theRow][theCol].myWest.isLocked()) {  //if it contains west door
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
    /**
     * Locks the door (specified in the parameter).
     *
     * @param theDirection
     * @return boolean
     */
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

    /**
     * Locks the door at a specific row and column (specified in the parameter).
     *
     * @param theDirection
     * @param theRow
     * @param theCol
     * @return boolean
     */
    public boolean locked(final char theDirection, int theRow, int theCol) {
        if (Character.toUpperCase(theDirection) == 'N') {
            return myMaze[theRow][theCol].myNorth.lockDoor();
        } else if (Character.toUpperCase(theDirection) == 'E') {
            return myMaze[theRow][theCol].myEast.lockDoor();
        }  else if (Character.toUpperCase(theDirection) == 'S') {
            return myMaze[theRow][theCol].mySouth.lockDoor();
        } else if (Character.toUpperCase(theDirection) == 'W') {
            return myMaze[theRow][theCol].myWest.lockDoor();
        } else {
            throw new IllegalArgumentException("ERROR! Direction is invalid.");
        }
    }

    char[][] getDisplayMaze() {
        return Arrays.copyOf(myDisplayMaze, myDisplayMaze.length);
    }

    char setLocked(final int theRow, final int theCol) {
        int numDoors = 0;
        if(!myMaze[theRow][theCol].myNorth.isLocked()) {
            //System.out.println("North");
            numDoors++;
        }
        if(!myMaze[theRow][theCol].mySouth.isLocked()) {
            //System.out.println("South");
            numDoors++;
        }
        if(!myMaze[theRow][theCol].myWest.isLocked()) {
            //System.out.println("west");
            numDoors++;
        }
        if(!myMaze[theRow][theCol].myEast.isLocked()) {
            //System.out.println("east");
            numDoors++;
        }
        return myDisplayMaze[theRow][theCol] = (char) (numDoors + '0');
    }
    /**
     * Returns the topic chosen.
     * @return myTopic
     */
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


    /**
     * returns String representation of maze
     *
     * @return sb.toString()
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("______\n");
        for(int i = 0; i < myDisplayMaze.length; i++) {
            sb.append("|");
            for (int j = 0; j < myDisplayMaze[0].length; j++) {
                sb.append(myDisplayMaze[i][j]);
            }
            sb.append("|\n");
        }
        sb.append("------\n");
        return sb.toString();
    }



    //traverse

    boolean traverse(Room[][] theMaze, int theRow, int theCol, int theCount) {
        boolean success = false;
        System.out.println("DEBUG - tried to move to " + theRow+ ", " + theCol);
        if (atExit(theRow, theCol)) {
            return true;
        }else if(theCount > 64){
            return false;
        } else {
                //not at exit so need to try other directions
                if (!success && isValidMove(theMaze, theRow + 1, theCol)
                        && canMoveSouth(theMaze, theRow, theCol)) {
                    System.out.println(theCount);
                    theCount++;
                    success = traverse(theMaze, theRow + 1, theCol, theCount);
                }
                if (!success && isValidMove(theMaze, theRow, theCol + 1)
                        && canMoveEast(theMaze, theRow, theCol)) {
                    System.out.println(theCount);
                    theCount++;
                    success = traverse(theMaze, theRow, theCol + 1, theCount); //right
                }
                if (!success && isValidMove(theMaze, theRow, theCol - 1)
                        && canMoveWest(theMaze, theRow, theCol)) {
                    theCount++;
                    success = traverse(theMaze, theRow, theCol - 1, theCount);
                }
                if (!success && isValidMove(theMaze, theRow - 1, theCol)
                        && canMoveNorth(theMaze, theRow, theCol)) {
                    theCount++;
                    success = traverse(theMaze, theRow - 1, theCol, theCount); //up
                }

        }
        return success;
    }

    boolean isValidMove(Room[][] theMaze, int theRow, int theCol) {
        return (theRow < theMaze.length && theCol < theMaze[0].length
                && theRow >= 0 && theCol >= 0 );
    }

    private boolean atExit(int row, int col) {

        return row == 3 && col == 3;
    }

}
