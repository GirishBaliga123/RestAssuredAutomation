package pathParamQueryParam;

import io.restassured.RestAssured;

public class QueryParameters {

	public static void main(String[] args) {

		
		//https://reqres.in/api/users?page=2
		
		RestAssured.given().
		queryParam("page", "2").
		queryParam("user", "active").       //invalid entry ..just to show multiple way query param usage 
		log().all().
		when().
		get("https://reqres.in/api/users").
		then().
		statusCode(200);
	}

}
