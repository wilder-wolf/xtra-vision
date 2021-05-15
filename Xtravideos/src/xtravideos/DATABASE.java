package PACK_MOVIES;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import PACK_MOVIES.FILMS;

/**
 *
 * @author Fabiolla/Wilder
 */
public class DATABASE {
    //    INFO TO CONNECT TO DATABASE
    private String dbServer = "jdbc:mysql://apontejaj.com:3306/Rylee_2019145?useSSL=false";
    private String dbUser = "Wilder_2019408";
    private String dbPassword = "2019408";
    
    Card c;
    FILMS m;
    
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public boolean boolNCC = true;
    
    public String[] movieTitles;
    
    public DATABASE(Card c) {
        this.c = c;
        openConnection();
    }
    
    public DATABASE(FILMS m) {
        this.m = m;
        openConnection();
    }
    
    public void openConnection(){
        try{
            //             CONNECT TO DATABASE
            conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);   // initialise connection to DB

//             GET A STATEMENT FROM THE CONNECTION
            stmt = conn.createStatement();
        } catch (SQLException se) {                                                                 // Catch SQL Exception errors and print out clear message
            System.out.println("SQL Exception:");

//             SQL EXCEPTIONS LOOP
            while (se != null) {                                                                        // Loop through the SQL Exceptions
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {                                                                     // Catch any other exceptions that might occur
            System.out.println(e);
        }
    }
    
    public void getMovieSelection(){
        String query = "SELECT title FROM movie;";                         // String query to get available movie titles from DB
        
        try{
            rs= stmt.executeQuery(query);                                                      // Result Statement to store results from DB
            
            while (rs.next()) {                                                                         // Loop to print results from Result Statement
                String title = rs.getString(1);
                System.out.println(title);
            }            
            rs.close();
            
        }catch (SQLException se) {                                                                      // Catch SQL Exception errors and print out clear message
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {                                                                            // Loop through the SQL Exceptions
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {                                                                         // Catch any other exceptions that might occur
            System.out.println(e);
        }
    }
    
    public void getMovieInfo(int movieNum){
        String query = "SELECT * FROM movie WHERE movie_ID= "+movieNum+ ";";                         // String query to get available movie titles from DB
        
        try{
            rs= stmt.executeQuery(query);                                                      // Result Statement to store results from DB
            
            while (rs.next()) { 
                String title = rs.getString("title");
                System.out.println("Title: " + title);
                String desc = rs.getString("description");
                System.out.println("Description: "+ desc);
                String genre = rs.getString("genre");
                System.out.println("Genre: " + genre);
                Date relDate = rs.getDate("release_date");
                String relDateYear = relDate.toString().substring(0, 4);
                System.out.println("Released: "+ relDateYear);
                int runTime = rs.getInt("runtime");
                System.out.println("Runtime: "+ runTime+ " minutes");
                double rating = rs.getDouble("rating");
                System.out.println("Rating: "+ rating);
            }     
            
            rs.close();
            
        }catch (SQLException se) {                                                                      // Catch SQL Exception errors and print out clear message
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {                                                                            // Loop through the SQL Exceptions
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {                                                                         // Catch any other exceptions that might occur
            System.out.println(e);
        }
    }
    
    public void insertNewCustCard(String newCardNum) {
        try {
//            STRING FOR SQL STATEMENT INSERTING NEW CUSTOMER CARD DETAILS
            String insertQuery = "INSERT INTO card (card) VALUES (?);";                 // Generic String Insert Query for all DB card insertions with empty value
            
//           PREPARE STATEMENT WITH VALIDATED (NEW GEN) CARD NUMBER 
           PreparedStatement pStmt = conn.prepareStatement(insertQuery);
           pStmt.setString(1, newCardNum);                                                      // Adds new card number to prepared statement to send to DB
           
//           EXECUTE PREPARED STATEMENT AND CLOSE
           pStmt.execute();
           pStmt.close();  
           
        } catch (SQLException se) {                                                                     // Catch SQL Exception errors and print out clear message
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {                                                                              // Loop through the SQL Exceptions
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {                                                                           // Catch any other exceptions that might occur
            System.out.println(e);
        }
    }
    
    
    public boolean newCustCheck(String custCardNum) {
        try {
           String selectQuery = "SELECT count(*) AS exist FROM card WHERE card='"+custCardNum+"';";         // String query to check if card given by user exists in DB already
           rs = stmt.executeQuery(selectQuery);                                                         // stores results from query in Result Statement
           
           if (rs.next()) {
               if (rs.getInt(1) > 0) {                                                                              // if rs has one (never duplicates as it is PK in DB) not a new customer
               boolNCC = false;
               }
           }
           
        } catch (SQLException se) {                                                     // Catch SQL Exception errors and print out clear message
            System.out.println("SQL Exception:");                       

            while (se != null) {                                                            // Loop through the SQL Exceptions
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {                                                           // Catch any other exceptions that might occur
            System.out.println(e);
        }
        
        return boolNCC;
    }
    
    
    
    public void closeConnection() {                                             // Close statement and connection (good practice)
        try {                                                                               // Must be done with try catch
            stmt.close();
            conn.close();
        } catch (SQLException se) {                                               // Catch SQL Exception errors and print out clear message
            System.out.println("SQL Exception:");

            while (se != null) {                                                        // Loop through the SQL Exceptions
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Text: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {                                                      // Catch any other exceptions that might occur
            System.out.println(e);
        }
    }
    
}
