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
    private static final Statement STATEMENT = createConnection();

     // Initial id for all questions that will be incremented.
    private static final int INITIAL_QUESTION_ID = 1;

    //The question database


    //The single instance of the class.
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

    /**
     * Creates instance of Databank object.
     *
     * @return DataBank myDataBank
     */
    public static DataBank getDataBank() {
        if(myDataBank = null){
            myDataBank = new DataBank();
            return myDataBank;
        }
        return myDataBank;
    }

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
            String multiChoiceReqs = " (id integer, question string, options string, answer string)"
            // Just to make sure the table is the most updated version of itself
            // the following code will delete the table if it already exists and
            // make a new table. This is because we send all data at once to the
            // database from text files. After that we will create that table again
            // to store the data into.
            STATEMENT.executeUpdate("DROP TABLE IF EXISTS " + query1);
            STATEMENT.executeUpdate("CREATE TABLE " + query1 + multiChoiceReqs)
            STATEMENT.executeUpdate("DROP TABLE IF EXISTS " + query2);
            STATEMENT.executeUpdate("CREATE TABLE " + query2 + multiChoiceReqs)
            STATEMENT.executeUpdate("DROP TABLE IF EXISTS " + query3);
            STATEMENT.executeUpdate("CREATE TABLE " + query3 + multiChoiceReqs)
            STATEMENT.executeUpdate("DROP TABLE IF EXISTS " + query4);
            STATEMENT.executeUpdate("CREATE TABLE " + query4 + multiChoiceReqs)
        } catch (final SQLException e) {
            System.out.println("Error: tables not created properly.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Reads data from the given files and transfers it to the given tables.
     *
     * @param fileName
     * @param tableName
     */
    private void addQuestions(final String theFileName, final String theTableName) {
        int questionId = INITIAL_QUESTION_ID;
        try {
            final File file = new File(theFilename);
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
            STATEMENT.executeUpdate("INSERT INTO " + theTableName + " VALUES" +theQuery);
        } catch (final SQLException e) {
            System.out.println("Error: data not inserted into table properly.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Creates a connection with the database.
     *
     * @return Statement
     */
    private static Statement createConnection() {
        SQLiteDataSource myDS;
        try {
            myDS = new SQLiteDataSource();
            myDS.setUrl("jdbc:sqlite:AOTquestions.db");
            final Connection conn = myDS.getConnection();
            myStmt = conn.createStatement();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
