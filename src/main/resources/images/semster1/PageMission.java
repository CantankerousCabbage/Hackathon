package app.semster1;

import java.util.ArrayList;

import app.Global;
import app.JDBCConnection;
import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageMission implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/mission.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 2.1</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        //html = html + """
            //<div class='topnav'>
                //<a href='/'>Homepage</a>
                //<a href='mission.html'>Our Mission</a>
                //<a href='page3.html'>Sub Task 2.1</a>
                //<a href='page4.html'>Sub Task 2.2</a>
                //<a href='page5.html'>Sub Task 3.1</a>
                //<a href='page6.html'>Sub Task 3.2</a>
            //</div>
        //""";

        String headerText = "Our Mission";

        // html = html + Global.getHeader(headerText);
        // // Add header content block
        // html = html + Global.getNavBar();
        // //html = html + """
            //<div class='header'>
                //<h1>Our Mission</h1>
            //</div>
        //""";

        

        // Add Div for page Content
        html = html + "<div class='content'>";
        html = html + "<h2>Our Mission</h2><br><h2>What is the 'Closing the Gap' campaign?</h2>";
        html = html + "<p>The 'Closing the Gap' campaign is a campaign which aims to improve social and health outcomes of<br>the Aboriginal and Torres Strait Islander community. The campaign was initiated in 2007 by the<br>Coalition of Aboriginal and Torres Strait Islander Peak Organisations, and Federal, State, and<br>Territory governments. The campaign aims to assist with the development and implementation of<br>policies which will improve the social and health outcomes of the indigenous community. Below is<br>one social comparison which highlights the just some of the differences in social outcomes between<br>the indigenous and non indigenous communities. </p>";

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        //Creat fact tables

        html = html + "<h2>Year 12 Completion in the Indigenous Popluation</h2>";
        int ihsc = jdbc.getIndigHighSchoolCompletion(); 
        int ip = jdbc.getIndigPopulation();
        int ipPercentageCompletion = (ihsc*100)/(ip);
        html = html + "  <table class="+"horizontal_table3"+"><tr><td>Number of Indigenous people who have completed year 12 or equivalent</td><td>"+ihsc+"</td></tr><tr><td>Total Indigenous Population</td><td>"+ip+"</td></tr><tr><td>Percentage of &nbsp;Cohort who have completed year12 or equivalent</td><td>"+ipPercentageCompletion+"%</td></tr></table><br>";
        
        html = html + "<h2>Year 12 Completion in the Non-Indigenous Popluation</h2>";
        int nhsc = jdbc.getNonIndigHSC();
        int np = jdbc.getNonIndigPopulation();
        int npPercentageCompletion = (nhsc*100)/(np);
        html = html + "  <table class="+"horizontal_table3"+"><tr><td>Number of Non-Indigenous people who have completed year 12 or equivalent</td><td>"+nhsc+"</td></tr><tr><td>Total Non-Indigenous Population</td><td>"+np+"</td></tr><tr><td>Percentage of &nbsp;Cohort who have completed year12 or equivalent</td><td>"+npPercentageCompletion+"%</td></tr></table><br>";

        html = html + "<h2>How can this website be used?</h2>";
        html = html + "<p>The purpose of this website is to highlight the importance of the 'Close the Gap' campaign by using<br>data from the 2016 census. Each page will contain varying levels of data, ranging from simple facts<br>and figures, to more complex data queries, depending on the users needs. Instructions will be provided<br> on subsequent pages if user input is required.</p>";
        html = html + "</div>";
        
        html = html + "<div class='content1'>";
        html = html + "<h2>Featured Users/Personas</h2>";
        html = html + "<p>The following users/personas have been selected as featured users/personas for this website.<br>They highlight the attributes and needs a typical user of this site.</p>";
        
        JDBCConnectionPersona jdbcp = new JDBCConnectionPersona();
        

        //Persona Variables to be displayed in Table format
        String user1Name = jdbcp.getPersona1Name();
        String user1Age = jdbcp.getPersona1Age();
        String user1Background = jdbcp.getPersona1Background();
        String user1Needs = jdbcp.getPersona1Needs();
        String user1Skills = jdbcp.getPersona1Skills();
        String user1Image = jdbcp.getPersona1Image();

        String user2Name = jdbcp.getPersona2Name();
        String user2Age = jdbcp.getPersona2Age();
        String user2Background = jdbcp.getPersona2Background();
        String user2Needs = jdbcp.getPersona2Needs();
        String user2Skills = jdbcp.getPersona2Skills();
        String user2Image = jdbcp.getPersona2Image();



        html = html + "<h2>User/Persona 1</h2>";
        html = html + "<table class="+"horizontal_table2"+"><tr><td>Name</td><td>"+user1Name+"</td></tr><tr><td>Age</td><td>"+user1Age+"</td></tr><tr><td>Background</td><td>"+user1Background+"</td></tr><tr><td>Needs</td><td>"+user1Needs+"</td></tr><tr><td>Skills</td><td>"+user1Skills+"</td></tr><tr><td>Image</td><td><img src="+ user1Image +">"+"</td></tr></table><br>";
        
        html = html + "<h2>User/Persona 2</h2>";
        html = html + "<table class="+"horizontal_table2"+"><tr><td>Name</td><td>"+user2Name+"</td></tr><tr><td>Age</td><td>"+user2Age+"</td></tr><tr><td>Background</td><td>"+user2Background+"</td></tr><tr><td>Needs</td><td>"+user2Needs+"</td></tr><tr><td>Skills</td><td>"+user2Skills+"</td></tr><tr><td>Image</td><td><img src="+ user2Image +">"+"</td></tr></table><br>";
        html = html + "</div>";
        
        ArrayList<Student> students = jdbcp.getStudents();
        html = html + "<div class='content1'>";
        
        html = html + "<h2>Meet the Team</h2>";
        for (Student student : students) {
            html = html + "<ul style='list-style-type:square;'>";
            html = html + "<li>" + student.getStudentName() + " - " + student.getStudentNumber() + "</li>";
            html = html + "</ul>";
        }


        // Close Content div
        html = html + "</div>";
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
                <p></p>
            </div>
        """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
