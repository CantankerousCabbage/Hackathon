
public class temp {
    public static void main (String[] args) {
        
        
        
        String input = "OperatorName";


        String output = "";
        
        switch (input) {
            case "FilePath":
                output = "RunDetails_FilePath";
                break;
            
            case "LoadNumber":
                output = "RunDetails_LoadNumber";
                break;
            
            case "Equipment":
                output = "RunDetails_Equipment";
                break;

            case "RunRecipe":
                output = "RunDetails_RunRecipe";
                break;

            case "RunStart":
                output = "RunDetails_RunStart";
                break;

            case "RunEnd":
                output = "RunDetails_RunEnd";
                break;
            
            case "RunDuration":
                output = "RunDetails_RunDuration";
                break;

            case "FileLength":
                output = "RunDetails_FileLength";
                break;
                
            case "OperatorName":
                output = "RunDetails_OperatorName";
                break;
            
            case "ExportControl":
                output = "RunDetails_ExportControl";
                break;

            case "IP":
                output = "RunDetails_IP";
                break;

            case "Index":
                output = "RunDetails_Index";
                break;

            case "WorkOrder":
                output = "RunDetails_WorkOrder";
                break;

            case "PartNumber":
                output = "RunDetails_PartNumber";
                break;

            case "PartDescription":
                output = "RunDetails_PartDescription";
                break;

            case "ToolLocation":
                output = "RunDetails_ToolLocation";
                break;

            case "PartTCs":
                output = "RunDetails_PartTCs";
                break;

            case "PartProbes":
                output = "RunDetails_PartProbes";
                break;

            case "OtherSensors":
                output = "RunDetails_OtherSensors";
                break;            
        }

        System.out.println(output);

        String temp = "yes";

        String SQL_Sting = "SELECT RunDetails_FileName FROM JASON WHERE " + output + " == " + temp;

        System.out.println(SQL_Sting);


    } 
}