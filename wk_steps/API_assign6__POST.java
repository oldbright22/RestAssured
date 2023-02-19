package wk_steps;

import java.util.List;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import wk_source.Global;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class API_assign6__POST extends Global {

	///////////////////////////////////////////
	//ASSIGNMENT 6
	///////////////////////////////////////////
	//(cucumber) - create an incident and add the below validations (use datatable for validations wherever applicable)
    //urgency    - 3
	//approval   - not requested
	//knowledge  - false
	//number     - contains INC
	
	@When("create post body")
	public void create_post_body() {
		request = RestAssured.given().contentType(ContentType.JSON).when().body("{\r\n"
				+ "\"short_description\": \"Created\"\r\n"
				+ "}").log().all();
	}

	@And("send post request")
	public void send_post_request() {
		response = request.post("change_request");
	}

	@Then("validate post response")
	public void validate_post_response(DataTable dt) {
		
	    List<List<String>> data = dt.cells();
	    response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
	    
	    for(int i=0; i <= data.size()-1; i++) {
	    	response.then().assertThat().body("result."+data.get(i).get(0), Matchers.containsString(data.get(i).get(1)));
	    }
	}

}
