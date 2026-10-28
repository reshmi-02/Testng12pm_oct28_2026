package org.test;

import org.testng.annotations.Test;

public class Class2 {
	
	@Test(groups = {"sanity","regression"})
	private void class2Method1() {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
		System.out.println("class2Method1");
	}
	
	
	
	@Test(groups = {"sanity"})
	private void class2Method2() {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
		System.out.println("class2Method2");
	}

}
