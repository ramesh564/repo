package packg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Baseclass {
	
	
	    public static WebDriver driver;

	    public void initializeBrowser()
	    
	    {
	       // WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	    }

	    public void closeBrowser()
	    {
	       if (driver != null)
	        driver.quit();
	    }
	}

		
		

