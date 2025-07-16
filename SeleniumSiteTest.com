package packg;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	

	
	
	public class SeleniumSiteTest {

	    WebDriver driver;

	    @BeforeClass
	    public void setup() {
	         // Automatically sets up ChromeDriver
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void openSeleniumWebsite() {
	        driver.get("https://www.selenium.dev");
	        String title = driver.getTitle();
	        System.out.println("Page Title: " + title);
	        Assert.assertTrue(title.contains("Selenium"), "Title does not contain 'Selenium'");
	    }

	    @AfterClass
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();  // Close browser
	        }
	    }
	}

