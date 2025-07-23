package packg;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Testrest {


//	private static Object given;

	public static void main(String[] args)
	{
	
		  RestAssured.baseURI = "https://rahulshettyacademy.com";
	
        given()
            .log().all()
            .queryParam("Key", "qaclick123")
            
            .header("Content-Type", "application/json")
     
    
            .body(Payload.AddPayload())  // ✅ This returns the JSON body
        .when()
            .post("maps/api/place/add/json")
        .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .body("scope", equalTo("APP"))
            .header("Server", "Apache/2.4.52 (Ubuntu)");
    }

}
	

	/*
   .queryParam("key","quick123")
   
   .header("content-Type","Application/json")


  
  
   .body("{\r\n" +
           "  \"location\": {\r\n" +
           "    \"lat\": -38.383494,\r\n" +
           "    \"lng\": 33.427362\r\n" +
           "  },\r\n" +
           "  \"accuracy\": 50,\r\n" +
           "  \"name\": \"Frontline house\",\r\n" +
           "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
           "  \"address\": \"29, side layout, cohen 09\",\r\n" +
           "  \"types\": [\r\n" +
           "    \"shoe park\",\r\n" +
           "    \"shop\"\r\n" +
           "  ],\r\n" +
           "  \"website\": \"http://google.com\",\r\n" +
           "  \"language\": \"French-IN\"\r\n" +
           "}")
   
   .when()
   .post("maps/api/place/add/json")
   .then()
   .log().all().assertThat().statusCode(200).body("scope",equalTo("APP"));
   
   
   
   */

	

