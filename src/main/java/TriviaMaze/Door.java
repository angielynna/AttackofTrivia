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
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */
public class Door {
    /** Holds Question object associated with this door.*/
    private Question myQuestion;

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
                final String theCorrectAns) {
        myQuestion = new Question(theQuestion, theAnsOptions, theCorrectAns);
        myStatus = false;

    }

    /**
     * lockDoor locks the current door.
     */
    public void lockDoor() {
        myStatus = true;
    }

    /**
     * returns the locked status of the door.
     *
     * @return myStatus
     */
    public boolean isLocked() {
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
