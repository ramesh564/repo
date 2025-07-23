package packg;

import org.testng.annotations.AfterSuite;

public class EmailTrigger 
{
	
	        @AfterSuite
		    public void sendEmail()
		   {
		        String to = "ramesh.gkd2@gmail.com";
		        String from = "yourgmail@gmail.com";
		        String password1 = "your_app_password"; // Use Gmail App Password

		        EmailReportsender.sendReport(to, from, password1);
		    }
		
		
	

}
