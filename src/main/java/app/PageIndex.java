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

                html = html + """

                                <!-- The flexible grid (content) -->
                                <div class="row">
                                        <div class="side">
                                        <h2>ACKNOWLEDGEMENT</h2>
                                        <p> Closing the Gap acknowledge the traditional owners of the lands and waters on which Australians live
                                                and work, and pay respects to their Elders past, present and emerging.
                                                Closing the Gap acknowledges the ongoing strength and resilience of Aboriginal and Torres Strait
                                                Islander
                                                people in sustaining the world's oldest living cultures.
                                                Closing the Gap is underpinned by the belief that when Aboriginal and Torres Strait Islander people
                                                have a
                                                genuine say in the design and delivery of policies, programs and services that affect them, better
                                                life outcomes are achieved.
                                                It also recognises that structural change in the way governments work with Aboriginal and Torres
                                                Strait Islander people is needed to close the gap (Source: www.closingthegap.gov.au).
                                        </p>
                                        <br>
                                        <img src='AdobeStock_287824234.jpeg' class='Landing_acknowledgement_image' height='200'>

                                        </div>
                                        <div class="main">
                                        <h2>Population</h2>
                                        <p><strong> Nationally in 2016, 644,785 or 2.8% of Australians identified as indigenous. </strong></p>
                                        <img src='AdobeStock_383621646.jpeg' class='Landing_population_image' height='200'>
                                        <br>
                                        <br>
                                        <h2>Education</h2>
                                        <p><strong> Nationally in 2016, 57,558 or 11.28% of Indigenous people obtained a qualification at
                                                Certificate III level or above. </strong></p>
                                        <img src='AdobeStock_383620364.jpeg' class='Landing_education_image' height='200'>
                                        <br>
                                        <br>
                                        <h2>Employment</h2>
                                        <p><strong> Nationally in 2016, 364,383 or 56% of the Indigenous population were employed. </strong></p>
                                        <img src='AdobeStock_368283062.jpeg' class='Landing_employment_image' height='200'>
                                        </div>
                                </div>

                                """;

                // Look up some information from JDBC
                JDBCConnection jdbc = new JDBCConnection();

                // Get number of LGA and total population
                ArrayList<Integer> NumberOfLGA = jdbc.getNumberOfLGA();

                String query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted";
                ArrayList<Integer> totalPopulation = jdbc.getTotalPopulation(query);

                // Footer
                html = html + "<div class='footer'>";

                html = html + "<p><strong> Total number of LGAs within the data set:" + " "
                                + NumberOfLGA.get(0).intValue() + " </strong></p>";

                html = html + "<p><strong> Total population (2016) within the data set:" + " "
                                + totalPopulation.get(0).intValue() + " </strong></p>";

                html = html + "</div>";

                // Finish the HTML webpage
                html = html + "</body>" + "</html>";

                // DO NOT MODIFY THIS
                // Makes Javalin render the webpage
                context.html(html);
        }

}
