package pathParamQueryParam;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class QueryParametersWithMap {

	public static void main(String[] args) {

		
		Map<String, Object>Params = new LinkedHashMap<>();
		Params.put("page", 2);
		Params.put("user", "active");
		
		//https://reqres.in/api/users?page=2
		
		RestAssured.given().
		queryParams(Params).
		log().all().
		when().
		get("https://reqres.in/api/users").
		then().
		statusCode(200);
	}

}
