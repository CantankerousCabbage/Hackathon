package app.semster1;

/**
 * Class represeting a LGA from the Studio Project database
 * In the template, this only uses the code and name for 2016
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class LGA_PageST31 {
   // LGA 2016 Code
   public int code16;

   // LGA 2016 Name
   public String name16;

   // LGA 2016 type
   public String type16;

   // LGA 2016 area
   public double area16;

   //Population Count
   public int populationCount;

   // LGA variables ---------------------------------------------------------------------------------------
   public int LGAcode = 0; //  lga code
   public String LGAname; //  lga name
   public String LGAtype; //  lga type
   public double LGAarea = 0; //  lga area
   public String LGAstate; //  The state the lga is located in

   // LGA population total variables ---------------------------------------------------------------------------------------
   public double LGAtotalPopulationIndig = 1; //  lga total population indig
   public double LGAtotalPopulationNonIndig = 1; //  lga total population non indig

   public double LGAtotalPopulationIndigBySexAge = 1; //  lga total population indig
   public double LGAtotalPopulationNonIndigBySexAge = 1; //  lga total population non indig

   // LGA school completion total variables ---------------------------------------------------------------------------------------
   public double LGAtotalPopulationIndigBySexSchoolCompletion = 1; //  lga total school completion indig
   public double LGAtotalPopulationNonIndigBySexSchoolCompletion = 1; //  lga total school completion non indig

   // LGA non school education total variables ---------------------------------------------------------------------------------------
   public double LGAtotalPopulationIndigBySexNonSchoolEducation = 1; //  lga total school completion indig
   public double LGAtotalPopulationNonIndigBySexNonSchoolEducation = 1; //  lga total school completion non indig

   // LGA emploment total variables ---------------------------------------------------------------------------------------
   public double LGAtotalPopulationIndigBySexEmployment = 1; //  lga total school completion indig
   public double LGAtotalPopulationNonIndigBySexEmployment = 1; //  lga total school completion non indig

   // LGA population proportional variables ---------------------------------------------------------------------------------------
   public double LGApercentPopulationIndigBySexAge = 1;
   public double LGApercentPopulationNonIndigBySexAge = 1;

   public double LGApercentPopulationIndigBySexSchoolCompletion = 1;
   public double LGApercentPopulationNonIndigBySexSchoolCompletion = 1;

   public double LGApercentPopulationIndigBySexNonSchoolEducation = 1;
   public double LGApercentPopulationNonIndigBySexNonSchoolEducation = 1;

   public double LGApercentPopulationIndigBySexEmployment = 1;
   public double LGApercentPopulationNonIndigBySexEmployment = 1;

   // LGA population gap score variables ---------------------------------------------------------------------------------------
   public double LGAgapScorePopulationIndigBySexAge = 0;
   public double LGAgapScorePopulationNonIndigBySexAge = 0;

   public double LGAgapScorePopulationIndigBySexSchoolCompletion = 0;
   public double LGAgapScorePopulationNonIndigBySexSchoolCompletion = 0;

   public double LGAgapScorePopulationIndigBySexNonSchoolEducation = 0;
   public double LGAgapScorePopulationNonIndigBySexNonSchoolEducation = 0;

   public double LGAgapScorePopulationIndigBySexEmployment = 0;
   public double LGAgapScorePopulationNonIndigBySexEmployment = 0;

   // Calculate LGA population proportional values ---------------------------------------------------------------------------------------
   // Calculate LGA population by sex, age proportional values 
   public void calcLGApopulationProportionalValuesBySexAge() {
      LGApercentPopulationIndigBySexAge = LGAtotalPopulationIndigBySexAge / LGAtotalPopulationIndig * 100;
      LGApercentPopulationNonIndigBySexAge = LGAtotalPopulationNonIndigBySexAge / LGAtotalPopulationNonIndig * 100;
   }

   // Calculate LGA population by sex, school completion proportional values 
   public void calcLGApopulationProportionalValuesBySexSchoolCompletion() {
      LGApercentPopulationIndigBySexSchoolCompletion = LGAtotalPopulationIndigBySexSchoolCompletion
            / LGAtotalPopulationIndig * 100;
      LGApercentPopulationNonIndigBySexSchoolCompletion = LGAtotalPopulationNonIndigBySexSchoolCompletion
            / LGAtotalPopulationNonIndig * 100;
   }

   // Calculate LGA population by sex, non school education proportional values 
   public void calcLGApopulationProportionalValuesBySexNonSchoolEducation() {
      LGApercentPopulationIndigBySexNonSchoolEducation = LGAtotalPopulationIndigBySexNonSchoolEducation
            / LGAtotalPopulationIndig * 100;
      LGApercentPopulationNonIndigBySexNonSchoolEducation = LGAtotalPopulationNonIndigBySexNonSchoolEducation
            / LGAtotalPopulationNonIndig * 100;
   }

   // Calculate LGA population by sex, non school education proportional values 
   public void calcLGApopulationProportionalValuesBySexEmployment() {
      LGApercentPopulationIndigBySexEmployment = LGAtotalPopulationIndigBySexEmployment
            / LGAtotalPopulationIndig * 100;
      LGApercentPopulationNonIndigBySexEmployment = LGAtotalPopulationNonIndigBySexEmployment
            / LGAtotalPopulationNonIndig * 100;
   }

   // Calculate LGA GAP SCORES ---------------------------------------------------------------------------------------
   // Calculate LGA population by sex, age proportional values GAP SCORE 
   public void calcLGAgapScorePopulationProportionalValuesBySexAge() {
      LGAgapScorePopulationIndigBySexAge = LGApercentPopulationIndigBySexAge
            - LGApercentPopulationNonIndigBySexAge;

      LGAgapScorePopulationNonIndigBySexAge = LGApercentPopulationNonIndigBySexAge
            - LGApercentPopulationIndigBySexAge;
   }

   // Calculate LGA population by sex, school completion proportional values GAP SCORE 
   public void calcLGAgapScorePopulationProportionalValuesBySexSchoolCompletion() {
      LGAgapScorePopulationIndigBySexSchoolCompletion = LGApercentPopulationIndigBySexSchoolCompletion
            - LGApercentPopulationNonIndigBySexSchoolCompletion;

      LGAgapScorePopulationNonIndigBySexSchoolCompletion = LGApercentPopulationNonIndigBySexSchoolCompletion
            - LGApercentPopulationIndigBySexSchoolCompletion;
   }

   // Calculate LGA population by sex, non school education proportional values GAP SCORE 
   public void calcLGAgapScorePopulationProportionalValuesBySexNonSchoolEducation() {
      LGAgapScorePopulationIndigBySexNonSchoolEducation = LGApercentPopulationIndigBySexNonSchoolEducation
            - LGApercentPopulationNonIndigBySexNonSchoolEducation;

      LGAgapScorePopulationNonIndigBySexNonSchoolEducation = LGApercentPopulationNonIndigBySexNonSchoolEducation
            - LGApercentPopulationIndigBySexNonSchoolEducation;
   }

   // Calculate LGA population by sex, employment proportional values GAP SCORE 
   public void calcLGAgapScorePopulationProportionalValuesBySexEmployment() {
      LGAgapScorePopulationIndigBySexEmployment = LGApercentPopulationIndigBySexEmployment
            - LGApercentPopulationNonIndigBySexEmployment;

      LGAgapScorePopulationNonIndigBySexEmployment = LGApercentPopulationNonIndigBySexEmployment
            - LGApercentPopulationIndigBySexEmployment;
   }

   // temp variables for calculations ------------------------------------------------------------------------------------------------------
   public double LGAtotalPopulationTemp = 1; //  lga total population non indig

   // ------------------------------------------------------------------------------------------------------
   // default constructor
   public LGA_PageST31() {

   }

   public LGA_PageST31(String name16, int code16, String age, int populationCount) {
      this.code16 = code16;
      this.name16 = name16;
      this.populationCount = populationCount;
   }

   public int getCode16() {
      return code16;
   }

   public String getName16() {
      return name16;
   }

   public String getType16() {
      return type16;
   }

   public double getArea16() {
      return area16;
   }

   public int getPopulationCount() {
      return populationCount;
   }

}
