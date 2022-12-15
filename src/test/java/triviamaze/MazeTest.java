package triviamaze;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void createIllegalRowMaze() throws Exception {
        List<Question> list = new ArrayList<Question>();
        list.add(new Question("Have you ever..?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        assertThrows(IllegalArgumentException.class, () -> new Maze(0, 3, list, "Random"));
    }

    @Test
    void createIllegalColMaze() throws Exception {
        List<Question> list = new ArrayList<Question>();
        list.add(new Question("Have you ever..?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        assertThrows(IllegalArgumentException.class, () -> new Maze(3, 0, list, "Random"));
    }

    @Test
    void createIllegalMaze() throws Exception {
        List<Question> list = new ArrayList<Question>();
        list.add(new Question("Have you ever..?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
        assertThrows(IllegalArgumentException.class, () -> new Maze(0, 0, list, "Random"));
    }

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