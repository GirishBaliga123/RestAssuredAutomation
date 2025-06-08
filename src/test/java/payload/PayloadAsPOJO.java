package payload;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.SamplePoJo;

public class PayloadAsPOJO {

	public static void main(String[] args) {

		//https://reqres.in/api/users
		
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		SamplePoJo payload = new SamplePoJo();   // Calling POJO class which contains payload
		payload.setName("Girish");                
		payload.setJob("Senior QA");
		
		String res = RestAssured.
		given().
		log().all().
		contentType(ContentType.JSON).
		header("x-api-key","reqres-free-v1").
		body(payload).
		when().
		post("/users").
		then().
		log().all().
		statusCode(201).
		body("id",Matchers.notNullValue()).
		extract().response().jsonPath().getString("id");
		//System.out.println(res.jsonPath().getInt("id"));

		System.out.println("id is "+res);
		
		
		
		RestAssured.given().
		log().all().
		header("x-api-key","reqres-free-v1").
		pathParam("userId", res).
		when().
		delete("/users/{userId}").
		then().
		log().all().
		statusCode(204);
		
	}

}
