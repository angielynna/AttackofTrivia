/**
 * Attack of Trivia: Door.java
 * 12/15/2022
 */

package TriviaMaze;

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
public class Door {
    /** Holds Question object associated with this door.*/
    private final Question myQuestion;

    /** Holds locked status of the door.*/
    private boolean myStatus;

    /**
     * Constructor calls the Question class to instantiate a new question object
     * and sets locked status to false.
     *
     * @param theQuestion
     * @param theAnsOptions
     * @param theCorrectAns
     */
    public Door(final String theQuestion, final String[] theAnsOptions,
                final String theCorrectAns) throws Exception {
        if(theQuestion.isEmpty() || theQuestion.equals(null)) {
            throw new Exception("ERROR! Question is empty!");
        }
        if(theCorrectAns.isEmpty() || theCorrectAns.equals(null)) {
            throw new Exception("ERROR! Correct answer is empty");
        }
        if(theAnsOptions.length != 5) {
                throw new Exception("ERROR! Too many or too few answer options!");
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
    private void lockDoor() {
        myStatus = true;
    }

    /**
     * returns the locked status of the door.
     *
     * @return myStatus
     */
    boolean isLocked() {
        return myStatus;
    }

    /**
     * returns question associated with the Door.
     *
     * @return myQuestion.toString()
     */
    public String getQuestion() {
        return (myQuestion.toString());
    }

}