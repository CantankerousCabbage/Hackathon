package app;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/* @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
* @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au */
public class PageST31 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/PageST31.html";

    // Object for storing all data used in this page
    public PageDataST31 pageDataST31 = new PageDataST31();

    @Override
    public void handle(Context context) throws Exception {

      JDBCConnection jdbc = new JDBCConnection();

      // String sex_drop = "f";
      // String ageBracket_drop = "_0_4";

        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 3.1</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Get header and navbar
        String headerText = "3.1 A Gap-Score for Comparing between Indigenous and Non-Indigenous People";
        html = html + Global.getHeader(headerText);
        html = html + Global.getNavBar();

        html = html + """

                <!-- The flexible grid (content) -->
                <div class="row">
                <div class="main">
                <!-- <h1>3.1 A Gap-Score for Comparing between Indigenous and Non-Indigenous People</h1> -->
                <br>

            """;

        // html = html + """
        //     <form action='/PageST31.html' method='post'>
        //     <input type="reset">
        //     </form>
        //     <br>
        //     <br>
        //     """;

        // STEP 1 ------------------------------------------------------------------------------------------------
        // create outcomes drop down menu
        html = html + "<form action='/PageST31.html' method='post'>";
        html = html + "<fieldset>";
        html = html + "<legend><h3>Step 1:</h3></legend>";
        // html = html + "<input type='reset'>";
        html = html + "   <div class='form-group'>";
        html = html + "      <label for='outcome_drop'>Select the socioeconomic outcome: </label>";
        html = html + "      <select id='outcome_drop' name='outcome_drop'>";

        html = html + "<option value='age' selected>Age Data</option>";
        html = html + "<option value='schoolCompletion'>School Education Data</option>";
        html = html + "<option value='nonSchoolEducation'>Non School Education Data</option>";
        html = html + "<option value='employment'>Employment Data</option>";
        
        html = html + "      </select>";
        html = html + "<br>";
        // html = html + "   <button type='submit' class='btn btn-primary'>Continue to Next Step</button>";
        // html = html + "   </div>";

        // html = html + "</form>";

        // STEP 1 ------------------------------------------------------------------------------------------------
        // outcomes radio buttons
        // html = html + "<fieldset>";
        // html = html + "<legend><h3>Step 1: Select Socioeconomic Outcome and Search Type</h3></legend>";
        // html = html + "<form action='/PageST31.html' method='post'>";
        // html = html + "   <div class='form-group'>";

        // html = html + """
        //       <h3>Select the socioeconomic outcome to search by: </h3>

        //       <input type='radio' id='age' name='outcome_radio' value='age'>
        //       <label for='age'>Age Data</label><br>
        //       <input type='radio' id='highSchoolCompletion' name='outcome_radio' value='highSchoolCompletion'>
        //       <label for='highSchoolCompletion'>High School Education Data</label><br>
        //       <input type='radio' id='furtherEducation' name='outcome_radio' value='furtherEducation'>
        //       <label for='furtherEducation'>Further Education Data</label><br>
        //       <input type='radio' id='employment' name='outcome_radio' value='employment'>
        //       <label for='employment'>Employment Data</label>
        //       <br>
        //       <!-- <button type='submit' class='btn btn-primary'>Continue to Next Step</button>
        //       </div>
        //       </fieldset>
        //       </form> -->
        //       <br>
        //     """;

        // search type dropdown
        // html = html + "<form action='/PageST31.html' method='post'>";
        // html = html + "<fieldset>";
        // html = html + "<legend><h3>Step 2:</h3></legend>";
        html = html + "<br><br>";
        // html = html + "<h3>Select your search type:</h3>";
        // html = html + "   <div class='form-group'>";
        html = html + "      <label for='searchType_drop'>Select your search type:</label>";
        html = html + "      <select id='searchType_drop' name='searchType_drop'>";

        html = html
            + "<option value='gapScore' selected>View Total Number, Percentage and Gap Score within each LGA</option>";
        html = html + "<option value='filterForLGA'>Filter for LGAs that fall within specified properties</option>";
        html = html + "<option value='rankLGA'>Rank LGAs according to their Gap Score</option>";

        html = html + "<br><br>";
        html = html + "      </select>";
        html = html + "<br><br>";
        html = html + "   <button type='submit' class='btn btn-primary'>Continue to Next Step</button>";
        html = html + "   </div>";
        html = html + "</fieldset>";
        html = html + "</form>";
        html = html + "<br>";
        html = html + "<br>";

        // search type radio buttons
        // html = html + """
        //     <h3>Select your search type:</h3>

        //     <!-- <p>Select Your Search Type:</p> -->

        //     <!-- <form action='/PageST31.html' method='post'>
        //     <div class='form-group'> -->
        //       <input type='radio' id='gapScore' name='searchType_radio' value='gapScore>
        //       <label for='gapScore'>View Total Number, Percentage and Gap Score within each LGA</label><br>
        //       <input type='radio' id='filterForLGA' name='searchType_radio' value='filterForLGA'>
        //       <label for='filterForLGA'>Filter for LGAs that fall within specified properties</label><br>
        //       <input type='radio' id='rankLGA' name='searchType_radio' value='rankLGA'>
        //       <label for='rankLGA'>Rank LGAs according to their Gap Score</label>
        //       <br>
        //       <br>
        //       <button type='submit' class='btn btn-primary'>Continue to Next Step</button>
        //     </div>
        //     </fieldset>
        //     </form>
        //     <br>
        //     <br>
        //     """;

        // Get the search type Form Data -------------------------------------------------------------------------
        String outcome_drop = context.formParam("outcome_drop");
        String searchType_drop = context.formParam("searchType_drop");
        // System.out.println(searchType_drop);

        // STEP 2 ------------------------------------------------------------------------------------------------
        // step 2 open fieldset
        html = html + "<fieldset>";
        html = html + "<legend><h3>Step 2: Build Your Search Query</h3></legend>";
        html = html + "<form action='/PageST31.html' method='post'>";
        html = html + "   <div class='form-group'>";

        // step 2 display queries -----------------------------------------------------------------------------------
        if (outcome_drop != null && searchType_drop != null) {
          pageDataST31.outcomeSelection = outcome_drop;
          pageDataST31.searchTypeSelection = searchType_drop;

          // If NOT NULL, then build the queries for gap score by LGA 

          if (pageDataST31.outcomeSelection.equals("age") && pageDataST31.searchTypeSelection.equals("gapScore")) {
            pageDataST31.searchType_ageGapScore = true;

            html = html + "<p>Find the number of " + getSexDropdown()
                + " Indigenous and Non-indigenous people aged " + getAgeBracketDropdown() + " within each LGA</p>";

          } else if (pageDataST31.outcomeSelection.equals("schoolCompletion")
              && pageDataST31.searchTypeSelection.equals("gapScore")) {

            pageDataST31.searchType_schoolCompletionGapScore = true;

            html = html + "<p>Find the number of " + getSexDropdown()
                + " Indigenous and Non-indigenous people "
                + " whose highest year of school completion was " + getSchoolCompletionDropdown()
                + " within each LGA</p>";
          } else if (pageDataST31.outcomeSelection.equals("nonSchoolEducation")
              && pageDataST31.searchTypeSelection.equals("gapScore")) {

            pageDataST31.searchType_nonSchoolEducationGapScore = true;

            html = html + "<p>Find the number of " + getSexDropdown()
                + " Indigenous and Non-indigenous people "
                + " who have completed non-school qualification level of " + getNonSchoolEducationDropdown()
                + " within each LGA</p>";
          } else if (pageDataST31.outcomeSelection.equals("employment")
              && pageDataST31.searchTypeSelection.equals("gapScore")) {

            pageDataST31.searchType_employmentGapScore = true;

            html = html + "<p>Find the number of " + getSexDropdown()
                + " Indigenous and Non-indigenous people "
                + " whose employment status is " + getEmploymentDropdown()
                + " within each LGA</p>";
          }
          // else {
          //   // If NULL, nothing to show, therefore we make some "no results" HTML
          //   html = html + "<h2><i>No Step 1 Search</i></h2>";
          // }
      }
        // step 2 close fieldset ----------------------------------------------------------------------------------
        html = html + "<br>";
        html = html + "<button type='submit' class='btn btn-primary'>Submit</button>";
        html = html + "</div>";
        html = html + "</fieldset>";
        html = html + "</form>";
        html = html + "<br><br>";

        // Step 2. Get and process user selections
        // String valueType_drop = context.formParam("valueType_drop");
        String sex_drop = context.formParam("sex_drop");
        String ageBracket_drop = context.formParam("ageBracket_drop");
        String schoolCompletion_drop = context.formParam("schoolCompletion_drop");
        String nonSchoolEducation_drop = context.formParam("nonSchoolEducation_drop");
        String employment_drop = context.formParam("employment_drop");

        // STEP 3 ------------------------------------------------------------------------------------------------
        // submit search query
        // html = html + "<fieldset>";
        // html = html + "<legend><h3>Step 3: Reveiw and Submit Your Search Query</h3></legend>";
        // html = html + "<form action='/PageST31.html' method='post'>";
        // html = html + "   <div class='form-group'>";

        // html = html + "<h3>Your Query: </h3>";

        // // step 2 user query feedback 
        // html = html + "<p>Find the number of " + sex_drop
        //     + " Indigenous and Non-indigenous people aged " + ageBracket_drop + " within each LGA</p>";

        // html = html + "<br>";
        // html = html + "<button type='submit' class='btn btn-primary'>Submit Query</button>";
        // html = html + "</div>";
        // html = html + "</fieldset>";
        // html = html + "</form>";
        // html = html + "<br><br>";

        // ---------------------------------------------------------------------------------------------------------            





        // else if (outcome_drop.equals("Population Data") && searchType_drop.equals("filterForLGA")) {
        //   html = html + buildQueryPopulationFilterForLGA();
        // } else if (outcome_drop.equals("Population Data") && searchType_drop.equals("rankLGA")) {
        //   html = html + buildQueryPopulationRankLGA();

        // } else if (outcome_drop.equals("High School Education Data") && searchType_drop.equals("gapScore")) {
        //   html = html + buildQuerySchoolCompletionGapScore();
        // } else if (outcome_drop.equals("High School Education Data") && searchType_drop.equals("filterForLGA")) {
        //   html = html + buildQuerySchoolCompletionFilterForLGA();
        // } else if (outcome_drop.equals("High School Education Data") && searchType_drop.equals("rankLGA")) {
        //   html = html + buildQuerySchoolCompletionRankLGA();

        // }

        // Age and Gap score search (1,1)  -------------------------------------------------------------------------------
        // LGA PROPORTIONAL DATA 

        // if (outcomeSelection == null || searchTypeSelection == null) { // do nothing
        //   html = html + "<h2><i>No Step 1 DISPLAY Results</i></h2>";
        // } else if (outcomeSelection.equals("age") && searchTypeSelection.equals("gapScore")) {
        if (pageDataST31.searchType_ageGapScore == true && sex_drop != null && ageBracket_drop != null) {

              // Array list for storing all LGA data for PageST31
              ArrayList<LGA_PageST31> lga_PageST31_listMaster = new ArrayList<>();

              // get total indig population of LGA --------------------------------------------------------------------------------
              ArrayList<LGA_PageST31> lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatus("indig");

              // add an object for each LGA to the list
              for (int i = 0; i < lga_PageST31_listTemp.size(); i++) {
                lga_PageST31_listMaster.add(lga_PageST31_listTemp.get(i));

              }

              // add the lga name and total indig population for each LGA to the list
              for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                lga_PageST31_listMaster.get(i).LGAname = lga_PageST31_listTemp.get(i).LGAname;
                lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig = lga_PageST31_listTemp
                    .get(i).LGAtotalPopulationTemp;

                // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\n", lga_PageST31_listMaster.get(i).LGAname,
                //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig);
              }

              // get total NON indig population of LGA --------------------------------------------------------------------------------
              lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatus("non_indig");

                // add total NON indig population for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // get total indig population of LGA by sex, age  --------------------------------------------------------------------------------
                lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexAge("indig", sex_drop,
                    ageBracket_drop);

                // add total indig population by sex, age bracket for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationIndigBySexAge = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // get total NON indig population of LGA by sex, age  --------------------------------------------------------------------------------
                lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexAge("non_indig", sex_drop,
                    ageBracket_drop);

                // add total NON indig population by sex, age bracket for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndigBySexAge = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // calc proportional data by sex, age bracket for each LGA 
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).calcLGApopulationProportionalValuesBySexAge();
                  lga_PageST31_listMaster.get(i).calcLGAgapScorePopulationProportionalValuesBySexAge();

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                if (sex_drop.equals("f")) {
                  pageDataST31.sexTableDisplay = "Females";
                } else if (sex_drop.equals("m")) {
                  pageDataST31.sexTableDisplay = "Males";
                }

                // Creat LGA age gap score data table
                html = html
                    + """
                        <h2>Total Population, Percentage and Gap Score within each LGA</h2>
                        <table class="table_PageST31_AgeDataGapScore">
                        <tr>
                          <th rowspan='2'>LGA Name</th>
                          <th colspan='3'>Number of Indigenous """ + " " + pageDataST31.sexTableDisplay + " " + """
                        aged """ + " " + ageBracket_drop + " " + """
                          within the LGA</th>
                        <th colspan='3'>Number of Non-Indigenous """ + " " + pageDataST31.sexTableDisplay + " " + """
                        aged """ + " " + ageBracket_drop + " " + """
                              within the LGA</th>
                        </tr>
                          <th>Total</th>
                          <th>Percent</th>
                          <th>Gap Score</th>
                          <th>Total</th>
                          <th>Percent</th>
                          <th>Gap Score</th>
                          </tr>
                          """;

                for (LGA_PageST31 lga_PageST31_temp1 : lga_PageST31_listMaster) {
                  html = html + "<tr>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAname + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAtotalPopulationIndigBySexAge + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGApercentPopulationIndigBySexAge + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAgapScorePopulationIndigBySexAge + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAtotalPopulationNonIndigBySexAge + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGApercentPopulationNonIndigBySexAge + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAgapScorePopulationNonIndigBySexAge + "</td>";
                }

                html = html + "</table>";
                html = html + "<br><br>";

                //  Search type: school completion, gap score --------------------------------------------------------------------------------------------------------------------  
              } else if (pageDataST31.searchType_schoolCompletionGapScore == true && sex_drop != null
                  && schoolCompletion_drop != null) {
                // Array list for storing all LGA data for PageST31
                ArrayList<LGA_PageST31> lga_PageST31_listMaster = new ArrayList<>();

                // get total indig population of LGA --------------------------------------------------------------------------------
                ArrayList<LGA_PageST31> lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatus("indig");

                // add an object for each LGA to the list
                for (int i = 0; i < lga_PageST31_listTemp.size(); i++) {
                  lga_PageST31_listMaster.add(lga_PageST31_listTemp.get(i));

                }

                // add the lga name and total indig population for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAname = lga_PageST31_listTemp.get(i).LGAname;
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\n", lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig);
                }

                // get total NON indig population of LGA --------------------------------------------------------------------------------
                lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatus("non_indig");

                // add total NON indig population for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // // get total indig population of LGA by sex, school completion  --------------------------------------------------------------------------------
                // lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexSchoolCompletion("indig", sex_drop,
                //     schoolCompletion_drop);

                // // add total indig population by sex, school completion for each LGA to the list
                // for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                //   lga_PageST31_listMaster.get(i).LGAtotalPopulationIndigBySexSchoolCompletion = lga_PageST31_listTemp
                //       .get(i).LGAtotalPopulationTemp;

                //   // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                //   //     lga_PageST31_listMaster.get(i).LGAname,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                // }

                // // get total NON indig population of LGA by sex, school completion  --------------------------------------------------------------------------------
                // lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexSchoolCompletion("non_indig", sex_drop,
                //     schoolCompletion_drop);

                // // add total NON indig population by sex, school completion for each LGA to the list
                // for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                //   lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndigBySexSchoolCompletion = lga_PageST31_listTemp
                //       .get(i).LGAtotalPopulationTemp;

                //   // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                //   //     lga_PageST31_listMaster.get(i).LGAname,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                // }

                // get total indig population of LGA by sex, school completion  --------------------------------------------------------------------------------
                lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexSchoolCompletion("indig", sex_drop,
                    schoolCompletion_drop);

                // add total indig population by sex, school completion for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationIndigBySexSchoolCompletion = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // get total NON indig population of LGA by sex, school completion  --------------------------------------------------------------------------------
                lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexSchoolCompletion("non_indig",
                    sex_drop, schoolCompletion_drop);

                // add total NON indig population by sex, school completion for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndigBySexSchoolCompletion = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // calc proportional data by sex, age bracket for each LGA 
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).calcLGApopulationProportionalValuesBySexSchoolCompletion();
                  lga_PageST31_listMaster.get(i).calcLGAgapScorePopulationProportionalValuesBySexSchoolCompletion();

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                if (sex_drop.equals("f")) {
                  pageDataST31.sexTableDisplay = "Females";
                } else if (sex_drop.equals("m")) {
                  pageDataST31.sexTableDisplay = "Males";
                }

                // Create LGA school completion gap score data table
                html = html
                    + """
                        <h2>Total Population, Percentage and Gap Score within each LGA</h2>
                        <table class="table_PageST31_AgeDataGapScore">
                        <tr>
                          <th rowspan='2'>LGA Name</th>
                          <th colspan='3'>Number of Indigenous """ + " " + pageDataST31.sexTableDisplay + " " + """
                        whose highest year of school completion was """ + " " + schoolCompletion_drop + " " + """
                          within the LGA</th>
                        <th colspan='3'>Number of Non-Indigenous """ + " " + pageDataST31.sexTableDisplay + " " + """
                        whose highest year of school completion was """ + " " + schoolCompletion_drop + " " + """
                              within the LGA</th>
                        </tr>
                          <th>Total</th>
                          <th>Percent</th>
                          <th>Gap Score</th>
                          <th>Total</th>
                          <th>Percent</th>
                          <th>Gap Score</th>
                          </tr>
                          """;

                for (LGA_PageST31 lga_PageST31_temp1 : lga_PageST31_listMaster) {
                  html = html + "<tr>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAname + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAtotalPopulationIndigBySexSchoolCompletion + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGApercentPopulationIndigBySexSchoolCompletion + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAgapScorePopulationIndigBySexSchoolCompletion + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAtotalPopulationNonIndigBySexSchoolCompletion + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGApercentPopulationNonIndigBySexSchoolCompletion + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAgapScorePopulationNonIndigBySexSchoolCompletion
                      + "</td>";
                }

                html = html + "</table>";
                html = html + "<br><br>";

                //  Search type: non school education, gap score  ---------------------------------------------------------------------  
              } else if (pageDataST31.searchType_nonSchoolEducationGapScore == true && sex_drop != null
                  && nonSchoolEducation_drop != null) {
                // Array list for storing all LGA data for PageST31
                ArrayList<LGA_PageST31> lga_PageST31_listMaster = new ArrayList<>();

                // get total indig population of LGA --------------------------------------------------------------------------------
                ArrayList<LGA_PageST31> lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatus("indig");

                // add an object for each LGA to the list
                for (int i = 0; i < lga_PageST31_listTemp.size(); i++) {
                  lga_PageST31_listMaster.add(lga_PageST31_listTemp.get(i));

                }

                // add the lga name and total indig population for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAname = lga_PageST31_listTemp.get(i).LGAname;
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\n", lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig);
                }

                // get total NON indig population of LGA --------------------------------------------------------------------------------
                lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatus("non_indig");

                // add total NON indig population for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // // get total indig population of LGA by sex, age  --------------------------------------------------------------------------------
                // lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexAge("indig", sex_drop,
                //     ageBracket_drop);

                // // add total indig population by sex, age bracket for each LGA to the list
                // for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                //   lga_PageST31_listMaster.get(i).LGAtotalPopulationIndigBySexAge = lga_PageST31_listTemp
                //       .get(i).LGAtotalPopulationTemp;

                //   // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                //   //     lga_PageST31_listMaster.get(i).LGAname,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                // }

                // // get total NON indig population of LGA by sex, age  --------------------------------------------------------------------------------
                // lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexAge("non_indig", sex_drop,
                //     ageBracket_drop);

                // // add total NON indig population by sex, age bracket for each LGA to the list
                // for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                //   lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndigBySexAge = lga_PageST31_listTemp
                //       .get(i).LGAtotalPopulationTemp;

                //   // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                //   //     lga_PageST31_listMaster.get(i).LGAname,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                // }

                // get total indig population of LGA by sex, non school education  --------------------------------------------------------------------------------
                lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexNonSchoolEducation("indig",
                    sex_drop,
                    nonSchoolEducation_drop);

                // add total indig population by sex, school completion for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationIndigBySexNonSchoolEducation = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // get total NON indig population of LGA by sex, non school education  --------------------------------------------------------------------------------
                lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexNonSchoolEducation("non_indig",
                    sex_drop, nonSchoolEducation_drop);

                // add total NON indig population by sex, non school education for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster
                      .get(i).LGAtotalPopulationNonIndigBySexNonSchoolEducation = lga_PageST31_listTemp
                          .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // calc proportional data by sex, age bracket for each LGA 
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).calcLGApopulationProportionalValuesBySexNonSchoolEducation();
                  lga_PageST31_listMaster.get(i).calcLGAgapScorePopulationProportionalValuesBySexNonSchoolEducation();

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                if (sex_drop.equals("f")) {
                  pageDataST31.sexTableDisplay = "Females";
                } else if (sex_drop.equals("m")) {
                  pageDataST31.sexTableDisplay = "Males";
                }

                // Create LGA non school education gap score data table
                html = html
                    + """
                        <h2>Total Population, Percentage and Gap Score within each LGA</h2>
                        <table class="table_PageST31_AgeDataGapScore">
                        <tr>
                          <th rowspan='2'>LGA Name</th>
                          <th colspan='3'>Number of Indigenous """ + " " + pageDataST31.sexTableDisplay + " " + """
                        who have completed non-school qualification level of """ + " " + nonSchoolEducation_drop + " "
                    + """
                          within the LGA</th>
                        <th colspan='3'>Number of Non-Indigenous """ + " " + pageDataST31.sexTableDisplay + " "
                    + """
                        who have completed non-school qualification level of """ + " " + nonSchoolEducation_drop + " "
                    + """
                              within the LGA</th>
                        </tr>
                          <th>Total</th>
                          <th>Percent</th>
                          <th>Gap Score</th>
                          <th>Total</th>
                          <th>Percent</th>
                          <th>Gap Score</th>
                          </tr>
                          """;

                for (LGA_PageST31 lga_PageST31_temp1 : lga_PageST31_listMaster) {
                  html = html + "<tr>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAname + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAtotalPopulationIndigBySexNonSchoolEducation + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGApercentPopulationIndigBySexNonSchoolEducation + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAgapScorePopulationIndigBySexNonSchoolEducation + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAtotalPopulationNonIndigBySexNonSchoolEducation + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGApercentPopulationNonIndigBySexNonSchoolEducation
                      + "</td>";
                  html = html + "<td>" + lga_PageST31_temp1.LGAgapScorePopulationNonIndigBySexNonSchoolEducation
                      + "</td>";
                }

                html = html + "</table>";
                html = html + "<br><br>";

                //  Search type: employment, gap score  ---------------------------------------------------------------------  
              } else if (pageDataST31.searchType_employmentGapScore == true && sex_drop != null
                  && employment_drop != null) {
                // Array list for storing all LGA data for PageST31
                ArrayList<LGA_PageST31> lga_PageST31_listMaster = new ArrayList<>();

                // get total indig population of LGA --------------------------------------------------------------------------------
                ArrayList<LGA_PageST31> lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatus("indig");

                // add an object for each LGA to the list
                for (int i = 0; i < lga_PageST31_listTemp.size(); i++) {
                  lga_PageST31_listMaster.add(lga_PageST31_listTemp.get(i));

                }

                // add the lga name and total indig population for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAname = lga_PageST31_listTemp.get(i).LGAname;
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\n", lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig);
                }

                // get total NON indig population of LGA --------------------------------------------------------------------------------
                lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatus("non_indig");

                // add total NON indig population for each LGA to the list
                for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                  lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig = lga_PageST31_listTemp
                      .get(i).LGAtotalPopulationTemp;

                  // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                  //     lga_PageST31_listMaster.get(i).LGAname,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                  //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                }

                // // get total indig population of LGA by sex, age  --------------------------------------------------------------------------------
                // lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexAge("indig", sex_drop,
                //     ageBracket_drop);

                // // add total indig population by sex, age bracket for each LGA to the list
                // for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                //   lga_PageST31_listMaster.get(i).LGAtotalPopulationIndigBySexAge = lga_PageST31_listTemp
                //       .get(i).LGAtotalPopulationTemp;

                //   // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                //   //     lga_PageST31_listMaster.get(i).LGAname,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
                // }

                // // get total NON indig population of LGA by sex, age  --------------------------------------------------------------------------------
                // lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexAge("non_indig", sex_drop,
                //     ageBracket_drop);

                // // add total NON indig population by sex, age bracket for each LGA to the list
                // for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                //   lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndigBySexAge = lga_PageST31_listTemp
                //       .get(i).LGAtotalPopulationTemp;

                //   // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                //   //     lga_PageST31_listMaster.get(i).LGAname,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                //   //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
              // }

              // get total indig population of LGA by sex, employment  --------------------------------------------------------------------------------
              lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexEmployment("indig",
                  sex_drop, employment_drop);

              // add total indig population by sex, employment for each LGA to the list
              for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                lga_PageST31_listMaster.get(i).LGAtotalPopulationIndigBySexEmployment = lga_PageST31_listTemp
                    .get(i).LGAtotalPopulationTemp;

                // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                //     lga_PageST31_listMaster.get(i).LGAname,
                //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
              }

              // get total NON indig population of LGA by sex, employment  --------------------------------------------------------------------------------
              lga_PageST31_listTemp = jdbc.getTotalPopulationAllLGAbyIndigStatusSexEmployment("non_indig",
                  sex_drop, employment_drop);

              // add total NON indig population by sex, non school education for each LGA to the list
              for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                lga_PageST31_listMaster
                    .get(i).LGAtotalPopulationNonIndigBySexEmployment = lga_PageST31_listTemp
                        .get(i).LGAtotalPopulationTemp;

                // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                //     lga_PageST31_listMaster.get(i).LGAname,
                //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
              }

              // calc proportional data by sex, employment for each LGA 
              for (int i = 0; i < lga_PageST31_listMaster.size(); i++) {
                lga_PageST31_listMaster.get(i).calcLGApopulationProportionalValuesBySexEmployment();
                lga_PageST31_listMaster.get(i).calcLGAgapScorePopulationProportionalValuesBySexEmployment();

                // System.out.printf("Name: %s\t\t\tLGAtotalPopulationIndig: %f\t\t\tLGAtotalPopulationIndig: %f\n",
                //     lga_PageST31_listMaster.get(i).LGAname,
                //     lga_PageST31_listMaster.get(i).LGAtotalPopulationIndig,
                //     lga_PageST31_listMaster.get(i).LGAtotalPopulationNonIndig);
              }

              if (sex_drop.equals("f")) {
                pageDataST31.sexTableDisplay = "Females";
              } else if (sex_drop.equals("m")) {
                pageDataST31.sexTableDisplay = "Males";
              }

              // Create LGA employment gap score data table
              html = html
                  + """
                      <h2>Total Population, Percentage and Gap Score within each LGA</h2>
                      <table class="table_PageST31_AgeDataGapScore">
                      <tr>
                        <th rowspan='2'>LGA Name</th>
                        <th colspan='3'>Number of Indigenous """ + " " + pageDataST31.sexTableDisplay + " " + """
                      whose employment status is """ + " " + employment_drop + " "
                  + """
                        within the LGA</th>
                      <th colspan='3'>Number of Non-Indigenous """ + " " + pageDataST31.sexTableDisplay + " "
                  + """
                      whose employment status is """ + " " + employment_drop + " "
                  + """
                            within the LGA</th>
                      </tr>
                        <th>Total</th>
                        <th>Percent</th>
                        <th>Gap Score</th>
                        <th>Total</th>
                        <th>Percent</th>
                        <th>Gap Score</th>
                        </tr>
                        """;

              for (LGA_PageST31 lga_PageST31_temp1 : lga_PageST31_listMaster) {
                html = html + "<tr>";
                html = html + "<td>" + lga_PageST31_temp1.LGAname + "</td>";
                html = html + "<td>" + lga_PageST31_temp1.LGAtotalPopulationIndigBySexEmployment + "</td>";
                html = html + "<td>" + lga_PageST31_temp1.LGApercentPopulationIndigBySexEmployment + "</td>";
                html = html + "<td>" + lga_PageST31_temp1.LGAgapScorePopulationIndigBySexEmployment + "</td>";
                html = html + "<td>" + lga_PageST31_temp1.LGAtotalPopulationNonIndigBySexEmployment + "</td>";
                html = html + "<td>" + lga_PageST31_temp1.LGApercentPopulationNonIndigBySexEmployment
                    + "</td>";
                html = html + "<td>" + lga_PageST31_temp1.LGAgapScorePopulationNonIndigBySexEmployment
                    + "</td>";
              }

              html = html + "</table>";
              html = html + "<br><br>";
            }
            // else {
            //   // If NULL, nothing to show, therefore we make some "no results" HTML
            //   html = html + "<h2><i>No Step 1 Selection</i></h2>";
            // }

        // ------------------------------------------------------------------------------------------------------
        // Close row div
        html = html + "</div></div>";

        html = html + Global.getFooter();

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
      }




    // Other methods ---------------------------------------------------------------------------------------------------------------------
    // get dropdown for age bracket
    public String getAgeBracketDropdown() {
      String html = "";

      // html = html + "<label for='agebracket_drop'>Select the Age Bracket: </label>";
      html = html + "<select id='ageBracket_drop' name='ageBracket_drop'>";

      html = html + "<option value='_0_4'>0 to 4</option>";
      html = html + "<option value='_5_9'>5 to 9</option>";
      html = html + "<option value='_10_14'>10 to 14</option>";
      html = html + "<option value='_15_19'>15 to 19</option>";
      html = html + "<option value='_20_24'>20 to 24</option>";
      html = html + "<option value='_25_29'>25 to 29</option>";
      html = html + "<option value='_30_34'>30 to 34</option>";
      html = html + "<option value='_35_39'>35 to 39</option>";
      html = html + "<option value='_40_44'>40 to 44</option>";
      html = html + "<option value='_45_49'>45 to 49</option>";
      html = html + "<option value='_50_54'>50 to 54</option>";
      html = html + "<option value='_55_59'>55 to 59</option>";
      html = html + "<option value='_60_64'>60 to 64</option>";
      html = html + "<option value='_65_yrs_ov'>Over 65</option>";
      // html = html + "<option value='all'>Any age</option>";
      html = html + "</select>";
      // html = html + "<button type='submit' class='btn btn-primary'>Submit</button>";

      return html;
    }

    // get dropdown for school completion
    public String getSchoolCompletionDropdown() {
      String html = "";

      // html = html + "<label for='school_drop'>Select a School Completion Level:</label>";
      html = html + "<select id='schoolCompletion_drop' name='schoolCompletion_drop'>";

      html = html + "<option value='did_not_go_to_school'>Did not go to school</option>";
      html = html + "<option value='y8_below'>Year 8 or below</option>";
      html = html + "<option value='y10_equiv'>Year 10 or equivalent</option>";
      html = html + "<option value='y12_equiv'>Year 12 or equivalent</option>";
      // html = html + "<option value='all'>Any age</option>";
      html = html + "</select>";
      // html = html + "<button type='submit' class='btn btn-primary'>Submit</button>";

      return html;
    }

    // get dropdown for non school qualification
    public String getNonSchoolEducationDropdown() {
      String html = "";

      // html = html + "<label for='school_drop'>Select a School Completion Level:</label>";
      html = html + "<select id='nonSchoolEducation_drop' name='nonSchoolEducation_drop'>";

      html = html + "<option value='nsq_ce_ii'>Certificate II</option>";
      html = html + "<option value='nsq_ad_dl'>Advanced Diploma</option>";
      html = html + "<option value='nsq_bdl'>Bachelor Degree</option>";
      html = html + "<option value='nsq_gd_gcl'>Graduate Diploma/Graduate Certificate</option>";
      html = html + "<option value='nsq_pgdl'>Postgraduate Degree</option>";
      // html = html + "<option value='all'>Any age</option>";
      html = html + "</select>";
      // html = html + "<button type='submit' class='btn btn-primary'>Submit</button>";

      return html;
    }

    // get dropdown for employment
    public String getEmploymentDropdown() {
      String html = "";

      // html = html + "<label for='school_drop'>Select a School Completion Level:</label>";
      html = html + "<select id='employment_drop' name='employment_drop'>";

      html = html + "<option value='in_lf_emp'>Employed</option>";
      html = html + "<option value='in_lf_unemp'>Unemplyed</option>";
      html = html + "<option value='indsec_gov'>Employed in the Government Sector</option>";
      html = html + "<option value='indsec_priv'>Employed in the Private Sector</option>";
      html = html + "<option value='self_employed'>Self Employed</option>";
      html = html + "<option value='n_the_lf'>Not in the labour force</option>";
      // html = html + "<option value='all'>Any age</option>";
      html = html + "</select>";
      // html = html + "<button type='submit' class='btn btn-primary'>Submit</button>";

      return html;
    }

    // get dropdown box for raw or percentage value
    // public String getValueTypeDropdown() {
    //   String html = "";

    //   // html = html + "<label for='valueType_drop'>Select the total number or percentage: </label>";
    //   html = html + "<select id='valueType_drop' name='valueType_drop'>";

    //   html = html + "<option value='Total Number'>Total Number</option>";
    //   html = html + "<option value='Percentage'>Percentage</option>";

    //   html = html + "</select>";
    //   // html = html + "<button type='submit' class='btn btn-primary'>Submit</button>";

    //   return html;
    // }

    // get dropdown box for sex
    public String getSexDropdown() {
      String html = "";

      // html = html + "<label for='valueType_drop'>Select the total number or percentage: </label>";
      html = html + "<select id='sex_drop' name='sex_drop'>";

      html = html + "<option value='f'>Female</option>";
      html = html + "<option value='m'>Male</option>";
      // html = html + "<option value='any'>Any Sex</option>";

      html = html + "</select>";
      // html = html + "<button type='submit' class='btn btn-primary'>Submit</button>";

      return html;
    }
}
