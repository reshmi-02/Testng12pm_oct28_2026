package org.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite
	private void beforeSuite() {
		// TODO Auto-generated method stub
		System.out.println("it is a before suite method");
	}
	
	@BeforeTest
	private void beforeTest() {
		// TODO Auto-generated method stub
		System.out.println("It is a before test method");
	}
	
	@BeforeClass
	private void beforeClass() {
		// TODO Auto-generated method stub
		System.out.println("it is a before class method");
	}
	
	
	@BeforeMethod
	private void beforeMethod() {
		// TODO Auto-generated method stub
		System.out.println("It is a before  method");
	}
	
	@AfterMethod
	private void afterMethod() {
		// TODO Auto-generated method stub
		System.out.println("It is a after  method ");
	}
	
	@AfterClass
	private void afterClass() {
		// TODO Auto-generated method stub
		System.out.println("it is a after class method");
	}
	
	@AfterTest
	private void afterTest() {
		// TODO Auto-generated method stub
		System.out.println("It is a after test method");
	}
	
	
	@AfterSuite
	private void afterSuite() {
		// TODO Auto-generated method stub
		System.out.println("it is a after suite method");
	}
	
	@Test
	private void test02() {
		// TODO Auto-generated method stub
		System.out.println("It is a test02 method");
	}
	
	@Test
	private void test01() {
		// TODO Auto-generated method stub
		System.out.println("It is a test01 method");
	}

}
