package api_chain_assign_1_2_servicenowPackage;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class JSON_DeleteIncident_DELETE extends BaseClassImpl {
	

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
	//c) delete any change_request and verify the status line is equal to "HTTP/1.1 204 No content"

	@Test( dependsOnMethods = {"api_chain_assign_1_2_servicenowPackage.JSON_UpdateIncident_PATCH.patchIncidentTest" })
	public void deleteIncidentTest() {
	       
		   response = request.delete("incident/"+sys_id);
	       
	       System.out.println("============== DELETE =================== Sys_id=== "+sys_id);
           response.then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);	
           
           response.then().assertThat().statusLine("HTTP/1.1 204 No Content");
	}
	
}
