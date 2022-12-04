package TriviaMaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void questionException() {
        assertThrows(IllegalArgumentException.class, () -> new Question(null,
                new String[]{"1", "2", "3", "4"}, "b"));
    }

    @Test
    void ansOptionException() {
        assertThrows(IllegalArgumentException.class, () -> new Question("Have you ever...?",
                new String[]{"1", "2"}, "b"));
    }

    @Test
    void answerChoiceException() {
        assertThrows(IllegalArgumentException.class, () -> new Question("Have you ever...?",
                new String[]{"1", "2", "3", "4"}, null));
    }

    @Test
    void getQuestion() {
        Question q = new Question("Have you ever...?",
                new String[]{"1", "2", "3", "4"}, "b");
        assertEquals("Have you ever...?", q.getQuestion());
    }

    @Test
    void getIllegalQuestion() {
        Question q = new Question(null,
                new String[]{"1", "2", "3", "4"}, "b");
        assertThrows(IllegalArgumentException.class, () -> q.getQuestion());
    }

    @Test
    void getAnswer() {
        Question q = new Question("Have you ever...?",
                new String[]{"1", "2", "3", "4"}, "b");
        assertEquals("b", q.getAnswer());
    }

    @Test
    void getIllegalAnswer() {
        Question q = new Question("Have you ever...?",
                new String[]{"1", "2", "3", "4"}, null);
        assertThrows(IllegalArgumentException.class, () -> q.getAnswer());
    }

    @Test
    void getOptions() {
        Question q = new Question("Have you ever...?",
                new String[]{"1", "2", "3", "4"}, "b");
        assertEquals("1\n2\n3\n4", q.getOptions());
    }

    @Test
    void getIllegalOptions() {
        Question q = new Question("Have you ever...?",
                new String[]{"1", "2"}, "b");
        assertThrows(IllegalArgumentException.class, () -> q.getOptions());
    }

    @Test
    void isCorrect() {
        Question q = new Question("Have you ever...?",
                new String[]{"1", "2", "3", "4"}, "b");
        assertEquals(true, q.isCorrect("b"));
    }

    @Test
    void isNotCorrect() {
        Question q = new Question("Have you ever...?",
                new String[]{"1", "2", "3", "4"}, "b");
        assertEquals(false, q.isCorrect("c"));
    }

    @Test
    void promptQuestion() {
        Question q = new Question("Have you ever...?",
                new String[]{"1", "2", "3", "4"}, "b");
        assertEquals("Have you ever...?\n1\n2\n3\n4\n", q.promptQuestion());
    }
}