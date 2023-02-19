package api_chain_assign_1_2_servicenowPackage;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class JSON_CreateIncident_POST extends BaseClassImpl {

	
	@Test
	public void createIncidentTest() {
		
		///////////////////////////////////////////
		//ASSIGNMENT 2
		///////////////////////////////////////////
		//Chaining concept in servicenow - ( should use Base class concept and status code verification )
		//Create
		//edit
		//delete
		//get
		
		
		
		Map<String, String> bodychanges = new HashMap<String, String>();
		bodychanges.put("short_description", "created_incident_for_chained_exercised.");
		bodychanges.put("description", "created_by_bernise_for_chained_exercised.");
		
		
		response = request.body(bodychanges).post("incident");
		
		sys_id = response.jsonPath().get("result.sys_id");
		System.out.println("============== CREATED ===================  Sys_id === " + sys_id);
		
		descIncident = response.jsonPath().get("result.description");
		System.out.println("============== CREATED ===================  Desc === " + descIncident);
		
		response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
	}
	
	
}
