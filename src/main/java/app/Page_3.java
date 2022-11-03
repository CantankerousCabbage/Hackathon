package app;

import java.util.ArrayList;

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
public class Page_3 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";
        
        html = html + "<head>" + 
               "<title>Homepage</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='LogIn_Page.css' />";

        // Add some Javascript
        html = html + "<script type ='text/javascript' src='javaScript.js'></script>";

        html = html + "</head>";

        html = html + "<div class='header'>";
        html = html + "<h3>Please Enter The Password to Enter:</h3>";
        html = html + "</div>";

        html = html + "<form action='/' method='post'>";

        html = html + "<div>";
        html = html + "   <div class='header'>";
        html = html + "     <input type='text' id='Password' name='Password'><br>";
        html = html + "     <input type='submit' value='Submit'>";
        html = html + "   </div>";
        html = html + "</form>";

        String Pass = context.formParam("Password");

        if (Pass != null){
            if (Pass.equals("Boeing")){
                html = html + """
                <script>
                window.location.replace('http://localhost:7001/homepage.html')
                </script>
                """;
            }
            html = html + "<div class='header'><h2>Incorrect Password<h2></div>";
        }


        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}