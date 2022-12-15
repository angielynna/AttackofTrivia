/**
 * Attack of Trivia: MazeTest.java
 * 12/15/2022
 */

package triviamaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** 
 * Tests the Room class.
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */
public class RoomTest {

    /**
     * Checks to see if North door exists - expects false.
     * @throws Exception
     */
    @Test
    void nonexistentNorth() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(false, r.myNorth.exists());
    }

    /**
     * Checks to see if North door is locked - expects true.
     * @throws Exception
     */
    @Test
    void lockedNorth() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(true, r.myNorth.isLocked());
    }

    /**
     * Checks to see if South door exists - expects false.
     * @throws Exception
     */
    @Test
    void nonexistentSouth() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(false, r.mySouth.exists());
    }

    /**
     * Checks to see if South door is locked - expects true.
     * @throws Exception
     */
    @Test
    void lockedSouth() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(true, r.mySouth.isLocked());
    }

    /**
     * Checks to see if West door exists - expects false.
     * @throws Exception
     */
    @Test
    void nonexistentWest() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(false, r.myWest.exists());
    }

    /**
     * Checks to see if West door is locked - expects true.
     * @throws Exception
     */
    @Test
    void lockedWest() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(true, r.myWest.isLocked());
    }

    /**
     * Checks to see if East door exists - expects false.
     * @throws Exception
     */
    @Test
    void nonexistentEast() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(false, r.myEast.exists());
    }

    /**
     * Checks to see if East door is locked - expects true.
     * @throws Exception
     */
    @Test
    void lockedEast() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(true, r.myEast.isLocked());
    }

}

