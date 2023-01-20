package practice_package;

import org.testng.annotations.Test;

public class SampleTestNG_Test_2 
{
	@Test(groups="smoke")
	public void sample3()
	{
		System.out.println("--testscript 3--");
	}
	@Test(groups= {"smoke","regression"})
	public void sample4()
	{
		System.out.println("--testscript 4--");
	}

}
