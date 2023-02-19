package api_basic_servicenowPackage;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class A_JSON_CreateIncident_POSTTest {
	public static String gblIncidentId;
	
  @Test
  public void incident_creationTest() {
	  
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
	  request.put("short_description", "incident_created.");
	  request.put("description", "created_by_bernise_with_maven_java");
	  
	
	  String incidentId = RestAssured.given().contentType("application/json")
	    	      .body(request)
	    	      .when()
	    	      .post(RestAssured.baseURI + "/incident")
	    	      .then()
	    	      .assertThat()
	    	      .statusCode(HttpStatus.SC_CREATED)
	    	      .extract()
	    	      .path("result.sys_id");
	    	   
	  System.out.println("Sys_Id created for incident is ----"+ incidentId);
	 
	  gblIncidentId = incidentId; 
	  
	  ///////////////////////////////////////////////////////////////////////////////  
	  //PER CLASS ASSIGNMENT, verified that I can execute below lines.
	  ///////////////////////////////////////////////////////////////////////////////
	  
	  
	  //https://github.com/rest-assured/rest-assured/wiki/Usage#parameters
	  RequestSpecification inputRequest = RestAssured.given()
	  		  										.contentType("application/json")
	  		  									  //if not specified, by default will be json
	  		  										.accept("application/json") //aplication/xml 
	  		  										.when()
	  		  										.body(request);
	     										  //.body("{\"short_description\":\"incident_created.\",\"description\":\"created_by_bernise_with_maven_java\"}");
			  										
	  
	  //#4
	  Response response = inputRequest.post("/incident");
	  
	  //#5
	  //Get status code
	  int statusCode = response.getStatusCode();
	  System.out.println("Status code for create incident is ---- "+statusCode);
	  
	  //Print response in console
	  response.prettyPrint();
	  
  }
}
