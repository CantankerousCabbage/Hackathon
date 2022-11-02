package app;

public class Global {

    // Navigation links ABOVE header
    public static String getTopNav() {
        // Add the topnav
        // This uses a Java v15+ Text Block
        String topNav = """
                    <div class='topnav'>
                        <a href='/'>Homepage</a>
                        <a href='mission.html'>Our Mission</a>
                        <a href='page3.html'>Sub Task 2.1</a>
                        <a href='page4.html'>Sub Task 2.2</a>
                        <a href='page5.html'>Sub Task 3.1</a>
                        <a href='page6.html'>Sub Task 3.2</a>
                    </div>
                """;
        return topNav;
    }

    // Navigation links BELOW header with full link test
    public static String getNavBar() {
        String NavBar = """
                <div class="navbar">
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='PageST21.html'>2.1 Age and School Completion Ranking by LGA</a>
                <a href='PageST22.html'>2.2 Age and School Completion Data by LGA</a>
                <a href='PageST31.html'>3.1 A Gap-Score for Comparing between Indigenous and Non-Indigenous People</a>
                <a href='PageST32.html'>3.2 Finding LGAs with similar Socioeconomic Outcomes</a>
                </div>
                    """;
        return NavBar;
    }

    // Get header
    // public static String getHeader() {
    //     // Add header content block
    //     String header = """
    //             <div class='header'>
    //                 <h1>
    //                 <a href='/'><img src='LogoV1.png' class='top-image' alt='RMIT logo' height='75'></a>
    //                 Closing The Gap
    //                 </h1>
    //                 </div>
    //                 """;
    //     return header;
    // }

    // Get header
    public static String getHeader(String headerText) {
        // Add header content block
        String header = """
                <div class='header'>
                    <h1>
                    <a href='/'><img src='LogoV1.png' class='top-image' alt='RMIT logo' height='75'></a> """
                + headerText +
                """
                    </h1>
                    </div>
                    """;
        return header;
    }


    // Get footer
    public static String getFooter() {
        String footer = """
                    <div class='footer'>
                        <!-- <p>Footer</p> -->
                    </div>
                """;

        return footer;
    }

    public static String getState(int LGAcode) {
        int LGAcodeFirstDigit = LGAcode / 10000;

        String LGAstate = "None";

        switch (LGAcodeFirstDigit) {
            case 1:
                LGAstate = "NSW";
                break;
            case 2:
                LGAstate = "Victoria";
                break;
            case 3:
                LGAstate = "QLD";
                break;
            case 4:
                LGAstate = "South Australia";
                break;
            case 5:
                LGAstate = "Western Australia";
                break;
            case 6:
                LGAstate = "Tasmania";
                break;
            case 7:
                LGAstate = "Northern Territory";
                break;
            case 8:
                LGAstate = "ACT";
                break;
            case 9:
                LGAstate = "Other";
                break;
            default:
                break;
        }

        return LGAstate;
    }
}
