import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Apirequest {

	

	public static void main(String[] args) {
		

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given()
			    .queryParam("key", "qaclick123")
			    .header("Content-Type", "application/json")
			    .body(payload.AddPayload())
			.when()
			    .post("/maps/api/place/add/json")
			.then()
			   .assertThat().statusCode(200).body("scope", equalTo("APP"))
			   .extract().response().asString();   // ✅ Extract response body as String
		
			   
			
			
			System.out.println("Response :"+response);
	
					
	
			String js = new String("jsonPath");
		
			JsonPath jsonPath=new JsonPath(response);
			
			// Parse the response using JsonPath
			
			 String placeId = jsonPath.getString("place_id");
		
		     System.out.println("Extracted place_id: " + placeId);

	}

}
