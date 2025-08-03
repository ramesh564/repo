package com.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
public class LoginTest  extends Loginpage{
	
	
	public LoginTest() throws IOException {
		super();
		
	}

	@FindBy(id = "inputUsername")
	  WebElement username;

	  @FindBy(name = "inputPassword")
	  WebElement password;

	  @FindBy(className ="signInBtn")
	  WebElement loginBtn;
	  


	public static WebDriver driver;
    Loginpage loginPage;
    
    static Properties prop;
    
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();  // Launch Chrome
        driver.get("https://rahulshettyacademy.com/locatorspractice/");  // Replace with actual login URL

        loginPage = new Loginpage(driver); 
        
        driver.manage().window().maximize();
        // Initialize page object
    }


    
    
    @Test
    public void testValidLogin()
    {
        loginPage.login("rahul", "hello123");  // Call login method
        // Add validation/assertions here if needed
    }
    
    
   
    @AfterMethod
    public void tearDown() 
    {
        driver.quit();  // Close browser
    }

}
