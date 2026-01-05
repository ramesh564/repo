package listeners;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.BaseTest;

import Utility.screenshotutility;



		
	public class TestListener extends BaseTest implements ITestListener {

	    private static final ITestResult ExtentManager = null;
		Object extent = ExtentManager.getInstance();
	    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest extentTest = ((ExtentReports) extent).createTest(result.getMethod().getMethodName());
	        test.set(extentTest);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.get().pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.get().fail(result.getThrowable()); // mark test as failed

	        WebDriver driver = BaseTest.driver;
	        String screenshotPath = screenshotutility.takeScreenshot(driver, result.getName());

	        try {
	            test.get().fail("Screenshot of failure",
	                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.get().skip(result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        ((ExtentReports) extent).flush(); // write the report
	    }
	}
		

	
