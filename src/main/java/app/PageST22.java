package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/* @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
* @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au */
public class PageST22 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/PageST22.html";

    // Object for storing all data used in this page
    public PageDataMatt PageST22Data = new PageDataMatt();

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 2.2</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // html = html + Global.getTopNav();  
        String headerText = "Age and School Completion Data by LGA";

        html = html + Global.getHeader(headerText);
        html = html + Global.getNavBar();

        // Add Div for page Content
        // html = html + "<div class='content'>";

        // html = html + """

        //         <!-- The flexible grid (content) -->
        //         <div class="row">
        //         <div class="main">
        //         <h1>2.2 Focused view of Socioeconomic Outcomes by LGA</h1>
        //         <br>
        //         <br>
        //         """;

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Next we will ask this *class* for the LGAs
        ArrayList<LGA> lgas = jdbc.getLGAs();

        html = html + "<div class='row'><div class='main'><br><br>";

        html = html + "<fieldset>";
        html = html + "<legend><h3>Step 1:</h3></legend>";

        html = html + "<form action='/PageST22.html' method='post'>";

        html = html + "   <div class='form-group'>";
        html = html + "      <label for='LGA_drop'>Select the LGA:</label>";
        html = html + "      <select id='LGA_drop' name='LGA_drop'>";
        html = html + "      <br>";

        // Add all of the LGAs to drop down menu
        for (LGA lga : lgas) {
            html = html + "<option>" + lga.getName16() + "</option>";
        }

        html = html + "      </select>";
        html = html + "   <button type='submit' class='btn btn-primary'>Get LGA Data</button>";
        html = html + "   </div>";


        html = html + "</form>";


        // Get the Form Data from the drop down list
        String LGA_drop = context.formParam("LGA_drop");

        if (LGA_drop == null) {
            // If NULL, nothing to show, therefore we make some "no results" HTML
            html = html + "<h3><i>No Results to show for dropbox</i></h3>";
        } else {
            // If NOT NULL, then lookup the LGA data!
            html = html + "<br>";

            html = html + outputLGAdataTable(LGA_drop);

            // Raw Data LGA queries --------------------------------------------------------------------
        String query;

        PageST22Data.totalIndigLGA_0_4 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_0_4");
        PageST22Data.totalNonIndigLGA_0_4 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig", "_0_4");

        PageST22Data.totalIndigLGA_5_9 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_5_9");
        PageST22Data.totalNonIndigLGA_5_9 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig", "_5_9");

        PageST22Data.totalIndigLGA_10_14 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_10_14");
        PageST22Data.totalNonIndigLGA_10_14 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_10_14");

        PageST22Data.totalIndigLGA_15_19 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_15_19");
        PageST22Data.totalNonIndigLGA_15_19 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_15_19");

        PageST22Data.totalIndigLGA_20_24 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_20_24");
        PageST22Data.totalNonIndigLGA_20_24 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_20_24");

        PageST22Data.totalIndigLGA_25_29 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_25_29");
        PageST22Data.totalNonIndigLGA_25_29 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_25_29");

        PageST22Data.totalIndigLGA_30_34 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_30_34");
        PageST22Data.totalNonIndigLGA_30_34 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_30_34");

        PageST22Data.totalIndigLGA_35_39 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_35_39");
        PageST22Data.totalNonIndigLGA_35_39 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_35_39");

        PageST22Data.totalIndigLGA_40_44 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_40_44");
        PageST22Data.totalNonIndigLGA_40_44 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_40_44");

        PageST22Data.totalIndigLGA_45_49 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_45_49");
        PageST22Data.totalNonIndigLGA_45_49 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_45_49");

        PageST22Data.totalIndigLGA_50_54 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_50_54");
        PageST22Data.totalNonIndigLGA_50_54 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_50_54");

        PageST22Data.totalIndigLGA_55_59 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_55_59");
        PageST22Data.totalNonIndigLGA_55_59 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_55_59");

        PageST22Data.totalIndigLGA_60_64 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig", "_55_59");
        PageST22Data.totalNonIndigLGA_60_64 = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_55_59");

        PageST22Data.totalIndigLGA_65_ov = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "indig","_65_yrs_ov");
        PageST22Data.totalNonIndigLGA_65_ov = jdbc.getTotalIndigStatusLGAbyAge(PageST22Data.LGAcode, "non_indig","_65_yrs_ov");

        // Get total indiginous in lga did not go to school
        query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted WHERE LGA_CODE16 = '"
                + PageST22Data.LGAcode
                + "' AND INDIGENOUS_STATUS = 'indig' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED =  'did_not_go_to_school' ";

        ArrayList<Integer> totalIndig_notSchool_List = jdbc.getTotalPopulation(query);
        PageST22Data.totalIndigLGA_notSchool = totalIndig_notSchool_List.get(0).intValue();

        // Get total NON indiginous in lga did not go to school
        query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted WHERE LGA_CODE16 = '"
                + PageST22Data.LGAcode
                + "' AND INDIGENOUS_STATUS = 'non_indig' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED =  'did_not_go_to_school' ";

        ArrayList<Integer> totalNonIndig_notSchool_List = jdbc.getTotalPopulation(query);
        PageST22Data.totalNonIndigLGA_notSchool = totalNonIndig_notSchool_List.get(0).intValue();

        // Get total indiginous in lga completed year 8 or below
        query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted WHERE LGA_CODE16 = '"
                + PageST22Data.LGAcode
                + "' AND INDIGENOUS_STATUS = 'indig' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED =  'y8_below' ";

        ArrayList<Integer> totalIndig_y8_List = jdbc.getTotalPopulation(query);
        PageST22Data.totalIndigLGA_y8 = totalIndig_y8_List.get(0).intValue();

        // Get total NON indiginous in lga completed year 8 or below
        query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted WHERE LGA_CODE16 = '"
                + PageST22Data.LGAcode
                + "' AND INDIGENOUS_STATUS = 'non_indig' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED =  'y8_below' ";

        ArrayList<Integer> totalNonIndig_y8_List = jdbc.getTotalPopulation(query);
        PageST22Data.totalNonIndigLGA_y8 = totalNonIndig_y8_List.get(0).intValue();

        // Get total indiginous in lga completed year 10 or equiv
        query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted WHERE LGA_CODE16 = '"
                + PageST22Data.LGAcode
                + "' AND INDIGENOUS_STATUS = 'indig' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED =  'y10_equiv' ";

        ArrayList<Integer> totalIndig_y10_List = jdbc.getTotalPopulation(query);
        PageST22Data.totalIndigLGA_y10 = totalIndig_y10_List.get(0).intValue();

        // Get total NON indiginous in lga completed year 10 or equiv
        query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted WHERE LGA_CODE16 = '"
                + PageST22Data.LGAcode
                + "' AND INDIGENOUS_STATUS = 'non_indig' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED =  'y10_equiv' ";

        ArrayList<Integer> totalNonIndig_y10_List = jdbc.getTotalPopulation(query);
        PageST22Data.totalNonIndigLGA_y10 = totalNonIndig_y10_List.get(0).intValue();

        // Get total indiginous in lga completed year 12 or equiv
        query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted WHERE LGA_CODE16 = '"
                + PageST22Data.LGAcode
                + "' AND INDIGENOUS_STATUS = 'indig' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED =  'y12_equiv' ";

        ArrayList<Integer> totalIndig_y12_List = jdbc.getTotalPopulation(query);
        PageST22Data.totalIndigLGA_y12 = totalIndig_y12_List.get(0).intValue();

        // Get total NON indiginous in lga completed year 12 or equiv
        query = "SELECT SUM(COUNT) AS SUM FROM HighestYearSchoolCompleted WHERE LGA_CODE16 = '"
                + PageST22Data.LGAcode
                + "' AND INDIGENOUS_STATUS = 'non_indig' AND HIGHEST_YEAR_OF_SCHOOL_COMPLETED =  'y12_equiv' ";

        ArrayList<Integer> totalNonIndig_y12_List = jdbc.getTotalPopulation(query);
        PageST22Data.totalNonIndigLGA_y12 = totalNonIndig_y12_List.get(0).intValue();

        // Creat LGA raw data table
        html = html + """
            <h2> """ + PageST22Data.LGAname + """
                          LGA Raw Data</h2>

            <table class="horizontal_table">
              <tr>
                <th>Data Description (Within the LGA population)</th>
                <th>Indigenous</th>
                <th>Non-Indiginous</th>
              </tr>
              <tr>
              <td>Total number of Indigenous and non-Indiginous people aged 0 to 4</td>
              <td>""" + PageST22Data.totalIndigLGA_0_4 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_0_4 + """
            </td>
            </tr>
            <tr>
            <td>Total number of Indigenous and non-Indiginous people aged 5 to 9</td>
            <td>""" + PageST22Data.totalIndigLGA_5_9 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_5_9 + """
            </td>
            </tr>
            <tr>
            <td>Total number of Indigenous and non-Indiginous people aged 10 to 14</td>
            <td>""" + PageST22Data.totalIndigLGA_10_14 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_10_14 + """
            </td>
            </tr>
              <tr>
                <td>Total number of Indigenous and non-Indiginous people aged 15 to 19</td>
                <td>""" + PageST22Data.totalIndigLGA_15_19 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_15_19 + """
                  </td>
              </tr>
            <tr>
            <td>Total number of Indigenous and non-Indiginous people aged 20 to 24</td>
            <td>""" + PageST22Data.totalIndigLGA_20_24 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_20_24 + """
                </td>
              </tr>
            <tr>
              <td>Total number of Indigenous and non-Indiginous people aged 25 to 29</td>
              <td>""" + PageST22Data.totalIndigLGA_25_29 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_25_29 + """
                </td>
            </tr>
            <tr>
            <td>Total number of Indigenous and non-Indiginous people aged 30 to 34</td>
            <td>""" + PageST22Data.totalIndigLGA_30_34 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_30_34 + """
                </td>
            </tr>
            <tr>
              <td>Total number of Indigenous and non-Indiginous people aged 35 to 39</td>
              <td>""" + PageST22Data.totalIndigLGA_35_39 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_35_39 + """
                </td>
            </tr>
            <tr>
              <td>Total number of Indigenous and non-Indiginous people aged 40 to 44</td>
              <td>""" + PageST22Data.totalIndigLGA_40_44 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_40_44 + """
                </td>
            </tr>
            <tr>
              <td>Total number of Indigenous and non-Indiginous people aged 45 to 49</td>
              <td>""" + PageST22Data.totalIndigLGA_45_49 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_45_49 + """
                </td>
            </tr>
            <tr>
              <td>Total number of Indigenous and non-Indiginous people aged 50 to 54</td>
              <td>""" + PageST22Data.totalIndigLGA_50_54 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_50_54 + """
                </td>
            </tr>
            <tr>
              <td>Total number of Indigenous and non-Indiginous people aged 55 to 59</td>
              <td>""" + PageST22Data.totalIndigLGA_55_59 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_55_59 + """
                </td>
            </tr>
            <tr>
              <td>Total number of Indigenous and non-Indiginous people aged 60 to 64</td>
              <td>""" + PageST22Data.totalIndigLGA_60_64 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_60_64 + """
                </td>
            </tr>
            <tr>
              <td>Total number of Indigenous and non-Indiginous people aged over 65</td>
              <td>""" + PageST22Data.totalIndigLGA_65_ov + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_65_ov + """
                </td>
            </tr>
              <tr>
              <td>Total number of Indigenous and non-Indiginous people who did not go to school</td>
            <td>""" + PageST22Data.totalIndigLGA_notSchool + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_notSchool + """
                  </td>
              </tr>
              <tr>
            <td>Total number of Indigenous and non-Indiginous people who completed year 8 or below</td>
            <td>""" + PageST22Data.totalIndigLGA_y8 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_y8 + """
                    </td>
              </tr>
              <td>Total number of Indigenous and non-Indiginous people who completed year 10 or equivalent</td>
            <td>""" + PageST22Data.totalIndigLGA_y10 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_y10 + """
                      </td>
              </tr>
              <tr>
              <td>Total number of Indigenous and non-Indiginous people who completed year 12 or equivalent</td>
            <td>""" + PageST22Data.totalIndigLGA_y12 + """
                </td>
            <td>""" + PageST22Data.totalNonIndigLGA_y12 + """
                      </td>
              </tr>
            </table>
            <br>
            <br>
            """;

      }

      html = html + "</fieldset>";

      html = html + "<br>";
      html = html + "<br>";

        // PROPORTIONAL DATA ------------------------------------------------------

        html = html + "<fieldset>";
        html = html + "<legend><h3>Step 2:</h3></legend>";

        // Proportional data view selection radio buttons
        html = html
            + """
                  <h3>Select which proportional values to view (by LGA, State or Australia):</h3>
                  <form action='/PageST22.html' method='post'>
                  <div class='form-group'>
                    <input type='checkbox' id='proportionalDataViewCheckByLGA' name='proportionalDataViewCheckByLGA' value='byLGA'>
                    <label for='proportionalDataViewCheckByLGA'>LGA Proportional Data</label><br>
                    <input type='checkbox' id='proportionalDataViewCheckByState' name='proportionalDataViewCheckByState' value='byState'>
                    <label for='proportionalDataViewCheckByState'>State Proportional Data</label><br>
                    <input type='checkbox' id='proportionalDataViewCheckByAustralia' name='proportionalDataViewCheckByAustralia' value='byAustralia'>
                    <label for='proportionalDataViewCheckByAustralia'>Australian Proportional Data</label>
                    <br>
                    <br>
                    <button type='submit' class='btn btn-primary'>View Data</button>
                  </div>
                  </form>
                """;

        html = html + "</fieldset>";
        html = html + "<br>";

        // Get the Form Data from the check box list
        String proportionalDataViewCheckByLGA = context.formParam("proportionalDataViewCheckByLGA");
        String proportionalDataViewCheckByState = context.formParam("proportionalDataViewCheckByState");
        String proportionalDataViewCheckByAustralia = context.formParam("proportionalDataViewCheckByAustralia");

        // if (proportionalDataViewCheckByLGA == null) {
        //   html = html + "<h3>No LGA View Selected</h3>";

        // } else 

        if (proportionalDataViewCheckByLGA != null) {
          // LGA PROPORTIONAL DATA -------------------------------------------------------------------------------
          // get total indig population of LGA
          String query = "SELECT SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS WHERE LGA_CODE16 = '"
              + PageST22Data.LGAcode
              + "' AND INDIGENOUS_STATUS = 'indig'";

          ArrayList<Integer> LGAtotalPopulation = jdbc.getTotalPopulation(query);
          PageST22Data.LGAtotalPopulationIndig = LGAtotalPopulation.get(0).intValue();

          // get total NON indig population of LGA
          query = "SELECT SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS WHERE LGA_CODE16 = '" + PageST22Data.LGAcode
              + "' AND INDIGENOUS_STATUS = 'non_indig'";

          LGAtotalPopulation = jdbc.getTotalPopulation(query);
          PageST22Data.LGAtotalPopulationNonIndig = LGAtotalPopulation.get(0).intValue();

          PageST22Data.calculateLGAproportionalData();

          // Create LGA proportional data table
          html = html + """
              <h2>""" + PageST22Data.LGAname + """
                        LGA Proportional Data</h2>

              <table class="horizontal_table">
                <tr>
                  <th>Data Description (Within the LGA population)</th>
                  <th>Indigenous (%)</th>
                  <th>Non-Indiginous (%)</th>
                </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 0 to 4</td>
                <td>""" + PageST22Data.percentIndigLGA_0_4 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_0_4 + """
              </td>
              </tr>
              <tr>
              <td>Percentage of Indigenous and non-Indiginous people aged 5 to 9</td>
              <td>""" + PageST22Data.percentIndigLGA_5_9 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_5_9 + """
              </td>
              </tr>
              <tr>
              <td>Percentage of Indigenous and non-Indiginous people aged 10 to 14</td>
              <td>""" + PageST22Data.percentIndigLGA_10_14 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_10_14 + """
              </td>
              </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 15 to 19</td>
                  <td>""" + PageST22Data.percentIndigLGA_15_19 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_15_19 + """
                    </td>
                </tr>
              <tr>
              <td>Percentage of Indigenous and non-Indiginous people aged 20 to 24</td>
              <td>""" + PageST22Data.percentIndigLGA_20_24 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_20_24 + """
                  </td>
                </tr>
              <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 25 to 29</td>
                <td>""" + PageST22Data.percentIndigLGA_25_29 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_25_29 + """
                  </td>
              </tr>
              <tr>
              <td>Percentage of Indigenous and non-Indiginous people aged 30 to 34</td>
              <td>""" + PageST22Data.percentIndigLGA_30_34 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_30_34 + """
                  </td>
              </tr>
              <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 35 to 39</td>
                <td>""" + PageST22Data.percentIndigLGA_35_39 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_35_39 + """
                  </td>
              </tr>
              <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 40 to 44</td>
                <td>""" + PageST22Data.percentIndigLGA_40_44 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_40_44 + """
                  </td>
              </tr>
              <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 45 to 49</td>
                <td>""" + PageST22Data.percentIndigLGA_45_49 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_45_49 + """
                  </td>
              </tr>
              <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 50 to 54</td>
                <td>""" + PageST22Data.percentIndigLGA_50_54 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_50_54 + """
                  </td>
              </tr>
              <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 55 to 59</td>
                <td>""" + PageST22Data.percentIndigLGA_55_59 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_55_59 + """
                  </td>
              </tr>
              <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 60 to 64</td>
                <td>""" + PageST22Data.percentIndigLGA_60_64 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_60_64 + """
                  </td>
              </tr>
              <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged over 65</td>
                <td>""" + PageST22Data.percentIndigLGA_65_ov + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_65_ov + """
                  </td>
              </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people who did not go to school</td>
              <td>""" + PageST22Data.percentIndigLGA_notSchool + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_notSchool + """
                    </td>
                </tr>
                <tr>
              <td>Percentage of Indigenous and non-Indiginous people who completed year 8 or below</td>
              <td>""" + PageST22Data.percentIndigLGA_y8 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_y8 + """
                      </td>
                </tr>
                <td>Percentage of Indigenous and non-Indiginous people who completed year 10 or equivalent</td>
              <td>""" + PageST22Data.percentIndigLGA_y10 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_y10 + """
                        </td>
                </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people who completed year 12 or equivalent</td>
              <td>""" + PageST22Data.percentIndigLGA_y12 + """
                  </td>
              <td>""" + PageST22Data.percentNonIndigLGA_y12 + """
                        </td>
                </tr>
              </table>
              <br>
              <br>
              """;
        }

        if (proportionalDataViewCheckByState != null) {
          // -----------------------------------------------------------------------------------------------------------
          // STATE DATA
          // get total population data of each state

          // // Get state total combined population
          // query = "SELECT S.STATE_NAME, SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS P JOIN STATE S ON P.LGA_CODE16 = S.LGA_CODE16 WHERE S.STATE_NAME = '" + PageST22Data.LGAstate + "'";

          // ArrayList<Integer> stateTotalPopulationTemp = jdbc.getTotalPopulation(query);
          // PageST22Data.stateTotalPopulation = stateTotalPopulationTemp.get(0).intValue();

          // Get state total indig population
          String query = "SELECT S.STATE_NAME, SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS P JOIN STATE S ON P.LGA_CODE16 = S.LGA_CODE16 WHERE S.STATE_NAME = '"
              + PageST22Data.LGAstate + "' AND INDIGENOUS_STATUS = 'indig' ";

          ArrayList<Integer> stateTotalPopulationTemp = jdbc.getTotalPopulation(query);
          PageST22Data.stateTotalPopulationIndig = stateTotalPopulationTemp.get(0).intValue();

          // Get state total NON indig population
          query = "SELECT S.STATE_NAME, SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS P JOIN STATE S ON P.LGA_CODE16 = S.LGA_CODE16 WHERE S.STATE_NAME = '"
              + PageST22Data.LGAstate + "' AND INDIGENOUS_STATUS = 'non_indig' ";

          stateTotalPopulationTemp = jdbc.getTotalPopulation(query);
          PageST22Data.stateTotalPopulationNonIndig = stateTotalPopulationTemp.get(0).intValue();

          // Raw Data state queries -------------------------------------------------------------------------------------------------------------------
          PageST22Data.totalIndigState_0_4 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "indig", "_0_4");
          PageST22Data.totalNonIndigState_0_4 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "non_indig", "_0_4");

          PageST22Data.totalIndigState_5_9 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "indig", "_5_9");
          PageST22Data.totalNonIndigState_5_9 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "non_indig", "_5_9");

            PageST22Data.totalIndigState_10_14 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "indig", "_10_14");
            PageST22Data.totalNonIndigState_10_14 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "non_indig", "_10_14");

            PageST22Data.totalIndigState_15_19 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "indig", "_15_19");
            PageST22Data.totalNonIndigState_15_19 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "non_indig", "_15_19");

            PageST22Data.totalIndigState_20_24 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "indig", "_20_24");
            PageST22Data.totalNonIndigState_20_24 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "non_indig", "_20_24");

            PageST22Data.totalIndigState_25_29 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "indig", "_25_29");
            PageST22Data.totalNonIndigState_25_29 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "non_indig", "_25_29");

            PageST22Data.totalIndigState_30_34 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "indig", "_30_34");
            PageST22Data.totalNonIndigState_30_34 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "non_indig", "_30_34");

            PageST22Data.totalIndigState_35_39 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "indig", "_35_39");
            PageST22Data.totalNonIndigState_35_39 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
                "non_indig", "_35_39");

          PageST22Data.totalIndigState_40_44 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "indig", "_40_44");
          PageST22Data.totalNonIndigState_40_44 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "non_indig", "_40_44");

          PageST22Data.totalIndigState_45_49 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "indig", "_45_49");
          PageST22Data.totalNonIndigState_45_49 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "non_indig", "_45_49");

          PageST22Data.totalIndigState_50_54 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "indig", "_50_54");
          PageST22Data.totalNonIndigState_50_54 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "non_indig", "_50_54");

          PageST22Data.totalIndigState_55_59 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "indig", "_55_59");
          PageST22Data.totalNonIndigState_55_59 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "non_indig", "_55_59");

          PageST22Data.totalIndigState_60_64 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "indig", "_55_59");
          PageST22Data.totalNonIndigState_60_64 = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "non_indig", "_55_59");

          PageST22Data.totalIndigState_65_ov = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "indig", "_65_yrs_ov");
          PageST22Data.totalNonIndigState_65_ov = jdbc.getTotalPopulationStateByIndigStatus_Age(PageST22Data.LGAstate,
              "non_indig", "_65_yrs_ov");

          // get state school completion data
          PageST22Data.totalIndigState_notSchool = jdbc.getTotalPopulationStateByIndigStatus_schoolCompletion(
              PageST22Data.LGAstate, "indig", "did_not_go_to_school");
          PageST22Data.totalNonIndigState_notSchool = jdbc.getTotalPopulationStateByIndigStatus_schoolCompletion(
              PageST22Data.LGAstate, "non_indig", "did_not_go_to_school");

          PageST22Data.totalIndigState_y8 = jdbc
              .getTotalPopulationStateByIndigStatus_schoolCompletion(PageST22Data.LGAstate, "indig", "y8_below");
          PageST22Data.totalNonIndigState_y8 = jdbc
              .getTotalPopulationStateByIndigStatus_schoolCompletion(PageST22Data.LGAstate, "non_indig", "y8_below");

            PageST22Data.totalIndigState_y10 = jdbc
                .getTotalPopulationStateByIndigStatus_schoolCompletion(PageST22Data.LGAstate, "indig", "y10_equiv");
            PageST22Data.totalNonIndigState_y10 = jdbc
                .getTotalPopulationStateByIndigStatus_schoolCompletion(PageST22Data.LGAstate, "non_indig", "y10_equiv");

            PageST22Data.totalIndigState_y12 = jdbc
                .getTotalPopulationStateByIndigStatus_schoolCompletion(PageST22Data.LGAstate, "indig", "y12_equiv");
            PageST22Data.totalNonIndigState_y12 = jdbc
                .getTotalPopulationStateByIndigStatus_schoolCompletion(PageST22Data.LGAstate, "non_indig", "y12_equiv");

            // calculate state proportional data ------------------------------------------------------------------------
            PageST22Data.calculateStateProportionalData();


            // Creat state proportional data table
            html = html + """
                <h2> """ + PageST22Data.LGAstate + """
                              State Proportional Data</h2>

                <table class="horizontal_table">
                  <tr>
                    <th>Data Description (Within the State population)</th>
                    <th>Indigenous (%)</th>
                    <th>Non-Indiginous (%)</th>
                  </tr>
                  <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 0 to 4</td>
                  <td>""" + PageST22Data.percentIndigState_0_4 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_0_4 + """
                </td>
                </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 5 to 9</td>
                <td>""" + PageST22Data.percentIndigState_5_9 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_5_9 + """
                </td>
                </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 10 to 14</td>
                <td>""" + PageST22Data.percentIndigState_10_14 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_10_14 + """
                </td>
                </tr>
                  <tr>
                    <td>Percentage of Indigenous and non-Indiginous people aged 15 to 19</td>
                    <td>""" + PageST22Data.percentIndigState_15_19 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_15_19 + """
                      </td>
                  </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 20 to 24</td>
                <td>""" + PageST22Data.percentIndigState_20_24 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_20_24 + """
                    </td>
                  </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 25 to 29</td>
                  <td>""" + PageST22Data.percentIndigState_25_29 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_25_29 + """
                    </td>
                </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 30 to 34</td>
                <td>""" + PageST22Data.percentIndigState_30_34 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_30_34 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 35 to 39</td>
                  <td>""" + PageST22Data.percentIndigState_35_39 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_35_39 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 40 to 44</td>
                  <td>""" + PageST22Data.percentIndigState_40_44 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_40_44 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 45 to 49</td>
                  <td>""" + PageST22Data.percentIndigState_45_49 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_45_49 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 50 to 54</td>
                  <td>""" + PageST22Data.percentIndigState_50_54 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_50_54 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 55 to 59</td>
                  <td>""" + PageST22Data.percentIndigState_55_59 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_55_59 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 60 to 64</td>
                  <td>""" + PageST22Data.percentIndigState_60_64 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_60_64 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged over 65</td>
                  <td>""" + PageST22Data.percentIndigState_65_ov + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_65_ov + """
                    </td>
                </tr>
                  <tr>
                  <td>Percentage of Indigenous and non-Indiginous people who did not go to school</td>
                <td>""" + PageST22Data.percentIndigState_notSchool + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_notSchool + """
                      </td>
                  </tr>
                  <tr>
                <td>Percentage of Indigenous and non-Indiginous people who completed year 8 or below</td>
                <td>""" + PageST22Data.percentIndigState_y8 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_y8 + """
                        </td>
                  </tr>
                  <td>Percentage of Indigenous and non-Indiginous people who completed year 10 or equivalent</td>
                <td>""" + PageST22Data.percentIndigState_y10 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_y10 + """
                          </td>
                  </tr>
                  <tr>
                  <td>Percentage of Indigenous and non-Indiginous people who completed year 12 or equivalent</td>
                <td>""" + PageST22Data.percentIndigState_y12 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigState_y12 + """
                          </td>
                  </tr>
                </table>
                <br>
                <br>
                """;
          }

          if (proportionalDataViewCheckByAustralia != null) {
            // ---------------------------------------------------------------------------------------------------------    
            // AUSTRALIAN DATA

            // Get Australian total indig population
            String query = "SELECT SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS WHERE INDIGENOUS_STATUS = 'indig'";

            ArrayList<Integer> australiaTotalPopulationTemp = jdbc.getTotalPopulation(query);
            PageST22Data.australiaTotalPopulationIndig = australiaTotalPopulationTemp.get(0).intValue();

            // Get Australia total NON indig population
            query = "SELECT SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS WHERE INDIGENOUS_STATUS = 'non_indig'";

            australiaTotalPopulationTemp = jdbc.getTotalPopulation(query);
            PageST22Data.australiaTotalPopulationNonIndig = australiaTotalPopulationTemp.get(0).intValue();

            // Raw Data national queries -------------------------------------------------------------------------------------------------------------------
            PageST22Data.totalIndigAustralia_0_4 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig", "_0_4");
            PageST22Data.totalNonIndigAustralia_0_4 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_0_4");

            PageST22Data.totalIndigAustralia_5_9 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig", "_5_9");
            PageST22Data.totalNonIndigAustralia_5_9 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_5_9");

            PageST22Data.totalIndigAustralia_10_14 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_10_14");
            PageST22Data.totalNonIndigAustralia_10_14 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_10_14");

            PageST22Data.totalIndigAustralia_15_19 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_15_19");
            PageST22Data.totalNonIndigAustralia_15_19 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_15_19");

            PageST22Data.totalIndigAustralia_20_24 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_20_24");
            PageST22Data.totalNonIndigAustralia_20_24 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_20_24");

            PageST22Data.totalIndigAustralia_25_29 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_25_29");
            PageST22Data.totalNonIndigAustralia_25_29 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_25_29");

            PageST22Data.totalIndigAustralia_30_34 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_30_34");
            PageST22Data.totalNonIndigAustralia_30_34 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_30_34");

            PageST22Data.totalIndigAustralia_35_39 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_35_39");
            PageST22Data.totalNonIndigAustralia_35_39 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_35_39");

            PageST22Data.totalIndigAustralia_40_44 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_40_44");
            PageST22Data.totalNonIndigAustralia_40_44 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_40_44");

            PageST22Data.totalIndigAustralia_45_49 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_45_49");
            PageST22Data.totalNonIndigAustralia_45_49 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_45_49");

            PageST22Data.totalIndigAustralia_50_54 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_50_54");
            PageST22Data.totalNonIndigAustralia_50_54 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_50_54");

            PageST22Data.totalIndigAustralia_55_59 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_55_59");
            PageST22Data.totalNonIndigAustralia_55_59 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_55_59");

            PageST22Data.totalIndigAustralia_60_64 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_55_59");
            PageST22Data.totalNonIndigAustralia_60_64 = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_55_59");

            PageST22Data.totalIndigAustralia_65_ov = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("indig",
                "_65_yrs_ov");
            PageST22Data.totalNonIndigAustralia_65_ov = jdbc.getTotalPopulationAustraliaByIndigStatus_Age("non_indig",
                "_65_yrs_ov");

            // get Australia school completion data
            PageST22Data.totalIndigAustralia_notSchool = jdbc
                .getTotalPopulationAustraliaByIndigStatus_schoolCompletion("indig", "did_not_go_to_school");
            PageST22Data.totalNonIndigAustralia_notSchool = jdbc
                .getTotalPopulationAustraliaByIndigStatus_schoolCompletion("non_indig", "did_not_go_to_school");

            PageST22Data.totalIndigAustralia_y8 = jdbc
                .getTotalPopulationAustraliaByIndigStatus_schoolCompletion("indig", "y8_below");
            PageST22Data.totalNonIndigAustralia_y8 = jdbc
                .getTotalPopulationAustraliaByIndigStatus_schoolCompletion("non_indig", "y8_below");

            PageST22Data.totalIndigAustralia_y10 = jdbc
                .getTotalPopulationAustraliaByIndigStatus_schoolCompletion("indig", "y10_equiv");
            PageST22Data.totalNonIndigAustralia_y10 = jdbc
                .getTotalPopulationAustraliaByIndigStatus_schoolCompletion("non_indig", "y10_equiv");

            PageST22Data.totalIndigAustralia_y12 = jdbc
                .getTotalPopulationAustraliaByIndigStatus_schoolCompletion("indig", "y12_equiv");
            PageST22Data.totalNonIndigAustralia_y12 = jdbc
                .getTotalPopulationAustraliaByIndigStatus_schoolCompletion("non_indig", "y12_equiv");

            // calculate Australian proportional data ------------------------------------------------------------------------
            PageST22Data.calculateAustraliaProportionalData();

            // Create Australian proportional data table
            html = html + """
                      <h2>Australian Proportional Data</h2>

                <table class="horizontal_table">
                  <tr>
                    <th>Data Description (Within Australia population)</th>
                    <th>Indigenous (%)</th>
                    <th>Non-Indiginous (%)</th>
                  </tr>
                  <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 0 to 4</td>
                  <td>""" + PageST22Data.percentIndigAustralia_0_4 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_0_4 + """
                </td>
                </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 5 to 9</td>
                <td>""" + PageST22Data.percentIndigAustralia_5_9 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_5_9 + """
                </td>
                </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 10 to 14</td>
                <td>""" + PageST22Data.percentIndigAustralia_10_14 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_10_14 + """
                </td>
                </tr>
                  <tr>
                    <td>Percentage of Indigenous and non-Indiginous people aged 15 to 19</td>
                    <td>""" + PageST22Data.percentIndigAustralia_15_19 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_15_19 + """
                      </td>
                  </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 20 to 24</td>
                <td>""" + PageST22Data.percentIndigAustralia_20_24 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_20_24 + """
                    </td>
                  </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 25 to 29</td>
                  <td>""" + PageST22Data.percentIndigAustralia_25_29 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_25_29 + """
                    </td>
                </tr>
                <tr>
                <td>Percentage of Indigenous and non-Indiginous people aged 30 to 34</td>
                <td>""" + PageST22Data.percentIndigAustralia_30_34 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_30_34 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 35 to 39</td>
                  <td>""" + PageST22Data.percentIndigAustralia_35_39 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_35_39 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 40 to 44</td>
                  <td>""" + PageST22Data.percentIndigAustralia_40_44 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_40_44 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 45 to 49</td>
                  <td>""" + PageST22Data.percentIndigAustralia_45_49 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_45_49 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 50 to 54</td>
                  <td>""" + PageST22Data.percentIndigAustralia_50_54 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_50_54 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 55 to 59</td>
                  <td>""" + PageST22Data.percentIndigAustralia_55_59 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_55_59 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged 60 to 64</td>
                  <td>""" + PageST22Data.percentIndigAustralia_60_64 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_60_64 + """
                    </td>
                </tr>
                <tr>
                  <td>Percentage of Indigenous and non-Indiginous people aged over 65</td>
                  <td>""" + PageST22Data.percentIndigAustralia_65_ov + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_65_ov + """
                    </td>
                </tr>
                  <tr>
                  <td>Percentage of Indigenous and non-Indiginous people who did not go to school</td>
                <td>""" + PageST22Data.percentIndigAustralia_notSchool + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_notSchool + """
                      </td>
                  </tr>
                  <tr>
                <td>Percentage of Indigenous and non-Indiginous people who completed year 8 or below</td>
                <td>""" + PageST22Data.percentIndigAustralia_y8 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_y8 + """
                        </td>
                  </tr>
                  <td>Percentage of Indigenous and non-Indiginous people who completed year 10 or equivalent</td>
                <td>""" + PageST22Data.percentIndigAustralia_y10 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_y10 + """
                          </td>
                  </tr>
                  <tr>
                  <td>Percentage of Indigenous and non-Indiginous people who completed year 12 or equivalent</td>
                <td>""" + PageST22Data.percentIndigAustralia_y12 + """
                    </td>
                <td>""" + PageST22Data.percentNonIndigAustralia_y12 + """
                          </td>
                  </tr>
                </table>
                <br>
                <br>
                """;

          }

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

    // Methods --------------------------------------------------------------------------------------------------------
    // create the PageST22 LGA data table
    public String outputLGAdataTable(String lga) {
        String html = "";
        html = html + "<h2>" + lga + " LGA Data</h2>";

        // Look up LGA data from JDBC
        JDBCConnection jdbc = new JDBCConnection(); 

        ArrayList<LGAExtended> LGAtableData = jdbc.getLGAtableData(lga);

        PageST22Data.LGAcode = LGAtableData.get(0).code16;
        PageST22Data.LGAname = LGAtableData.get(0).name16;
        PageST22Data.LGAtype = LGAtableData.get(0).type16;
        PageST22Data.LGAarea = LGAtableData.get(0).area16;

        // get total combined population of LGA
        String query = "SELECT SUM(COUNT) AS SUM FROM POPULATIONSTATISTICS WHERE LGA_CODE16 = '" + PageST22Data.LGAcode
            + "' ";

        ArrayList<Integer> totalPopulation = jdbc.getTotalPopulation(query);
        PageST22Data.LGAtotalPopulation = totalPopulation.get(0).intValue();

        // Determine state from lga code
        PageST22Data.LGAstate = Global.getState(PageST22Data.LGAcode);

        // Add HTML for the LGA table
        html = html + """
                <table class="verticle_table">
                <tr>
                  <th>LGA</th>
                  <td>""" + PageST22Data.LGAname + """
                      </td>
                </tr>
                <tr>
                  <th>State</th>
                <td>""" + PageST22Data.LGAstate + """
                      </td>
                </tr>
                <tr>
                  <th>Type</th>
                  <td>""" + PageST22Data.LGAtype + """
                      </td>
                </tr>
                <tr>
                  <th>Area</th>
                  <td>""" + PageST22Data.LGAarea + """
                      </td>
                </tr>
                <tr>
                  <th>Total Population</th>
            <td>""" + PageST22Data.LGAtotalPopulation + """
                        </td>
                  </tr>
                </table>
                <br>
                <br>
                      """;

        return html;
    }


}
