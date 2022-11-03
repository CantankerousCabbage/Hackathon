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
public class Page_1 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/Page_1.html";

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
        //Page TopNav
        Global nav = new Global();
        html = html + nav.getHeader();
        html = html + nav.getTopNav();

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Page_1</h1>
            </div>
        """;

        JDBCConnection jdbc = new JDBCConnection();

        ArrayList<String> cures = new ArrayList<String>();
        cures.add("07337");
        cures.add("07338");
        cures.add("07339");
        cures.add("07340");
        cures.add("07341");
        cures.add("07343");
        cures.add("07347");
        cures.add("07351");
        cures.add("07354");
        cures.add("07356");
        cures.add("06994");
        cures.add("06998");
        cures.add("07001");
        cures.add("07003");
        cures.add("07005");
        cures.add("07007");
        cures.add("02979");
        cures.add("02983");
        cures.add("02988");
        
        ArrayList<String> sParam = new ArrayList<String>();
//         FileName
        sParam.add("FilePath");
        sParam.add("LoadNumber");
        sParam.add("Equipment");
        sParam.add("RunRecipe");
        sParam.add("RunStart");
        sParam.add("RunEnd");
        sParam.add("RunDuration");
        sParam.add("FileLength");
        sParam.add("OperatorName");
        sParam.add("ExportControl");
        sParam.add("IP");
        sParam.add("Index");
        sParam.add("WorkOrder");
        sParam.add("RunStart");
        sParam.add("PartNumber");
        sParam.add("PartDescription");
        sParam.add("ToolLocation");
        sParam.add("PartTCs");
        sParam.add("PartProbes");
        sParam.add("OtherSensors");




        html = html + "<form action='/Page_1.html' method='post'>";

        html = html + "<div class='grid-container_input221'>";

        html = html + "   <div class='grid-iteminput221'>";
        html = html + "      <label for='feature'>Select Feature:</label>";
        html = html + "      <select id='feature' name='feature' class=dropDownSize>"; 
        html = html + "         <option value='' selected disabled hidden>Choose here</option>";      
        for (int index = 0; index < sParam.size(); index++) {
            html = html + "         <option>" + sParam.get(index) + "</option>";
        }
        html = html + "      </select>";
        //<button type='submit' class='btn btn-primary'>Submit</button>"
        
        html = html + "   </div>";
        

        


            
            html = html + "<div class='grid-container_input221'>";
            html = html + "   <div class='grid-iteminput221'>";
            html = html + "     <label for='featureData'>" + "Feature Value" + ":</label><br>";
            html = html + "     <input type='text' id='featureData' name='featureData' value='Search'><br>";
            html = html + "     <input type='submit' value='Submit'>";
            html = html + "   </div>";
            html = html + "</form>";   

        String feature = context.formParam("feature");
        String featureData = context.formParam("featureData");
        System.out.print(featureData);
        System.out.println(feature);
        
        ArrayList<String> arrayData = new ArrayList<String>();

        if(feature != null && featureData != null){

            arrayData = jdbc.getFiles(feature, featureData);
            ArrayList<String> arrayDataRenamed = new ArrayList<String>();
            for(int i = 0; i < arrayData.size(); i++){
               //ArrayList<String> arrayDataRenamed = new ArrayList<String>();
               String temp = arrayData.get(i);
                temp = temp.substring(0, temp.length() - 4);
                temp = temp.concat("-anon.html");
                //System.out.print(temp);

               arrayDataRenamed.add(temp);
            }

            //System.out.print("Loop Reached");
            //ystem.out.print(arrayData);
            html = "<h2>File Name List:</h2>";
            for (int i = 0; i<arrayData.size(); i++) {
                html = html + "<ul style='list-style-type:square;'>";
                html = html + "<li>" + "<a href=/AutoClave5_JSON_Files/" + arrayDataRenamed.get(i)+" target ='_blank'" + ">"+ arrayDataRenamed.get(i) +"</a>" + "</li>";
                html = html + "</ul>";

        }
    }


















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