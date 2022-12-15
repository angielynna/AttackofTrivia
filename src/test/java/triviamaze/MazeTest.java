/**
 * Attack of Trivia: MazeTest.java
 * 12/15/2022
 */

package triviamaze;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Maze class.
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

class MazeTest {

    /**
     * Makes an illegal amount of rows in maze - expects exception.
     * @throws Exception
     */
    @Test
    void createIllegalRowMaze() throws Exception {
        List<Question> list = new ArrayList<Question>();
        list.add(new Question("Have you ever..?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        assertThrows(IllegalArgumentException.class, () -> new Maze(0, 3, list, "Random"));
    }

    /**
     * Makes an illegal amount of columns in maze - expects exception.
     * @throws Exception
     */
    @Test
    void createIllegalColMaze() throws Exception {
        List<Question> list = new ArrayList<Question>();
        list.add(new Question("Have you ever..?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        assertThrows(IllegalArgumentException.class, () -> new Maze(3, 0, list, "Random"));
    }

    /**
     * Makes an illegal maze - expects exception.
     * @throws Exception
     */
    @Test
    void createIllegalMaze() throws Exception {
        List<Question> list = new ArrayList<Question>();
        list.add(new Question("Have you ever..?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        assertThrows(IllegalArgumentException.class, () -> new Maze(0, 0, list, "Random"));
    }

    /**
     * Sets the location to an illegal location - expects exception.
     * @throws Exception
     */
    @Test
    void setIllegalLocation() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertThrows(IllegalArgumentException.class, () -> m.setLocation(-1, -1));
    }

    /**
     * Tries to move in an illegal direction - expects exception.
     * @throws Exception
     */
    @Test
    void moveIllegal() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertThrows(IllegalArgumentException.class, () -> m.move('P'));
    }

    /**
     * Tests canMoveSouth method - expects true.
     * @throws Exception
     */
    @Test
    void canMoveSouth() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(true, m.canMoveSouth(m.getMaze(), 0, 0));
    }

    /**
     * Tests canMoveSouth method - expects false.
     * @throws Exception
     */
    @Test
    void cannotMoveSouth() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(false, m.canMoveSouth(m.getMaze(), 3, 3));
    }

    /**
     * Tests canMoveNorth method - expects true.
     * @throws Exception
     */
    @Test
    void canMoveNorth() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(true, m.canMoveNorth(m.getMaze(), 1, 1));
    }

    /**
     * Tests canMoveNorth method - expects false.
     * @throws Exception
     */
    @Test
    void cannotMoveNorth() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(false, m.canMoveNorth(m.getMaze(), 0, 0));
    }

    /**
     * Tests canMoveEast method - expects true.
     * @throws Exception
     */
    @Test
    void canMoveEast() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(true, m.canMoveEast(m.getMaze(), 0, 0));
    }

    /**
     * Tests canMoveEast method - expects false.
     * @throws Exception
     */
    @Test
    void cannotMoveEast() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(false, m.canMoveEast(m.getMaze(), 1, 3));
    }

    /**
     * Tests canMoveWest method - expects true.
     * @throws Exception
     */
    @Test
    void canMoveWest() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(true, m.canMoveWest(m.getMaze(), 1, 1));
    }

    /**
     * Tests canMoveWest method - expects false.
     * @throws Exception
     */
    @Test
    void cannotMoveWest() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(false, m.canMoveWest(m.getMaze(), 0, 0));
    }

    /**
     * Tests atLastRoom method - expects true.
     * @throws Exception
     */
    @Test
    void atLastRoom() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        m.setLocation(3, 3);
        assertEquals(true, m.atLastRoom());
    }

    /**
     * Tests atLastRoom method - expects false.
     * @throws Exception
     */
    @Test
    void notAtLastRoom() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(false, m.atLastRoom());
    }

    /**
     * Tests to see if specified door is locked - expects false.
     * @throws Exception
     */
    @Test
    void falseNorthLocked() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        m.setLocation(1, 1);
        assertEquals(false, m.isLocked('N'));
    }

    /**
     * Tests to see if specified door is locked - expects true.
     * @throws Exception
     */
    @Test
    void trueNorthLocked() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(true, m.isLocked('N'));
    }

    /**
     * Tests to see if specified door is locked - expects true.
     * @throws Exception
     */
    @Test
    void trueSouthLocked() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        m.setLocation(3, 3);
        assertEquals(true, m.isLocked('S'));
    }

    /**
     * Tests to see if specified door is locked - expects false.
     * @throws Exception
     */
    @Test
    void falseSouthLocked() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(false, m.isLocked('S'));
    }

    /**
     * Tests to see if specified door is locked - expects false.
     * @throws Exception
     */
    @Test
    void falseWestLocked() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        m.setLocation(1, 1);
        assertEquals(false, m.isLocked('W'));
    }

    /**
     * Tests to see if specified door is locked - expects true.
     * @throws Exception
     */
    @Test
    void trueWestLocked() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(true, m.isLocked('W'));
    }

    /**
     * Tests to see if specified door is locked - expects true.
     * @throws Exception
     */
    @Test
    void trueEastLocked() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        assertEquals(true, m.isLocked('W'));
    }

    /**
     * Tests to see if specified door is locked - expects false.
     * @throws Exception
     */
    @Test
    void falseEastLocked() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        m.setLocation(1, 1);
        assertEquals(false, m.isLocked('W'));
    }

    /**
     * Tests getRow method - expects 1.
     * @throws Exception
     */
    @Test
    void getRow() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        m.setLocation(1, 0);
        assertEquals(1, m.getRow());
    }

    /**
     * Tests getCol method - expects 0.
     * @throws Exception
     */
    @Test
    void getCol() throws Exception {
        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");
        m.setLocation(1, 0);
        assertEquals(0, m.getCol());
    }

    /**
     * Tests build display method - expects String expected.
     * @throws Exception
     */
    @Test
    void testBuildDisplay() throws Exception {
        String expected = "P***\n****\n****\n***E\n";

        List<Question> list = new ArrayList<Question>();
        for(int i = 0; i < 64; i++) {
            list.add(new Question("Have you ever..?",
                    "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        }
        Maze m = new Maze(list, "Random");

        assertEquals(expected, m.getDisplayMaze());
    }

}