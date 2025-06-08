package assignment_01;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;


public class TCGetObjectById {

	public static void main(String[] args) {

		
int productID =
	    given().
		when().
		get("https://api.restful-api.dev/objects/7").
		then().
		log().
		all().
		statusCode(200).
		body("name",equalTo("Apple MacBook Pro 16")).
		time(lessThan(2000L)).
		extract().jsonPath().getInt("id");

        System.out.println("Product ID is "+productID);
	}

}
