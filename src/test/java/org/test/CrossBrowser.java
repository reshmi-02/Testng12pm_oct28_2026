package org.test;

import java.time.Duration;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	WebDriver driver;
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void setup(String browsername,String url) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void verificationOfOrangeHrmPageTitle() {
		
		@Nullable
		String data = driver.getTitle();
		Assert.assertEquals(data, "OrangeHRM");
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}

}
