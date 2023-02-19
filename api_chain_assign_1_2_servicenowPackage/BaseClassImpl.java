package api_chain_assign_1_2_servicenowPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClassImpl {

	static RequestSpecification request = null;
	static String sys_id = null;
	static String descIncident = null;
	static Response response = null;

	
	@BeforeMethod
	public void setup () {
			
		  RestAssured.baseURI="https://dev87862.service-now.com/api/now/table/";
		  RestAssured.authentication=RestAssured.basic("admin", "q-IhZF$6oWd5");
		  
		  request = RestAssured.given().contentType(ContentType.JSON).log().all();
		  
	}
	
	
	@AfterMethod
	public void teardown () {
		  response.then().log().all();
    }
	
}
