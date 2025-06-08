package sampleAPI;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPI {

	public static void main(String[] args) {
		
	//non-BDD approach 

	Response res = RestAssured.get("https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBooking");
	System.out.println(res.statusCode());
	System.out.println(res.asPrettyString());
	System.out.println(res.headers());
	}

}
