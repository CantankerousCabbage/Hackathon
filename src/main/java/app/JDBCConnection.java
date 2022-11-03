package app;

import java.util.ArrayList;

import app.semster1.LGA;
import app.semster1.LGAExtended;
import app.semster1.LGA_PageST31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class JDBCConnection {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/hackathon.db";

    // If you are using the Homelessness data set replace this with the below
    // private static final String DATABASE =
    // "jdbc:sqlite:database/homelessness.db";

    /**
     * This creates a JDBC Object so we can keep talking to the database
     */
    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    /**
     * Get all of the LGAs in the database.
     * 
     * @return
     *         Returns an ArrayList of LGA objects
     */

    //LEFT AS TEMPLATE

    public ArrayList<String> getFiles(String Column, String Value){
        
        ArrayList<String> output_Files = new ArrayList<String>();

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(DATABASE);
            
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String output = "";
        
            switch (Column) {
                case "FilePath":
                    output = "RunDetails_FilePath";
                    break;
                
                case "LoadNumber":
                    output = "RunDetails_LoadNumber";
                    break;
                
                case "Equipment":
                    output = "RunDetails_Equipment";
                    break;

                case "RunRecipe":
                    output = "RunDetails_RunRecipe";
                    break;

                case "RunStart":
                    output = "RunDetails_RunStart";
                    break;

                case "RunEnd":
                    output = "RunDetails_RunEnd";
                    break;
                
                case "RunDuration":
                    output = "RunDetails_RunDuration";
                    break;

                case "FileLength":
                    output = "RunDetails_FileLength";
                    break;
                    
                case "OperatorName":
                    output = "RunDetails_OperatorName";
                    break;
                
                case "ExportControl":
                    output = "RunDetails_ExportControl";
                    break;

                case "IP":
                    output = "RunDetails_IP";
                    break;

                case "Index":
                    output = "RunDetails_Index";
                    break;

                case "WorkOrder":
                    output = "RunDetails_WorkOrder";
                    break;

                case "PartNumber":
                    output = "RunDetails_PartNumber";
                    break;

                case "PartDescription":
                    output = "RunDetails_PartDescription";
                    break;

                case "ToolLocation":
                    output = "RunDetails_ToolLocation";
                    break;

                case "PartTCs":
                    output = "RunDetails_PartTCs";
                    break;

                case "PartProbes":
                    output = "RunDetails_PartProbes";
                    break;

                case "OtherSensors":
                    output = "RunDetails_OtherSensors";
                    break;            
            }

            String query = "SELECT RunDetails_FileName FROM JASON WHERE " + output + " == " + output;

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString("RunDetails_FileName");
                output_Files.add(name);
            }
            statement.close();
        }catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return output_Files;

    }

    // public ArrayList<LGA> getLGAs() {
    //     // Create the ArrayList of LGA objects to return
    //     ArrayList<LGA> lgas = new ArrayList<LGA>();

    //     // Setup the variable for the JDBC connection
    //     Connection connection = null;

    //     try {
    //         // Connect to JDBC data base
    //         connection = DriverManager.getConnection(DATABASE);

    //         // Prepare a new SQL Query & Set a timeout
    //         Statement statement = connection.createStatement();
    //         statement.setQueryTimeout(30);

    //         // The Query
    //         String query = "SELECT * FROM LGA ORDER BY LGA_NAME16";

    //         // Get Result
    //         ResultSet results = statement.executeQuery(query);

    //         // Process all of the results
    //         while (results.next()) {
    //             // Lookup the columns we need
    //             int code16 = results.getInt("lga_code16");
    //             String name16 = results.getString("lga_name16");

    //             // Create a LGA Object
    //             LGA lga = new LGA(code16, name16);

    //             // Add the lga object to the array
    //             lgas.add(lga);
    //         }

    //         // Close the statement because we are done with it
    //         statement.close();
    //     } catch (SQLException e) {
    //         // If there is an error, lets just pring the error
    //         System.err.println(e.getMessage());
    //     } finally {
    //         // Safety code to cleanup
    //         try {
    //             if (connection != null) {
    //                 connection.close();
    //             }
    //         } catch (SQLException e) {
    //             // connection close failed.
    //             System.err.println(e.getMessage());
    //         }
    //     }

    //     // Finally we return all of the lga
    //     return lgas;
    // }

}