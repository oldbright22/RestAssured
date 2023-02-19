package api_chain_assign_1_2_servicenowPackage;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class JSON_UpdateIncident_PUT extends BaseClassImpl {

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
	//a) Update any change_request with the below short description
    //"using put method for hemcrest" using the put method and ensure the update is successful

	
	@Test( dependsOnMethods = {"api_chain_assign_1_2_servicenowPackage.JSON_CreateIncident_POST.createIncidentTest" })
	public void updateIncidentTest() {
		
		
		Map<String, String> bodychanges = new HashMap<String, String>();
		bodychanges.put("short_description", "using put method for hemcrest");
		bodychanges.put("description", "updated_by_bernise_with_maven_java_chained");
		  
		response = request.body(bodychanges).put("incident/"+sys_id);
		
		sys_id = response.jsonPath().get("result.sys_id");
		System.out.println("============== UPDATED =================== Sys_id === "+sys_id);
		
		descIncident = response.jsonPath().get("result.description");
		System.out.println("============== UPDATED =================== Desc === "+ descIncident);
		
		response.then().assertThat().statusCode(HttpStatus.SC_OK);
		response.then().assertThat().body("result.short_description", Matchers.equalTo("using put method for hemcrest"));

	}
	
}
