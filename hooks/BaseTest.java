package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class BaseTest {
	
	@Before
	public void setup() {
		RestAssured.baseURI = "https://dev87862.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "q-IhZF$6oWd5");
	}

}
