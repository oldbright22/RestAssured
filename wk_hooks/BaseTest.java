package wk_hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;


public class BaseTest {

	@Before
	public void configuration() {
		System.out.println("Hook | configuration ");
		
		RestAssured.baseURI = "https://dev87862.service-now.com/api/now/table/";
				
		RestAssured.authentication = RestAssured.basic("admin", "q-IhZF$6oWd5");
	}

	
}
