/**
 * Attack of Trivia: QuestionTest.java
 * 12/15/2022
 */

package triviamaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Question class.
 *
 * @author Amtoj Kaur, Angelynna Pyeatt, Leyla Ahmed
 * @version Autumn 2022
 */
class QuestionTest {

    /**
     * Tests the Question constructor: theQuestion parameter
     * - expects an exception.
     */
    @Test
    void questionExceptionConstructor() {
        assertThrows(Exception.class, () -> new Question(null,
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
    }

    /**
     * Tests the Question constructor: theAnswerOptions parameter
     * - expects an exception.
     */
    @Test
    void ansOptionExceptionConstructor() {
        assertThrows(Exception.class, () -> new Question("Have you ever...?",
                null, "B"));
    }

    /**
     * Tests the Question constructor: theCorrectAnswer parameter
     * - expects an exception.
     */
    @Test
    void answerChoiceExceptionConstructor() {
        assertThrows(Exception.class, () -> new Question("Have you ever...?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", null));
    }

    /**
     * Tests isCorrect() method - expects true.
     * @throws Exception
     */
    @Test
    void isCorrect() throws Exception {
        Question q = new Question("Have you ever...?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B");
        assertEquals(true, q.isCorrect("B"));
    }

    /**
     * Tests isCorrect() method - expects false.
     * @throws Exception
     */
    @Test
    void isNotCorrect() throws Exception {
        Question q = new Question("Have you ever...?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B");
        assertEquals(false, q.isCorrect("C"));
    }

    /**
     * Tests prompt question method - expects Question.
     * @throws Exception
     */
    @Test
    void promptQuestion() throws Exception {
        Question q = new Question("Have you ever...?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B");
        assertEquals("Have you ever...?\nA. Hi\nB. Hello\nC. Bye\nD. Goodbye\n", q.promptQuestion());
    }
}
