package wk_steps;

import org.apache.http.HttpStatus;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class API_assign__GET_Incidents {

	RequestSpecification request;
	Response response;

	
	@When("Filter with query params {string} and {string}")
	public void query_param_and(String key, String value) {
	    request = RestAssured.given().queryParam(key, value).log().all();
	}

	
	@And("send get request")
	public void send_get_request() {
	    response = request.get("change_request");
	}

	
	@Then("validate get response")
	public void validate_get_response() {
	    response.then().log().all();
	    response.then().assertThat().statusCode(HttpStatus.SC_OK);
	}

}
