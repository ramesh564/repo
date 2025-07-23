package packg;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportmanager {
	
	static ExtentReports extent;

    public static ExtentReports getReportObject() {
        String path = System.getProperty("user.dir") + "/reports/index.html";


        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Ramesh Automation Results");
        reporter.config().setDocumentTitle("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Ramesh Gaikwad");
        
        
        

        return extent;
    }
}


