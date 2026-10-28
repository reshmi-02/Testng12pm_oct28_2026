package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BrowserUtility {  //used to store a reusable methods 
	
	public  WebDriver driver;
	
	@BeforeMethod
	public  WebDriver browsersetup() throws IOException {
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
		
		FileReader fr = new FileReader(f);
		
		Properties prop = new Properties();
		
		prop.load(fr);
		
		String browsername=prop.getProperty("browser");
		String url = prop.getProperty("testurl");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			
			 driver = new EdgeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			
			 driver = new FirefoxDriver();
			
		}
		else {
			System.out.println("Invalid browsername");
		}
		
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
		
	}
	
	
	
	
	@AfterMethod
	public  void tearDown() {
		driver.quit();
	}

}
