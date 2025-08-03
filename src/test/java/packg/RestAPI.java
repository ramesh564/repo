

package packg;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAPI {


//	private static Object given;

	public static void main(String[] args)
	{
	
		  RestAssured.baseURI = "https://rahulshettyacademy.com";
	
        given().queryParam("Key", "qaclick123").header("Content-Type", "application/json")
     
    
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
	

	

	

