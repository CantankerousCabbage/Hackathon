package app;

public class PageDataST31 {
    // LGA 2016 Code
    public int code16;

    // LGA 2016 Name
    public String name16;

    // LGA 2016 type
    public String type16;

    // LGA 2016 area
    public double area16;

    // Population Count
    // public int populationCount;

    public String age;

    // General variables ---------------------------------------------------------------------------------------
    public String sexTableDisplay = "none"; // for display in table so that sex displays as female instead of f
    public String outcomeSelection = "none";
    public String searchTypeSelection = "none";

    // Search type variables ---------------------------------------------------------------------------------------
    Boolean searchType_ageGapScore = false;
    Boolean searchType_schoolCompletionGapScore = false;
    Boolean searchType_nonSchoolEducationGapScore = false;
    Boolean searchType_employmentGapScore = false;

    // LGA variables ---------------------------------------------------------------------------------------
    public int LGAcode = 0; // PageST22 lga code
    public String LGAname; // PageST22 lga name
    public String LGAtype; // PageST22 lga type
    public double LGAarea = 0; // PageST22 lga area
    public String LGAstate; // PageST22. The state the lga is located in
    public double LGAtotalPopulation = 1; // PageST22 lga total population (indig and non indig)
    public double LGAtotalPopulationIndig = 1; // PageST22 lga total population indig
    public double LGAtotalPopulationNonIndig = 1; // PageST22 lga total population non indig

    // State variables ---------------------------------------------------------------------------------------
    // public double stateTotalPopulation = 1; // PageST22 lga total population (indig and non indig)
    public double stateTotalPopulationIndig = 1; // PageST22 lga total population indig
    public double stateTotalPopulationNonIndig = 1; // PageST22 lga total population non indig

    // australia variables ---------------------------------------------------------------------------------------
    public double australiaTotalPopulationIndig = 1; // PageST22 lga total population indig
    public double australiaTotalPopulationNonIndig = 1; // PageST22 lga total population non indig

    // LGA raw values variable declarations ---------------------------------------------------------------------------------------
    public int totalIndigLGA_0_4 = 0; // total indiginous in lga aged 0 - 4
    public int totalNonIndigLGA_0_4 = 0; // total non indiginous in lga aged 0 - 4

    public int totalIndigLGA_5_9 = 0; // total indiginous in lga aged 5 - 9
    public int totalNonIndigLGA_5_9 = 0; // total non indiginous in lga aged 5 - 9

    public int totalIndigLGA_10_14 = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_10_14 = 0; // total non indiginous in lga aged

    public int totalIndigLGA_15_19 = 0; // total indiginous in lga aged 15 - 19
    public int totalNonIndigLGA_15_19 = 0; // total non indiginous in lga aged 15 - 19

    public int totalIndigLGA_20_24 = 0; // total indiginous in lga aged 20 - 24
    public int totalNonIndigLGA_20_24 = 0; // total non indiginous in lga aged 20 - 24

    public int totalIndigLGA_25_29 = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_25_29 = 0; // total non indiginous in lga aged

    public int totalIndigLGA_30_34 = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_30_34 = 0; // total non indiginous in lga aged

    public int totalIndigLGA_35_39 = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_35_39 = 0; // total non indiginous in lga aged

    public int totalIndigLGA_40_44 = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_40_44 = 0; // total non indiginous in lga aged

    public int totalIndigLGA_45_49 = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_45_49 = 0; // total non indiginous in lga aged

    public int totalIndigLGA_50_54 = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_50_54 = 0; // total non indiginous in lga aged

    public int totalIndigLGA_55_59 = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_55_59 = 0; // total non indiginous in lga aged

    public int totalIndigLGA_60_64 = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_60_64 = 0; // total non indiginous in lga aged

    public int totalIndigLGA_65_ov = 0; // total indiginous in lga aged
    public int totalNonIndigLGA_65_ov = 0; // total non indiginous in lga aged

    public int totalIndigLGA_notSchool = 0; // total indiginous in lga did not go to school
    public int totalNonIndigLGA_notSchool = 0; // total non indiginous in lga did not go to school

    public int totalIndigLGA_y8 = 0; // total indiginous in lga completed y8
    public int totalNonIndigLGA_y8 = 0; // total non indiginous in lga completed y8

    public int totalIndigLGA_y10 = 0; // total indiginous in lga completed y10
    public int totalNonIndigLGA_y10 = 0; // total non indiginous in lga completed y10

    public int totalIndigLGA_y12 = 0; // total indiginous in lga completed y12
    public int totalNonIndigLGA_y12 = 0; // total non indiginous in lga completed y12

    // LGA proportional values variable declarations ----------------------------------------------------------------------------------------

    public double percentIndigLGA_0_4 = totalIndigLGA_0_4 / LGAtotalPopulationIndig; // percent indiginous in lga 0 - 4
    public double percentNonIndigLGA_0_4 = totalNonIndigLGA_0_4 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged 0 - 4

    public double percentIndigLGA_5_9 = totalIndigLGA_5_9 / LGAtotalPopulationIndig; // percent indiginous in lga aged 5 - 9
    public double percentNonIndigLGA_5_9 = totalNonIndigLGA_5_9 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged 5 - 9

    public double percentIndigLGA_10_14 = totalIndigLGA_10_14 / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_10_14 = totalNonIndigLGA_10_14 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_15_19 = totalIndigLGA_15_19 / LGAtotalPopulationIndig; // percent indiginous in lga aged 15 - 19
    public double percentNonIndigLGA_15_19 = totalNonIndigLGA_15_19 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged 15 - 19

    public double percentIndigLGA_20_24 = totalIndigLGA_20_24 / LGAtotalPopulationIndig; // percent indiginous in lga aged 20 - 24
    public double percentNonIndigLGA_20_24 = totalNonIndigLGA_20_24 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged 20 - 24

    public double percentIndigLGA_25_29 = totalIndigLGA_25_29 / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_25_29 = totalNonIndigLGA_25_29 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_30_34 = totalIndigLGA_30_34 / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_30_34 = totalNonIndigLGA_30_34 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_35_39 = totalIndigLGA_35_39 / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_35_39 = totalNonIndigLGA_35_39 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_40_44 = totalIndigLGA_40_44 / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_40_44 = totalNonIndigLGA_40_44 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_45_49 = totalIndigLGA_45_49 / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_45_49 = totalNonIndigLGA_45_49 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_50_54 = totalIndigLGA_50_54 / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_50_54 = totalNonIndigLGA_50_54 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_55_59 = totalIndigLGA_55_59 / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_55_59 = totalNonIndigLGA_55_59 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_60_64 = totalIndigLGA_60_64 / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_60_64 = totalNonIndigLGA_60_64 / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_65_ov = totalIndigLGA_65_ov / LGAtotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigLGA_65_ov = totalNonIndigLGA_65_ov / LGAtotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigLGA_notSchool = totalIndigLGA_notSchool / LGAtotalPopulationIndig; // percent indiginous in lga did not go to school
    public double percentNonIndigLGA_notSchool = totalNonIndigLGA_notSchool / LGAtotalPopulationNonIndig; // percent non indiginous in lga did not go to school

    public double percentIndigLGA_y8 = totalIndigLGA_y8 / LGAtotalPopulationIndig; // percent indiginous in lga completed y8
    public double percentNonIndigLGA_y8 = totalNonIndigLGA_y8 / LGAtotalPopulationNonIndig; // percent non indiginous in lga completed y8

    public double percentIndigLGA_y10 = totalIndigLGA_y10 / LGAtotalPopulationIndig; // percent indiginous in lga completed y10
    public double percentNonIndigLGA_y10 = totalNonIndigLGA_y10 / LGAtotalPopulationNonIndig; // percent non indiginous in lga completed y10

    public double percentIndigLGA_y12 = totalIndigLGA_y12 / LGAtotalPopulationIndig; // percent indiginous in lga completed y12
    public double percentNonIndigLGA_y12 = totalNonIndigLGA_y12 / LGAtotalPopulationNonIndig; // percent non indiginous in lga completed y12

    // calculate LGA proportional data ----------------------------------------------------------------------------------------------------------
    public void calculateLGAproportionalData() {
        percentIndigLGA_0_4 = totalIndigLGA_0_4 / LGAtotalPopulationIndig * 100; // percent indiginous in lga 0 - 4
        percentNonIndigLGA_0_4 = totalNonIndigLGA_0_4 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged 0 - 4

        percentIndigLGA_5_9 = totalIndigLGA_5_9 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged 5 - 9
        percentNonIndigLGA_5_9 = totalNonIndigLGA_5_9 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged 5 - 9

        percentIndigLGA_10_14 = totalIndigLGA_10_14 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_10_14 = totalNonIndigLGA_10_14 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_15_19 = totalIndigLGA_15_19 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged 15 - 19
        percentNonIndigLGA_15_19 = totalNonIndigLGA_15_19 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged 15 - 19

        percentIndigLGA_20_24 = totalIndigLGA_20_24 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged 20 - 24
        percentNonIndigLGA_20_24 = totalNonIndigLGA_20_24 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged 20 - 24

        percentIndigLGA_25_29 = totalIndigLGA_25_29 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_25_29 = totalNonIndigLGA_25_29 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_30_34 = totalIndigLGA_30_34 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_30_34 = totalNonIndigLGA_30_34 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_35_39 = totalIndigLGA_35_39 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_35_39 = totalNonIndigLGA_35_39 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_40_44 = totalIndigLGA_40_44 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_40_44 = totalNonIndigLGA_40_44 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_45_49 = totalIndigLGA_45_49 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_45_49 = totalNonIndigLGA_45_49 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_50_54 = totalIndigLGA_50_54 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_50_54 = totalNonIndigLGA_50_54 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_55_59 = totalIndigLGA_55_59 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_55_59 = totalNonIndigLGA_55_59 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_60_64 = totalIndigLGA_60_64 / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_60_64 = totalNonIndigLGA_60_64 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_65_ov = totalIndigLGA_65_ov / LGAtotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigLGA_65_ov = totalNonIndigLGA_65_ov / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga aged

        percentIndigLGA_notSchool = totalIndigLGA_notSchool / LGAtotalPopulationIndig * 100; // percent indiginous in lga did not go to school
        percentNonIndigLGA_notSchool = totalNonIndigLGA_notSchool / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga did not go to school

        percentIndigLGA_y8 = totalIndigLGA_y8 / LGAtotalPopulationIndig * 100; // percent indiginous in lga completed y8
        percentNonIndigLGA_y8 = totalNonIndigLGA_y8 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga completed y8

        percentIndigLGA_y10 = totalIndigLGA_y10 / LGAtotalPopulationIndig * 100; // percent indiginous in lga completed y10
        percentNonIndigLGA_y10 = totalNonIndigLGA_y10 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga completed y10

        percentIndigLGA_y12 = totalIndigLGA_y12 / LGAtotalPopulationIndig * 100; // percent indiginous in lga completed y12
        percentNonIndigLGA_y12 = totalNonIndigLGA_y12 / LGAtotalPopulationNonIndig * 100; // percent non indiginous in lga completed y12
    }

    // State raw values ----------------------------------------------------------------------------------------
    public int totalIndigState_0_4 = 0; // total indiginous in State aged 0 - 4
    public int totalNonIndigState_0_4 = 0; // total non indiginous in State aged 0 - 4

    public int totalIndigState_5_9 = 0; // total indiginous in State aged 5 - 9
    public int totalNonIndigState_5_9 = 0; // total non indiginous in State aged 5 - 9

    public int totalIndigState_10_14 = 0; // total indiginous in State aged
    public int totalNonIndigState_10_14 = 0; // total non indiginous in State aged

    public int totalIndigState_15_19 = 0; // total indiginous in State aged 15 - 19
    public int totalNonIndigState_15_19 = 0; // total non indiginous in State aged 15 - 19

    public int totalIndigState_20_24 = 0; // total indiginous in State aged 20 - 24
    public int totalNonIndigState_20_24 = 0; // total non indiginous in State aged 20 - 24

    public int totalIndigState_25_29 = 0; // total indiginous in State aged
    public int totalNonIndigState_25_29 = 0; // total non indiginous in State aged

    public int totalIndigState_30_34 = 0; // total indiginous in State aged
    public int totalNonIndigState_30_34 = 0; // total non indiginous in State aged

    public int totalIndigState_35_39 = 0; // total indiginous in State aged
    public int totalNonIndigState_35_39 = 0; // total non indiginous in State aged

    public int totalIndigState_40_44 = 0; // total indiginous in State aged
    public int totalNonIndigState_40_44 = 0; // total non indiginous in State aged

    public int totalIndigState_45_49 = 0; // total indiginous in State aged
    public int totalNonIndigState_45_49 = 0; // total non indiginous in State aged

    public int totalIndigState_50_54 = 0; // total indiginous in State aged
    public int totalNonIndigState_50_54 = 0; // total non indiginous in State aged

    public int totalIndigState_55_59 = 0; // total indiginous in State aged
    public int totalNonIndigState_55_59 = 0; // total non indiginous in State aged

    public int totalIndigState_60_64 = 0; // total indiginous in State aged
    public int totalNonIndigState_60_64 = 0; // total non indiginous in State aged

    public int totalIndigState_65_ov = 0; // total indiginous in State aged
    public int totalNonIndigState_65_ov = 0; // total non indiginous in State aged

    public int totalIndigState_notSchool = 0; // total indiginous in State did not go to school
    public int totalNonIndigState_notSchool = 0; // total non indiginous in State did not go to school

    public int totalIndigState_y8 = 0; // total indiginous in State completed y8
    public int totalNonIndigState_y8 = 0; // total non indiginous in State completed y8

    public int totalIndigState_y10 = 0; // total indiginous in State completed y10
    public int totalNonIndigState_y10 = 0; // total non indiginous in State completed y10

    public int totalIndigState_y12 = 0; // total indiginous in State completed y12
    public int totalNonIndigState_y12 = 0; // total non indiginous in State completed y12

    // State proportional values variable declarations ----------------------------------------------------------------------------------------

    public double percentIndigState_0_4 = totalIndigState_0_4 / stateTotalPopulationIndig; // percent indiginous in state 0 - 4
    public double percentNonIndigState_0_4 = totalNonIndigLGA_0_4 / stateTotalPopulationNonIndig; // percent non indiginous in state aged 0 - 4

    public double percentIndigState_5_9 = totalIndigState_5_9 / stateTotalPopulationIndig; // percent indiginous in lga aged 5 - 9
    public double percentNonIndigState_5_9 = totalNonIndigState_5_9 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged 5 - 9

    public double percentIndigState_10_14 = totalIndigState_10_14 / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_10_14 = totalNonIndigState_10_14 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_15_19 = totalIndigState_15_19 / stateTotalPopulationIndig; // percent indiginous in lga aged 15 - 19
    public double percentNonIndigState_15_19 = totalNonIndigState_15_19 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged 15 - 19

    public double percentIndigState_20_24 = totalIndigState_20_24 / stateTotalPopulationIndig; // percent indiginous in lga aged 20 - 24
    public double percentNonIndigState_20_24 = totalNonIndigState_20_24 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged 20 - 24

    public double percentIndigState_25_29 = totalIndigState_25_29 / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_25_29 = totalNonIndigState_25_29 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_30_34 = totalIndigState_30_34 / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_30_34 = totalNonIndigState_30_34 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_35_39 = totalIndigState_35_39 / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_35_39 = totalNonIndigState_35_39 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_40_44 = totalIndigState_40_44 / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_40_44 = totalNonIndigState_40_44 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_45_49 = totalIndigState_45_49 / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_45_49 = totalNonIndigState_45_49 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_50_54 = totalIndigState_50_54 / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_50_54 = totalNonIndigState_50_54 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_55_59 = totalIndigState_55_59 / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_55_59 = totalNonIndigState_55_59 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_60_64 = totalIndigState_60_64 / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_60_64 = totalNonIndigState_60_64 / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_65_ov = totalIndigState_65_ov / stateTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigState_65_ov = totalNonIndigState_65_ov / stateTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigState_notSchool = totalIndigState_notSchool / stateTotalPopulationIndig; // percent indiginous in lga did not go to school
    public double percentNonIndigState_notSchool = totalNonIndigState_notSchool / stateTotalPopulationNonIndig; // percent non indiginous in lga did not go to school

    public double percentIndigState_y8 = totalIndigState_y8 / stateTotalPopulationIndig; // percent indiginous in lga completed y8
    public double percentNonIndigState_y8 = totalNonIndigState_y8 / stateTotalPopulationNonIndig; // percent non indiginous in lga completed y8

    public double percentIndigState_y10 = totalIndigState_y10 / stateTotalPopulationIndig; // percent indiginous in lga completed y10
    public double percentNonIndigState_y10 = totalNonIndigState_y10 / stateTotalPopulationNonIndig; // percent non indiginous in lga completed y10

    public double percentIndigState_y12 = totalIndigState_y12 / stateTotalPopulationIndig; // percent indiginous in lga completed y12
    public double percentNonIndigState_y12 = totalNonIndigState_y12 / stateTotalPopulationNonIndig; // percent non indiginous in lga completed y12

     // ------------------------------------------------------------------------------------------------------------------------------
    // calculate state proportional data
    public void calculateStateProportionalData() {
        percentIndigState_0_4 = totalIndigState_0_4 / stateTotalPopulationIndig * 100; // percent indiginous in state 0 - 4
        percentNonIndigState_0_4 = totalNonIndigState_0_4 / stateTotalPopulationNonIndig * 100; // percent non indiginous in state aged 0 - 4
            
        percentIndigState_5_9 = totalIndigState_5_9 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged 5 - 9
        percentNonIndigState_5_9 = totalNonIndigState_5_9 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged 5 - 9
            
        percentIndigState_10_14 = totalIndigState_10_14 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_10_14 = totalNonIndigState_10_14 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_15_19 = totalIndigState_15_19 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged 15 - 19
        percentNonIndigState_15_19 = totalNonIndigState_15_19 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged 15 - 19
            
        percentIndigState_20_24 = totalIndigState_20_24 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged 20 - 24
        percentNonIndigState_20_24 = totalNonIndigState_20_24 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged 20 - 24
            
        percentIndigState_25_29 = totalIndigState_25_29 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_25_29 = totalNonIndigState_25_29 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_30_34 = totalIndigState_30_34 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_30_34 = totalNonIndigState_30_34 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_35_39 = totalIndigState_35_39 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_35_39 = totalNonIndigState_35_39 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_40_44 = totalIndigState_40_44 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_40_44 = totalNonIndigState_40_44 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_45_49 = totalIndigState_45_49 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_45_49 = totalNonIndigState_45_49 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_50_54 = totalIndigState_50_54 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_50_54 = totalNonIndigState_50_54 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_55_59 = totalIndigState_55_59 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_55_59 = totalNonIndigState_55_59 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_60_64 = totalIndigState_60_64 / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_60_64 = totalNonIndigState_60_64 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_65_ov = totalIndigState_65_ov / stateTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigState_65_ov = totalNonIndigState_65_ov / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigState_notSchool = totalIndigState_notSchool / stateTotalPopulationIndig * 100; // percent indiginous in lga did not go to school
        percentNonIndigState_notSchool = totalNonIndigState_notSchool / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga did not go to school
            
        percentIndigState_y8 = totalIndigState_y8 / stateTotalPopulationIndig * 100; // percent indiginous in lga completed y8
        percentNonIndigState_y8 = totalNonIndigState_y8 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga completed y8
            
        percentIndigState_y10 = totalIndigState_y10 / stateTotalPopulationIndig * 100; // percent indiginous in lga completed y10
        percentNonIndigState_y10 = totalNonIndigState_y10 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga completed y10
            
        percentIndigState_y12 = totalIndigState_y12 / stateTotalPopulationIndig * 100; // percent indiginous in lga completed y12
        percentNonIndigState_y12 = totalNonIndigState_y12 / stateTotalPopulationNonIndig * 100; // percent non indiginous in lga completed y12
        
    }

    // australia raw values variable declarations ----------------------------------------------------------------------------------------
    public int totalIndigAustralia_0_4 = 0; // total indiginous in Australia aged 0 - 4
    public int totalNonIndigAustralia_0_4 = 0; // total non indiginous in Australia aged 0 - 4

    public int totalIndigAustralia_5_9 = 0; // total indiginous in Australia aged 5 - 9
    public int totalNonIndigAustralia_5_9 = 0; // total non indiginous in Australia aged 5 - 9

    public int totalIndigAustralia_10_14 = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_10_14 = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_15_19 = 0; // total indiginous in Australia aged 15 - 19
    public int totalNonIndigAustralia_15_19 = 0; // total non indiginous in Australia aged 15 - 19

    public int totalIndigAustralia_20_24 = 0; // total indiginous in Australia aged 20 - 24
    public int totalNonIndigAustralia_20_24 = 0; // total non indiginous in Australia aged 20 - 24

    public int totalIndigAustralia_25_29 = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_25_29 = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_30_34 = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_30_34 = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_35_39 = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_35_39 = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_40_44 = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_40_44 = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_45_49 = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_45_49 = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_50_54 = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_50_54 = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_55_59 = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_55_59 = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_60_64 = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_60_64 = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_65_ov = 0; // total indiginous in Australia aged
    public int totalNonIndigAustralia_65_ov = 0; // total non indiginous in Australia aged

    public int totalIndigAustralia_notSchool = 0; // total indiginous in Australia did not go to school
    public int totalNonIndigAustralia_notSchool = 0; // total non indiginous in Australia did not go to school

    public int totalIndigAustralia_y8 = 0; // total indiginous in Australia completed y8
    public int totalNonIndigAustralia_y8 = 0; // total non indiginous in Australia completed y8

    public int totalIndigAustralia_y10 = 0; // total indiginous in Australia completed y10
    public int totalNonIndigAustralia_y10 = 0; // total non indiginous in Australia completed y10

    public int totalIndigAustralia_y12 = 0; // total indiginous in Australia completed y12
    public int totalNonIndigAustralia_y12 = 0; // total non indiginous in Australia completed y12

    // Australia proportional values variable declarations ----------------------------------------------------------------------------------------

    public double percentIndigAustralia_0_4 = totalIndigAustralia_0_4 / australiaTotalPopulationIndig; // percent indiginous in australia 0 - 4
    public double percentNonIndigAustralia_0_4 = totalNonIndigLGA_0_4 / australiaTotalPopulationNonIndig; // percent non indiginous in australia aged 0 - 4

    public double percentIndigAustralia_5_9 = totalIndigAustralia_5_9 / australiaTotalPopulationIndig; // percent indiginous in lga aged 5 - 9
    public double percentNonIndigAustralia_5_9 = totalNonIndigAustralia_5_9 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged 5 - 9

    public double percentIndigAustralia_10_14 = totalIndigAustralia_10_14 / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_10_14 = totalNonIndigAustralia_10_14 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_15_19 = totalIndigAustralia_15_19 / australiaTotalPopulationIndig; // percent indiginous in lga aged 15 - 19
    public double percentNonIndigAustralia_15_19 = totalNonIndigAustralia_15_19 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged 15 - 19

    public double percentIndigAustralia_20_24 = totalIndigAustralia_20_24 / australiaTotalPopulationIndig; // percent indiginous in lga aged 20 - 24
    public double percentNonIndigAustralia_20_24 = totalNonIndigAustralia_20_24 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged 20 - 24

    public double percentIndigAustralia_25_29 = totalIndigAustralia_25_29 / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_25_29 = totalNonIndigAustralia_25_29 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_30_34 = totalIndigAustralia_30_34 / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_30_34 = totalNonIndigAustralia_30_34 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_35_39 = totalIndigAustralia_35_39 / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_35_39 = totalNonIndigAustralia_35_39 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_40_44 = totalIndigAustralia_40_44 / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_40_44 = totalNonIndigAustralia_40_44 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_45_49 = totalIndigAustralia_45_49 / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_45_49 = totalNonIndigAustralia_45_49 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_50_54 = totalIndigAustralia_50_54 / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_50_54 = totalNonIndigAustralia_50_54 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_55_59 = totalIndigAustralia_55_59 / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_55_59 = totalNonIndigAustralia_55_59 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_60_64 = totalIndigAustralia_60_64 / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_60_64 = totalNonIndigAustralia_60_64 / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_65_ov = totalIndigAustralia_65_ov / australiaTotalPopulationIndig; // percent indiginous in lga aged
    public double percentNonIndigAustralia_65_ov = totalNonIndigAustralia_65_ov / australiaTotalPopulationNonIndig; // percent non indiginous in lga aged

    public double percentIndigAustralia_notSchool = totalIndigAustralia_notSchool / australiaTotalPopulationIndig; // percent indiginous in lga did not go to school
    public double percentNonIndigAustralia_notSchool = totalNonIndigAustralia_notSchool / australiaTotalPopulationNonIndig; // percent non indiginous in lga did not go to school

    public double percentIndigAustralia_y8 = totalIndigAustralia_y8 / australiaTotalPopulationIndig; // percent indiginous in lga completed y8
    public double percentNonIndigAustralia_y8 = totalNonIndigAustralia_y8 / australiaTotalPopulationNonIndig; // percent non indiginous in lga completed y8

    public double percentIndigAustralia_y10 = totalIndigAustralia_y10 / australiaTotalPopulationIndig; // percent indiginous in lga completed y10
    public double percentNonIndigAustralia_y10 = totalNonIndigAustralia_y10 / australiaTotalPopulationNonIndig; // percent non indiginous in lga completed y10

    public double percentIndigAustralia_y12 = totalIndigAustralia_y12 / australiaTotalPopulationIndig; // percent indiginous in lga completed y12
    public double percentNonIndigAustralia_y12 = totalNonIndigAustralia_y12 / australiaTotalPopulationNonIndig; // percent non indiginous in lga completed y12

    // ------------------------------------------------------------------------------------------------------------------------------
    // calculate Australia proportional data
    public void calculateAustraliaProportionalData() {
        percentIndigAustralia_0_4 = totalIndigAustralia_0_4 / australiaTotalPopulationIndig * 100; // percent indiginous in australia 0 - 4
        percentNonIndigAustralia_0_4 = totalNonIndigAustralia_0_4 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in australia aged 0 - 4
            
        percentIndigAustralia_5_9 = totalIndigAustralia_5_9 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged 5 - 9
        percentNonIndigAustralia_5_9 = totalNonIndigAustralia_5_9 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged 5 - 9
            
        percentIndigAustralia_10_14 = totalIndigAustralia_10_14 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_10_14 = totalNonIndigAustralia_10_14 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_15_19 = totalIndigAustralia_15_19 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged 15 - 19
        percentNonIndigAustralia_15_19 = totalNonIndigAustralia_15_19 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged 15 - 19
            
        percentIndigAustralia_20_24 = totalIndigAustralia_20_24 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged 20 - 24
        percentNonIndigAustralia_20_24 = totalNonIndigAustralia_20_24 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged 20 - 24
            
        percentIndigAustralia_25_29 = totalIndigAustralia_25_29 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_25_29 = totalNonIndigAustralia_25_29 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_30_34 = totalIndigAustralia_30_34 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_30_34 = totalNonIndigAustralia_30_34 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_35_39 = totalIndigAustralia_35_39 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_35_39 = totalNonIndigAustralia_35_39 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_40_44 = totalIndigAustralia_40_44 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_40_44 = totalNonIndigAustralia_40_44 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_45_49 = totalIndigAustralia_45_49 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_45_49 = totalNonIndigAustralia_45_49 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_50_54 = totalIndigAustralia_50_54 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_50_54 = totalNonIndigAustralia_50_54 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_55_59 = totalIndigAustralia_55_59 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_55_59 = totalNonIndigAustralia_55_59 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_60_64 = totalIndigAustralia_60_64 / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_60_64 = totalNonIndigAustralia_60_64 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_65_ov = totalIndigAustralia_65_ov / australiaTotalPopulationIndig * 100; // percent indiginous in lga aged
        percentNonIndigAustralia_65_ov = totalNonIndigAustralia_65_ov / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga aged
            
        percentIndigAustralia_notSchool = totalIndigAustralia_notSchool / australiaTotalPopulationIndig * 100; // percent indiginous in lga did not go to school
        percentNonIndigAustralia_notSchool = totalNonIndigAustralia_notSchool / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga did not go to school
            
        percentIndigAustralia_y8 = totalIndigAustralia_y8 / australiaTotalPopulationIndig * 100; // percent indiginous in lga completed y8
        percentNonIndigAustralia_y8 = totalNonIndigAustralia_y8 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga completed y8
            
        percentIndigAustralia_y10 = totalIndigAustralia_y10 / australiaTotalPopulationIndig * 100; // percent indiginous in lga completed y10
        percentNonIndigAustralia_y10 = totalNonIndigAustralia_y10 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga completed y10
            
        percentIndigAustralia_y12 = totalIndigAustralia_y12 / australiaTotalPopulationIndig * 100; // percent indiginous in lga completed y12
        percentNonIndigAustralia_y12 = totalNonIndigAustralia_y12 / australiaTotalPopulationNonIndig * 100; // percent non indiginous in lga completed y12
    }    
    
    // -------------------------------------------------------------------------------------------------------------------------------------
    // default constructor
    public PageDataST31() {

    }

    /**
     * Create an LGA and set the fields
     */
    public PageDataST31(String name16, int code16, String age, int populationCount) {
        this.code16 = code16;
        this.name16 = name16;
        this.age = age;
        // this.populationCount = populationCount;
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

    // public int getPopulationCount() {
    //     return populationCount;
    // }

    public String getAge() {
        return age;
    }
}
