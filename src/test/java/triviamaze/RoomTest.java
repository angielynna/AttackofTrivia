package triviamaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** 
* Room Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 14, 2022</pre> 
* @version 1.0 
*/ 
public class RoomTest {

    @Test
    void nonexistentNorth() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(false, r.myNorth.exists());
    }

    @Test
    void lockedNorth() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(true, r.myNorth.isLocked());
    }

    @Test
    void nonexistentSouth() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(false, r.mySouth.exists());
    }

    @Test
    void lockedSouth() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(true, r.mySouth.isLocked());
    }

    @Test
    void nonexistentWest() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(false, r.myWest.exists());
    }

    @Test
    void lockedWest() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(true, r.myWest.isLocked());
    }

    @Test
    void nonexistentEast() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(false, r.myEast.exists());
    }

    @Test
    void lockedEast() throws Exception {
        Room r = new Room(null, null, null, null);
        assertEquals(true, r.myEast.isLocked());
    }

}

