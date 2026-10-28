package org.test;

import org.testng.annotations.Test;

public class Class3 {
	
	@Test(groups = {"smoke","regression"})
	private void class3Method1() {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
		System.out.println("class3Method1");
	}

}
