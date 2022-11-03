package app.semster1;

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
public class JDBCConnectionPersona {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/personas.db";

    // If you are using the Homelessness data set replace this with the below
    //private static final String DATABASE = "jdbc:sqlite:database/homelessness.db";

    /**
     * This creates a JDBC Object so we can keep talking to the database
     */
    public JDBCConnectionPersona() {
        System.out.println("Created JDBC Connection Object");
    }

    public ArrayList<Student> getStudents() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Student> students = new ArrayList<Student>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM team_members ORDER BY student_number";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String studentName     = results.getString("Name");
                int studentNumber  = results.getInt("student_number");

                // Create a LGA Object
                Student student = new Student(studentNumber, studentName);

                // Add the lga object to the array
                students.add(student);
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
        return students;
    }

    //Get Persona 1 Name

    public String getPersona1Name() {
        // Create the String to return
        String persona1Name = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT name FROM PersonaAttributes WHERE id = 1";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona1Name = results.getString("name");
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
        return persona1Name;
    }


    //Get Persona 2 Name

    public String getPersona2Name() {
        // Create the String to return
        String persona2Name = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT name FROM PersonaAttributes WHERE id = 2";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona2Name = results.getString("name");
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
        return persona2Name;
    }
    
    //Get Persona 1 Age

    public String getPersona1Age() {
        // Create the String to return
        String persona1Age = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT age FROM PersonaAttributes WHERE id = 1";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona1Age = results.getString("age");
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
        return persona1Age;
    }
    
    //Get Persona 2 Age

    public String getPersona2Age() {
        // Create the String to return
        String persona2Age = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT age FROM PersonaAttributes WHERE id = 2";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona2Age = results.getString("age");
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
        return persona2Age;
    }
    
    //Get Persona 1 Background

    public String getPersona1Background() {
        // Create the String to return
        String persona1Background = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT background FROM PersonaAttributes WHERE id = 1";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona1Background = results.getString("background");
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
        return persona1Background;
    }
    
    
    //Get Persona 2 Background

    public String getPersona2Background() {
        // Create the String to return
        String persona2Background = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT background FROM PersonaAttributes WHERE id = 2";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona2Background = results.getString("background");
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
        return persona2Background;
    }
    
    //Get Persona 1 Attributes

    public String getPersona1Attributes() {
        // Create the String to return
        String persona1Attributes = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT attributes FROM PersonaAttributes WHERE id = 1";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona1Attributes = results.getString("attributes");
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
        return persona1Attributes;
    }
    
    //Get Persona 2 Attributes

    public String getPersona2Attributes() {
        // Create the String to return
        String persona2Attributes = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT attributes FROM PersonaAttributes WHERE id = 2";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona2Attributes = results.getString("attributes");
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
        return persona2Attributes;
    }
    
    
    //Get Persona 1 Needs and Goals

    public String getPersona1Needs() {
        // Create the String to return
        String persona1Needs = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT needs_and_goals FROM PersonaAttributes WHERE id = 1";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona1Needs = results.getString("needs_and_goals");
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
        return persona1Needs;
    }
    
    //Get Persona 2 Needs and Goals

    public String getPersona2Needs() {
        // Create the String to return
        String persona2Needs = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT needs_and_goals FROM PersonaAttributes WHERE id = 2";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona2Needs = results.getString("needs_and_goals");
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
        return persona2Needs;
    }
    
    //Get Persona 1 Skills and Experience

    public String getPersona1Skills() {
        // Create the String to return
        String persona1Skills = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT skills_and_experience FROM PersonaAttributes WHERE id = 1";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona1Skills = results.getString("skills_and_experience");
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
        return persona1Skills;
    }

    //Get Persona 2 Skills and Experience

    public String getPersona2Skills() {
        // Create the String to return
        String persona2Skills = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT skills_and_experience FROM PersonaAttributes WHERE id = 2";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona2Skills = results.getString("skills_and_experience");
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
        return persona2Skills;
    }


    //Get Persona 1 image source

    public String getPersona1Image() {
        // Create the String to return
        String persona1Image = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT image_path FROM image JOIN PersonaAttributes ON image.id = PersonaAttributes.id WHERE PersonaAttributes.id = 1";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona1Image = results.getString("image_path");
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
        return persona1Image;
    }

    //Get Persona 1 image source

    public String getPersona2Image() {
        // Create the String to return
        String persona2Image = "";
        // Setup the variable for the JDBC connection
        Connection connection = null;
        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // The Query
            String query = "SELECT image_path FROM image JOIN PersonaAttributes ON image.id = PersonaAttributes.id WHERE PersonaAttributes.id = 2";
            // Get Result
            ResultSet results = statement.executeQuery(query);
            persona2Image = results.getString("image_path");
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
        return persona2Image;
    }

    /**
     * Get all of the LGAs in the database.
     * @return
     *    Returns an ArrayList of LGA objects
     */
}