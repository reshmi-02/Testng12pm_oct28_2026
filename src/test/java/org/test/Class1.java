package org.test;

import org.testng.annotations.Test;

public class Class1 {
	
	@Test(groups = {"smoke"})
	private void class1Method1() {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
		System.out.println("class1Method1");
	}

}
