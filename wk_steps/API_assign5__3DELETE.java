package wk_steps;


import org.apache.http.HttpStatus;

import wk_source.Global;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;


public class API_assign5__3DELETE extends Global {

	///////////////////////////////////////////
	//ASSIGNMENT 5
	///////////////////////////////////////////
	//delete 
	//- status code verification
	//- validate the record is removed from the system

	@When("send deleteRequest")
	public void send_deleteRequest() {
		request = RestAssured.given().log().all();
	    response = request.delete("change_request/" + sys_id);
	}

	@Then("validate deleteResponse")
	public void validate_deleteResponse() {
		
	   //confirm via status code, record was in fact removed	
	   response.then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
	   
	   //confirm via logs that in fact a removal (204) occurred
	   //response.then().assertThat().statusLine("HTTP/1.1 204 No Content");
	}

}
