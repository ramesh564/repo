package packg;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

// Login in application

public class Locators {

	public static WebDriver driver;
	
	
	@BeforeMethod
    public void setup()
	{
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}
	
	@Test(priority=1)
	public void LoginTest()
	{
	driver.findElement(By.id("inputUsername")).sendKeys("rahul");
	driver.findElement(By.name("inputPassword")).sendKeys("hello123");
	driver.findElement(By.className("signInBtn")).click();

			
	}
	
    // Validation 
	
	@Test(priority=2)
	public void Loginvalidation()
	{
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("inputUsername")).sendKeys("rahul1");
	driver.findElement(By.name("inputPassword")).sendKeys("hello1213");
	driver.findElement(By.className("signInBtn")).click();
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
    System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	
	String errorMsg = driver.findElement(By.cssSelector("p.error")).getText();
	
	}
	
	

@AfterMethod
public void tearDown() 

{
    driver.quit();
}
}
	
		

		
		
		
		
		
		
		
		

