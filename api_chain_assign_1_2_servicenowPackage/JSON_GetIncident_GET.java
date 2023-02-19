package api_chain_assign_1_2_servicenowPackage;

import org.testng.annotations.Test;

import org.apache.http.HttpStatus;

public class JSON_GetIncident_GET extends BaseClassImpl {
	
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

	@Test( dependsOnMethods = {"api_chain_assign_1_2_servicenowPackage.JSON_DeleteIncident_DELETE.deleteIncidentTest" })
	public void getIncidentTest() {
		
	       response = request.get("incident/"+sys_id);
	       System.out.println("============== GET =================== Sys_id === "+sys_id);
	       
           response.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);		
	}
	
}
