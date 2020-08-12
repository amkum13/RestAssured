import org.json.simple.JSONObject; 
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Tests_POSTandRestAll {
		
		@Test
		public void test_1_post() {
//			  Map<String, Object> map = new HashMap<String, Object>();
//			  
//			  map.put("name", "AMit");
//			  map.put("job", "Study");
//			  System.out.println(map);    //{name=AMit, job=Study} its not json have to 
			  							//parse it to json using some json parsers
			  
//			  JSONObject request = new JSONObject(map);
			
//2nd method without map
			
			 JSONObject req = new JSONObject();
			  req.put("name", "Amit");
			  req.put("job", "Study");
			  System.out.println(req);
			  System.out.println(req.toJSONString());
			  
			  given().
			  		header("Content-Type","application/json").
			  		contentType(ContentType.JSON).
			  		accept(ContentType.JSON).
			  		body(req.toJSONString()).
			  	when().
			  		post("https://reqres.in/api/users").
			  	then().
			  		statusCode(201).
			  		log().all();
		
		}
		@Test
		public void test_1_put() {

			
			 JSONObject request = new JSONObject();
			  request.put("name", "Amit");
			  request.put("job", "Learn");	//change the value from post response
			 
			  System.out.println(request.toJSONString());
			  
			  given().
			  		header("Content-Type","application/json").
			  		contentType(ContentType.JSON).
			  		accept(ContentType.JSON).
			  		body(request.toJSONString()).
			  	when().
			  		put("https://reqres.in/api/users/2"). //change to PUT url and put() method
			  	then().
			  		statusCode(200).
			  		log().all();
			  		
		
		}
		@Test
		public void test_1_patch() {

			
			 JSONObject request = new JSONObject();
			  request.put("name", "Amit");
			  request.put("job", "Learner");	//change the value from put response
			 
			  System.out.println(request.toJSONString());
			  
			  given().
			  		header("Content-Type","application/json").
			  		contentType(ContentType.JSON).
			  		accept(ContentType.JSON).
			  		body(request.toJSONString()).
			  	when().
			  		patch("https://reqres.in/api/users/2"). //change to Patch url and patch() method
			  	then().
			  		statusCode(200).
			  		log().all();
			  		
		
		}
		@Test
		public void test_1_delete() {

			//no request body required
			  
			  given().		//nothing given we just have url
			  	when().
			  		delete("https://reqres.in/api/users/2"). //change to delete url and delete() method
			  	then().
			  		statusCode(204); 		
		
		}
}
