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
public class Page_2 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/Page_2.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Page 2</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";

        // Add some Javascript
        html = html + "<script type ='text/javascript' src='javaScript.js'></script>";

        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        
        //Page TopNav
        Global nav = new Global();
        html = html + nav.getHeader();
        html = html + nav.getTopNav();

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Page_2</h1>
            </div>
        """;

        html = html + "<table border="1"><tr><th>RunDetails</th><td><table border="1"><tr><th>FileName</th><td>AC2-07340.DAT</td></tr><tr><th>FilePath</th><td>\\server1\AC2-DATA</td></tr><tr><th>LoadNumber</th><td>7340</td></tr><tr><th>Equipment</th><td>Autoclave #2</td></tr><tr><th>RunRecipe</th><td>XB-Falcon-Body</td></tr><tr><th>RunStart</th><td>2022-10-10T12:45:32</td></tr><tr><th>RunEnd</th><td>2022-10-10T17:56:41</td></tr><tr><th>RunDuration</th><td>311.15</td></tr><tr><th>FileLength</th><td>163162</td></tr><tr><th>OperatorName</th><td>RAD</td></tr><tr><th>ExportControl</th><td>AU NSR</td></tr><tr><th>IP</th><td>Third Party Disclosure Requires Written Approval</td></tr></table></td></tr><tr><th>PartInformation</th><td><table border="1"><thead><tr><th>Index</th><th>WorkOrder</th><th>PartNumber</th><th>PartDescription</th><th>ToolLocation</th><th>Comment1</th><th>Comment2</th><th>Comment3</th><th>PartTCs</th><th>PartProbes</th><th>OtherSensors</th></tr></thead><tbody><tr><td>1</td><td>3428123</td><td>ACME-100</td><td>Left Qtr Panel</td><td>B</td><td>L 53</td><td></td><td></td><td><ul><li>TC1</li><li>TC2</li></ul></td><td><ul><li>MON43</li></ul></td><td></td></tr><tr><td>2</td><td>3428124</td><td>ACME-200</td><td>Right Qtr Panel</td><td>F</td><td>L38</td><td></td><td></td><td><ul><li>TC35</li><li>TC36</li><li>TC37</li></ul></td><td><ul><li>MON49</li><li>MON50</li></ul></td><td></td></tr></tbody></table></td></tr></table>";

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
