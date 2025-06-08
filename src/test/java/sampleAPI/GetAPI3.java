package sampleAPI;

import  static io.restassured.RestAssured.*;
import  io.restassured.response.Response;

public class GetAPI3 {

	//Combination of BDD approach and Non-BDD 
	
	public static void main(String[] args) {
		
		Response res = given().
		when().
		get("https://restful-booker.herokuapp.com/booking/1");
		
	// instead of then() we can store in response interface and print accordingly
		
		System.out.println(res.statusCode());
		System.out.println(res.asPrettyString());
		System.out.println(res.contentType());
	
	}
	

}
