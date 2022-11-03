package app;

//import app.homepage;
// import app.semster1.PageMission;
// import app.semster1.PageST21;
// import app.semster1.PageST22;
// import app.semster1.PageST31;
// import app.semster1.PageST32;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;

/**
 * Main Application Class.
 * <p>
 * Running this class as regular java application will start the
 * Javalin HTTP Server and our web application.
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class App {

    public static final int JAVALIN_PORT = 7001;
    public static final String CSS_DIR = "css/";
    public static final String IMAGES_DIR = "images/";
    public static final String FIL_DIR = "AutoClave5_JSON_Files/";

    public static void main(String[] args) {
        // Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));

            // Uncomment this if you have files in the CSS Directory
            config.addStaticFiles(CSS_DIR);

            // Uncomment this if you have files in the Images Directory
            config.addStaticFiles(IMAGES_DIR);
            config.addStaticFiles(FIL_DIR);
        }).start(JAVALIN_PORT);

        // Configure Web Routes
        configureRoutes(app);
    }

    public static void configureRoutes(Javalin app) {
        // All webpages are listed here as GET pages
        app.get(homepage.URL, new homepage());
        app.get(Page_1.URL, new Page_1());
        app.get(Page_2.URL, new Page_2());
        app.get(Page_3.URL, new Page_3());
        app.get(Page_4.URL, new Page_4());
        // app.get(PageST32.URL, new PageST32());

        // Add / uncomment POST commands for any pages that need web form POSTS
        app.post(homepage.URL, new homepage());
        app.post(Page_1.URL, new Page_1());
        app.post(Page_2.URL, new Page_2());
        app.post(Page_3.URL, new Page_3());
        app.post(Page_4.URL, new Page_4());
        
    }

}
