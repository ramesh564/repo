package packg;


import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginTest {

	
		
		public WebDriver driver;

	    @BeforeMethod
	    public void setup() throws InterruptedException {
	        driver = new ChromeDriver();
	        driver.get("https://rahulshettyacademy.com/locatorspractice/"); 
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	    }

	    
	   
	   
	   @DataProvider(name = "Logindata")
	   public Object[][] getData() 
	   
	   {
	       Object[][] data = new Object[2][2];

	       data[0][0] = Excelutils.getData("Sheet1", 0, 0); // rahul
	       data[0][1] = Excelutils.getData("Sheet1", 0, 1); // hello123

	       data[1][0] = Excelutils.getData("Sheet1", 1, 0); // rahul
	       data[1][1] = Excelutils.getData("Sheet1", 1, 1); // hello124
	       
	       data[2][0]=  Excelutils.getData("sheet1",2,0);
	       data[2][2]=  Excelutils.getData("Sheet1", 2, 2);
	           
	       
	       System.out.println("Data: " + data[0][0] + "/" + data[0][1]);
	       System.out.println("Data: " + data[1][0] + "/" + data[1][1]);
	       System.out.println("Data: " + data[2][0] + "/" + data[2][0]);
	       System.out.println("Data: " + data[2][2] + "/" + data[2][2]);
	        
	        

	        return data;

	   }
	  
	    
	    
	    
	    @Test(dataProvider = "Logindata")
	    public void loginTest(String username, String password) throws IOException, Exception
	    
	   {
	    	
	    	try 
	    	
	    	{
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.name("password")).sendKeys(password);
	        driver.findElement(By.className("signInBtn")).click();
	        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	        
	    	}
	    	
	    	catch(Exception e)
	    	
	    	{
	    		 if(driver!=null)
	    			 
	    		 {
	    		
	    		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	    FileUtils.copyFile(screenshot, new File("error.png"));  // needs commons-io lib
	    	    e.printStackTrace();
	    	    System.out.println(" Screenshot taken: error.png");
	    		 }
	    	    else
	    	    {
	                System.out.println("❌ Cannot take screenshot. Driver is null.");
	    	        
	    	    }
	    		 
	    	}
	    		
	    	}
	    
	    public void captureScreenshot(String fileName) 
	    
	    {
	        try {
	        	
	        	
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            File destination = new File("test-output/" + fileName + ".png");
	            FileUtils.copyFile(screenshot, destination);
	            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		

	  
	    
	    @AfterMethod
	    public void tearDown() 
	    {
	        driver.quit();
	    }
	    
	    
	     
	    
	     

}
