package org.test;

import org.listeners.MyRetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.BrowserUtility;

public class ListenerDemo extends BrowserUtility{
	
	 
	
	@Test(dataProvider = "invalidLoginData")
	public void verificationOfLoginWithInValidCrendentials(String user,String pass) throws InterruptedException {
		
		driver.findElement(By.name("username")).sendKeys(user);;
		driver.findElement(By.name("password")).sendKeys(pass);;
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		
	}
	
	
	@DataProvider
	public String[][] invalidLoginData() {
		
		String [] [] datas  = {
			
				{"priya","priya123"},
				{"kavi","kavi123"},
				{"Admin","admin123"}
		};
		
		return datas;
		
	}

}
