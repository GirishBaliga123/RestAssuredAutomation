package pathParamQueryParam;

import static io.restassured.RestAssured.*;

public class PathParameters {

	public static void main(String[] args) {

		//https://petstore.swagger.io/v2/pet/findByStatus?status=pending

		
		          given().
				             pathParam("version", "v2").
				             pathParam("petname", "pet").
				             pathParam("find", "findByStatus").
				             queryParam("status", "pending").
				             log().all().
		           when().
		                      get("https://petstore.swagger.io/{version}/{petname}/{find}").
		           then().
		                      log().all().
		                      statusCode(200);
	}

}
