package payload;

import static io.restassured.RestAssured.baseURI;

import java.io.File;

import io.restassured.RestAssured;

public class PayloadAsFile {

	public static void main(String[] args) {

		 baseURI = "https://reqres.in/api";
		 
		File userfile =  new File(System.getProperty("user.dir")+"\\user.json");
		System.out.println("json file path "+userfile);
		
		RestAssured.given().
		log().all().
		header("Content-Type","application/json").
		header("x-api-key","reqres-free-v1").
		body(userfile).
		when().post("/users").
		then().
		log().all().
		statusCode(201);
		
	}

}
