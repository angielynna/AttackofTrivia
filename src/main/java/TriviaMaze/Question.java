/**
 * Attack of Trivia: Question.java
 * 12/15/2022
 */

package TriviaMaze;

import java.io.Serializable;

/**
 * Question class holds the question, answer options, and correct answer to
 * the question.
 * Model
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */

public class Question {

    /** holds question.*/
    private String myQuestion;

    /** holds correct answer to the question.*/
    private String myCorrectAnswer;

    /** holds array of answer options.*/
    private String[] myAnswerOptions;

    /**
     * Constructor
     *
     * @param theQuestion
     * @param theAnswerOptions
     * @param theCorrectAnswer
     */
    public Question(final String theQuestion, final String[] theAnswerOptions,
             final String theCorrectAnswer) {
        if (myQuestion == null || myCorrectAnswer == null
                || myAnswerOptions == null) {
            throw new IllegalArgumentException("Input is incorrect!");
        }

        this.myQuestion = theQuestion;
        this.myCorrectAnswer = theCorrectAnswer;
        this.myAnswerOptions = theAnswerOptions;
    }

    /**
     * Returns question.
     *
     * @return myQuestion
     */
    protected String getQuestion() {
        return myQuestion;
    }

    /**
     * returns correct answer to question.
     *
     * @return myCorrectAnswer
     */
    protected String getAnswer() {

        return myCorrectAnswer;
    }

    /**
     * returns answer options
     *
     * @return sb.toString()
     */
    protected String getOptions() {
        StringBuilder sb  = new StringBuilder();
        sb.append(myAnswerOptions[0] + "\n" + myAnswerOptions[1] + "\n"
                  + myAnswerOptions[2] + "\n" + myAnswerOptions[3]);
        return (sb.toString());
    }

    /**
     * returns true or false based off if the answer sent is equal to
     * myCorrectAnswer
     *
     * @param theAnswer
     * @return boolean
     */
    protected boolean isCorrect(final String theAnswer) {
        if (theAnswer.equals(this.myCorrectAnswer)) {
            return true;
        }
        return false;
    }

    /**
     * Prompts the question to the user
     *
     * @return sb.toString()
     */
    protected String promptQuestion() {
        StringBuilder sb = new StringBuilder();
        sb.append(getQuestion() + "\n" + getOptions() + "\n");
        return (sb.toString());
    }

}
