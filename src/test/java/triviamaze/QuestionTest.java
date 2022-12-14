package triviamaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void questionExceptionConstructor() {
        assertThrows(Exception.class, () -> new Question(null,
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B"));
    }

    @Test
    void ansOptionExceptionConstructor() {
        assertThrows(Exception.class, () -> new Question("Have you ever...?",
                null, "B"));
    }

    @Test
    void answerChoiceExceptionConstructor() {
        assertThrows(Exception.class, () -> new Question("Have you ever...?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", null));
    }

    @Test
    void isCorrect() {
        Question q = new Question("Have you ever...?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B");
        assertEquals(true, q.isCorrect("B"));
    }

    @Test
    void isNotCorrect() {
        Question q = new Question("Have you ever...?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B");
        assertEquals(false, q.isCorrect("C"));
    }

    @Test
    void promptQuestion() {
        Question q = new Question("Have you ever...?",
                "A. Hi, B. Hello, C. Bye, D. Goodbye", "B");
        assertEquals("Have you ever...?\nA. Hi\nB. Hello\nC. Bye\nD. Goodbye\n", q.promptQuestion());
    }
}