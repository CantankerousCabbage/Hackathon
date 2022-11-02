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
public class PageST32 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/PageST32.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 3.2</title>";

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
               // <a href='mission.html'>Our Mission</a>
               // <a href='page3.html'>Sub Task 2.1</a>
               // <a href='page4.html'>Sub Task 2.2</a>
               // <a href='page5.html'>Sub Task 3.1</a>
               // <a href='page6.html'>Sub Task 3.2</a>
           // </div>
       // """;
       String headerText = "3.2 Finding LGAs with similar Socioeconomic Outcomes";

       html = html + Global.getHeader(headerText);
       
       html = html + Global.getNavBar();
       html = html + "</div>";
       



        // Add Div for page Content
        html = html + "<div class='content'>";
        html = html + "<p><a href = 'PageST32.html'>Clear the page.</a></p>";

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

         //Similar LGA AGE
         html = html + "<div class='content'>";
         html = html + "<h2>Find Similar LGAs by Age and Indigenous Status</h2><br>";
         html = html + "<p>Similar LGAs in this context are defined as LGAs<br> with a population count that is + or - 10%<br> based of the selected parameters.</p><br>";
         html = html + "<form action='/PageST32.html' method='post'>";
         html = html + "   <div class='form-group'>";
         
         
 
         // Next we will ask this *class* for the LGAs
         ArrayList<LGA> lgas = jdbc.getLGAs();
 
         html = html + "<form action='/PageST32.html' method='post'>";
 
         
         html = html + "      <label for='LGA_drop'>Select the LGA:</label>";
         html = html + "      <select id='LGA_drop' name='LGA_drop'>";
 
         // Add all of the LGAs to drop down menu
         for (LGA lga : lgas) {
             html = html + "<option>" + lga.getName16() + "</option>";
         }
 
         html = html + "      </select>";
 
         
         html = html + "     <br> <br><label for='indigenous_status_drop'>Select Indigenous Status (Dropdown):</label>";
         html = html + "      <select id='indigenous_status_drop' name='indigenous_status_drop'>";
 
         html = html +"<option value='indig'>Indigenous</option>";
         html = html +"<option value='non_indig'>Non-Indigenous</option>";
         html = html +"<option value='indig_ns'>Indigenous status not stated</option>";
         html = html + "      </select>";
 
         html = html + "   <br>  <br> <label for='agebracket_drop1e'>Select the Age Bracket (Dropdown):</label>";
         html = html + "      <select id='agebracket_drop1e' name='agebracket_drop1e'>";
         
         html = html +"<option value='_0_4'>0 to 4</option>";
         html = html +"<option value='_5_9'>5 to 9</option>";
         html = html +"<option value='_10_14'>10 to 14</option>";
         html = html +"<option value='_15_19'>15 to 19</option>";
         html = html +"<option value='_20_24'>20 to 24</option>";
         html = html +"<option value='_25_29'>25 to 29</option>";
         html = html +"<option value='_30_34'>30 to 34</option>";
         html = html +"<option value='_35_39'>35 to 39</option>";
         html = html +"<option value='_40_44'>40 to 44</option>";
         html = html +"<option value='_45_49'>45 to 49</option>";
         html = html +"<option value='_50_54'>50 to 54</option>";
         html = html +"<option value='_55_59'>55 to 59</option>";
         html = html +"<option value='_60_64'>60 to 64</option>";
         html = html +"<option value='_65_yrs_ov'>65 and older</option>";
         html = html + "      </select>";
         html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
         html = html + "</form>";


         String LGA_drop2 = context.formParam("LGA_drop");
         String indigenous_status_drop2 = context.formParam("indigenous_status_drop");
         String agebracket_drop2e = context.formParam("agebracket_drop1e");
         if (agebracket_drop2e == null) {
             html = html + "<p><i>Please select parameters above.</i></p>";
         }
 
         else {
             html = html + similarLGAbyAge(LGA_drop2, indigenous_status_drop2, agebracket_drop2e);
         }
        // Close Content div
        html = html + "</div>";
        html = html + "</div>";


                 //Similar LGA Employment Status
                 html = html + "<div class='content1'>";
                 html = html + "<h2>Find Similar LGAs by Labour Force Status and Indigenous Status</h2><br>";
                 html = html + "<p>Similar LGAs in this context are defined as LGAs<br> with a population count that is + or - 10%<br> based of the selected parameters.</p><br>";

                 html = html + "<form action='/PageST32.html' method='post'>";
                 html = html + "   <div class='form-group'>";
                 
                 
         
                 // Next we will ask this *class* for the LGAs
                 ArrayList<LGA> lgas2 = jdbc.getLGAs();
         
                 html = html + "<form action='/PageST32.html' method='post'>";
         
                 
                 html = html + "      <label for='LGA_drop3'>Select the LGA:</label>";
                 html = html + "      <select id='LGA_drop3' name='LGA_drop3'>";
         
                 // Add all of the LGAs to drop down menu
                 for (LGA lga : lgas2) {
                     html = html + "<option>" + lga.getName16() + "</option>";
                 }
         
                 html = html + "      </select>";
         
                 
                 html = html + "    <br>  <br><label for='indigenous_status_drop3'>Select Indigenous Status:</label>";
                 html = html + "      <select id='indigenous_status_drop3' name='indigenous_status_drop3'>";
         
                 html = html +"<option value='indig'>Indigenous</option>";
                 html = html +"<option value='non_indig'>Non-Indigenous</option>";
                 html = html +"<option value='indig_ns'>Indigenous status not stated</option>";
                 html = html + "      </select>";
         

                 
                 html = html + "    <br>  <br><label for='labourforce_drop'>Select an Employment Status:</label>";
                 html = html + "      <select id='labourforce_drop' name='labourforce_drop'>";
                 
                 
                 html = html +"<option value='in_lf_emp'>Employed</option>";
                 html = html +"<option value='in_lf_unemp'>Unemplyed</option>";
                 html = html +"<option value='indsec_gov'>Employed in the Government Sector</option>";
                 html = html +"<option value='indsec_priv'>Employed in the Private Sector</option>";
                 html = html +"<option value='self_employed'>Self Employed</option>";
                 html = html +"<option value='n_the_lf'>Not in the labour force</option>";
                 html = html + "      </select>";
                 html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
                 html = html + "</form>";
                 html = html + "      </select>";

                 String LGA_drop3 = context.formParam("LGA_drop3");
                 String indigenous_status_drop3 = context.formParam("indigenous_status_drop3");
                 String labourforce_drop = context.formParam("labourforce_drop");
                 if (labourforce_drop == null) {
                     html = html + "<p><i>Please select parameters above.</i></p>";
                 }
         
                 else {
                     html = html + similarLGAbyLF(LGA_drop3, indigenous_status_drop3, labourforce_drop);
                 }
                // Close Content div
                html = html + "</div>";
                html = html + "</div>";

                // Close Content div
                html = html + "</div>";

                 //Similar LGA School Completion
                 html = html + "<div class='content'>";
                 html = html + "<h2>Find Similar LGAs by School Completion Status and Indigenous Status</h2><br>";
                 html = html + "<p>Similar LGAs in this context are defined as LGAs<br> with a population count that is + or - 10%<br> based of the selected parameters.</p><br>";

                 html = html + "<form action='/PageST32.html' method='post'>";
                 html = html + "   <div class='form-group'>";
                 
                 
         
                 // Next we will ask this *class* for the LGAs
                 ArrayList<LGA> lgas3 = jdbc.getLGAs();
         
                 html = html + "<form action='/PageST32.html' method='post'>";
         
                 
                 html = html + "      <label for='LGA_drop4'>Select the LGA:</label>";
                 html = html + "      <select id='LGA_drop4' name='LGA_drop4'>";
         
                 // Add all of the LGAs to drop down menu
                 for (LGA lga : lgas3) {
                     html = html + "<option>" + lga.getName16() + "</option>";
                 }
         
                 html = html + "      </select>";
         
                 
                 html = html + "      <br><br><label for='indigenous_status_drop4'>Select Indigenous Status:</label>";
                 html = html + "      <select id='indigenous_status_drop4' name='indigenous_status_drop4'>";
         
                 html = html +"<option value='indig'>Indigenous</option>";
                 html = html +"<option value='non_indig'>Non-Indigenous</option>";
                 html = html +"<option value='indig_ns'>Indigenous status not stated</option>";
                 html = html + "      </select>";
         

                 
                 html = html + "   <br>   <br><label for='school_drop'>Select a School Completion Level:</label>";
                 html = html + "      <select id='school_drop' name='school_drop'>";
                 
                 html = html +"<option value='did_not_go_to_school'>Did not go to school</option>";
                 html = html +"<option value='year8_below'>Year 8 or below</option>";
                 html = html +"<option value='y10_equiv'>Year 10 or equivalent</option>";
                 html = html +"<option value='y12_equiv'>Year 12 or equivalent</option>";
                 html = html + "      </select>";
                 html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
                 html = html + "</form>";
                 html = html + "      </select>";

                 String LGA_drop4 = context.formParam("LGA_drop4");
                 String indigenous_status_drop4 = context.formParam("indigenous_status_drop4");
                 String schooldrop = context.formParam("school_drop");
                 if (schooldrop == null) {
                     html = html + "<p><i>Please select parameters above.</i></p>";
                 }
         
                 else {
                     html = html + similarLGAbySchool(LGA_drop4, indigenous_status_drop4, schooldrop);
                 }
                // Close Content div
                html = html + "</div>";
                html = html + "</div>";

                // Close Content div
                html = html + "</div>";

//Find LGA based on Distance
                //html = html + "<div class='content1'>";
               // html = html + "<h2>Find LGAs within distance of a given LGA</h2><br>";
               

               // html = html + "<form action='/PageST32.html' method='post'>";
                //html = html + "   <div class='form-group'>";          
                //html = html + "      <label for='LGA_drop5'>Select the LGA:</label>";
               // html = html + "      <select id='LGA_drop5' name='LGA_drop5'>";
        
                // Add all of the LGAs to drop down menu
               // for (LGA lga : lgas3) {
               //     html = html + "<option>" + lga.getName16() + "</option>";
               // }
               // html = html + "      </select>";     
                //html = html + "      <br><br><label for='distance'>Select a Distance:</label>";
                //html = html + "      <select id='distance' name='distance'>";
        
               // html = html +"<option value='5'>5km</option>";
               // html = html +"<option value='50'>50km</option>";
               // html = html +"<option value='100'>100km</option>";
               // html = html +"<option value='250'>250km</option>";
               // html = html +"<option value='500'>500km</option>";
               // html = html +"<option value='1000'>1000km</option>";
               // html = html +"<option value='2000'>2000km</option>";
        
               // html = html + "      </select>";     
               //html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
               // html = html + "</form>";
                




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

    public String similarLGAbyAge(String LGA_drop2, String indigenous_status_drop2, String agebracket_drop2) {
        JDBCConnection jdbc = new JDBCConnection();
        String lgadrop2 = LGA_drop2;
        String indigdrop2 = indigenous_status_drop2;
        String agebracketdrop2 = agebracket_drop2;
        int populationTotal = jdbc.getPopulationAge1(lgadrop2, indigdrop2);
        int populationTotal2 = jdbc.getPopulationAge2(lgadrop2, indigdrop2, agebracketdrop2);
        String html = "";
        //html = html + "<p>Selected Population:" + indigdrop2 + " - " + "Selected Age Bracket:" + agebracketdrop2 + " - " + "Selected LGA:" + lgadrop2 + "</p>";
        //html = html + "<ul style='list-style-type:square;'>";
        //html = html + "<li> LGA Name = " + LGA_drop2 + "</li>";
        //html = html + "<li> Total Selected Population" + populationTotal + "</li>";
       // html = html + "<li> Total Selected Population within Age Bracket = " + populationTotal2 + "</li>";
       // html = html + "<li> Proportional Value of Selected Age Bracket and Selected Population = " + populationTotal2*100/populationTotal + "%</li></ul>";
        html = html + "<br><br><table class="+"horizontal_table3"+"><tr><td>LGA Name</td><td>"+LGA_drop2+"</td></tr><tr><td>Total "+indigdrop2+"&nbsp;people in the Selected LGA</td><td>"+populationTotal+"</td></tr><tr><td>Total " + indigdrop2 + "&nbsp;Population within&nbsp; " +agebracket_drop2+"&nbsp;age bracket in the selected LGA</td><td>"+populationTotal2+"</td></tr><tr><td>Proportional Value</td><td>"+populationTotal2*100/populationTotal+"%</td></tr></table><br>";

        
        ArrayList<LGAExtended> list3 = jdbc.getSimilarLGA(lgadrop2, indigenous_status_drop2, agebracketdrop2);
        System.out.println(list3);
        // Add HTML for the movies list
        html = html + "<ul style='list-style-type:square;'>";
        html = html + "<p>Similar LGAs</p>";
        html = html + "<strong>LGA Code - LGA Name - Population Count</strong><br>";

        
        for (LGAExtended lgaExtended : list3) {
            html = html + "<li>" + lgaExtended.getCode16()
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lgaExtended.getName16() +" -&nbsp;" +lgaExtended.getPopulationCount() + "</li>";
        }
        html = html + "</ul>";

        return html;
    }

    public String similarLGAbyLF(String LGA_drop3, String indigenous_status_drop3, String labourforce_drop) {
        JDBCConnection jdbc = new JDBCConnection();
        String lgadrop3 = LGA_drop3;
        String indigdrop3 = indigenous_status_drop3;
        String labourforcedrop = labourforce_drop;
        int populationTotal = jdbc.getPopulationAge1(lgadrop3, indigdrop3);
        int populationTotal2 = jdbc.getPopulationLF(lgadrop3, indigdrop3, labourforcedrop);
        String html = "";
        //html = html + "<p>Selected Population:" + indigdrop2 + " - " + "Selected Age Bracket:" + agebracketdrop2 + " - " + "Selected LGA:" + lgadrop2 + "</p>";
        //html = html + "<ul style='list-style-type:square;'>";
        //html = html + "<li> LGA Name = " + LGA_drop2 + "</li>";
        //html = html + "<li> Total Selected Population" + populationTotal + "</li>";
       // html = html + "<li> Total Selected Population within Age Bracket = " + populationTotal2 + "</li>";
       // html = html + "<li> Proportional Value of Selected Age Bracket and Selected Population = " + populationTotal2*100/populationTotal + "%</li></ul>";
        html = html + "<br><br><table class="+"horizontal_table2"+"><tr><td>LGA Name</td><td>"+LGA_drop3+"</td></tr><tr><td>Total "+indigdrop3+"&nbsp;people in the Selected LGA</td><td>"+populationTotal+"</td></tr><tr><td>Total " + indigdrop3 + "&nbsp;population who are&nbsp; " +labourforce_drop+"&nbsp;in the selected LGA</td><td>"+populationTotal2+"</td></tr><tr><td>Proportional Value</td><td>"+populationTotal2*100/populationTotal+"%</td></tr></table><br>";

        
        ArrayList<LGAExtended> list4 = jdbc.getSimilarLGALF(lgadrop3, indigenous_status_drop3, labourforce_drop);
        System.out.println(list4);
        // Add HTML for the movies list
        html = html + "<ul style='list-style-type:square;'>";
        html = html + "<p>Similar LGAs</p>";
        html = html + "<strong>LGA Code - LGA Name - Population Count</strong><br>";

        
        for (LGAExtended lgaExtended : list4) {
            html = html + "<li>" + lgaExtended.getCode16()
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lgaExtended.getName16() +" -&nbsp;" +lgaExtended.getPopulationCount() + "</li>";
        }
        html = html + "</ul>";

        return html;
    }

    public String similarLGAbySchool(String LGA_drop4, String indigenous_status_drop4, String schooldrop) {
        JDBCConnection jdbc = new JDBCConnection();
        String lgadrop4 = LGA_drop4;
        String indigdrop4 = indigenous_status_drop4;
        String schooldrop4 = schooldrop;
        int populationTotal = jdbc.getPopulationAge1(lgadrop4, indigdrop4);
        int populationTotal2 = jdbc.getPopulationSchool(lgadrop4, indigdrop4, schooldrop4);
        String html = "";
        //html = html + "<p>Selected Population:" + indigdrop2 + " - " + "Selected Age Bracket:" + agebracketdrop2 + " - " + "Selected LGA:" + lgadrop2 + "</p>";
        //html = html + "<ul style='list-style-type:square;'>";
        //html = html + "<li> LGA Name = " + LGA_drop2 + "</li>";
        //html = html + "<li> Total Selected Population" + populationTotal + "</li>";
       // html = html + "<li> Total Selected Population within Age Bracket = " + populationTotal2 + "</li>";
       // html = html + "<li> Proportional Value of Selected Age Bracket and Selected Population = " + populationTotal2*100/populationTotal + "%</li></ul>";
        html = html + "<br><br><table class="+"horizontal_table3"+"><tr><td>LGA Name</td><td>"+LGA_drop4+"</td></tr><tr><td>Total "+indigdrop4+"&nbsp;people in the Selected LGA</td><td>"+populationTotal+"</td></tr><tr><td>Number of " + indigdrop4 + "&nbsp;people whos highest level of school completed is&nbsp; " +schooldrop4+"&nbsp;within the selected LGA</td><td>"+populationTotal2+"</td></tr><tr><td>Proportional Value</td><td>"+populationTotal2*100/populationTotal+"%</td></tr></table><br>";

        
        ArrayList<LGAExtended> list5 = jdbc.getSimilarLGASchool(lgadrop4, indigenous_status_drop4, schooldrop4);
        System.out.println(list5);
        // Add HTML for the movies list
        html = html + "<ul style='list-style-type:square;'>";
        html = html + "<p>Similar LGAs</p>";
        html = html + "<strong>LGA Code - LGA Name - Population Count</strong><br>";

        
        for (LGAExtended lgaExtended : list5) {
            html = html + "<li>" + lgaExtended.getCode16()
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lgaExtended.getName16() +" -&nbsp;" +lgaExtended.getPopulationCount() + "</li>";
        }
        html = html + "</ul>";

        return html;
    }    
}
