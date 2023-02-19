package api_basic_servicenowPackage;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class F_JSON_DeleteIncident_DELETE {

	
	@Test
	public void incident_deletion() {
		
		  A_JSON_CreateIncident_POSTTest createNewIncident = new A_JSON_CreateIncident_POSTTest();
		  createNewIncident.incident_creationTest();
		  
		  ///////////////////////////////////////////////////////////////////////////////////
		  //Perform 5 steps for exercise API	
		  //////////////////////////////////////////////////////////////////////////////////
		  //1 - Requirement Analysis :: Understand API Documentation
		  //2 - End Point (Server + Port + Resources
		  //3 - Add Request (Header + Authorization + Request Query|Body
		  //4 - Send Request (sent to the server with appropriate request type)
		  //5 - Validate Request (response, status code, body) + assertions
			
		  //        "message": "Invalid content-type. Supported request media types for this service are: [application/json, application/xml, text/xml]"
			
		  //#2	
		  RestAssured.baseURI="https://dev87862.service-now.com/api/now/table";
		  //#3
		  RestAssured.authentication=RestAssured.basic("admin", "q-IhZF$6oWd5");
		  	  
		 
		  String result = RestAssured.given().contentType("application/json")
		    	      .when()
		    	      .delete(RestAssured.baseURI + "/incident"+"/"+createNewIncident.gblIncidentId)
		    	      .then()
		    	      .assertThat()
		    	      .statusCode(HttpStatus.SC_NO_CONTENT)
		    	      .toString();
		    	      
		    	   
		  System.out.println("Sys_Id deleted for incident is ----"+ createNewIncident.gblIncidentId);
		 
		   
		  
		  ///////////////////////////////////////////////////////////////////////////////  
		  //PER CLASS ASSIGNMENT, verified that I can execute below lines.
		  ///////////////////////////////////////////////////////////////////////////////
		  createNewIncident.incident_creationTest();
		  
		  //https://github.com/rest-assured/rest-assured/wiki/Usage#parameters
		  RequestSpecification inputRequest = RestAssured.given();
		  		  										
		  //#4
		  Response response = inputRequest.delete("/incident"+"/"+createNewIncident.gblIncidentId);
		  
		  //#5
		  //Get status code
		  int statusCode = response.getStatusCode();
		  System.out.println("Status code for delete incident is ---- "+statusCode);
		  
		  //Print response in console
		  response.prettyPrint();

		
	}
	
}
