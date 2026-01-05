package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class Registration {

	
	
	 WebDriver driver;

	    @FindBy(id = "username")
	    WebElement username;

	    @FindBy(id = "email")
	    WebElement email;

	    @FindBy(id = "password")
	    WebElement password;

	    @FindBy(id = "mobile")
	    WebElement mobileNumber;

	    @FindBy(id = "registerBtn")
	    WebElement registerButton;

	    // ✅ Correct constructor
	    public void RegistrationPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterMobileNumber(String mobile) 
	    {
	        mobileNumber.clear();
	        mobileNumber.sendKeys(mobile);
	    }

	    public String getMobileNumberValue() {
	        return mobileNumber.getAttribute("value");
	    }

	    public void registerUser(String user, String mail, String mobile, String pass) {
	        username.sendKeys(user);
	        email.sendKeys(mail);
	        enterMobileNumber(mobile);  // Reuse method
	        password.sendKeys(pass);
	        registerButton.click();
	    }
	}
	

