package app;

import java.util.ArrayList;

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

    public ArrayList<LGA> getLGAs() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> hackathon = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA ORDER BY LGA_NAME16";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code16 = results.getInt("lga_code16");
                String name16 = results.getString("lga_name16");

                // Create a LGA Object
                LGA lga = new LGA(code16, name16);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the lga
        return hackathon;
    }
     

    public ArrayList<LGA> getLGAs() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA ORDER BY LGA_NAME16";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code16 = results.getInt("lga_code16");
                String name16 = results.getString("lga_name16");

                // Create a LGA Object
                LGA lga = new LGA(code16, name16);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the lga
        return lgas;
    }

    // Fact 1 for Page Mission - Number of Indigenous people who have completed year
    // 12 or equivalent

    public int getIndigHighSchoolCompletion() {
        // Create the integer to return
        int ihsc = -1;
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT SUM(COUNT) FROM HighestYearSchoolCompleted WHERE indigenous_status= 'indig' AND highest_year_of_school_completed= 'y12_equiv';";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            ihsc = results.getInt("SUM(COUNT)");
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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
        // Finally we return all of the COUNT results
        return ihsc;
    }

    // Fact 2 for Page Mission - Total Indigenous Population

    public int getIndigPopulation() {
        // Create the integer to return
        int indigenousPopulation = -1;
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT SUM(COUNT) FROM PopulationStatistics WHERE indigenous_status = 'indig';";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            indigenousPopulation = results.getInt("SUM(COUNT)");
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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
        // Finally we return all of the COUNT results
        return indigenousPopulation;
    }

    // Fact 3 for Page Mission - Year 12 Completed by non-indigenous

    public int getNonIndigHSC() {
        // Create the integer to return
        int nonIdigHSC = -1;
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT SUM(COUNT) FROM HighestYearSchoolCompleted WHERE indigenous_status= 'non_indig' AND highest_year_of_school_completed= 'y12_equiv';";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            nonIdigHSC = results.getInt("SUM(COUNT)");
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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
        // Finally we return all of the COUNT results
        return nonIdigHSC;
    }

    // Fact 4 for Page Mission - Total Non-Indigenous Population

    public int getNonIndigPopulation() {
        // Create the integer to return
        int nonIdigPopulation = -1;
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT SUM(COUNT)  FROM PopulationStatistics  WHERE indigenous_status = 'non_indig';";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            nonIdigPopulation = results.getInt("SUM(COUNT)");
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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
        // Finally we return all of the COUNT results
        return nonIdigPopulation;
    }

    //Get LGAS and Population for Sub Task 2 by age - Indigenous. 
    
    public ArrayList<LGAExtended> getLGAExtended() {
        ArrayList<LGAExtended> lgaExtendeds = new ArrayList<LGAExtended>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT lga_name16, LGA.lga_code16, PopulationStatistics.age, SUM(PopulationStatistics.count) FROM LGA JOIN PopulationStatistics ON LGA.lga_code16 = PopulationStatistics.lga_code16 WHERE PopulationStatistics.indigenous_status = 'indig' Group By LGA.lga_name16, PopulationStatistics.age ORDER BY SUM(PopulationStatistics.count) DESC";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name16 = results.getString("lga_name16");
                int code16 = results.getInt("lga_code16");
                String age = results.getString("age");
                int populationCount = results.getInt("SUM(PopulationStatistics.count)");
                

                LGAExtended lgaExtended = new LGAExtended(name16, code16, age, populationCount);
                lgaExtendeds.add(lgaExtended);


            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return lgaExtendeds;
    }


    public ArrayList<LGAExtended> getLGAExtendedVar(String ageInput, String indigStatus) {
        ArrayList<LGAExtended> lgaExtendeds = new ArrayList<LGAExtended>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT lga_name16, LGA.lga_code16, PopulationStatistics.age, SUM(PopulationStatistics.count) FROM LGA JOIN PopulationStatistics ON LGA.lga_code16 = PopulationStatistics.lga_code16 WHERE PopulationStatistics.indigenous_status = '"+indigStatus+"' AND PopulationStatistics.age ='" +ageInput+ "'Group By LGA.lga_name16, PopulationStatistics.age ORDER BY SUM(PopulationStatistics.count) DESC";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name16 = results.getString("lga_name16");
                int code16 = results.getInt("lga_code16");
                String age = results.getString("age");
                int populationCount = results.getInt("SUM(PopulationStatistics.count)");
                

                LGAExtended lgaExtended = new LGAExtended(name16, code16, age, populationCount);
                lgaExtendeds.add(lgaExtended);


            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return lgaExtendeds;
    }

    public ArrayList<LGAExtended> getLGAExtendedVarnonIndig(String ageInput) {
        ArrayList<LGAExtended> lgaExtendeds = new ArrayList<LGAExtended>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT lga_name16, LGA.lga_code16, PopulationStatistics.age, SUM(PopulationStatistics.count) FROM LGA JOIN PopulationStatistics ON LGA.lga_code16 = PopulationStatistics.lga_code16 WHERE PopulationStatistics.indigenous_status = 'non_indig' AND PopulationStatistics.age ='" +ageInput+ "'Group By LGA.lga_name16, PopulationStatistics.age ORDER BY SUM(PopulationStatistics.count) DESC";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name16 = results.getString("lga_name16");
                int code16 = results.getInt("lga_code16");
                String age = results.getString("age");
                int populationCount = results.getInt("SUM(PopulationStatistics.count)");
                

                LGAExtended lgaExtended = new LGAExtended(name16, code16, age, populationCount);
                lgaExtendeds.add(lgaExtended);


            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return lgaExtendeds;
    }

    public ArrayList<LGAExtended> getLGAExtendedVar2(String schoolInput, String indigStatus) {
        ArrayList<LGAExtended> lgaExtendeds = new ArrayList<LGAExtended>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT LGA.lga_name16, LGA.lga_code16, HighestYearSchoolCompleted.highest_year_of_school_completed, SUM(HighestYearSchoolCompleted.count) FROM HighestYearSchoolCompleted JOIN LGA ON LGA.lga_code16 = HighestYearSchoolCompleted.lga_code16 WHERE HighestYearSchoolCompleted.indigenous_status = '"+indigStatus+"' AND HighestYearSchoolCompleted.highest_year_of_school_completed = '"+schoolInput+"' GROUP BY LGA.lga_code16 ORDER BY SUM(HighestYearSchoolCompleted.count) DESC";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name16 = results.getString("lga_name16");
                int code16 = results.getInt("lga_code16");
                String highest_year_of_school_completed = results.getString("highest_year_of_school_completed");
                int populationCount = results.getInt("SUM(HighestYearSchoolCompleted.count)");
                

                LGAExtended lgaExtended = new LGAExtended(name16, code16, highest_year_of_school_completed, populationCount);
                lgaExtendeds.add(lgaExtended);


            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return lgaExtendeds;
    }

    public ArrayList<LGAExtended> getLGAExtendedVar2nonIndig(String schoolInput) {
        ArrayList<LGAExtended> lgaExtendeds = new ArrayList<LGAExtended>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT LGA.lga_name16, LGA.lga_code16, HighestYearSchoolCompleted.highest_year_of_school_completed, SUM(HighestYearSchoolCompleted.count) FROM HighestYearSchoolCompleted JOIN LGA ON LGA.lga_code16 = HighestYearSchoolCompleted.lga_code16 WHERE HighestYearSchoolCompleted.indigenous_status = 'non_indig' AND HighestYearSchoolCompleted.highest_year_of_school_completed = '"+schoolInput+"' GROUP BY LGA.lga_code16 ORDER BY SUM(HighestYearSchoolCompleted.count) DESC";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name16 = results.getString("lga_name16");
                int code16 = results.getInt("lga_code16");
                String highest_year_of_school_completed = results.getString("highest_year_of_school_completed");
                int populationCount = results.getInt("SUM(HighestYearSchoolCompleted.count)");
                

                LGAExtended lgaExtended = new LGAExtended(name16, code16, highest_year_of_school_completed, populationCount);
                lgaExtendeds.add(lgaExtended);


            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return lgaExtendeds;
    }

    public int getPopulationAge1(String LGA_drop2, String indigenous_status_drop2) 
    {
        // Create the integer to return
        String lga;
        String indigenous_status;
        String agebracket;
        int populationCount = 0;
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT SUM(COUNT) FROM PopulationStatistics JOIN LGA ON LGA.lga_code16 = PopulationStatistics.lga_code16  WHERE indigenous_status = '"+indigenous_status_drop2+"' AND LGA.lga_name16 = '"+LGA_drop2+"'";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            populationCount = results.getInt("SUM(COUNT)");
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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
        // Finally we return all of the COUNT results
        return populationCount;
    }

    public int getPopulationAge2(String LGA_drop2, String indigenous_status_drop2, String agebracket_drop2) 
    {
        // Create the integer to return
        String lga;
        String indigenous_status;
        String agebracket;
        int populationCount = 0;
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT SUM(COUNT) FROM PopulationStatistics JOIN LGA ON LGA.lga_code16 = PopulationStatistics.lga_code16  WHERE indigenous_status = '"+indigenous_status_drop2+"' AND LGA.lga_name16 = '"+LGA_drop2+"'AND PopulationStatistics.age = '"+agebracket_drop2+"'";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            populationCount = results.getInt("SUM(COUNT)");
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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
        // Finally we return all of the COUNT results
        return populationCount;
    }

    public int getPopulationSchool(String LGA_drop4, String indigenous_status_drop4, String schooldrop) 
    {
        // Create the integer to return

        int populationCount = 0;
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT SUM(COUNT) FROM HighestYearSchoolCompleted JOIN LGA ON LGA.lga_code16 = HighestYearSchoolCompleted.lga_code16 WHERE indigenous_status = '"+indigenous_status_drop4+"' AND LGA.lga_name16 = '"+LGA_drop4+"' AND HighestYearSchoolCompleted.highest_year_of_school_completed = '"+schooldrop+"';";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            populationCount = results.getInt("SUM(COUNT)");
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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
        // Finally we return all of the COUNT results
        return populationCount;
    }

    public int getPopulationLF(String LGA_drop3, String indigenous_status_drop3, String labourforce_drop) 
    {
        // Create the integer to return
        String lga;
        String indigenous_status;
    {
        // Create the integer to return
        
        
        String labourforce;
        int populationCount = 0;
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT SUM(COUNT) FROM LabourForce JOIN LGA ON LGA.lga_code16 = LabourForce.lga_code16  WHERE indigenous_status = '"+indigenous_status_drop3+"' AND LGA.lga_name16 = '"+LGA_drop3+"' AND LabourForce.labour_force_status = '"+labourforce_drop+"';";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            populationCount = results.getInt("SUM(COUNT)");
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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
        // Finally we return all of the COUNT results
        return populationCount;
    }
}

    public ArrayList<LGAExtended> getSimilarLGA(String LGA_drop2, String indigenous_status_drop2, String agebracket_drop2) {
        ArrayList<LGAExtended> lgaExtendeds = new ArrayList<LGAExtended>();
        Connection connection = null;

        int populationTotal3 = getPopulationAge2(LGA_drop2, indigenous_status_drop2, agebracket_drop2);
        double lowerAgeRange = populationTotal3 - (populationTotal3 * 0.1);
        double upperAgeRange = populationTotal3 + (populationTotal3 * 0.1);
        
        //getPopulationAge2(LGA_drop2, indigenous_status_drop2, agebracket_drop2);
        


        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT lga_name16, LGA.lga_code16, PopulationStatistics.age, SUM(PopulationStatistics.count) FROM LGA JOIN PopulationStatistics ON LGA.lga_code16 = PopulationStatistics.lga_code16 WHERE PopulationStatistics.indigenous_status = '"+indigenous_status_drop2+"' AND PopulationStatistics.age = '"+agebracket_drop2+"' Group By LGA.lga_name16, PopulationStatistics.age HAVING SUM(PopulationStatistics.count) Between "+lowerAgeRange+" AND "+upperAgeRange+" ORDER BY SUM(PopulationStatistics.count) DESC;";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name16 = results.getString("lga_name16");
                int code16 = results.getInt("lga_code16");
                String age = results.getString("age");
                int populationCount = results.getInt("SUM(PopulationStatistics.count)");
                

                LGAExtended lgaExtended = new LGAExtended(name16, code16, age, populationCount);
                lgaExtendeds.add(lgaExtended);


            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return lgaExtendeds;
    }

    public ArrayList<LGAExtended> getSimilarLGALF(String LGA_drop3, String indigenous_status_drop3, String labourforce_drop) {
        ArrayList<LGAExtended> lgaExtendeds = new ArrayList<LGAExtended>();
        Connection connection = null;

        int populationTotal4 = getPopulationLF(LGA_drop3, indigenous_status_drop3, labourforce_drop);
        double lowerAgeRange = populationTotal4 - (populationTotal4 * 0.1);
        double upperAgeRange = populationTotal4 + (populationTotal4 * 0.1);
        
        //getPopulationAge2(LGA_drop2, indigenous_status_drop2, agebracket_drop2);
        


        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query ="SELECT LGA.lga_name16, LGA.lga_code16, LabourForce.labour_force_status, SUM(LabourForce.count) FROM LGA JOIN LabourForce ON LGA.lga_code16 = LabourForce.lga_code16 WHERE LabourForce.indigenous_status = '"+indigenous_status_drop3+"' AND LabourForce.labour_force_status = '"+labourforce_drop+"' Group By LGA.lga_name16, LabourForce.labour_force_status HAVING SUM(LabourForce.count) Between "+lowerAgeRange+" AND "+upperAgeRange+" ORDER BY SUM(LabourForce.count) DESC;";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name16 = results.getString("lga_name16");
                int code16 = results.getInt("lga_code16");
                String age = results.getString("labour_force_status");
                int populationCount = results.getInt("SUM(LabourForce.count)");
                

                LGAExtended lgaExtended = new LGAExtended(name16, code16, age, populationCount);
                lgaExtendeds.add(lgaExtended);


            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return lgaExtendeds;
    }

    public ArrayList<LGAExtended> getSimilarLGASchool(String LGA_drop4, String indigenous_status_drop4, String schooldrop4) {
        ArrayList<LGAExtended> lgaExtendeds = new ArrayList<LGAExtended>();
        Connection connection = null;

        int populationTotal4 = getPopulationSchool(LGA_drop4, indigenous_status_drop4, schooldrop4);
        double lowerAgeRange = populationTotal4 - (populationTotal4 * 0.1);
        double upperAgeRange = populationTotal4 + (populationTotal4 * 0.1);
        
        //getPopulationAge2(LGA_drop2, indigenous_status_drop2, agebracket_drop2);
        


        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query ="SELECT LGA.lga_name16, LGA.lga_code16, HighestYearSchoolCompleted.highest_year_of_school_completed, SUM(HighestYearSchoolCompleted.count) FROM LGA JOIN HighestYearSchoolCompleted ON LGA.lga_code16 = HighestYearSchoolCompleted.lga_code16 WHERE HighestYearSchoolCompleted.indigenous_status = '"+indigenous_status_drop4+"' AND HighestYearSchoolCompleted.highest_year_of_school_completed = '"+schooldrop4+"' Group By LGA.lga_name16, HighestYearSchoolCompleted.highest_year_of_school_completed HAVING SUM(HighestYearSchoolCompleted.count) Between "+lowerAgeRange+" AND "+upperAgeRange+" ORDER BY SUM(HighestYearSchoolCompleted.count) DESC;";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name16 = results.getString("lga_name16");
                int code16 = results.getInt("lga_code16");
                String age = results.getString("highest_year_of_school_completed");
                int populationCount = results.getInt("SUM(HighestYearSchoolCompleted.count)");
                

                LGAExtended lgaExtended = new LGAExtended(name16, code16, age, populationCount);
                lgaExtendeds.add(lgaExtended);


            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return lgaExtendeds;
    }


    // MATT's methods start from this line -------------------------------------------------------------------------------------------

    // PageIndex. Get number of LGAs for Page Index
    public ArrayList<Integer> getNumberOfLGA() {
        // Create the ArrayList to return
        ArrayList<Integer> NumberOfLGA = new ArrayList<Integer>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT COUNT(*) AS COUNT FROM LGA";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                Integer integerTemp = results.getInt("COUNT");
                NumberOfLGA.add(integerTemp);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the movies
        return NumberOfLGA;
    }

    //  Get total population for PageIndex, PageST22 state data
    public ArrayList<Integer> getTotalPopulation(String query) {
        // Create the ArrayList to return
        ArrayList<Integer> totalPopulation = new ArrayList<Integer>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            // String query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                Integer integerTemp = results.getInt("SUM");
                totalPopulation.add(integerTemp);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the movies
        return totalPopulation;
    }

    // PageST22. Get LGA name, code, state, type area
    public ArrayList<LGAExtended> getLGAtableData(String lga) {
        // Create the ArrayList to return
        ArrayList<LGAExtended> LGAtableData = new ArrayList<LGAExtended>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA WHERE LGA_NAME16 = '" + lga + "'";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // We can iterate through all of the database query results
            while (results.next()) {
                LGAExtended LGAExtendedTemp = new LGAExtended();

                LGAExtendedTemp.code16 = results.getInt("lga_code16");
                LGAExtendedTemp.name16 = results.getString("lga_name16");
                LGAExtendedTemp.type16 = results.getString("lga_type16");
                LGAExtendedTemp.area16 = results.getDouble("area_sqkm");

                LGAtableData.add(LGAExtendedTemp);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the movies
        return LGAtableData;
    }

    // Get total population in LGA by indig status and age
    public int getTotalIndigStatusLGAbyAge(int LGAcode, String indigStatus, String age) {
        // JDBCConnection jdbc1 = new JDBCConnection();
        ArrayList<Integer> totalIndigStatusByAge_List = new ArrayList<>();
        int totalIndigStatusByAge = 0;

        String query = "SELECT SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS WHERE LGA_CODE16 = '"
                + LGAcode
                + "' AND INDIGENOUS_STATUS = '"
                + indigStatus
                + "' AND AGE = '"
                + age
                + "' ";

        totalIndigStatusByAge_List = getTotalPopulation(query);
        totalIndigStatusByAge = totalIndigStatusByAge_List.get(0).intValue();
        return totalIndigStatusByAge;
    }

    // // PageST22. Get total population of each state
    // public ArrayList<StateMatt> getStateTotalPopulation(String query) {
    //     // Create the ArrayList to return
    //     ArrayList<StateMatt> stateMattList = new ArrayList<StateMatt>();

    //     // Setup the variable for the JDBC connection
    //     Connection connection = null;

    //     try {
    //         // Connect to JDBC data base
    //         connection = DriverManager.getConnection(DATABASE);

    //         // Prepare a new SQL Query & Set a timeout
    //         Statement statement = connection.createStatement();
    //         statement.setQueryTimeout(30);

    //         // Get Result
    //         ResultSet results = statement.executeQuery(query);

    //         // We can iterate through all of the database query results
    //         while (results.next()) {
    //             StateMatt StateTemp = new StateMatt();

    //             // StateTemp.stateName = results.getString("STATE_NAME");
    //             StateTemp.stateTotalPopulation = results.getInt("SUM");

    //             stateMattList.add(StateTemp);
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

    //     return stateMattList;
    // }

    // Get total population in state by indig status and age
    public int getTotalPopulationStateByIndigStatus_Age(String state, String indigStatus, String age) {
        ArrayList<Integer> totalPopulationStateByIndigStatus_Age_List = new ArrayList<>();
        int totalPopulationStateByIndigStatus_Age = 0;

        // String query = "SELECT SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS WHERE LGA_CODE16 = '"
        //         + stateName
        //         + "' AND INDIGENOUS_STATUS = '"
        //         + indigStatus
        //         + "' AND AGE = '"
        //         + age
        //         + "' ";

        String query = "SELECT S.STATE_NAME, SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS P JOIN STATE S ON P.LGA_CODE16 = S.LGA_CODE16 WHERE S.STATE_NAME = '"
                + state
                + "' AND INDIGENOUS_STATUS = '"
                + indigStatus
                + "' AND AGE = '"
                + age
                + "' ";


        totalPopulationStateByIndigStatus_Age_List = getTotalPopulation(query);
        totalPopulationStateByIndigStatus_Age = totalPopulationStateByIndigStatus_Age_List.get(0).intValue();
        return totalPopulationStateByIndigStatus_Age;
    }

    // Get total population in state by indig status and school completion
    public int getTotalPopulationStateByIndigStatus_schoolCompletion(String state, String indigStatus, String highestYearSchoolCompleted) {
        ArrayList<Integer> totalPopulationStateByIndigStatus_schoolCompletion_List = new ArrayList<>();
        int totalPopulationStateByIndigStatus_schoolCompletion = 0;
        
        String query = "SELECT S.STATE_NAME, SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted C JOIN STATE S ON C.LGA_CODE16 = S.LGA_CODE16 WHERE S.STATE_NAME = '"
                + state
                + "' AND INDIGENOUS_STATUS = '"
                + indigStatus
                + "' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED = '"
                + highestYearSchoolCompleted
                + "' ";

        totalPopulationStateByIndigStatus_schoolCompletion_List = getTotalPopulation(query);
        totalPopulationStateByIndigStatus_schoolCompletion = totalPopulationStateByIndigStatus_schoolCompletion_List.get(0).intValue();
        return totalPopulationStateByIndigStatus_schoolCompletion;
    }

    // Get total population in Australia by indig status and age
    public int getTotalPopulationAustraliaByIndigStatus_Age(String indigStatus, String age) {
        ArrayList<Integer> totalPopulationAustraliaByIndigStatus_Age_List = new ArrayList<>();
        int totalPopulationAustraliaByIndigStatus_Age = 0;

        String query = "SELECT SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS WHERE INDIGENOUS_STATUS = '"
                + indigStatus
                + "' AND AGE = '"
                + age
                + "' ";


        totalPopulationAustraliaByIndigStatus_Age_List = getTotalPopulation(query);
        totalPopulationAustraliaByIndigStatus_Age = totalPopulationAustraliaByIndigStatus_Age_List.get(0).intValue();
        return totalPopulationAustraliaByIndigStatus_Age;
    }

     // Get total population in Australia by indig status and school completion
     public int getTotalPopulationAustraliaByIndigStatus_schoolCompletion(String indigStatus, String highestYearSchoolCompleted) {
        ArrayList<Integer> totalPopulationAustraliaByIndigStatus_schoolCompletion_List = new ArrayList<>();
        int totalPopulationAustraliaByIndigStatus_schoolCompletion = 0;
        
        String query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted WHERE INDIGENOUS_STATUS ='"
                + indigStatus
                + "' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED = '"
                + highestYearSchoolCompleted
                + "' ";

        totalPopulationAustraliaByIndigStatus_schoolCompletion_List = getTotalPopulation(query);
        totalPopulationAustraliaByIndigStatus_schoolCompletion = totalPopulationAustraliaByIndigStatus_schoolCompletion_List.get(0).intValue();
        return totalPopulationAustraliaByIndigStatus_schoolCompletion;
    }

    // MATT's PageST31 methods ----------------------------------------------------------------------------------------------------
    // PageST31. Get raw population of each LGA by indig status
    public ArrayList<LGA_PageST31> getTotalPopulationAllLGAbyIndigStatus(String indigStatus) {
        // Create the ArrayList to return
        ArrayList<LGA_PageST31> LGA_PageST31_list = new ArrayList<LGA_PageST31>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT L.LGA_CODE16 ,L.LGA_NAME16, SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS P JOIN LGA L ON P.LGA_CODE16 = L.LGA_CODE16 WHERE INDIGENOUS_STATUS = '"
                    + indigStatus
                    + "' GROUP BY L.LGA_NAME16 ORDER BY L.LGA_NAME16";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // We can iterate through all of the database query results
            while (results.next()) {
                LGA_PageST31 LGA_PageST31_temp = new LGA_PageST31();

                LGA_PageST31_temp.LGAname = results.getString("lga_name16");
                LGA_PageST31_temp.LGAtotalPopulationTemp = results.getInt("SUM");

                LGA_PageST31_list.add(LGA_PageST31_temp);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the movies
        return LGA_PageST31_list;
    }

    // PageST31. Get total population of each LGA by indig status, sex, age
    public ArrayList<LGA_PageST31> getTotalPopulationAllLGAbyIndigStatusSexAge(String indigStatus, String sex,
            String age) {
        // Create the ArrayList to return
        ArrayList<LGA_PageST31> LGA_PageST31_list = new ArrayList<LGA_PageST31>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT L.LGA_CODE16, L.LGA_NAME16, COUNT FROM POPULATIONSTATISTICS P JOIN LGA L ON P.LGA_CODE16 = L.LGA_CODE16 WHERE INDIGENOUS_STATUS = '"
                    + indigStatus
                    + "' AND SEX = '"
                    + sex
                    + "' AND AGE = '"
                    + age
                    + "' ORDER BY L.LGA_NAME16";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // We can iterate through all of the database query results
            while (results.next()) {
                LGA_PageST31 LGA_PageST31_temp = new LGA_PageST31();

                LGA_PageST31_temp.LGAname = results.getString("lga_name16");
                LGA_PageST31_temp.LGAtotalPopulationTemp = results.getInt("COUNT");

                LGA_PageST31_list.add(LGA_PageST31_temp);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the movies
        return LGA_PageST31_list;
    }

    // PageST31. Get total population of each LGA by indig status, sex, school completion
    public ArrayList<LGA_PageST31> getTotalPopulationAllLGAbyIndigStatusSexSchoolCompletion(String indigStatus,
            String sex, String schoolCompeltion) {
        // Create the ArrayList to return
        ArrayList<LGA_PageST31> LGA_PageST31_list = new ArrayList<LGA_PageST31>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT L.LGA_CODE16, L.LGA_NAME16, COUNT FROM LGA L JOIN HIGHESTYEARSCHOOLCOMPLETED H ON L.LGA_CODE16 = H.LGA_CODE16 WHERE indigenous_status = '"
                    + indigStatus
                    + "' AND SEX = '"
                    + sex
                    + "' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED = '"
                    + schoolCompeltion
                    + "' ORDER BY L.LGA_NAME16";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // We can iterate through all of the database query results
            while (results.next()) {
                LGA_PageST31 LGA_PageST31_temp = new LGA_PageST31();

                LGA_PageST31_temp.LGAname = results.getString("lga_name16");
                LGA_PageST31_temp.LGAtotalPopulationTemp = results.getInt("COUNT");

                LGA_PageST31_list.add(LGA_PageST31_temp);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the movies
        return LGA_PageST31_list;
    }

    // PageST31. Get total population of each LGA by indig status, sex, non school education
    public ArrayList<LGA_PageST31> getTotalPopulationAllLGAbyIndigStatusSexNonSchoolEducation(String indigStatus,
            String sex, String nonSchoolEducation) {
        // Create the ArrayList to return
        ArrayList<LGA_PageST31> LGA_PageST31_list = new ArrayList<LGA_PageST31>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT L.LGA_CODE16 , L.LGA_NAME16, NON_SCHOOL_QUALIFICATION_LEVEL, COUNT FROM LGA L JOIN NONSCHOOLEDUCATION N ON L.LGA_CODE16 = N.LGA_CODE16 WHERE indigenous_status = '"
                    + indigStatus
                    + "' AND SEX = '"
                    + sex
                    + "' AND NON_SCHOOL_QUALIFICATION_LEVEL = '"
                    + nonSchoolEducation
                    + "' ORDER BY L.LGA_NAME16";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // We can iterate through all of the database query results
            while (results.next()) {
                LGA_PageST31 LGA_PageST31_temp = new LGA_PageST31();

                LGA_PageST31_temp.LGAname = results.getString("lga_name16");
                LGA_PageST31_temp.LGAtotalPopulationTemp = results.getInt("COUNT");

                LGA_PageST31_list.add(LGA_PageST31_temp);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the movies
        return LGA_PageST31_list;
    }

    // PageST31. Get total population of each LGA by indig status, sex, non school education
    public ArrayList<LGA_PageST31> getTotalPopulationAllLGAbyIndigStatusSexEmployment(String indigStatus,
            String sex, String employment) {
        // Create the ArrayList to return
        ArrayList<LGA_PageST31> LGA_PageST31_list = new ArrayList<LGA_PageST31>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT L.LGA_CODE16 , L.LGA_NAME16, LABOUR_FORCE_STATUS, COUNT FROM LGA L JOIN LABOURFORCE F ON L.LGA_CODE16 = F.LGA_CODE16 WHERE indigenous_status = '"
                    + indigStatus
                    + "' AND SEX = '"
                    + sex
                    + "' AND LABOUR_FORCE_STATUS = '"
                    + employment
                    + "' ORDER BY L.LGA_NAME16";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // We can iterate through all of the database query results
            while (results.next()) {
                LGA_PageST31 LGA_PageST31_temp = new LGA_PageST31();

                LGA_PageST31_temp.LGAname = results.getString("lga_name16");
                LGA_PageST31_temp.LGAtotalPopulationTemp = results.getInt("COUNT");

                LGA_PageST31_list.add(LGA_PageST31_temp);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
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

        // Finally we return all of the movies
        return LGA_PageST31_list;
    }
}
