package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class Homepage {

	
	public static WebDriver driver;
	
	
	 // Constructor
    public Homepage(WebDriver driver) 
    {
        this.driver = driver;
    }
    
  
 //   Homepage Homepage = new Homepage(driver);
    
   

    
    @Test
    public void verifyWelcomeMessage1() {
        String message = Homepage.verifyWelcomeMessage();
        Assert.assertEquals(message, "Welcome to Rahul Shetty Academy");
    }

    
	public static String verifyWelcomeMessage() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
   
    
}
	


