package TriviaMaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DoorTest {

    @Test
    void questionException() {
        assertThrows(Exception.class, () -> new Door(null,
                new String[]{"1", "2", "3", "4"}, "b"));
    }

    @Test
    void ansOptionException() {
        assertThrows(Exception.class, () -> new Door("Have you ever...?",
                new String[]{"1", "2"}, "b"));
    }

    @Test
    void answerChoiceException() {
        assertThrows(Exception.class, () -> new Door("Have you ever...?",
                new String[]{"1", "2", "3", "4"}, null));
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
                new String[]{"1", "2", "3", "4"}, "b");
        assertEquals("Have you ever...?", door.getQuestion());
    }
}