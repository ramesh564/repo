package com.tests;

import java.time.Duration;

import org.apache.poi.ss.usermodel.BorderExtent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.pages.Homepage;
import com.pages.Loginpage;

import packg.Login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;




public class HomepageTest  extends BaseTest {

@Test
public void verifypagetitle() {

	// Step 1: Login first
	Loginpage login = new Loginpage(driver);
    login.login("rahul", "rahulshettyacademy");

    // Step 2: Now homepage appears
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@id='root']//p")
    ));

    // Step 3: Read the message
    String text = driver.findElement(By.xpath("//div[@id='root']//p")).getText();
    System.out.println("Message = " + text);

    Assert.assertEquals(text, "You are successfully logged in.");
  }
}