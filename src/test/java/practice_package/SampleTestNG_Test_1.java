package practice_package;

import org.testng.annotations.Test;

import com.onlinebanking.genericutilities.JavaUtility;

public class SampleTestNG_Test_1 
{
	
	@Test(groups="smoke")
	public void sample1()
	{
		
		System.out.println("--testscript 1--");
	}
	@Test(groups="regression")
	public void sample2()
	{
		System.out.println("--testscript 2--");
	}

}
