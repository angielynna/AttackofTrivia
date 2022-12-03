/**
 * Attack of Trivia: Maze.java
 * 12/15/2022
 */

package TriviaMaze;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Maze stores a 2D array of Room, the players current row and column index,
 * and a reference to the database
 * Controller
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Maze {

    /** 2D array of Room.*/
    private Room[][] myMaze;

    /** Holds data.*/
    private String myData;  //can change, probably will lol

    /** current player row index.*/
    private int myRow;

    /** current player column index.*/
    private int myCol;

    //may need a separate private display maze

    /**
     * default maze constructor, for when no params are sent: 4 by 4 by default
     */
    public Maze() {
        this(4, 4);
    }

    /**
     * Constructor initializes maze based off of parameters.
     *
     * @param theRows
     * @param theCols
     */
    public Maze(final int theRows, final int theCols) {
        if(theRows < 1 || theCols < 1) {
            throw new IllegalArgumentException("ERROR! Number of rows and/or columns"
                + " cannot be zero or less!");
        }
        myMaze = buildMaze(theRows, theCols);
        myRow = 0;
        myCol = 0;
    }

    /**
     * Builds 2D array of Room objects.
     *
     * @param theRows
     * @param theCols
     * @return maze
     */
    private Room[][] buildMaze(final int theRows, final int theCols) {
        final Room[][] maze = new Room[theRows][theCols];

        for (int i = 0; i < theRows; i++) {
            for (int j = 0; j < theCols; j++) {
                //break down of logic:
                if (i == 0) {                          //If top row:
                    if (j == 0) {                      //at first position: S, E
                        maze[i][j] = new Room(null, null, null, null);
                        //insert stuff here
                    } else if (j == theCols - 1) {  // at last position: S, W
                        maze[i][j] = new Room(null, null, null, null);
                    } else {                        //other positions: S, W, E <- default
                        maze[i][j] = new Room(null, null, null, null);
                    }
                } else if(j == 0 && i > 0) {        //If first column
                    if(i == theRows - 1) {          //if last row: N, E
                        maze[i][j] = new Room(null, null, null, null);
                    } else {                        //other positions: N, E, S <- default
                        maze[i][j] = new Room(null, null, null, null);
                    }
                } else if (j > 0 && i == theRows - 1) { //if last row:
                    if (j == theCols - 1) {             //if last column: N, W
                        maze[i][j] = new Room(null, null, null, null);
                    } else {                           //other positions: N, E, W <- default
                        maze[i][j] = new Room(null, null, null, null);
                    }
                } else if (j == theCols - 1 && (i > 0 && i < theRows - 1)) {// Last column
                    maze[i][j] = new Room(null, null, null, null);
                    //N, S, W
                } else {            //in middle of it all, has all rooms
                    maze[i][j] = new Room(null, null, null, null);
                    //N, E, W, S
                }
            }
        }
        //recall: the last room is the exit point, so there are no questions
        maze[theRows - 1][theCols - 1] = new Room(null, null,null, null);
        //stuff
        return maze;
    }

    /**
     * sets the player location.
     *
     * @param theRow
     * @param theCol
     */
    public void setLocation(final int theRow, final int theCol) {
        if (theRow >= myMaze.length || theCol >= myMaze.length
                || theRow < 0 || theCol < 0) {
            throw new IllegalArgumentException("Provided invalid row or column.");
        }
        myRow = theRow;
        myCol = theCol;
    }

    /**
     * Changes player location.
     * "Moves player."
     *
     * @param theDirection
     */
    public void move(final char theDirection) {
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
    public boolean canMoveSouth() {
        if (myMaze[myRow + 1][myCol].mySouth != null) {  //if it contains south door
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifies that the player can move North.
     *
     * @return boolean
     */
    public boolean canMoveNorth() {
        if (myMaze[myRow + 1][myCol].myNorth != null) {  //if it contains north door
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifies that the player can move East.
     *
     * @return boolean
     */
    public boolean canMoveEast() {
        if (myMaze[myRow + 1][myCol].myEast != null) {  //if it contains east door
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifies that the player can move West.
     *
     * @return boolean
     */
    public boolean canMoveWest() {
        if (myMaze[myRow + 1][myCol].myWest != null) {  //if it contains west door
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determines whether the player has made it to the last room in the maze.
     *
     * @return myRow == myMaze.length - 1 && myCol == myMaze[0].length - 1;
     */
    public boolean atLastRoom() {
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
        sb.append(myMaze.toString());
        return sb.toString();
    }

    //little note for later: do we need an openDoor() method in room?
    //another note: do we need a display String[][] for maze? to maze toString and output easier?
}
