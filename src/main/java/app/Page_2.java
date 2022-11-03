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
public class Page_2 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/Page_2.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Page 2</title>";

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
                <h1>Page_2</h1>
            </div>
        """;

        html = html + """
                <table border='1'>
                <tr><th>RunDetails</th><td><table border='1'><tr><th>FileName</th><td>AC2-07341.DAT</td></tr><tr><th>FilePath</th><td>\\server1\AC2-DATA</td></tr><tr><th>LoadNumber</th><td>7341</td></tr><tr><th>Equipment</th><td>Autoclave #2</td></tr><tr><th>RunRecipe</th><td>ACME HIGH PRESSURE</td></tr><tr><th>RunStart</th><td>2022-10-11T15:21:30</td></tr><tr><th>RunEnd</th><td>2022-10-12T08:13:27</td></tr><tr><th>RunDuration</th><td>1011.95</td></tr><tr><th>FileLength</th><td>417209</td></tr><tr><th>OperatorName</th><td>RAJ</td></tr><tr><th>ExportControl</th><td>AU NSR</td></tr><tr><th>IP</th><td>Third Party Disclosure Requires Written Approval</td></tr></table></td></tr><tr><th>PartInformation</th><td><table border="1"><thead><tr><th>Index</th><th>WorkOrder</th><th>PartNumber</th><th>PartDescription</th><th>ToolLocation</th><th>Comment1</th><th>Comment2</th><th>Comment3</th><th>PartTCs</th><th>PartProbes</th><th>OtherSensors</th></tr></thead><tbody><tr><td>1</td><td>2251277</td><td>ACME-700</td><td>Door Handle</td><td>F</td><td></td><td></td><td></td><td><ul><li>TC44</li><li>TC45</li></ul></td><td><ul><li>MON28</li></ul></td><td></td></tr><tr><td>2</td><td>2251278</td><td>ACME-701</td><td>Door Handle</td><td>F</td><td>L 75</td><td></td><td></td><td><ul><li>TC1</li><li>TC2</li></ul></td><td><ul><li>MON10</li></ul></td><td></td></tr><tr><td>3</td><td>2251276</td><td>ACME-702</td><td>BONDED PART</td><td>F</td><td>L38 &amp; 35</td><td></td><td></td><td><ul><li>TC13</li><li>TC14</li><li>TC39</li><li>TC40</li></ul></td><td><ul><li>MON16</li><li>MON17</li></ul></td><td></td></tr><tr><td>4</td><td>2251274</td><td>ACME-703</td><td>BONDED PART</td><td>F</td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>5</td><td>2251273</td><td>ACME-704</td><td>Door Handle</td><td>F</td><td>L 35</td><td></td><td></td><td><ul><li>TC15</li><li>TC16</li><li>TC17</li><li>TC18</li></ul></td><td><ul><li>MON4</li><li>MON6</li></ul></td><td></td></tr><tr><td>6</td><td>2251272</td><td>ACME-705</td><td>Door Handle</td><td>F</td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>7</td><td>2251271</td><td>ACME-706</td><td>Door Handle</td><td>F</td><td></td><td></td><td></td><td><ul><li>TC5</li><li>TC6</li></ul></td><td><ul><li>MON2</li><li>MON3</li></ul></td><td></td></tr><tr><td>8</td><td>2251270</td><td>ACME-707</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>9</td><td>2251269</td><td>ACME-708</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>10</td><td>2251268</td><td>ACME-709</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>11</td><td>2251267</td><td>ACME-710</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>12</td><td>2251266</td><td>ACME-711</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>13</td><td>2251265</td><td>ACME-712</td><td>Rearwiew Mirror</td><td>F</td><td>L 86</td><td></td><td></td><td><ul><li>TC27</li><li>TC28</li><li>TC29</li><li>TC30</li></ul></td><td><ul><li>MON18</li><li>MON39</li></ul></td><td></td></tr><tr><td>14</td><td>2251264</td><td>ACME-713</td><td>Steering Wheel</td><td>F</td><td>L 38</td><td></td><td></td><td><ul><li>TC35</li><li>TC36</li></ul></td><td><ul><li>MON37</li><li>MON38</li></ul></td><td></td></tr><tr><td>15</td><td>2251263</td><td>ACME-714</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>16</td><td>2251262</td><td>ACME-715</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>17</td><td>2251261</td><td>ACME-716</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>18</td><td>2251260</td><td>ACME-717</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>19</td><td>2251259</td><td>ACME-718</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>20</td><td>2251258</td><td>ACME-719</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>21</td><td>2251256</td><td>ACME-720</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>22</td><td>2251255</td><td>ACME-721</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>23</td><td>2251254</td><td>ACME-722</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>24</td><td>2251253</td><td>ACME-723</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>25</td><td>2251252</td><td>ACME-724</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>26</td><td>2251250</td><td>ACME-725</td><td>Steering Wheel</td><td>F</td><td>L 38</td><td></td><td></td><td><ul><li>TC37</li><li>TC38</li></ul></td><td><ul><li>MON22</li><li>MON23</li></ul></td><td></td></tr><tr><td>27</td><td>2251249</td><td>ACME-726</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>28</td><td>2251248</td><td>ACME-727</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>29</td><td>22251247</td><td>ACME-728</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>30</td><td>2251246</td><td>ACME-729</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>31</td><td>2251243</td><td>ACME-730</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>32</td><td>2251242</td><td>ACME-731</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>33</td><td>2251241</td><td>ACME-732</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>34</td><td>2251240</td><td>ACME-733</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>35</td><td>2251239</td><td>ACME-734</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>36</td><td>2251238</td><td>ACME-735</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>37</td><td>2251237</td><td>ACME-736</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>38</td><td>2251236</td><td>ACME-737</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>39</td><td>2251235</td><td>ACME-738</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>40</td><td>22251234</td><td>ACME-739</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></tbody></table></td></tr></table>
                """;

        JDBCConnection jdbc = new JDBCConnection();

        // Close Content div
        html = html + "</div>";

        html = html + """
            <body>

            <p>Upload a new JASON File:</p>

            <form action='/action_page.php'>
            <input type='file' id='myFile' name='filename'>
            <input type='submit'>
            </form>

            </body>
                """;


        // Footer
    //    html = html + nav.getFooter();
      

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
