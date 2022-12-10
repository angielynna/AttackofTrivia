/**
 * Attack of Trivia: Room.java
 * 12/15/2022
 */

package TriviaMaze;

import java.util.Arrays;
import java.io.Serializable;
/**
 * Room class instantiates Door objects (maximum of 4).
 * Model
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Room implements Serializable {
    private static final long serialVersionUID = 3;
    /** North door object.*/
    final Door myNorth;

    /** East door object.*/
    final Door myEast;

    /** West door object.*/
    final Door myWest;

    /** South door object.*/
    final Door mySouth;

    private boolean visited = false;

    /**
     * Constructor instantiates all door objects based off of information
     * sent from parameters
     * Model
     *
     * @param theNorthData
     * @param theEastData
     * @param theWestData
     * @param theSouthData
     */
//    public Room(String[] theNorthData, String[] theEastData,
//                String[] theWestData, String[] theSouthData) throws Exception {
//        if (!theNorthData[0].equals("null")) {
//            myNorth = new Door(theNorthData[0], Arrays.copyOfRange(theNorthData, 1, 5),
//                    theNorthData[5]);
//        } else {
//            myNorth = new Door(true);
//        }
//        if (!theEastData[0].equals("null")) {
//            myEast = new Door(theEastData[0], Arrays.copyOfRange(theEastData, 1, 5),
//                    theEastData[5]);
//        } else {
//            myEast = new Door(true);
//        }
//        if (!theWestData[0].equals("null")) {
//            myWest = new Door(theWestData[0], Arrays.copyOfRange(theWestData, 1, 5),
//                    theWestData[5]);
//        } else {
//            myWest = new Door(true);
//        }
//        if (!theSouthData[0].equals("null")) {
//            mySouth = new Door(theSouthData[0], Arrays.copyOfRange(theSouthData, 1, 5),
//                    theSouthData[5]);
//        } else {
//            mySouth = new Door(true);
//        }
//    }
    public Room(Question theNorthData, Question theEastData,
                Question theWestData, Question theSouthData) throws Exception {
        if(theNorthData != null) {
            myNorth = new Door(theNorthData);
        } else {
            myNorth = new Door(true);
        }
        if(theEastData != null) {
            myEast = new Door(theEastData);
        } else {
            myEast = new Door(true);
        }
        if(theWestData != null) {
            myWest = new Door(theWestData);
        } else {
            myWest = new Door(true);
        }
        if(theSouthData != null) {
            mySouth = new Door(theSouthData);
        } else {
            mySouth = new Door(true);
        }
    }

    public boolean visited() {
        return this.visited;
    }
}