package com.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class BaseTest {

    
    protected static ExtentReports extent;
  //  protected WebDriver driver;
    protected ExtentTest test;
    public static WebDriver driver;

    // Initialize ExtentReports once before all tests
    
 
    
    
    @BeforeSuite
    public void setupExtentReport()
    {
        if (extent == null)
        {
        	
        	String reportPath = "C:/Users/" + System.getProperty("user.name") + "/Desktop/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    }

    

    // Setup browser before each test
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        test = extent.createTest("Test Execution Started");
        test.info("Browser launched successfully");

        // Start Extent test log
        test = extent.createTest(this.getClass().getSimpleName());
        test.info("Browser opened and navigated to URL");
    }

    // Teardown browser after each test
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            test.info("Browser closed");
        }
    }
    
    @AfterSuite
    public void flushReport() {
        extent.flush();  // This is MANDATORY
    }








}
	


