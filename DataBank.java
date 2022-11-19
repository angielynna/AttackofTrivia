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
    public static void main(String[] theArgs) {
        SQLiteDataSource ds = new SQLiteDataSource();
        try {
            //ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:AOTQuestions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        //Creating Question table for BollywoodQuiz
        String queryBQ = "CREATE TABLE IF NOT EXISTS BQQuestions ( " +
                "QID INT NOT NULL," +
                "QUESTION TEXT NOT NULL )";
        String queryBA = "CREATE TABLE IF NOT EXISTS BQAnswers ( " +
                "ANSWER TEXT NOT NULL," +
                "QID INT NOT NULL," +
                "CORRECT_FLAG INT NOT NULL )";

        createTable(queryBQ, ds);
        createTable(queryBA, ds);


        //Creating Question table for FriendsQuiz
        String queryFQ = "CREATE TABLE IF NOT EXISTS FQQuestions ( " +
                "QID INT NOT NULL," +
                "QUESTION TEXT NOT NULL )";
        String queryFA = "CREATE TABLE IF NOT EXISTS FQAnswers ( " +
                "ANSWER TEXT NOT NULL," +
                "QID INT NOT NULL," +
                "CORRECT_FLAG INT NOT NULL )";

        createTable(queryFQ, ds);
        createTable(queryFA, ds);


        //Creating Question table for HorrorQuiz
        String queryHQ = "CREATE TABLE IF NOT EXISTS HQQuestions ( " +
                "QID INT NOT NULL," +
                "QUESTION TEXT NOT NULL )";
        String queryHA = "CREATE TABLE IF NOT EXISTS HQAnswers ( " +
                "ANSWER TEXT NOT NULL," +
                "QID INT NOT NULL," +
                "CORRECT_FLAG INT NOT NULL )";
        createTable(queryHQ, ds);
        createTable(queryHA, ds);


        //Creating Question table for RandomQuiz
        String queryRQ = "CREATE TABLE IF NOT EXISTS RQQuestions ( " +
                "QID INT NOT NULL," +
                "QUESTION TEXT NOT NULL )";
        String queryRA = "CREATE TABLE IF NOT EXISTS RQAnswers ( " +
                "ANSWER TEXT NOT NULL," +
                "QID INT NOT NULL," +
                "CORRECT_FLAG INT NOT NULL )";

        createTable(queryRQ, ds);
        createTable(queryRA, ds);
    }

    public static void createTable(String query, SQLiteDataSource ds) {
        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement() ) {
            int rv = stmt.executeUpdate( query );
            System.out.println( "executeUpdate() returned " + rv );
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }


    public static void addData(String query, SQLiteDataSource ds) {
        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate(query);
            //System.out.println( "1st executeUpdate() returned " + rv );

            //rv = stmt.executeUpdate( query );
            //System.out.println( "2nd executeUpdate() returned " + rv );
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }

}
