package com.onlinebanking.genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer
{
	int count=0;
	int retrylimit=4;

	public boolean retry(ITestResult result) 
	{
		if(count<retrylimit)
		{
			count++; 
			return true;
		}
		
		return false;
	}

}
