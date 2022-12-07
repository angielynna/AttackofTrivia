package TriviaMaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DoorTest {

    @Test
    void questionException() {
       assertThrows(Exception.class, () -> new Door(null,
                "A. 1, B. 2, C. 3, D. 4", "B"));
    }

    @Test
    void ansOptionException() {
        assertThrows(Exception.class, () -> new Door("Have you ever...?",
                null, "B"));
    }

    @Test
    void answerChoiceException() {
        assertThrows(Exception.class, () -> new Door("Have you ever...?",
                "A. 1, B. 2, C. 3, D. 4", null));
    }

    @Test
    void isLockedTrue() {
        Door door = new Door(true);
        assertEquals(true, door.isLocked());
    }

    @Test
    void isLockedFalse() {
        Door door = new Door(false);
        assertEquals(false, door.isLocked());
    }

    @Test
    void getQuestion() throws Exception {
        Door door = new Door("Have you ever...?",
                "A. 1, B. 2, C. 3, D. 4", "B");
        assertEquals("Have you ever...?", door.getQuestion());
    }
}