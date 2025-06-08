package sampleAPI;


import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class Hamcrest {

	public static void main(String[] args) {

		String payload = "{\r\n"
				+ "    \"firstname\": \"Jim\",\r\n"
				+ "    \"lastname\": \"Brown\",\r\n"
				+ "    \"totalprice\": 111,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}";	
		
		given().
		log().all().
		header("Content-Type","application/json").
		body(payload).
		when().
		post("https://restful-booker.herokuapp.com/booking").
		then().
		log().all().
		body("booking.firstname",equalTo("Jim")).
		body("booking.additionalneeds",containsStringIgnoringCase("Breakfast")).
		body("bookingid",notNullValue()).
		header("Content-Type", equalTo("application/json; charset=utf-8")).
		statusCode(200);
		
	
	}

}
