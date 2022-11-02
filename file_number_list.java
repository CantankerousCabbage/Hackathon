import java.util.ArrayList;

public class file_number_list {

    public static void main(String[] args) throws Exception {

        ArrayList<String> fileNameList = new ArrayList<String>();
        fileNameList.add("Volvo");
        fileNameList.add("BMW");
        fileNameList.add("Ford");
        fileNameList.add("Mazda");
        

        //public class file_number_list {
    
            String html = "<h2>Meet the Team</h2>";
            for (int i = 0; i<fileNameList.size(); i++) {
                html = html + "<ul style='list-style-type:square;'>";
                html = html + "<li>" + fileNameList.get(i) + "</li>";
                html = html + "</ul>";
        }
        System.out.println(html);
    }
}
    


