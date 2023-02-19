package wk_steps;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import wk_source.Global;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class API_assign5__2PUT extends Global {

	///////////////////////////////////////////
	//ASSIGNMENT 5
	///////////////////////////////////////////
	//update PUT (change request)
	//    change description with 6 digit random alphanumeric
	//	- status code verification
	//	- verify the description was updated with the 6 digit random alphanumeric
	
	String randomDesc="R1ND0M3";
	
	@When("create putBody")
	public void create_putBody() {
		
		
	  	Map<String, String> bodychanges = new HashMap<String, String>();
		bodychanges.put("short_description", randomDesc);

		request = RestAssured.given().contentType(ContentType.JSON).when().body(bodychanges).log().all();
	}

	@And("send putRequest")
	public void send_putRequest() {
	    response = request.put("change_request/" + sys_id);
	}

	@Then("validate putResponse")
	public void validate_put_response() {
	    response.then().assertThat().statusCode(HttpStatus.SC_OK);
	    response.then().assertThat().body("result.short_description", Matchers.containsString(randomDesc));
	}

	
}
