package api_auto;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import  java.util.HashMap;

/*
given()
	content type, set cookies, add auth, parameter, set header

.when()
	get, post, put, delete

.then()
	validation - status code, extract response

 */

public class HTTPSRequest {

	int id;
	@Test (priority=1)
	void getUsers() {

		given()

		.when()
			.get("https://reqres.in/api/users/2")

		.then()
			.statusCode(200)
			.log().all();

	}
	@Test (priority=2)
	void createUser()
	{
		HashMap hm =new HashMap();
		
		// key & value
		hm.put("name", "rahul");
		hm.put("job", "trainer");
		
		id=given()
				.contentType("application/json")
				.body(hm)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
				

		/*.then()
			.statusCode(200)
			.log().all(); */
	}
	

}
