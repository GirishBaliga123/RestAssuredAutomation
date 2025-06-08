package pathParamQueryParam;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PathParametersWithMap {

	public static void main(String[] args) {

		//https://petstore.swagger.io/v2/pet/findByStatus?status=pending
		
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("version", "v2");
		params.put("petname", "pet");
		params.put("find", "findByStatus");
		
		given().
				pathParams(params).
				queryParam("status", "pending").
				log().all().
		when().
				get("https://petstore.swagger.io/{version}/{petname}/{find}").
		then().
				log().all().
				statusCode(200);
	}

}
