package payload;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.response.Response;

public class PayloadAsMap3 {

	public static void main(String[] args) {
		
		/**
		 * Payload as Map with  JSON objects as POJO
		 * */
		
		//https://reqres.in/api/users

             baseURI = "https://reqres.in/api";
             
             Map<String, Object>payload = new LinkedHashMap<>();
             payload.put("name","Girish");
             payload.put("job","SeniorTester");
		
		
Response res = 
		given().
		log().all().
		//contentType("application.json").
		header("Content-Type","application/json").
		header("x-api-key","reqres-free-v1").
		body(payload).
		when().
		post("/users").
		then().
		log().all().
		statusCode(201).
		body("id",notNullValue()).
		body("name", equalTo("Girish")).
		body("job", equalTo("SeniorTester")).
		body("createdAt", notNullValue()).

		extract().response();

       String userId = res.jsonPath().getString("id");
       System.out.println("user id is "+userId);
       
  
	}

}
