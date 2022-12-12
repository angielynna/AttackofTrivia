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

    /** Holds data.*/
    private String myData;  //can change, probably will lol

    /** current player row index.*/
    private int myRow;

    /** current player column index.*/
    private int myCol;

    private List<Question> myQuestion;

    //may need a separate private display maze

    /**
     * default maze constructor, for when no params are sent: 4 by 4 by default
     */
    public Maze(List<Question> theQuestions) throws Exception {
        this(4, 4,theQuestions);
        myQuestion = theQuestions;
    }

    /**
     * Constructor initializes maze based off of parameters.
     *
     * @param theRows
     * @param theCols
     */
    public Maze(final int theRows, final int theCols, List<Question> theQuestions) throws Exception {
        if(theRows < 1 || theCols < 1) {
            throw new IllegalArgumentException("ERROR! Number of rows and/or columns"
                    + " cannot be zero or less!");
        }
        myQuestion = theQuestions;
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
        myRow = theRow;
        myCol = theCol;
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
    boolean canMoveSouth(int theRow, int theCol) {
        if ((theRow + 1 >= myMaze.length) || myMaze[theRow + 1][theCol].mySouth == null
                || myMaze[theRow+1][theCol].mySouth.isLocked()) {  //if it contains south door
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
    boolean canMoveNorth(int theRow, int theCol) {
        if ((theRow - 1 < 0)
                || myMaze[theRow-1][theCol].myNorth.isLocked()) {  //if it contains north door
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
    boolean canMoveEast(int theRow, int theCol) {
        if (( theCol + 1 >= myMaze[0].length)
                || myMaze[theRow][theCol+1].myEast.isLocked()) {  //if it contains east door
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
    boolean canMoveWest(int theRow, int theCol) {
        if ((theCol - 1 < 0)
                || myMaze[theRow][theCol-1].myWest.isLocked()) {  //if it contains west door
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
    boolean atLastRoom(int theRow, int theCol) {
        return theRow == myMaze.length - 1 && theCol == myMaze[0].length - 1;
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
    public boolean Locked(final char theDirection) {
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


    int getQuestionType(){
        int myInput = 0;
        if(myQuestion.hashCode() == -1604025196 || myQuestion.hashCode() == 2011654487){
            myInput = 1;
        } if (myQuestion.hashCode() == -1921522889 || myQuestion.hashCode() == -1018561296){
            myInput = 2;
        } if (myQuestion.hashCode() == 162359501 || myQuestion.hashCode() == 203761585){
            myInput = 3;
        } if (myQuestion.hashCode() == -1890575511 || myQuestion.hashCode() == 2065094921){
            myInput = 4;
        }

        return myInput;
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

//    public boolean outOfOptions(int theRow, int theCol) {
//        boolean success = false;
//        if (isValidMove(theRow, theCol)) {
////        System.out.println("DEBUG - tried to move to " + theRow + ", " + theCol);
////            markVisited(theRow,theCol); //drop a bread crumb to track we've been here
//            if (atLastRoom(theRow, theCol)) {
//                return true;
//            }
//            //not at exit so need to try other directions
//
//
//            if (canMoveSouth(theRow,theCol)) {
//                success = outOfOptions(theRow + 1, theCol);//South
//                System.out.println("south");
//
//            }
//            if (canMoveEast(theRow,theCol)) {
//                success = outOfOptions(theRow, theCol + 1); //East
//                System.out.println("east");
//
//            }
//            if (canMoveNorth(theRow,theCol)) {
//                success = outOfOptions(theRow - 1, theCol); //North
//                System.out.println("north");
//
//            }
//            if (canMoveWest(theRow,theCol)) {
//                success = outOfOptions(theRow, theCol - 1); //West
//                System.out.println("west");
//
//            }
//
//            //markDeadEnd(theRow, theCol);
//        }
//        return success;
//    }
    boolean isValidMove(int theRow, int theCol) {

            return (theRow < myMaze.length && theCol < myMaze[0].length
                    && theRow >= 0 && theCol >= 0);
        }


    /**
     * returns String representation of maze
     *
     * @return sb.toString()
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
//        for(int i=0; i < myRow; i++){
//            for(int j=0; j < myCol; j++){
//                System.out.print(myMaze[i][j]);
//
//            }
//            System.out.println();
//        }

        for (int i = 0; i < 4; i++) {
            sb.append(" __");
        }
        for (int i = 0; i < 4; i++) {
            sb.append("\n|");
            for (int j = 0; j < 5; j++) {
                if (myRow == i && myCol == j)
                    sb.append(" P ");
                else if (i >= 0 && 4 == j) {
                    sb.append("|");
                } else {
                    sb.append(" ? ");
                }
            }

        }
        sb.append("\n");
        for (int i = 0; i < 4; i++) {
            sb.append(" __");
        }


        return sb.toString();
    }

    //little note for later: do we need an openDoor() method in room?
    //another note: do we need a display String[][] for maze? to maze toString and output easier?
}