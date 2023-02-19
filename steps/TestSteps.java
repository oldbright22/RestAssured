package steps;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestSteps {

	RequestSpecification request = null;
	Response response = null;
	
	@Given("set the endpoint")
	public void setEndpoint() {
		RestAssured.baseURI = "https://dev87862.service-now.com/api/now/table/incident";
	}
	
	@And("add the Auth")
	public void addAuth() {
		RestAssured.authentication = RestAssured.basic("admin", "q-IhZF$6oWd5");
	}
	
	@And("add the queryparams")
	public void addQueryParams(DataTable dt) {
		request = RestAssured.given().log().all();
		Map<String, String> asMap = dt.asMap();
		request.queryParams(asMap).contentType(ContentType.JSON);
	}
	
	@And("add the queryparams as {string} and {string}")
	public void addQueryParamsAsString(String key, String value) {
		request = RestAssured.given().log().all();
		
		request.queryParam(key, value).contentType(ContentType.JSON);
	}
	
	
	@When("send the request with queryParams")
	public void sendRequestQP() {
		request = RestAssured.given().log().all();
		
		response = request.get();
	}
	
	@When("send the request")
	public void sendRequest() {
		request = RestAssured.given().log().all();
		response = request.get();
	}	
	
	@When("send the request for assignment")
	public void sendRequestAssignment() {
		
		response = RestAssured.get();
	}
	
	@When("send the post request")
	public void sendRequestPost() {
		
		response = RestAssured.given().contentType(ContentType.JSON).post();
	}
	
	
	@When("post request is sent with short description as {string} and category (string}")
	public void postRequest(String short_desc, String category) {
		
		Map<String, String> bodychanges = new HashMap<String, String>();
		bodychanges.put("short_description", short_desc);
		bodychanges.put("description", category);
		
		request = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).log().all();
		response = request.body(bodychanges).post("incident");
	}
	
	
	@When("send the request for assignment as {string}")
	public void sendRequestAssignment4(String verb) {
		request = RestAssured.given().log().all();

		if (verb.equalsIgnoreCase("get"))
			response = request.get();
		else if (verb.equalsIgnoreCase("post"))
			response = request.contentType(ContentType.JSON).post();
		
		response.prettyPrint();
	}
	
	
	@When("post request with short description as {string} and category (string}")
	public void postRequest2(String short_desc, String category) {
		
		Map<String, String> bodychanges = new HashMap<String, String>();
		bodychanges.put("short_description", short_desc);
		bodychanges.put("description", category);
		
		response = request.body(bodychanges).post("incident");
	}
	
	
	@Then("validate the response status code and number")
	public void response() {
		response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
		System.out.println(response.prettyPrint());
		
		response.then().assertThat().body("result.number", Matchers.containsString("INC"));
	}

	@Then("validate the response")
	public void validateResponse() {
		response.then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
	}
	
	
	@Then("validate the response as {int}")
	public void validateResponseInt(int code) {
		response.then().log().all().assertThat().statusCode(code);
	}

	@When("post the request with file as {string}")
	public void fileUpload(String fileName) {
		response = request.body(new File("./src/test/resources/" + fileName)).post();
	}
	
	
	@Then("Validate the length of incident number")
	public void validateResposelength() {
		response.then().log().all().assertThat().body("result[0].number.size()", Matchers.is(10));
	}
	
	
	@Then("validate the response as {string}")
	public void validateResposeString(String code) {
		response.then().log().all().assertThat().statusCode(Integer.parseInt(code));
	}
	
	@Then("validate the response for below")
	public void responseWithDataTable(Map<String,String> responseFields) {
		
			for (Entry<String,String> eachEntry : responseFields.entrySet()) {
				  response.then().body(eachEntry.getKey(), equalTo(eachEntry.getValue()));
				  System.out.println(response.prettyPrint());
			}
	}
	
	

}
