package app;

public class Global {

    // Navigation links ABOVE header
    public String getTopNav() {
        // Add the topnav
        // This uses a Java v15+ Text Block
        String topNav = """
                    <div class='topnav'>
                        <a href='/'>Homepage</a>
                        <a href='Page_1.html'>Page_1</a>
                        <a href='Page_2.html'>Page_2</a>
                        <a href='Page_3.html'>Page_3</a>
                        <a href='Page_4.html'>Page_4</a>
                    </div>
                """;
        return topNav;
    }

    // Navigation links BELOW header with full link test
    public String getNavBar() {
        String NavBar = """
                <div class="navbar">
                <a href='/'>Homepage</a>
                <a href='Page_1.html'>Page_1</a>
                <a href='Page_2.html'>Page_2</a>
                <a href='Page_3.html'>Page_3</a>
                <a href='Page_4.html'>Page_4</a>
                </div>
                    """;
        return NavBar;
    }

    // Get header
    public String getHeader() {
        // Add header content block
        String header = """
                <div class='header'>
                    <h1>
                    <a href='/'><img src='LogoV1.png' class='top-image' alt='RMIT logo' height='75'></a> 
                    </h1>
                    </div>
                    """;
        return header;
    }


    // Get footer
    public String getFooter() {
        String footer = """
                    <div class='footer'>
                        <!-- <p>Footer</p> -->
                    </div>
                """;

        return footer;
    }
}

