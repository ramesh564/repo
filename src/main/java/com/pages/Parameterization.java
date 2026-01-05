package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;



public class Parameterization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.manage().window().maximize();
		
		String filepath =System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		//int rows =NetUtils.getRowCount(filepath, "sheet1");
		
		for(int i=1;i<=i;i++)
			
		{
			
			// read data from excel;
			
		//	String price=ExcelUtils.getCellData(filepath,"sheet1",1,0);
		//	String rateofinterest=ExcelUtils.getCellData(filepath, "sheet",i,1);
			
			driver.findElement(By.xpath("//input[@id='principle'")).sendKeys(filepath);
			driver.findElement(By.xpath("//input[@id='interest')")).sendKeys(filepath);
			
		}
		
	}

}
