package com.pages;

import static io.restassured.RestAssured.*;

import java.net.CacheResponse;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.apache.http.HttpResponse;
import org.testng.annotations.Test;

public class Auth {

	
	
	    	  
	    	        
	    	    @Test
	  	        public void testBasicAuth() 
	  	        
	  	        {
	  	            given()
	  	                .baseUri("https://httpbin.org")
	  	                .auth()
	  	                .basic("user", "passwd")
	  	            .when()
	  	                .get("/basic-auth/user/passwd")
	  	            .then()
	  	                .statusCode(200);
	  	            
	  	        }
	    	 
	    	    
	    	    @Test
	    	    public void loginAndGetToken() {
	    	        String payload = "{\n" +
	    	            "  \"userEmail\": \"rahul\",\n" +
	    	            "  \"userPassword\": \"hello123\"\n" +
	    	            "}";

	    	        Response response = given()
	    	            .baseUri("https://rahulshettyacademy.com")
	    	            .header("Content-Type", "application/json")
	    	            .body(payload)
	    	        .when()
	    	            .post("/api/ecom/auth/login");

	    	        String token = response.jsonPath().getString("token");
	    	        System.out.println("Access Token: " + token);
	    	    }
	    	    
	    	    
	    	
	    	    /*
	    	    
	    	    
	    	    
	    	     public void testBasicAuth() 
	  	        
	  	        {
	  	            given()
	  	                .baseUri("https://httpbin.org")
	  	                .auth()
	  	                .basic("user", "passwd")
	  	            .when()
	  	                .get("/basic-auth/user/passwd")
	  	            .then()
	  	                .statusCode(200);
	  	            
	  	        }
	    	    
	    	    
	    	    
	    	    */
	    	    		
	    	    		
	    	    		
	    	    
	    	    
	    	    /*
	   	     @Test
	   	     public void display()
	   	     
	   	     {
	   	            /*
	   	    	        ValidatableResponse res = given()
	   	    	            .baseUri("https://reqres.in/api")
	   	    	            .queryParam("page", 2)
	   	    	        .when()
	   	    	            .get("/users")
	   	    	        .then()
	   	    	            .statusCode(200);

	   	    	        res.log().all();
	   	    	        
	   	    	} 
	   	    	

	    	        
	    	        
	    	        
	    	/* given()
	    	    .baseUri("https://rahulshettyacademy.com")
	    	    .queryParam("key", "qaclick123")
	    	
	    	.when()
	    	    .get("/maps/api/place/get/json?place_id=xyz");
	    	
	    	    
            */
	    	        
	    	      
	    	 
	    	 
	          //  System.out.println(CacheResponse.getStatusCode());
	            //response.prettyPrint()
	    	     
	 	}
	 	
	 	
	  

			


	    
		    
		    


