package TriviaMaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void createIllegalRowMaze() {
        assertThrows(IllegalArgumentException.class, () -> new Maze(0, 3));
    }

    @Test
    void createIllegalColMaze() {
        assertThrows(IllegalArgumentException.class, () -> new Maze(3, 0));
    }

    @Test
    void createIllegalMaze() {
        assertThrows(IllegalArgumentException.class, () -> new Maze(0, 0));
    }

    @Test
    void setIllegalLocation() {
        Maze m = new Maze();
        assertThrows(IllegalArgumentException.class, () -> m.setLocation(0, 0));
    }

    @Test
    void moveIllegal() {
        Maze m = new Maze();
        assertThrows(IllegalArgumentException.class, () -> m.move('P'));
    }

    @Test
    void moveNorth() {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertThrows(IllegalArgumentException.class, () -> m.move('N'));
    }

    @Test
    void moveSouth() {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertThrows(IllegalArgumentException.class, () -> m.move('S'));
    }

    @Test
    void moveEast() {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertThrows(IllegalArgumentException.class, () -> m.move('E'));
    }

    @Test
    void moveWest() {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertThrows(IllegalArgumentException.class, () -> m.move('W'));
    }

    @Test
    void canMoveSouth() {
        Maze m = new Maze();
        assertEquals(true, m.canMoveSouth());
    }

    @Test
    void cannotMoveSouth() {
        Maze m = new Maze();
        m.setLocation(3,0); //set to last row
        assertEquals(false, m.canMoveSouth());
    }


    @Test
    void canMoveNorth() {
        Maze m = new Maze();
        m.setLocation(3, 0); //set to last row
        assertEquals(true, m.canMoveNorth());
    }

    @Test
    void cannotMoveNorth() {
        Maze m = new Maze();
        assertEquals(true, m.canMoveNorth());
    }

    @Test
    void canMoveEast() {
        Maze m = new Maze();
        assertEquals(true, m.canMoveEast());
    }

    @Test
    void cannotMoveEast() {
        Maze m = new Maze();
        m.setLocation(0, 3);
        assertEquals(false, m.canMoveEast());
    }

    @Test
    void canMoveWest() {
        Maze m = new Maze();
        m.setLocation(0, 3);
        assertEquals(true, m.canMoveWest());
    }

    @Test
    void cannotMoveWest() {
        Maze m = new Maze();
        assertEquals(false, m.canMoveWest());
    }

    @Test
    void atLastRoom() {
        Maze m = new Maze();
        m.setLocation(3, 3);
        assertEquals(true, m.atLastRoom());
    }

    @Test
    void notAtLastRoom() {
        Maze m = new Maze();
        assertEquals(false, m.atLastRoom());
    }

    @Test
    void falseNorthLocked() {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertEquals(false, m.isLocked('N'));
    }

    @Test
    void trueNorthLocked() {
        Maze m = new Maze();
        assertEquals(true, m.isLocked('N'));
    }

    @Test
    void trueSouthLocked() {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertEquals(true, m.isLocked('S'));
    }

    @Test
    void falseSouthLocked() {
        Maze m = new Maze();
        assertEquals(false, m.isLocked('S'));
    }

    @Test
    void falseWestLocked() {
        Maze m = new Maze();
        m.setLocation(2, 0);
        assertEquals(false, m.isLocked('W'));
    }

    @Test
    void trueWestLocked() {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertEquals(true, m.isLocked('W'));
    }

    @Test
    void trueEastLocked() {
        Maze m = new Maze();
        m.setLocation(2, 0);
        assertEquals(true, m.isLocked('W'));
    }

    @Test
    void falseEastLocked() {
        Maze m = new Maze();
        m.setLocation(2, 3);
        assertEquals(false, m.isLocked('W'));
    }

    @Test
    void getRow() {
        Maze m = new Maze();
        m.setLocation(3, 2);
        assertEquals(3, m.getRow());
    }

    @Test
    void getCol() {
        Maze m = new Maze();
        m.setLocation(3, 2);
        assertEquals(2, m.getRow());
    }
    
}