package packg;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;

public class Login {

	
	
	   static ExtentReports extent1;
	
	   ExtentReports extent = ExtentReportmanager.getReportObject();

	    @Test
	    public void loginTest() {
	        ExtentTest test = extent1.createTest("Login Test");
	        
	        // Add your selenium code here
	        System.out.println("Running login test...");

	        test.pass("Login successful");

	        extent1.flush();
	
	}

}
