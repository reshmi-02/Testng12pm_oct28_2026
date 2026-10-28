package org.test;

import org.testng.annotations.Test;

public class Attributes {
	
	@Test(priority = -2,description = "Login functionality")
	private void login() {
		// TODO Auto-generated method stub
		System.out.println("It is a login functionality");
		System.out.println(10/0);
	}
	
	@Test(priority = -1,description = "Homepage functionality",dependsOnMethods = "login",alwaysRun = true)
	private void homepage() {
		// TODO Auto-generated method stub
		System.out.println("It is a homepage funtionality");
	}
	
	@Test(priority = 0,invocationCount = 2)
	private void productpage() {
		// TODO Auto-generated method stub
		System.out.println("it is a product page functionality");
	}
	
	@Test(priority = 1,timeOut = 2000)
	private void searchPage() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("it is a searchpage functionality");
		Thread.sleep(3000);
	}	
	
	@Test(priority = 2,enabled = false)
	private void logout() {
		// TODO Auto-generated method stub
		System.out.println("It is a logout funtionality");
	}

}
