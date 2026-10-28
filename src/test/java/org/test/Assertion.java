package org.test;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
	
	@Test
	private void verificationOfGooglePageTitle() {
		// TODO Auto-generated method stub

		@Nullable
		String title = driver.getTitle();
		
		//hard assert 
		Assert.assertEquals(title, "google");
		
		System.out.println("test completed");
		
		
	}
	
	@Test
	private void verificationOfGooglePageUrl() {
		// TODO Auto-generated method stub
		@Nullable
		String url = driver.getCurrentUrl();
		
		//soft assert 
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(url.contains("google"));
		
		sa.assertAll();
		
		System.out.println("completed");
		
	}
	
	
}
