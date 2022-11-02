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
public class PageST21 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/PageST21.html";

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
               // <a href='/'>Homepage</a>
                //<a href='mission.html'>Our Mission</a>
                //<a href='page3.html'>Sub Task 2.1</a>
                //<a href='page4.html'>Sub Task 2.2</a>
               // <a href='page5.html'>Sub Task 3.1</a>
               // <a href='page6.html'>Sub Task 3.2</a>
            //</div>
        //""";
        String headerText = "2.1 Age and School Completion Ranking by LGA";

        html = html + Global.getHeader(headerText);
        // Add header content block
        html = html + Global.getNavBar();
        // Add header content block
       // html = html + """
           // <div class='header'>
               // <h1>Subtask 2.1</h1>
            //</div>
        //""";

        // Add Div for page Content
        html = html + "<div class='content1'>";
        html = html + "<p><a href = 'PageST21.html'>Clear the page.</a></p>";

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Next we will ask this *class* for the LGAs
        ArrayList<LGAExtended> lgaExtendeds = jdbc.getLGAExtended();

        // Add HTML for the LGA list
        html = html + "<h2> Sort LGAs by Population Based on Age Bracket and Indigenous Status</h2>";
        html = html + "<ul>";
        html = html + "<form action='/PageST21.html' method='post'>";

        html = html + "   <div class='form-group'>";
        html = html + "      <label for='agebracket_drop'>Select the Age Bracket:</label>";
        html = html + "      <select id='agebracket_drop' name='agebracket_drop'>";
        
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


        html = html + "      <br><br><label for='indigenous_status_drop11'>Select Indigenous Status:</label>";
        html = html + "      <select id='indigenous_status_drop11' name='indigenous_status_drop11'>";

        html = html +"<option value='indig'>Indigenous</option>";
        html = html +"<option value='non_indig'>Non-Indigenous</option>";
        html = html +"<option value='indig_ns'>Indigenous status not stated</option>";
        html = html + "      </select>";
        html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
        html = html + "</form>";

        String agebracket_drop = context.formParam("agebracket_drop");
        String indigenous_status_drop11 = context.formParam("indigenous_status_drop11");
        if (agebracket_drop == null) {
            html = html + "<p><i>Please select parameters above.</i></p>";
        }

        else {
            html = html + outputLGAS(agebracket_drop,indigenous_status_drop11);
        }

                // Finish the List HTML
                html = html + "</ul>";

                // Close Content div
                html = html + "</div>";

//Non indiginous population

        // Add HTML for the LGA list
       // html = html + "<div class='content1'>";
        //html = html + "<h2>Non-Indigenous Population</h2>" +  "<ul>";
        //html = html + "<form action='/PageST21.html' method='post'>";

        //html = html + "   <div class='form-group'>";
        //html = html + "      <label for='agebracket_drop1'>Select the Age Bracket:</label>";
        //html = html + "      <select id='agebracket_drop1' name='agebracket_drop1'>";
        
        //html = html +"<option value='_0_4'>0 to 4</option>";
        //html = html +"<option value='_5_9'>5 to 9</option>";
        //html = html +"<option value='_10_14'>10 to 14</option>";
        //html = html +"<option value='_15_19'>15 to 19</option>";
        //html = html +"<option value='_20_24'>20 to 24</option>";
        //html = html +"<option value='_25_29'>25 to 29</option>";
        //html = html +"<option value='_30_34'>30 to 34</option>";
        //html = html +"<option value='_35_39'>35 to 39</option>";
        //html = html +"<option value='_40_44'>40 to 44</option>";
        //html = html +"<option value='_45_49'>45 to 49</option>";
        //html = html +"<option value='_50_54'>50 to 54</option>";
        //html = html +"<option value='_55_59'>55 to 59</option>";
        //html = html +"<option value='_60_64'>60 to 64</option>";
        //html = html +"<option value='_65_yrs_ov'>65 and older</option>";
        //html = html + "      </select>";
        //html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
        //html = html + "</form>";

        //String agebracket_drop1 = context.formParam("agebracket_drop1");
        //if (agebracket_drop1 == null) {
          //  html = html + "<p><i>Please select an age bracket above.</i></p>";
        //}

        //else {
          //  html = html + outputLGASnonIndig(agebracket_drop1);
        //}

        
        // Finally we can print out all of the LGAs
        //for (LGAExtended lgaExtended : lgaExtendeds) {
           // html = html + "<li>" + lgaExtended.getCode16()
            //            + " - " + lgaExtended.getName16() +" - " + lgaExtended.getAge()+" - " +lgaExtended.getPopulationCount() + "</li>";
        //}

        // Finish the List HTML
        //html = html + "</ul>";

        // Close Content div
        //html = html + "</div>";


                // Add Div for page Content
                html = html + "<div class='content'>";

                // Look up some information from JDBC
                // First we need to use your JDBCConnection class
                JDBCConnection jdbc1 = new JDBCConnection();
        
                // Next we will ask this *class* for the LGAs
                ArrayList<LGAExtended> lgaExtendeds1 = jdbc1.getLGAExtended();
        
                // Add HTML for the LGA list
                html = html + "<h2> Sort LGAs by School Completion Status </h2>";
                html = html + "<ul>";
                html = html + "<form action='/PageST21.html' method='post'>";
        
                html = html + "   <div class='form-group'>";
                html = html + "      <label for='schoolstatus_drop'>Select the Highest Level of School Completion:</label>";
                html = html + "      <select id='schoolstatus_drop' name='schoolstatus_drop'>";
                
                
                html = html +"<option value='did_not_go_to_school'>Did not go to school</option>";
                html = html +"<option value='year8_below'>Year 8 or below</option>";
                html = html +"<option value='y10_equiv'>Year 10 or equivalent</option>";
                html = html +"<option value='y12_equiv'>Year 12 or equivalent</option>";
                html = html + "      </select>";

                html = html + "      <br><br><label for='indigenous_status_drop12'>Select Indigenous Status:</label>";
                html = html + "      <select id='indigenous_status_drop12' name='indigenous_status_drop12'>";
        
                html = html +"<option value='indig'>Indigenous</option>";
                html = html +"<option value='non_indig'>Non-Indigenous</option>";
                html = html +"<option value='indig_ns'>Indigenous status not stated</option>";
                html = html + "      </select>";

                html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
                html = html + "</form>";
        
                String schoolstatus_drop = context.formParam("schoolstatus_drop");
                String indigenous_status_drop12 = context.formParam("indigenous_status_drop12");
                if (schoolstatus_drop == null) {
                    html = html + "<p><i>Please select parameters above.</i></p>";
                }
        
                else {
                    html = html + outputLGAS1(schoolstatus_drop, indigenous_status_drop12);
                }
        
                
                
                // Finally we can print out all of the LGAs
                //for (LGAExtended lgaExtended : lgaExtendeds) {
                   // html = html + "<li>" + lgaExtended.getCode16()
                    //            + " - " + lgaExtended.getName16() +" - " + lgaExtended.getAge()+" - " +lgaExtended.getPopulationCount() + "</li>";
                //}
        
                // Finish the List HTML
                html = html + "</ul>";
        
                // Close Content div
                html = html + "</div>";


                //School Completion Non-Indigenous Population
                                // Add Div for page Content
                                //html = html + "<div class='content'>";

                                // Look up some information from JDBC
                                // First we need to use your JDBCConnection class

                        
                                // Add HTML for the LGA list

                                //html = html + "<div class='content'>";
                                
                               // html = html + "<h2>Non-Indigenous Population</h2>" +  "<ul>";
                                //html = html + "<form action='/PageST21.html' method='post'>";
                        
                                //html = html + "   <div class='form-group'>";
                               // html = html + "      <label for='schoolstatus_drop1'>Select the Highest Level of School Completion:</label>";
                               // html = html + "      <select id='schoolstatus_drop1' name='schoolstatus_drop1'>";
                                
                               // html = html +"<option value='did_not_go_to_school'>Did not go to school</option>";
                               // html = html +"<option value='year8_below'>Year 8 or below</option>";
                               // html = html +"<option value='y10_equiv'>Year 10 or equivalent</option>";
                               // html = html +"<option value='y12_equiv'>Year 12 or equivalent</option>";
                               // html = html + "      </select>";
                               // html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
                               // html = html + "</form>";
                        
                               // String schoolstatus_drop1 = context.formParam("schoolstatus_drop1");
                               // if (schoolstatus_drop1 == null) {
                               //     html = html + "<p><i>Please select School Completion Status above.</i></p>";
                               // }
                        
                               // else {
                                //    html = html + outputLGAS1nonIndig(schoolstatus_drop1);
                               // }
                        
                                
                                
                                // Finally we can print out all of the LGAs
                                //for (LGAExtended lgaExtended : lgaExtendeds) {
                                   // html = html + "<li>" + lgaExtended.getCode16()
                                    //            + " - " + lgaExtended.getName16() +" - " + lgaExtended.getAge()+" - " +lgaExtended.getPopulationCount() + "</li>";
                                //}
                        
                                // Finish the List HTML
                               // html = html + "</ul>";
                        
                                // Close Content div
                               // html = html + "</div>";

        
        //Proportional Data by Age Bracket
        html = html + "<div class='content1'>";
        html = html + "<h2>Proportional Age Data for a given LGA</h2>"+  "<ul>";
        html = html + "<form action='/PageST21.html' method='post'>";
        html = html + "   <div class='form-group'>";
        
        

        // Next we will ask this *class* for the LGAs
        ArrayList<LGA> lgas = jdbc.getLGAs();

        html = html + "<form action='/PageST22.html' method='post'>";

        
        html = html + "      <label for='LGA_drop'>Select the LGA:</label>";
        html = html + "      <select id='LGA_drop' name='LGA_drop'>";

        // Add all of the LGAs to drop down menu
        for (LGA lga : lgas) {
            html = html + "<option>" + lga.getName16() + "</option>";
        }

        html = html + "      </select>";

        
        html = html + "      <br><br><label for='indigenous_status_drop'>Select Indigenous Status:</label>";
        html = html + "      <select id='indigenous_status_drop' name='indigenous_status_drop'>";

        html = html +"<option value='indig'>Indigenous</option>";
        html = html +"<option value='non_indig'>Non-Indigenous</option>";
        html = html +"<option value='indig_ns'>Indigenous status not stated</option>";
        html = html + "      </select>";

        html = html + "     <br><br> <label for='agebracket_drop1e'>Select the Age Bracket:</label>";
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
            html = html + proportionalAge(LGA_drop2, indigenous_status_drop2, agebracket_drop2e);
        }
        html = html + "</ul>";

                //Proportional Data by School Completion Status
                html = html + "<div class='content'>";
                html = html + "<h2>Proportional School Completion Data for a given LGA</h2>"+  "<ul>";
                html = html + "<form action='/PageST21.html' method='post'>";
                html = html + "   <div class='form-group'>";
                
                
        
                // Next we will ask this *class* for the LGAs
                ArrayList<LGA> lgas2 = jdbc.getLGAs();
        
                html = html + "<form action='/PageST22.html' method='post'>";
        
                
                html = html + "      <label for='LGA_dropSchool'>Select the LGA:</label>";
                html = html + "      <select id='LGA_dropSchool' name='LGA_dropSchool'>";
        
                // Add all of the LGAs to drop down menu
                for (LGA lga : lgas2) {
                    html = html + "<option>" + lga.getName16() + "</option>";
                }
        
                html = html + "      </select>";
        
                
                html = html + "      <br><br><label for='indigenous_status_dropSchool'>Select Indigenous Status:</label>";
                html = html + "      <select id='indigenous_status_dropSchool' name='indigenous_status_dropSchool'>";
                
                
                html = html +"<option value='indig'>Indigenous</option>";
                html = html +"<option value='non_indig'>Non-Indigenous</option>";
                html = html +"<option value='indig_ns'>Indigenous status not stated</option>";
                html = html + "      </select>";
        
                html = html + "     <br><br> <label for='school_drop'>Select the School Completion Status:</label>";
                html = html + "      <select id='school_drop' name='school_drop'>";
                
                html = html +"<option value='did_not_go_to_school'>Did not go to school</option>";
                html = html +"<option value='year8_below'>Year 8 or below</option>";
                html = html +"<option value='y10_equiv'>Year 10 or equivalent</option>";
                html = html +"<option value='y12_equiv'>Year 12 or equivalent</option>";
                html = html + "      </select>";
                html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
                html = html + "</form>";
        
        
                String LGA_drop3 = context.formParam("LGA_dropSchool");
                String indigenous_status_drop3 = context.formParam("indigenous_status_dropSchool");
                String schoolCompletion = context.formParam("school_drop");
                if (schoolCompletion == null) {
                    html = html + "<p><i>Please select parameters above.</i></p>";
                }
        
                else {
                    html = html + schoolPopulation(LGA_drop3, indigenous_status_drop3, schoolCompletion);
                }
        
                html = html + "</ul>";

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

    public String proportionalAge(String LGA_drop2, String indigenous_status_drop2, String agebracket_drop2) {
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
        html = html + "<br><br><table class="+"horizontal_table"+"><tr><td>LGA Name</td><td>"+LGA_drop2+"</td></tr><tr><td>Total " + indigdrop2 + "&nbsp;population within&nbsp; " +agebracket_drop2+"&nbsp;age bracket in the selected LGA</td><td>"+populationTotal2+"</td></tr><tr><td>Total "+indigdrop2+" population of the selected LGA</td><td>"+populationTotal+"</td></tr><tr><td>Proportional Value</td><td>"+populationTotal2*100/populationTotal+"%</td></tr></table><br>";

        return html;
    }

    public String schoolPopulation(String LGA_drop3, String indigenous_status_drop3, String schoolCompletion) {
        JDBCConnection jdbc = new JDBCConnection();
        String lgadrop3 = LGA_drop3;
        String indigdrop3 = indigenous_status_drop3;
        String schoolCompletionStatus = schoolCompletion;
        int populationTotal = jdbc.getPopulationAge1(lgadrop3, indigdrop3);
        int populationTotal2 = jdbc.getPopulationSchool(lgadrop3, indigdrop3, schoolCompletionStatus);
        String html = "";
        //html = html + "<p>Selected Population:" + indigdrop2 + " - " + "Selected Age Bracket:" + agebracketdrop2 + " - " + "Selected LGA:" + lgadrop2 + "</p>";
        //html = html + "<ul style='list-style-type:square;'>";
        //html = html + "<li> LGA Name = " + LGA_drop2 + "</li>";
        //html = html + "<li> Total Selected Population" + populationTotal + "</li>";
       // html = html + "<li> Total Selected Population within Age Bracket = " + populationTotal2 + "</li>";
       // html = html + "<li> Proportional Value of Selected Age Bracket and Selected Population = " + populationTotal2*100/populationTotal + "%</li></ul>";
        html = html + "<br><br><table class="+"horizontal_table1"+"><tr><td>LGA Name</td><td>"+LGA_drop3+"</td></tr><tr><td>Total " + indigdrop3 + "&nbsp;population who have completed&nbsp; " +schoolCompletionStatus+"&nbsp;in the selected LGA</td><td>"+populationTotal2+"</td></tr><tr><td>Total "+indigdrop3+" population of the selected LGA</td><td>"+populationTotal+"</td></tr><tr><td>Proportional Value</td><td>"+populationTotal2*100/populationTotal+"%</td></tr></table><br>";

        return html;
    }

    public String outputLGAS(String type, String indigStatus) {
        String html = "";
        html = html + "<h2>" + type + " Age Bracket:&nbsp"+indigStatus+" </h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAExtended> list = jdbc.getLGAExtendedVar(type, indigStatus);

        // Add HTML for the movies list
        html = html + "<ul style='list-style-type:square;'>";
        html = html + "<strong>LGA Code - LGA Name - Population Count</strong><br>";
        for (LGAExtended lgaExtended : list) {
            html = html + "<li>" + lgaExtended.getCode16()
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lgaExtended.getName16() +" -&nbsp;"  + lgaExtended.getPopulationCount() + "</li>";
        }
        html = html + "</ul>";

        return html;
    }


    public String outputLGASnonIndig(String type) {
        String html = "";
        html = html + "<h2>" + type + " Age Bracket</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAExtended> list1 = jdbc.getLGAExtendedVarnonIndig(type);

        // Add HTML for the movies list
        html = html + "<ul style='list-style-type:square;'>";
        html = html + "<strong>LGA Code - LGA Name - Population Count</strong><br>";
        for (LGAExtended lgaExtended : list1) {
            html = html + "<li>" + lgaExtended.getCode16()
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lgaExtended.getName16() +" -&nbsp;"  +lgaExtended.getPopulationCount() + "</li>";
        }
        html = html + "</ul>";

        return html;
    }


    public String outputLGAS1(String type, String indigStatus) {
        String html = "";
        html = html + "<h2>" + type + " :School Completion</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAExtended> list2 = jdbc.getLGAExtendedVar2(type, indigStatus);

        // Add HTML for the movies list
        html = html + "<ul style='list-style-type:square;'>";
        html = html + "<strong>LGA Code - LGA Name - Population Count</strong><br>";
        for (LGAExtended lgaExtended : list2) {
            html = html + "<li>" + lgaExtended.getCode16()
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lgaExtended.getName16() +" -&nbsp;" +lgaExtended.getPopulationCount() + "</li>";
        }
        html = html + "</ul>";

        return html;
    }

    public String outputLGAS1nonIndig(String type) {
        String html = "";
        html = html + "<h2>" + type + " :School Completion</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAExtended> list2 = jdbc.getLGAExtendedVar2nonIndig(type);

        // Add HTML for the movies list
        html = html + "<ul style='list-style-type:square;'>";
        html = html + "<strong>LGA Code - LGA Name - Population Count</strong><br>";
        for (LGAExtended lgaExtended : list2) {
            html = html + "<li>" + lgaExtended.getCode16()
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lgaExtended.getName16() +" -&nbsp;" +lgaExtended.getPopulationCount() + "</li>";
        }
        html = html + "</ul>";

        return html;
    }

}
