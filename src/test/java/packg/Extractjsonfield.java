package packg;

import io.restassured.path.json.JsonPath;
public class  Extractjsonfield {

	public static void main(String[] args) {
		
		
		
		String jsonResponse= "{\n" +
		
                "  \"status\": \"OK\",\n" +
                
                "  \"place\": {\n" +
                
                "    \"id\": \"abc123\",\n" +
                
                "    \"address\": \"29, side layout, cohen 09\",\n" +
                
                "    \"city_code\": \"IN-MH\",\n" +
                
                "    \"name\": \"Frontline house\"\n" +
                "  }\n" +
                "}";
		
		JsonPath js = new JsonPath(jsonResponse);
		String id=js.getString("place.id");
		
		String id1=js.getString("status");
		
		String address=js.getString("place.address");
		
		String city=js.getString("place.city_code");
		
		
		
		    System.out.println("ID        : " + id1);
	        System.out.println("Address   : " + address);
	        System.out.println("City Code : " + id1);
				
				
		
		
		

	}

}
