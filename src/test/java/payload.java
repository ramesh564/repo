
import io.restassured.RestAssured;
import io.restassured.response.Response;
import packg.Payload;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.json.Json;
import static io.restassured.RestAssured.given;

import org.openqa.selenium.json.Json;
public class payload {

	
public  static  String  AddPayload()
	
	{
		
	return ("{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \"Ramesh QA\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "  \"address\": \"Pune\",\r\n"
			+ "  \"types\": [\"QA\"],\r\n"
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"Marathi\"\r\n"
			+ "}");
		
	}
	
	
}
