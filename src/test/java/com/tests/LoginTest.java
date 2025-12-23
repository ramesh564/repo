
package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseTest;
import com.pages.Loginpage;


public class LoginTest extends BaseTest  {
	
	

	@Test
    public <HomePage> void testValidLogin()
	{
		Loginpage login = new Loginpage(driver);
        login.login("rahul", "rahulshettyacademy");
        
        String currentUrl = driver.getCurrentUrl();
      
     
        String errorMsg = login.getWelcomeMessage();
        
       
        String expected = "Rahul Shetty"; 
        
        
        
        
        String actual = driver.findElement(By.xpath("//*[@id='root']//h1/strong")).getText();
        
        
        System.out.println("Actual text = " + actual);
        
        
        Assert.assertEquals(actual, expected,
                "Login welcome message ");
      
      
      
    }

	
}
