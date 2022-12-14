/**
 * Attack of Trivia: Room.java
 * 12/15/2022
 */

package triviamaze;

import java.io.Serial;
import java.io.Serializable;
/**
 * Room class instantiates Door objects (maximum of 4).
 * Model
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Room implements Serializable {
    /**Serial version ID.*/
    @Serial
    private static final long serialVersionUID = 3;
    /** North door object.*/
    final Door myNorth;

    /** East door object.*/
    final Door myEast;

    /** West door object.*/
    final Door myWest;

    /** South door object.*/
    final Door mySouth;


    /**
     * Constructor instantiates all door objects based off of information
     * sent from parameters.
     * Model
     *
     * @param theNorthData
     * @param theEastData
     * @param theWestData
     * @param theSouthData
     */
    public Room(final Question theNorthData, final Question theEastData,
                final Question theWestData, final Question theSouthData)
            throws Exception {
        if (theNorthData != null) {
            myNorth = new Door(theNorthData);
        } else {
            myNorth = new Door(true);
        }
        if (theEastData != null) {
            myEast = new Door(theEastData);
        } else {
            myEast = new Door(true);
        }
        if (theWestData != null) {
            myWest = new Door(theWestData);
        } else {
            myWest = new Door(true);
        }
        if (theSouthData != null) {
            mySouth = new Door(theSouthData);
        } else {
            mySouth = new Door(true);
        }
    }

}
