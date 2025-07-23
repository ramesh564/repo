package packg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Baseclass {
	
	
	    public static WebDriver driver;

	    public void initializeBrowser()
	    
	    {
	       // WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    public void closeBrowser() {
	        driver.quit();
	    }
	}

		
		

