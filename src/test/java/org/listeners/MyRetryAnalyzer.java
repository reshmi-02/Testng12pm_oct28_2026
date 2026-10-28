package org.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{

	int min = 1 , max = 3;
	
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		while(min<=max) { //4<=3
			min++; //4
			return true;
		}
		
		return false;
	}

}
