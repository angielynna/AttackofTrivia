/**
 * Attack of Trivia: Door.java
 * 12/15/2022
 */

package TriviaMaze;

import java.io.Serial;
import java.io.Serializable;

/**
 * Door represents pathways between Rooms.
 * Door holds its question and locked status. When a door is locked, a player
 * can no longer access it.
 * Model
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */
public class Door implements Serializable {
    /**Serial version ID.*/
    @Serial
    private static final long serialVersionUID = 2;

    /** Holds Question object associated with this door.*/
    private final Question myQuestion;

    /** Holds locked status of the door.*/
    private boolean myStatus;

    /**
     * Constructor calls the Question class to instantiate a new question object
     * and sets locked status to false.
     *
     * @param theQuestion
     */
    public Door(final String theQuestion, final String theAnsOptions,
                final String theCorrectAns) throws Exception {
        if (theQuestion.isEmpty() || theQuestion == null) {
            throw new Exception("ERROR! Question is empty!");
        }
        if (theCorrectAns.isEmpty() || theCorrectAns == null) {
            throw new Exception("ERROR! Correct answer is empty");
        }
        if (theAnsOptions == null) {
            throw new Exception("ERROR! Answer options do not exist!");
        }
        myQuestion = new Question(theQuestion, theAnsOptions, theCorrectAns);
        myStatus = false;

    }

    public Door(Question theQuestion) throws Exception {
        if(theQuestion == null) {
            throw new Exception("ERROR! Question is null!");
        }
        myQuestion = theQuestion;
        myStatus = false;

    }

    public Door(boolean theLockedStatus) {
        myStatus = theLockedStatus;
        myQuestion = null;
    }

    /**
     * lockDoor locks the current door.
     */
    boolean lockDoor() {
        return myStatus = true;
    }
    /**
     * returns the locked status of the door.
     *
     * @return myStatus
     */
    boolean isLocked() {
        return myStatus;
    }



}
