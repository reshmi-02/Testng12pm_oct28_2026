package org.test;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {
	WebDriver driver ;
	
	@BeforeMethod
	public void setup() {
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({"title"})
	@Test
	public void verificationOfOrangeHrmPageTitle(String title) {
		
		@Nullable
		String data = driver.getTitle();
		Assert.assertEquals(data, title);
	}
	
	@Parameters({"username","password"})
	@Test
	public void verificationOfLoginWithValidCrendentials(String user,String pass) {
		
		driver.findElement(By.name("username")).sendKeys(user);;
		driver.findElement(By.name("password")).sendKeys(pass);;
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertTrue(driver.getTitle().contains("dashboard"));
		
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
}
