package payload;

import static io.restassured.RestAssured.baseURI;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class PayloadAsMap2 {

	/**
	 * Payload as Map with nested JSON objects as POJO
	 * */
	
	
	public static void main(String[] args) {

		//https://restful-booker.herokuapp.com/booking

		
		 baseURI = "https://restful-booker.herokuapp.com";
         
         Map<String, Object>payload = new LinkedHashMap<>();
         payload.put("firstname","Girish");
         payload.put("lastname","Baliga");
         payload.put("totalprice",1000);
         payload.put("depositpaid",true);
         
         
         Map<String, String>bookingDates = new LinkedHashMap<String, String>();
         
         bookingDates.put("checkin","2025-01-01");
         bookingDates.put("checkout","2026-01-01");
         
         payload.put("bookingdates",bookingDates);
         payload.put("additionalneeds","Dinner");       
         
		
		RestAssured.given().
		log().all().
		header("Content-Type","application/json").
		body(payload).
		pathParam("path", "booking").
		when().
		post("/{path}").
		then().
		log().
		all().
		statusCode(200);

	}

}
