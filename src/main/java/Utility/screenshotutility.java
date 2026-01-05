package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class screenshotutility 
{
	
	public static String takeScreenshot(WebDriver driver, String testName)
	
	{
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		String filePath = System.getProperty("user.dir") 
	                + "/reports/screenshots/" 
	                + testName + "_" + timestamp + ".png";
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);
        
        
        try
        {
        	dest.getParentFile().mkdirs(); // create folders if missing
            FileHandler.copy(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } 
        
        catch (IOException e) 
        {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
		
		return testName;
	
	}

}



