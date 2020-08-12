import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Tests_GET {
		
	@Test
	void test_1() {
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[1]", equalTo(8))
			.log().all()		//log the entire response
			.body("data.first_name", hasItems("Michael","Lindsay"));
		
		System.out.println("All validations passed");
	}
}
