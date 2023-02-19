package wk_steps;


import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class API_assign3__POST_serviceoutline {


	///////////////////////////////////////////
	//ASSIGNMENT 3
	///////////////////////////////////////////
	//(cucumber)  - Create 3 incidents using the same scenario (Hint - use Scenario Outline)
	//(Short-desc - "This is First"  and category -"software")  and verify the category is software
	//(Short-desc - "This is Second" and category -"hardware")  and verify the category is not software nor inquiry
	//(Short-desc - "This is Third"  and category -"inquiry")   and verify the short-desc is not empty

    
	RequestSpecification request;
	Response response;
	
	@When("^create postRequest withItems (.*) and (.*)$")
	public void create_postRequest_withItems(String short_desc, String category) {
		
		Map<String, String> bodychanges = new HashMap<String, String>();
		bodychanges.put("short_description", short_desc);
		bodychanges.put("category", category);
			
	   request = RestAssured.given().contentType(ContentType.JSON).body(bodychanges).log().all();
	   
	   response = request.post("change_request");
	}
	
	@Then("^validate postRequest withItems (.*) and (.*)$")
	public void validate_postReponse_withItems(String short_desc, String category) {
		response.then().assertThat().statusCode(HttpStatus.SC_CREATED);  
		response.then().assertThat().body("result.short_description", Matchers.containsString(short_desc));
		response.then().assertThat().body("result.category", Matchers.containsString(category));
	}

	
}
