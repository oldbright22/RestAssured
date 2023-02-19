package api_basic_servicenowPackage;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class B_JSON_UpdateIncident_PUT {

	
	@Test
	public void incident_update() {
	//INC0010151	
	//"sys_id": "686cdaef87f02110b24e99383cbb358e"	
		
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
		  
		  
		  Map<String, String> request = new HashMap<String, String>();
		  request.put("short_description", "incident_updated_with_maven_java.");
		  request.put("description", "updated_by_bernise_with_maven_java");
		  
		  String updateIncidentId ="686cdaef87f02110b24e99383cbb358e";
		  
		  String incidentId = RestAssured.given().contentType("application/json")
		    	      .body(request)
		    	      .when()
		    	      .put(RestAssured.baseURI + "/incident"+"/"+updateIncidentId)
		    	      .then()
		    	      .assertThat()
		    	      .statusCode(HttpStatus.SC_OK)
		    	      .extract()
		    	      .path("result.sys_id");
		    	   
		  System.out.println("Sys_Id updated for incident #1 is ----"+ incidentId);
		 
		   
		  
		  ///////////////////////////////////////////////////////////////////////////////  
		  //PER CLASS ASSIGNMENT, verified that I can execute below lines.
		  ///////////////////////////////////////////////////////////////////////////////
		  
		  //https://github.com/rest-assured/rest-assured/wiki/Usage#parameters
		  RequestSpecification inputRequest = RestAssured.given()
		  		  										 .contentType("application/json")
		  		  									   //if not specified, by default will be json
		  		  										 .accept("application/json") //aplication/xml 
		  		  										 .when()
		  		  										 .body(request)
		  		  									     .queryParams("sysparm_fields","sys_id,short_description,description,number");
		     										   //.body("{\"short_description\":\"incident_created.\",\"description\":\"created_by_bernise_with_maven_java\"}");
			
		  
		  //#4
		  String update2IncidentId = "4cb48beb87b42110b24e99383cbb3549";
		  Response response = inputRequest.put("/incident"+"/"+update2IncidentId);
		  
		  
		  //#5
		  //Get status code
		  int statusCode = response.getStatusCode();
		  System.out.println("Status code for update incident #2 is ---- "+statusCode);
		  
		  
		  //Print response in console
		  response.prettyPrint();
		  
		
	}
}
