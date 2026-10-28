package org.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.BrowserUtility;

public class PropertyTest extends BrowserUtility{
	
	
	@Test
	public void verificationOfLoginWithInValidCrendentials() throws InterruptedException {
		
		driver.findElement(By.name("username")).sendKeys("user");;
		driver.findElement(By.name("password")).sendKeys("pass");;
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		
	}
	
	
	

}
