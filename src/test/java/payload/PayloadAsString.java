package payload;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class PayloadAsString {

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
		
		
Response res = 
		given().
		log().all().
		header("Content-Type","application/json").
		body(payload).
		when().
		post("https://restful-booker.herokuapp.com/booking").
		then().
		log().all().
		statusCode(200).
		body("bookingid",notNullValue()).
		body("booking.lastname", equalTo("Brown")).
		body("booking.bookingdates.checkin", notNullValue()).
		body("booking.bookingdates.checkout", notNullValue()).

		extract().response();

       String bookindId = res.jsonPath().getString("bookingid");
       System.out.println("booking id is "+bookindId);
       
  
	}

}
