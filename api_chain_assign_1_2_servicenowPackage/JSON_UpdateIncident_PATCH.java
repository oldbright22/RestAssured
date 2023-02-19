package api_chain_assign_1_2_servicenowPackage;


import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class JSON_UpdateIncident_PATCH extends BaseClassImpl {

	
	///////////////////////////////////////////
	//ASSIGNMENT 2
	///////////////////////////////////////////
	//Chaining concept in servicenow - ( should use Base class concept and status code verification )
	//Create
	//edit
	//delete
	//get
	
	///////////////////////////////////////////
	//ASSIGNMENT 1
	///////////////////////////////////////////
	//b) update any change_request with the short description " using patch method for hamcrest"
	//using patch method and ensure that word hamcrest is present in the response and number is equal to 
	//""
	
	@Test( dependsOnMethods = {"api_chain_assign_1_2_servicenowPackage.JSON_UpdateIncident_PUT.updateIncidentTest" })
	public void patchIncidentTest() {
		
		
		Map<String, String> bodychanges = new HashMap<String, String>();
		bodychanges.put("description", "using patch method for hamcrest");
				  
		response = request.body(bodychanges).patch("incident/"+sys_id);
		
		sys_id = response.jsonPath().get("result.sys_id");
		System.out.println("============== UPDATED -PATCH =================== Sys_id === "+  sys_id);
		
		
		//Q: which type of comparision is more performant?
		descIncident = response.jsonPath().get("result.description");
		System.out.println("============== UPDATED -PATCH =================== Desc === "+ descIncident);
		
		response.then().assertThat().statusCode(HttpStatus.SC_OK);
		response.then().assertThat().body("result.description", Matchers.equalTo("using patch method for hamcrest"));

	}

	
}
