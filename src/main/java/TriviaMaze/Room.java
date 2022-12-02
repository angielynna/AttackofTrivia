/**
 * Attack of Trivia: Room.java
 * 12/15/2022
 */

package TriviaMaze;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Room class instantiates Door objects (maximum of 4).
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Room {
    /** North door object.*/
    protected Door myNorth;

    /** East door object.*/
    protected Door myEast;

    /** West door object.*/
    protected Door myWest;

    /** South door object.*/
    protected Door mySouth;

    /**
     * Constructor instantiates all door objects based off of information
     * sent from parameters
     *
     * @param theNorthData
     * @param theEastData
     * @param theWestData
     * @param theSouthData
     */
    public Room(String[] theNorthData, String[] theEastData,
                String[] theWestData, String[] theSouthData) {
        if (theNorthData != null) {
            myNorth = new Door(theNorthData[0], Arrays.copyOfRange(theNorthData, 1, 5),
                    theNorthData[5]);
        } else {
            myNorth = null;
        }
        if (theEastData != null) {
            myEast = new Door(theEastData[0], Arrays.copyOfRange(theEastData, 1, 5),
                    theEastData[5]);
        } else {
            myEast = null;
        }
        if (theWestData != null) {
            myWest = new Door(theWestData[0], Arrays.copyOfRange(theWestData, 1, 5),
                    theWestData[5]);
        } else {
            myWest = null;
        }
        if (theSouthData != null) {
            mySouth = new Door(theSouthData[0], Arrays.copyOfRange(theSouthData, 1, 5),
                    theSouthData[5]);
        } else {
            mySouth = null;
        }
    }
}
