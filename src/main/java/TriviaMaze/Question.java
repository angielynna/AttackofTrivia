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
        if (myQuestion == null || myCorrectAnswer == null || myAnswerOptions.length != 4) {
            throw new IllegalArgumentException("Input is incorrect!");
        } else {
            this.myQuestion = theQuestion;
            this.myCorrectAnswer = theCorrectAnswer;
            this.myAnswerOptions = theAnswerOptions;
        }
    }

    /**
     * Returns question.
     *
     * @return myQuestion
     */
    public String getQuestion() {
        if(myQuestion.isEmpty() || myQuestion.equals(null)) {
            throw new IllegalArgumentException("ERROR! Question is empty!");
        } else {
            return myQuestion;
        }
    }

    /**
     * returns correct answer to question.
     *
     * @return myCorrectAnswer
     */
    public String getAnswer() {
        if(myCorrectAnswer.isEmpty() || myCorrectAnswer.equals(null)) {
            throw new IllegalArgumentException("ERROR! Correct answer is empty!");
        } else {
            return myCorrectAnswer;
        }
    }

    /**
     * returns answer options
     *
     * @return sb.toString()
     */
    public String getOptions() {
        if(myAnswerOptions.length != 4) {
            throw new IllegalArgumentException("ERROR! Not enough or too many answer options!");
        } else {
            StringBuilder sb  = new StringBuilder();
            sb.append(myAnswerOptions[0] + "\n" + myAnswerOptions[1] + "\n"
                    + myAnswerOptions[2] + "\n" + myAnswerOptions[3]);
            return (sb.toString());
        }
    }

    /**
     * returns true or false based off if the answer sent is equal to
     * myCorrectAnswer
     *
     * @param theAnswer
     * @return boolean
     */
     boolean isCorrect(final String theAnswer) {
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
    public String promptQuestion() {
        StringBuilder sb = new StringBuilder();
        sb.append(getQuestion() + "\n" + getOptions() + "\n");
        return (sb.toString());
    }

}
