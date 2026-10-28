package org.listeners;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.BaseClass;

public class MyTestListener implements ITestListener {

	public void onStart(ITestContext context) {
		// not implemented
		System.out.println("It is a onstart method");
	}

	public void onTestStart(ITestResult result) {
		// not implemented
		System.out.println("It is a onteststart method");
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
		System.out.println("On test success method");
	}

	public void onTestFailure(ITestResult result) {
		// not implemented
		System.out.println("On test failure method");
		try {
			BaseClass.captureImage();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
		System.out.println("On test skipped method");
	}

	public void onFinish(ITestContext context) {
		// not implemented
		System.out.println("On finish method");
	}

}
