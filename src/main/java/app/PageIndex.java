package app;

import java.util.ArrayList;
import io.javalin.http.Context;
import io.javalin.http.Handler;

/* @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au */

public class PageIndex implements Handler {

        // URL of this page relative to http://localhost:7001/
        public static final String URL = "/";
        
        @Override
        public void handle(Context context) throws Exception {
                // Create a simple HTML webpage in a String
                JDBCConnection jdbc = new JDBCConnection();
                String html = "<html>";

                // Add some Header information
                html = html + "<head>" +
                                "<title>Homepage</title>";

                // Add some CSS (external file)
                html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
                html = html + "</head>";

                // Add the body
                html = html + "<body>";

                // html = html + Global.getTopNav();
                String headerText = "Closing The Gap";

                html = html + Global.getHeader(headerText);
                html = html + Global.getNavBar();

                html = html + "<div class='content'>";
                html = html + "<h1>Homepage</h1>";
                html = html + "<p>Welcome to the homepage.</p>";
                html = html + "Practice Query" + jdbc.getIndigHighSchoolCompletion();
                html = html + "</div>";
        }
}