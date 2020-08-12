package data.driven.tests;
import org.json.simple.JSONObject; 
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class Tests_ZDataDrivenExamples1 //extends Test_ZDataForTests {
	
{


//	@Test(dataProvider= "dataForPost")
	public void test_1_post(String firstName, String lastName, int subjectId ) {
		
		 
		
		JSONObject req = new JSONObject();
		req.put("firstName", firstName);
		req.put("lastName", lastName);
		req.put("subjectId", subjectId);
		
		baseURI = "http://localhost:3000/";
		
		System.out.println(req.toJSONString());

		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();

	}
	
	
//	@Test(dataProvider = "dataForDelete")			//thro data provider class
	public void test_1_delete(int userId) {

		//no request body required
		
		baseURI = "http://localhost:3000/";
		  
		  given().		
		  	when().
		  		delete("/users/"+userId). //append the user id in url
		  	then().
		  		statusCode(200). 
		  		log().all();
	
	}
	@Parameters({"userId"})				//thro parameter testng.xml file
	@Test
	public void test_2_delete(int userId) {

		
		System.out.println("Parameter received for userId: "+userId);
		baseURI = "http://localhost:3000/";
		  
		  given().		
		  	when().
		  		delete("/users/"+userId). //append the user id in url
		  	then().
		  		statusCode(200). 
		  		log().all();
	
	}

	
	}

