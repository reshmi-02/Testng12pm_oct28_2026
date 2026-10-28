package org.test;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.BaseClass;

public class DataproviderDemo {

	
WebDriver driver ;
	
	@BeforeMethod
	public void setup() {
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Test(dataProvider = "orangehrmTitle") //OrangeHRM
	public void verificationOfOrangeHrmPageTitle(String title) {
		
		@Nullable
		String data = driver.getTitle();
		Assert.assertEquals(data, title);
	}
	
	
	@Test( dataProviderClass = BaseClass.class,dataProvider = "excelRead")
	public void verificationOfLoginWithInValidCrendentials(String user,String pass) {
		
		driver.findElement(By.name("username")).sendKeys(user);;
		driver.findElement(By.name("password")).sendKeys(pass);;
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
	
	@DataProvider
	public String[] orangehrmTitle() {
		
		//single dimensional array 
		
		String [] data = {"OrangeHRM" };
		
		return data;
	}
	
	
	@DataProvider
	public String[][] invalidLoginData() {
		
		String [] [] datas  = {
			
				{"priya","priya123"},
				{"kavi","kavi123"}
		};
		
		return datas;
		
	}
	
}
