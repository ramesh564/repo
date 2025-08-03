package com.pages;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import packg.Payload;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.json.Json;
import static io.restassured.RestAssured.given;

public class payload {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	    Response response=given().log().all()
	    		  .queryParam("key","qaclick123")
	    		  .header("Content-Type","application/json")
	              .body("{\r\n"
	              		+ "	\"name\": \"Ramesh\",\r\n"
	              		+ "	\"language\": \"Marathi\",\r\n"
	              		+ "	\"address\": \"Pune\"\r\n"
	              		+ "}")
	               .when()
	               .post("maps/api/place/add/json")
	               .then()
	               .log().all()
	               .assertThat().statusCode(200).extract().response();
	               
	               System.out.println("json: " + response.asString());
	               
	               
	
	}

}


