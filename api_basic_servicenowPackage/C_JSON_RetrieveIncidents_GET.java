package api_basic_servicenowPackage;

import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;


import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import org.hamcrest.Matcher;
//import org.hamcrest.Matchers.*;


import java.util.Iterator;
import java.util.List;
import java.util.Map;



import io.restassured.RestAssured;
//import io.restassured.RestAssured.*;
//import io.restassured.matcher.RestAssuredMatchers.*;
//import io.restassured.module.jsv.JsonSchemaValidator.*;
//import io.restassured.path.json.*;
//import io.restassured.path.xml.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class C_JSON_RetrieveIncidents_GET {

	
	@Test
	public void incident_retrieval() {
		
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
		  RequestSpecification inputRequest = RestAssured.given()
				  										.param("description", "created_by_bernise_with_maven_java")
				  										.contentType("application/json")
				  										//if not specified, by default will be json
				  										.accept("application/json"); //application/xml 
				  										
		  
		  //#4
		  //Able to add parameters to request
		//Response response = inputRequest.get("/incident?description=created_by_bernise_with_maven_java");
		  Response response = inputRequest.get("/incident");
		  
		  
		  //#5
		  //Get status code = 200
		  int statusCode = response.getStatusCode();
		  System.out.println("Status code for create incident is ----"+statusCode);
		  
		  //Print response in console
		  response.prettyPrint();
		  
		  ////////////////////////////////////////////////////////////////////////////////
		  //Types of validations
		  ////////////////////////////////////////////////////////////////////////////////
		  //https://github.com/rest-assured/rest-assured/wiki/Usage#example-1---json
		  ////////////////////////////////////////////////////////////////////////////////
		  //"sys_id": "686cdaef87f02110b24e99383cbb358e"
	

		  assertThat(response.statusCode()).isEqualTo(200);
		  assertThat(response.header("Content-Type")).matches("application/json;charset=UTF-8.*");
 
		  DocumentContext docContext = JsonPath.parse(response.getBody().asString());
		  JsonPath jsonPath = JsonPath.compile("$.result");
		  List<Map<String,String>> jsonList = docContext.read(jsonPath);
			
		  for (int i=0; i< jsonList.size(); i++)
		  {
			  Iterator item = jsonList.get(i).entrySet().iterator();
			  
			  while(item.hasNext()){
				  Map.Entry itemEntry = null;    
			      itemEntry = (Map.Entry) item.next();
			      String strKey = (String) itemEntry.getKey();
			      String strVal = (String) itemEntry.getValue().toString();
			      //Employee empObject = (Employee) empEntry.getValue();
			      
			      System.out.println(strKey + " => " + ": " + strVal);
			  }  
		  }
		  
		  
		  //assertThatJson(parsedJson).field("['id']").isEqualTo("11");
		  //assertThatJson(parsedJson).field("['backlog']").isNull();
		  
				  
		  
	}
	
	
}
