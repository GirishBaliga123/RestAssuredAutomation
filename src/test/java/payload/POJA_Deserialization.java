package payload;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.TokenAuthorization;

public class  POJA_Deserialization {

     @Test	
	public void testDeserialization()
	{
		Map<String, String>payload =  Map.of("username", "admin", "password", "password123");
		
	    Response res = 	
	        RestAssured.
			given().
			log().all().
			//contentType(ContentType.JSON).
			header("Content-Type","application/json").
			body(payload).
			when().
			post("https://restful-booker.herokuapp.com/auth").
			then().
			log().all().
			statusCode(200).extract().response();

	        TokenAuthorization tokenID =  res.as(TokenAuthorization.class);
	        
	        System.out.println("toke id is"+ tokenID.getToken());
	}
		
}


