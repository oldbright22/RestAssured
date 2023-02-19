package wk_steps;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;

import wk_source.Global;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class API_assign5__1POST extends Global {

	///////////////////////////////////////////
	//ASSIGNMENT 5
	///////////////////////////////////////////
	//Create POST - change request	
	//- status code Validation
	//- task_effective_number is 10 digits	
	
	@When("create postBody")
	public void create_postBody() {
		
  	Map<String, String> bodychanges = new HashMap<String, String>();
	bodychanges.put("short_description", "created incident");
	bodychanges.put("description", "new description by bernise - via cucumber");
		
	   request = RestAssured.given().contentType(ContentType.JSON).when().body(bodychanges).log().all();
	}

	@And("send postRequest")
	public void send_postRequest() {
		response = request.post("change_request");
	}

	@Then("validate postResponse")
	public void validate_postResponse() {
		
	  //Confirm StatusCode	
	  response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
	  
	  sys_id = response.body().jsonPath().getString("result.sys_id");
	  
	  String task = response.body().jsonPath().getString("result.task_effective_number");
	  
	  //Confirm task effective_number is in fact = 10 digits
	  int strSize = task.length();
	  assertEquals(10, strSize);
	}
	
}
