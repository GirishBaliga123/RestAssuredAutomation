package sampleAPI;

import  static io.restassured.RestAssured.*;

public class GetAPI2 {

	//BDD approach with given(), when() and then()
	
	public static void main(String[] args) {
		
		given().
		log().all().
		when().
		get("https://restful-booker.herokuapp.com/booking/1").
		then().
		log().all().
		statusCode(200);
	
	}

}
