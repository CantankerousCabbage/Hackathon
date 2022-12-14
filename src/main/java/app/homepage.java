
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
public class homepage implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/homepage.html";

    @Override
    public void handle(Context context) throws Exception {

        Global nav = new Global();
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Homepage</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";

        // Add some Javascript
        html = html + "<script type ='text/javascript' src='javaScript.js'></script>";
        html = html + nav.getStyle();

        html = html + "</head>";

        // Add the body
        html = html + "<body>";
        
        //Page TopNav
        
        html = html + nav.getHeader();
        
        html = html + nav.getTopNav();

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>
                    Welcome to Boeing DataBase GUI
                </h1>
            </div>
        """;
        

        html = html + """
            <div class='Plane_image'>
                <img src="Plane.webp" class='Plane_imgage'>
            </div>
        """;
                
               
        JDBCConnection jdbc = new JDBCConnection();

        // Close Content div
        html = html + "</div>";



        // Footer
    //    html = html + nav.getFooter();
      

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
