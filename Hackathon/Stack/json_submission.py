


#Run_Details

    # #"RunDetails":{
	# 	"FileName":"AC2-07337.DAT",
	# 	"FilePath":"\\\\server1\\AC2-DATA",
	# 	"LoadNumber":"7337",
	# 	"Equipment":"Autoclave #2",
	# 	"RunRecipe":"XB-Falcon-Body",
	# 	"RunStart":"2022-10-06T01:27:46",
	# 	"RunEnd":"2022-10-06T18:33:15",
	# 	"RunDuration":"1025.48",
	# 	"FileLength":"192505",
	# 	"OperatorName":"raymond",
	# 	"ExportControl":"AU NSR",
	# 	"IP":"Boeing Proprietary",
	# 	"IP":"Copyright 2022 Boeing Aerostructures Australia",
	# 	"IP":"All Rights Reserved",
	# 	"IP":"Third Party Disclosure Requires Written Approval"},
	# "PartInformation":[{
	# 	"Index":1,
	# 	"WorkOrder":"3458987",
	# 	"PartNumber":"ACME-100",
	# 	"PartDescription":"Left Qtr Panel",
	# 	"ToolLocation":"BOTTOM",
	# 	"Comment1":"L=57",
	# 	"Comment2":"",
	# 	"Comment3":"",
	# 	"PartTCs":["TC9","TC10"],
	# 	"PartProbes":["MON45"],
	# 	"OtherSensors":[] 


#Part_Information





        html = html + "<form action='/page4.html' method='post'>";

        html = html + "<div class='grid-container_input221'>";

        html = html + "   <div class='Run Details'>";
        html = html + "      <label for='LGA_drop'>Select LGA:</label>";
        html = html + "      <select id='LGA_drop' name='LGA_drop' class=dropDownSize>"; 
        html = html + "         <option value='' selected disabled hidden>Choose here</option>";      
        for (int index = 0; index < lgas.size(); index++) {
            html = html + "         <option>" + lgas.get(index) + "</option>";
        }
        html = html + "      </select>";
        html = html + "   </div>";

        html = html + "   <div class='grid-iteminput221'>";
        html = html + "      <label for='year_drop'>Select Year:</label>";
        html = html + "      <select id='year_drop' name='year_drop' class=dropDownSize>";
        html = html + "         <option value='' selected disabled hidden>Choose here</option>";
        html = html + "         <option>2016</option>";
        html = html + "         <option>2018</option>";
        html = html + "      </select>";
        html = html + "   </div>";
        

        html = html + "   <div class='grid-iteminput221'>";
        html = html + "     <label>Select Comparison:</label>";
        html = html + "         <input type='checkbox' id='LGA_box' name='LGA_box' value='true' class=dropDownSize>";
        html = html + "         <label for='LGA_box'>LGA</label>";
        html = html + "         <input type='checkbox' id='State_box' name='State_box' value='true' class=dropDownSize>";
        html = html + "         <label for='State_box'>State</label>";
        html = html + "         <input type='checkbox' id='National_box' name='National_box' value='true' class=dropDownSize>";
        html = html + "         <label for='National_box'>National</label>";
        html = html + "   </div>";

        html = html + "   <div class='grid-search221'>";
        html = html + "   <button type='submit' class='btn btn-primary'>Submit</button>";
        html = html + "   </div>";

        html = html + "</div>";

        html = html +"</form>";

        //Assignment selection/filter variable from form.
        String year_drop = "";
        year_drop = context.formParam("year_drop");
        String LGA_drop = context.formParam("LGA_drop");
        String LGA_box = context.formParam("LGA_box");
        String state_box = context.formParam("State_box");
        String national_box = context.formParam("National_box");