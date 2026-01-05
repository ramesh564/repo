package com.tests;

import Utility.screenshotutility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

@SuppressWarnings("unused")
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        try {
            // Get WebDriver from your test class
            WebDriver driver = (WebDriver) testClass.getClass().getDeclaredField("driver").get(testClass);
            String testName = result.getName();
            screenshotutility.takeScreenshot(driver, testName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void onTestStart(ITestResult result) 
    {
    System.out.println("Test Started: " + result.getName());	
    }
    @Override
    public void onTestSuccess(ITestResult result) 
    {
    System.out.println("Test Passed: " + result.getName());	
    }
    @Override
    public void onTestSkipped(ITestResult result) 
    {
    System.out.println("Test Skipped: " + result.getName());	
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
    System.out.println("Test Failed but within success %: " + result.getName());	
    	
    }
    @Override
    public void onStart(ITestContext context)
    {
    System.out.println("Test Suite Started: " + context.getName());	
    }
    @Override
    public void onFinish(ITestContext context) 
    {
    System.out.println("Test Suite Finished: " + context.getName());	
    	
    	}
    }
