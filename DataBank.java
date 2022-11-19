/*
 * DataBank Class
 * Version Autumn 2022
 * 11/18/2022
 */

import java.util.*;
import java.io.*;
import java.sql.*;
import org.sqlite.SQLiteDataSource;

public class DataBank {

    // The Statement object.
    private static final Statement STATEMENT = createStatement();

     // Initial id for all questions that will be incremented.
    private static final int INITIAL_QUESTION_ID = 1;

     // The single instance of the class.
    private static DataBank myDataBank;

     // Array of all the bollywood questions from the database.
    private final Array<Question> bollywoodQuestions;

     // Array of all the Friends questions from the database.

    private final Array<Question> friendsQuestions;

     // Array of all the horror questions from the database.

    private final Array<Question> horrorQuestions;

    // Array of all the random questions from the database.

     // The index which keeps track of the questions in the bollywood array.

    private int bollywoodIndex = 0;

     // The index which keeps track of the questions in the friends array.
    private int friendsIndex = 0;

     // The index which keeps track of the questions in the horror array.

    private int horrorIndex = 0;

    // The index which keeps track of the questions in the random array.

    /**
     * Private Constructor, which sets up the database.
     */
    private Databank() {
        //method that sets up the database
        createDB();
        bollywoodQuestions = makeArray("Bollywood");
        friendsQuestions = makeArray("Friends");
        horrorQuestions = makeArray("Horror");
        // method closes the database
        closeDB();

    }
}
