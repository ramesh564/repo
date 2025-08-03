package packg1;




import io.restassured.response.Response;
import packg.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
                                        // required for given(), when(), then()


public class RestApi {
	
	
	public static void main(String[] args)
	{

	 RestAssured.baseURI = "https://rahulshettyacademy.com";
	  

	 Response  response = given()
             .queryParam("key", "qaclick123")
             .header("Content-Type", "application/json")
             .body(Payload.AddPayload())  // Your method that returns the request JSON
     .when()
             .post("maps/api/place/add/json")
     .then()
             .log().all()
             .assertThat().statusCode(200)
             .body("", equalTo("APP"))
    
            
            // .body("scope", equalTo("APP")) // ✅ Add this if the response body includes "scope": "APP"
           //  .header("Server", "Apache/2.4.52 (Ubuntu)") // Optional header assertion
             .extract().response();

     // Print the response body as string
     System.out.println("Response Body:\n" + response.asString());
     
     
     String response1=given().log().all().
    		            queryParam("key", "qaclick123")
    		           .header("Content-Type","application/json")
    		           .body(Payload.AddPayload())
    		.when()
    		.post("https://your-api-endpoint.com/path")
    		.then()
    		           .log().all()
    		           .assertThat().statusCode(200).body("scope",equalTo("APP"))
    		           .header("server","Apache/2.4.8").extract().response().asString();
     
            
     
     
     
 }
     
		
		


	
	}
	  



