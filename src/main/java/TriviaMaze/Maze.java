//DRAFT - Angelynna Pyeatt
//Satisfies story AoT: 2.42.02
package TriviaMaze;

import java.util.*;

public class Maze {

    private Room myMaze[][];
    private String myData;  //can change, probably will lol
    private int myRow;
    private int myCol;

    //may need a separate private display maze

    /**
     * default maze contructor, for when no params are sent: 4 by 4 by
     * default
     */
    public Maze() {
        this(4, 4);
    }
    public Maze(final int theRows, final int theCols) {
        myMaze = buildMaze(theRows, theCols);
        myRow = 0;
        myCol = 0;
    }

    private Room[][] buildMaze(final int theRows, final int theCols) {
        final Room[][] maze = new Room[theRows][theCols];

        for(int i = 0; i < theRows; i++) {
            for (int j = 0; j < theCols; j++) {
                //break down of logic:
                if(i==0) {                          //If top row:
                    if(j==0) {                      //at first position: S, E
                        maze[i][j] = new Room();    //insert stuff here
                    } else if (j == theCols - 1) {  // at last position: S, W
                        maze[i][j] = new Room();    //info here again
                    } else {                        //other positions: S, W, E <- default
                        maze[i][j] = new Room();    //info here again
                    }
                } else if(j == 0 && i > 0) {        //If first column
                    if(i == theRows - 1) {          //if last row: N, E
                        maze[i][j] = new Room();    //info here again
                    } else {                        //other positions: N, E, S <- default
                        maze[i][j] = new Room();    //info here again
                    }
                } else if(j > 0 && i == theRows - 1) { //if last row:
                    if(j == theCols - 1) {             //if last column: N, W
                        maze[i][j] = new Room();       //info here again
                    } else {                           //other positions: N, E, W <- default
                        maze[i][j] = new Room();       //info here again
                    }
                } else if(j == theCols - 1 && (i > 0 && i < theRows - 1)) {// Last column
                    maze[i][j] = new Room();            //N, S, W
                } else {            //in middle of it all, has all rooms
                    maze[i][j] = new Room();            //N, E, W, S
                }
            }
        }
        //recall: the last room is the exit point, so there are no questions
        maze[theRows - 1][theCols - 1] = new Room();    //stuff
        return maze;
    }

    public void setLocation(final int theRow, final int theCol) {
        if (theRow >= myMaze.length || theCol >= myMaze.length
                || theRow < 0 || theCol < 0) {
            throw new IllegalArgumentException("Provided invalid row or column.");
        }
        myRow = theRow;
        myCol = theCol;
    }

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

    public boolean canMoveSouth() {
        if (myMaze[myRow + 1][myCol].mySouth != null) {  //if it contains south door
            return true;
        } else {
            return false;
        }
    }

    public boolean canMoveNorth() {
        if (myMaze[myRow + 1][myCol].myNorth != null) {  //if it contains north door
            return true;
        } else {
            return false;
        }
    }

    public boolean canMoveEast() {
        if (myMaze[myRow + 1][myCol].myEast != null) {  //if it contains east door
            return true;
        } else {
            return false;
        }
    }

    public boolean canMoveWest() {
        if (myMaze[myRow + 1][myCol].myWest != null) {  //if it contains west door
            return true;
        } else {
            return false;
        }
    }

    public boolean atLastRoom() {
        return myRow == myMaze.length - 1 && myCol == myMaze[0].length - 1;
    }

    public boolean isLocked() {
        return myMaze[myRow][myCol].isLocked();
    }

    public int getRow() {
        return myRow;
    }

    public int getCol() {
        return myCol;
    }

    public Room[][] getMaze() {
        return Arrays.copyOf(myMaze, myMaze.length);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(myMaze.toString());
        return sb.toString();
    }

    //little note for later: do we need an openDoor() method in room?
    //another note: do we need a display String[][] for maze? to maze toString and output easier?
}
