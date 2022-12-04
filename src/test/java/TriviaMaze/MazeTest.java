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
    void setIllegalLocation() throws Exception {
        Maze m = new Maze();
        assertThrows(IllegalArgumentException.class, () -> m.setLocation(0, 0));
    }

    @Test
    void moveIllegal() throws Exception {
        Maze m = new Maze();
        assertThrows(IllegalArgumentException.class, () -> m.move('P'));
    }

    @Test
    void moveNorth() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertThrows(IllegalArgumentException.class, () -> m.move('N'));
    }

    @Test
    void moveSouth() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertThrows(IllegalArgumentException.class, () -> m.move('S'));
    }

    @Test
    void moveEast() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertThrows(IllegalArgumentException.class, () -> m.move('E'));
    }

    @Test
    void moveWest() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertThrows(IllegalArgumentException.class, () -> m.move('W'));
    }

    @Test
    void canMoveSouth() throws Exception {
        Maze m = new Maze();
        assertEquals(true, m.canMoveSouth());
    }

    @Test
    void cannotMoveSouth() throws Exception {
        Maze m = new Maze();
        m.setLocation(3,0); //set to last row
        assertEquals(false, m.canMoveSouth());
    }


    @Test
    void canMoveNorth() throws Exception {
        Maze m = new Maze();
        m.setLocation(3, 0); //set to last row
        assertEquals(true, m.canMoveNorth());
    }

    @Test
    void cannotMoveNorth() throws Exception {
        Maze m = new Maze();
        assertEquals(true, m.canMoveNorth());
    }

    @Test
    void canMoveEast() throws Exception {
        Maze m = new Maze();
        assertEquals(true, m.canMoveEast());
    }

    @Test
    void cannotMoveEast() throws Exception {
        Maze m = new Maze();
        m.setLocation(0, 3);
        assertEquals(false, m.canMoveEast());
    }

    @Test
    void canMoveWest() throws Exception {
        Maze m = new Maze();
        m.setLocation(0, 3);
        assertEquals(true, m.canMoveWest());
    }

    @Test
    void cannotMoveWest() throws Exception {
        Maze m = new Maze();
        assertEquals(false, m.canMoveWest());
    }

    @Test
    void atLastRoom() throws Exception {
        Maze m = new Maze();
        m.setLocation(3, 3);
        assertEquals(true, m.atLastRoom());
    }

    @Test
    void notAtLastRoom() throws Exception {
        Maze m = new Maze();
        assertEquals(false, m.atLastRoom());
    }

    @Test
    void falseNorthLocked() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertEquals(false, m.isLocked('N'));
    }

    @Test
    void trueNorthLocked() throws Exception {
        Maze m = new Maze();
        assertEquals(true, m.isLocked('N'));
    }

    @Test
    void trueSouthLocked() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertEquals(true, m.isLocked('S'));
    }

    @Test
    void falseSouthLocked() throws Exception {
        Maze m = new Maze();
        assertEquals(false, m.isLocked('S'));
    }

    @Test
    void falseWestLocked() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 0);
        assertEquals(false, m.isLocked('W'));
    }

    @Test
    void trueWestLocked() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 2);
        assertEquals(true, m.isLocked('W'));
    }

    @Test
    void trueEastLocked() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 0);
        assertEquals(true, m.isLocked('W'));
    }

    @Test
    void falseEastLocked() throws Exception {
        Maze m = new Maze();
        m.setLocation(2, 3);
        assertEquals(false, m.isLocked('W'));
    }

    @Test
    void getRow() throws Exception {
        Maze m = new Maze();
        m.setLocation(3, 2);
        assertEquals(3, m.getRow());
    }

    @Test
    void getCol() throws Exception {
        Maze m = new Maze();
        m.setLocation(3, 2);
        assertEquals(2, m.getRow());
    }

}