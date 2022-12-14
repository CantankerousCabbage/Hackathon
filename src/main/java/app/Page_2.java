package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class Page_2 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/Page_2.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" +
                "<title>Page 1</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        // Add some Javascript
        html = html + "<script type ='text/javascript' src='javaScript.js'></script>";
        html = html + "</head>";
        // Add the body
        html = html + "<body>";
        // Page TopNav
        Global nav = new Global();
        html = html + nav.getHeader();
        html = html + nav.getTopNav();

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Submission</h1>
            </div>
        """;


        JDBCConnection jdbc = new JDBCConnection();

        
        html = html + "</div>";
        // Close Content div
        html = html + "<div class='header'>";

        
        html = html + """
            <body>

            <p>Upload a new JASON File:</p>

            <form action='/action_page.php'>
            <input type='file' id='myFile' name='filename'>
            <input type='submit'>
            </form>

            </body>
                """;

        html = html + "</div>";


        // Footer
        // html = html + nav.getFooter();

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}