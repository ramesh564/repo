package com.pages;


import java.io.FilterInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;



public class Loginpage {
	
	
  public static WebDriver driver;
  static Properties prop;
	
  //WebDriver driver1;

  // Constructor
  public Loginpage(WebDriver driver) {
      Loginpage.driver = driver;
      PageFactory.initElements(driver, this);  // initialize elements
  }

 
  @FindBy(id = "inputUsername")
  WebElement username;

  @FindBy(name = "inputPassword")
  WebElement password;

  @FindBy(className ="signInBtn")
  WebElement loginBtn;
  


  public Loginpage() throws IOException
  
  {
	  
	  try
	  
	  {
		  prop=new Properties();
		  
		  FileInputStream  fis=new   FileInputStream("src/Test/resource/config.properties");
		  

		  
		  prop.load(fis);
		   
		  int data ;
		  
		  while((data=fis.read())!=-1)
			  
		  {
			  
			  System.out.print((char) data);
		  }
		  
		  
      }   catch (FileNotFoundException e) {
    	  e.printStackTrace();
          System.out.println("Error reading file: " + e.getMessage());
      }
		  
	  }
	  


  // Action method
  public void login(String uname, String pwd)
  {
	  
	  
	  // ✅ Add this debug print to check if element is null
      System.out.println("Username element is: " + username);
      username.sendKeys(uname);
      password.sendKeys(pwd);
      loginBtn.click();
      
      
  }
  
}
