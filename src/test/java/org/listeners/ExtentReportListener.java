package org.listeners;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp repName="Test-Report-"+timeStamp+".html";
		repName="Test-Report-"+timeStamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report
		sparkReporter.config().setDocumentTitle("orangeHrmProject"); // Title of report
		sparkReporter.config().setReportName("Orange hrm"); // name of the report
		sparkReporter.config().setTheme (Theme. DARK);
		extent=new ExtentReports();
		extent.attachReporter (sparkReporter);
		extent.setSystemInfo("Application", "Orange hrm");
		extent.setSystemInfo("Operating System", System.getProperty("os.name")); extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Reshmi");
	  }
	
	public void onTestSuccess (ITestResult result)
	{
	test= extent.createTest(result.getName());
	test.assignCategory(result.getMethod().getGroups());
	test.createNode(result.getName());
	test.log(Status.PASS, "Test Passed");
	}
	public void onTestFailure (ITestResult result)
	{
	test=extent.createTest(result.getName());
	test.createNode(result.getName());
	test.assignCategory (result.getMethod().getGroups());
	test.log(Status. FAIL, "Test Failed");
	test.log(Status. FAIL, result.getThrowable().getMessage());
	try {
		test.addScreenCaptureFromPath(screenShot());
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void onTestSkipped (ITestResult result)
	{
	test=extent.createTest(result.getName());
	test.createNode(result.getName());
	test.assignCategory (result.getMethod().getGroups());
	test.log(Status. SKIP, "Test Skipped");
	test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	public void onFinish (ITestContext testContext)
	{
	extent.flush();
	}
	
	public static String screenShot() throws AWTException, IOException {
		Robot r = new Robot();
				
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				
				Rectangle rect = new Rectangle(d);
				
				BufferedImage b = r.createScreenCapture(rect);
				
				File dest = new File("./screenShot/orangehrm"+System.currentTimeMillis()+".png");
				
				ImageIO.write(b, "png", dest);
				
				String absolutePath = dest.getAbsolutePath();
				
				return absolutePath;
			}

}
