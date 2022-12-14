package triviamaze;
/**
 * Attack of Trivia: DataBank.java
 * 12/15/2022
 */

import java.util.*;
import java.io.*;
import java.sql.*;
import org.sqlite.SQLiteDataSource;
import java.io.Serializable;

public class DataBank implements Serializable  {
    // The question database.
    SQLiteDataSource myDs;

    // Statement object for database.
    Statement myStmt;

    // Initial id for all questions that will be incremented.
    private static final int INITIAL_QUESTION_ID = 1;

    //The single instance of the class.
    //private static DataBank myDataBank;

    // List of all the bollywood questions from the database.
    private final List<Question> bollywoodQuestions;

    // List of all the Friends questions from the database.
    private final List<Question> friendsQuestions;

    // List of all the horror questions from the database.
    private final List<Question> horrorQuestions;

    // List of all the random questions from the database.
    private final List<Question> randomQuestions;

    // The index which keeps track of the questions in the bollywood array.
    private int bollywoodIndex = 0;

    // The index which keeps track of the questions in the friends array.
    private int friendsIndex = 0;

    // The index which keeps track of the questions in the horror array.
    private int horrorIndex = 0;

    // The index which keeps track of the questions in the random array.
    private int randomIndex = 0;

    /**
     * Private Constructor, which sets up the database as well as creates a connection
     * with the SQLiteDataSource.
     */
    public DataBank() {
        try {
            myDs = new SQLiteDataSource();
            myDs.setUrl("jdbc:sqlite:AOTQuestions.db");
            final Connection conn = myDs.getConnection();
            myStmt = conn.createStatement();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        //method that sets up the database
        createDB();
        bollywoodQuestions = makeList("Bollywood");
        friendsQuestions = makeList("Friends");
        horrorQuestions = makeList("Horror");
        randomQuestions = makeList("Random");
        // method closes the database
        closeDB();

    }

//    /**
//     * Creates instance of Data bank object.
//     *
//     * @return TriviaMaze.DataBank myDataBank
//     */
//    public static DataBank getDataBank() {
//        if(myDataBank == null){
//            myDataBank = new DataBank();
//            return myDataBank;
//        }
//        return myDataBank;
//    }

    /**
     * Adds Tables and questions to tables in the database created.
     */
    private void createDB() {
        //method adds tables to DataBase
        addTables();

        //method adds Data to tables from specified text files
        addData("Bollywood.txt", "Bollywood");
        addData("Friends.txt", "Friends");
        addData("Horror.txt", "Horror");
        addData("Random.txt", "Random");
    }

    /**
     * Adds four tables for the for different text files to the Database.
     */
    private void addTables() {
        //creating tables
        try {
            // strings that store table names for execution command
            String query1 = "Bollywood";
            String query2 = "Friends";
            String query3 = "Horror";
            String query4 = "Random";
            String multiChoiceReqs = " (id integer, question string, options string, answer string)";
            // Just to make sure the table is the most updated version of itself
            // the following code will delete the table if it already exists and
            // make a new table. This is because we send all data at once to the
            // database from text files. After that we will create that table again
            // to store the data into.
            myStmt.executeUpdate("DROP TABLE IF EXISTS " + query1);
            myStmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + query1 + multiChoiceReqs);
            myStmt.executeUpdate("DROP TABLE IF EXISTS " + query2);
            myStmt.executeUpdate("CREATE TABLE IF NOT EXISTS  " + query2 + multiChoiceReqs);
            myStmt.executeUpdate("DROP TABLE IF EXISTS " + query3);
            myStmt.executeUpdate("CREATE TABLE IF NOT EXISTS  " + query3 + multiChoiceReqs);
            myStmt.executeUpdate("DROP TABLE IF EXISTS " + query4);
            myStmt.executeUpdate("CREATE TABLE IF NOT EXISTS  " + query4 + multiChoiceReqs);
        } catch (final SQLException e) {
            System.err.println("Error: tables not created properly.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Reads data from the given files and transfers it to the given tables.
     *
     * @param theFileName
     * @param theTableName
     */
    private void addData(final String theFileName, final String theTableName) {
        int questionId = INITIAL_QUESTION_ID;
        try {
            final File file = new File(theFileName);
            final Scanner sc = new Scanner(file);
            //create query from the line
            while (sc.hasNextLine()) {
                final String query;
                final String question = sc.nextLine();
                final String options = sc.nextLine();
                final String answer = sc.nextLine();
                query = String.format("(%d, '%s', '%s', '%s')", questionId,
                        question, options, answer);
                addQuery(theTableName, query);
                questionId++;
            }
            sc.close();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert the entry into the table name given.
     *
     * @param theTableName
     * @param theQuery
     */
    private void addQuery(final String theTableName, final String theQuery) {
        try {
            myStmt.executeUpdate("INSERT INTO " + theTableName + " VALUES" +theQuery);
        } catch (final SQLException e) {
            System.err.println("Error: data not inserted into table properly.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Reads all the questions from the database from the given table name and
     * stores it in a list.
     *
     * @param theTableName
     * @return List</String>
     */
    private List<Question> makeList(final String theTableName) {
        final String questionFieldName = "question";
        final String optionsFieldName = "options";
        final String answerFieldName = "answer";
        int questionID = INITIAL_QUESTION_ID;

        final List<Question> list = new ArrayList<>();
        while (entryAvailable(questionID, theTableName)) {
            final String question = fetchInfo(questionID, questionFieldName, theTableName);
            final String options = fetchInfo(questionID, optionsFieldName, theTableName);
            final String answer = fetchInfo(questionID, answerFieldName, theTableName);
            final Question q = new Question(question, options, answer);
            list.add(q);
            questionID++;
        }
        return list;
    }

    /**
     * Fetches the entry from the table with the given information.
     *
     * @param theQuestionID
     * @param theField
     * @param theTable
     * @return String result
     */
    private String fetchInfo(final int theQuestionID, final String theField, final String theTable) {

        String result = "";
        try {
            final ResultSet rs = myStmt.executeQuery("SELECT " + theField + " FROM " + theTable + " WHERE ID = " + theQuestionID);
            result = rs.getString(theField);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * Checks if the entry with the question id exists in the table or not
     *
     * @param theQuestionID
     * @param theTable
     * @return boolean
     */
    private boolean entryAvailable(final int theQuestionID, final String theTable) {
        boolean result = true;
        try {
            final ResultSet rs = myStmt.executeQuery("SELECT * FROM " + theTable + " WHERE ID =" + theQuestionID);
            if (!rs.next()) {
                result = false;
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Closes the connection with the database.
     */
    private void closeDB() {
        try {
            Connection c = myStmt.getConnection();
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * @return Return a copy of the list of bollywood questions.
     */
    public List<Question> getBollywoodQuestions() {
        return new ArrayList<>(bollywoodQuestions);
    }

    /**
     * @return A bollywood choice question.
     */
    public Question getBollywoodQuestion() {
        if (bollywoodIndex >= bollywoodQuestions.size()) {
            bollywoodIndex = 0;
        }
        return bollywoodQuestions.get(bollywoodIndex++);
    }

    /**
     * @return Return a copy of the list of Friends questions.
     */
    public List<Question> getFriendsQuestions() {
        return new ArrayList<>(friendsQuestions);
    }

    /**
     * @return A Friends choice question.
     */
    public Question getFriendsQuestion() {
        if (friendsIndex >= friendsQuestions.size()) {
            friendsIndex = 0;
        }
        return friendsQuestions.get(friendsIndex++);
    }

    /**
     * @return Return a copy of the list of horror questions.
     */
    public List<Question> getHorrorQuestions() {
        return new ArrayList<>(horrorQuestions);
    }

    /**
     * @return A horror choice question.
     */
    public Question getHorrorQuestion() {
        if (horrorIndex >= horrorQuestions.size()) {
            horrorIndex = 0;
        }
        return horrorQuestions.get(horrorIndex++);
    }
    /**
     * @return Return a copy of the list of horror questions.
     */
    public List<Question> getRandomQuestions() {
        return new ArrayList<>(randomQuestions);
    }

    /**
     * @return A horror choice question.
     */
    public Question getRandomQuestion() {
        if (randomIndex >= randomQuestions.size()) {
            randomIndex = 0;
        }
        return randomQuestions.get(randomIndex++);
    }
}