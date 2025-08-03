package packg;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.*;




public class Login {

	
	ExtentReports extent11;
    ExtentTest test;
	
	
	   static ExtentReports extent1;
	
	   ExtentReports extent = ExtentReportmanager.getReportObject();
	   
	   
	 

	    @Test
	    public void loginTest() {
	        ExtentTest test = extent11.createTest("Login Test");
	        
	        // Add your selenium code here
	        System.out.println("Running login test...");

	        test.pass("Login successful");

	        extent11.flush();
	
	}

}
