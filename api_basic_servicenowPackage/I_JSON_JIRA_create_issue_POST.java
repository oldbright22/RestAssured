package api_basic_servicenowPackage;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class I_JSON_JIRA_create_issue_POST {

	public static String gblIssueId;
	
	  @Test
	  public void issue_creation() {
		  
		  ///////////////////////////////////////////////////////////////////////////////////
		  //Perform 5 steps for exercise API	
		  //////////////////////////////////////////////////////////////////////////////////
		  //1 - Requirement Analysis :: Understand API Documentation
		  //2 - End Point (Server + Port + Resources
		  //3 - Add Request (Header + Authorization + Request Query|Body
		  //4 - Send Request (sent to the server with appropriate request type)
		  //5 - Validate Request (response, status code, body) + assertions
			
		  //"message": "Invalid content-type. Supported request media types for this service are: [application/json, application/xml, text/xml]"
			
		  
		  //#2			                       
		  RestAssured.baseURI="https://jiraoldright22.atlassian.net/rest/api/2/";
		  //#3
		  RestAssured.authentication=RestAssured.preemptive().basic("oldbright22@gmail.com", 
		  "ATATT3xFfGF0gzbhP1yzGstVS63Pr0a_0jK7YV4bjIhpOqF1ucRdXdlKu3sShd91UcJlF2SkEqC4qhmeBqQVz2-2kGjPgJh0-22KkoFvFAzLHZHZ88U2uEKoG9Xd8EmbMZEOaf2HldfHLVHazx-0TshVEFJy5k8lRSDRV1A6LQd-JfneZ-aQWT4=DD3F833E"
		  );
		  
		  
		  /* Q: How to translate below into a map - so its easy to pass along
				{
				    "fields": {
				        "project": {
				            "key": "LDRGHTSCRM"
				        },
				        "summary": "create issue in SCRUM project - by bernise via Postman",
				        "description": "POST issue created via postman",
				        "issuetype": {
				            "name": "Bug"
				        }
				    }
				}
		   * */
		   
		  //Map<String, String> request = new HashMap<String, String>();
		  //request.put("short_description", "incident_created.");
		  //request.put("description", "created_by_bernise_with_maven_java");
		  
		
		  String issueId = RestAssured.given().contentType("application/json")
		    	      .body("{\r\n"
		    	      		+ "    \"fields\": {\r\n"
		    	      		+ "        \"project\": {\r\n"
		    	      		+ "            \"key\": \"LDRGHTSCRM\"\r\n"
		    	      		+ "        },\r\n"
		    	      		+ "        \"summary\": \"create issue in SCRUM project - by bernise via maven_java\",\r\n"
		    	      		+ "        \"description\": \"POST issue created via maven_java\",\r\n"
		    	      		+ "        \"issuetype\": {\r\n"
		    	      		+ "            \"name\": \"Bug\"\r\n"
		    	      		+ "        }\r\n"
		    	      		+ "    }\r\n"
		    	      		+ "}")
		    	      .when()
		    	      .post(RestAssured.baseURI + "issue/")
		    	      .then()
		    	      .assertThat()
		    	      .statusCode(HttpStatus.SC_CREATED)
		    	      .extract()
		    	      .path("id");
		    	   
		  System.out.println("ISSUE Id created is ----"+ issueId);
		 
		  gblIssueId = issueId; 
		  
		  
		  ///////////////////////////////////////////////////////////////////////////////  
		  //PER CLASS ASSIGNMENT, verified that I can execute below lines.
		  ///////////////////////////////////////////////////////////////////////////////
		  
		  
		  //https://github.com/rest-assured/rest-assured/wiki/Usage#parameters
		  RequestSpecification inputRequest = RestAssured.given()
		  		  									  .contentType("application/json")
		  		  									  .accept("application/json")
		  		  									  .when()
		  		  						    	      .body("{\r\n"
		  		  						    	      		+ "    \"fields\": {\r\n"
		  		  						    	      		+ "        \"project\": {\r\n"
		  		  						    	      		+ "            \"key\": \"LDRGHTSCRM\"\r\n"
		  		  						    	      		+ "        },\r\n"
		  		  						    	      		+ "        \"summary\": \"create issue in SCRUM project - by bernise via maven_java\",\r\n"
		  		  						    	      		+ "        \"description\": \"POST issue created via maven_java\",\r\n"
		  		  						    	      		+ "        \"issuetype\": {\r\n"
		  		  						    	      		+ "            \"name\": \"Bug\"\r\n"
		  		  						    	      		+ "        }\r\n"
		  		  						    	      		+ "    }\r\n"
		  		  						    	      		+ "}");
		     										  
				  										
		  
		  //#4
		  Response response = inputRequest.post("issue/");
		  
		  //#5
		  //Get status code
		  int statusCode = response.getStatusCode();
		  System.out.println("Status code for new issue is ---- "+statusCode);
		  
		  //Print response in console
		  response.prettyPrint();
		  
	  }
}
