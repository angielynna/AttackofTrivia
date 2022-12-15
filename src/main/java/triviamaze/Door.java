/**
 * Attack of Trivia: Door.java
 * 12/15/2022
 */

package triviamaze;

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

    /**boolean if the door exists.*/
    private boolean myExistence;

    /**
     * Door constructor that instantiates a Question.
     *
     * @param theQuestion
     * @param theAnsOptions
     * @param theCorrectAns
     * @throws Exception
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
        myExistence = true;

    }

    /**
     * Door constructor for Question object.
     * @param theQuestion
     * @throws Exception
     */
    public Door(final Question theQuestion) throws Exception {
        if (theQuestion == null) {
            throw new Exception("ERROR! Question is null!");
        }
        myQuestion = theQuestion;
        myStatus = false;
        myExistence = true;

    }

    /**
     * Constructor for a Door that does not exist.
     *
     * @param theLockedStatus
     */
    public Door(final boolean theLockedStatus) {
        myStatus = theLockedStatus;
        myQuestion = null;
        myExistence = false;
    }

    /**
     * lockDoor locks the current door.
     */
    void lockDoor() {

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
     * Returns whether the door exists or not.
     *
     * @return myExistence
     */
    boolean exists() {

        return myExistence;
    }

}
