package assignment_01;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class TCCreateNewObject {

	public static void main(String[] args) {

		String body = "{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}";
		
		Response res = given().
		   log().all().	
		        body(body).
		          header("Content-Type","application/json").
		           when().
		               post("https://api.restful-api.dev/objects").
		                    then().
		                       log().all().
		                           statusCode(200).
		                                time(lessThan(2000L)).
		                                     body("id", notNullValue()).
		                                       extract().response();   //extract response 
		
	
		//Extracted response get the product ID and print in console
		
		  String productID =   res.jsonPath().getString("id");	
		  System.out.println("Product ID is "+productID);
		
	}

}
