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

    /** holds String of answer options that needs to be split*/
    private String myAnswerOptions;

    /**
     * Constructor
     *
     * @param theQuestion
     * @param theAnswerOptions
     * @param theCorrectAnswer
     */
    public Question(final String theQuestion, final String theAnswerOptions,
                    final String theCorrectAnswer) {
        if (theQuestion.equals(null) || theCorrectAnswer.equals(null) || theAnswerOptions.equals(null)) {
            throw new IllegalArgumentException("Input is incorrect!");
        } else {
            myQuestion = theQuestion;
            myCorrectAnswer = theCorrectAnswer;
            myAnswerOptions = theAnswerOptions;
        }
    }

    /**
     * Returns question.
     *
     * @return myQuestion
     */
    public String getQuestion() {
        return myQuestion;
    }

    /**
     * returns correct answer to question.
     *
     * @return myCorrectAnswer
     */
    public String getAnswer() {
        return myCorrectAnswer;
    }

    /**
     * returns answer options
     *
     * @return sb.toString()
     */
    public String getOptions() {
        StringBuilder sb  = new StringBuilder();
        String[] parts = myAnswerOptions.split(", ");
        if(parts.length != 4) {
            throw new IllegalArgumentException("ERROR! Not enough or too many answer options!");
        } else {
            //adds the split up string to string builder
            sb.append(parts[0]+"\n"+parts[1]+"\n"+parts[2]+"\n"+parts[3]);
        }
        return sb.toString();
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