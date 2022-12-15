/**
 * Attack of Trivia: DoorTest.java
 * 12/15/2022
 */

package triviamaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Door class.
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */
class DoorTest {

    /**
     * Tests Door constructor with illegal question string - expects Exception.
     */
    @Test
    void questionException() {
        assertThrows(Exception.class, () -> new Door(null,
                "A. 1, B. 2, C. 3, D. 4", "B"));
    }

    /**
     * Tests Door constructor with illegal answer options string - expects Exception.
     */
    @Test
    void ansOptionException() {
        assertThrows(Exception.class, () -> new Door("Have you ever...?",
                null, "B"));
    }

    /**
     * Tests Door constructor with illegal correct answer string - expects Exception.
     */
    @Test
    void answerChoiceException() {
        assertThrows(Exception.class, () -> new Door("Have you ever...?",
                "A. 1, B. 2, C. 3, D. 4", null));
    }

    /**
     * Checks to see if door is locked - expects true.
     */
    @Test
    void isLockedTrue() {
        Door door = new Door(true);
        assertEquals(true, door.isLocked());
    }

    /**
     * Checks to see if door is locked - expects false.
     */
    @Test
    void isLockedFalse() {
        Door door = new Door(false);
        assertEquals(false, door.isLocked());
    }

}