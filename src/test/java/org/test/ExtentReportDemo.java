package org.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	@BeforeClass
	public void setup() {
		// directory where output is to be printed
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\report.html");
	    extent = new ExtentReports();
		extent.attachReporter(spark);

	}
	
	@Test
	public void signIn() {
		
		ExtentTest test = extent.createTest("Sigin Page test");
		test.log(Status.PASS, "Sign in page got passed");
		
	}
	
	@Test
	public void homepage() {
		ExtentTest test = extent.createTest("homepage test").assignDevice("chrome").assignCategory("smoke");
		test.fail("homepage test gor fail");
	}
	
	
	@AfterClass
	public void tear() {
		extent.flush();
	}

}
