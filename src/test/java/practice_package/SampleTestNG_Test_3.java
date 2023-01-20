package practice_package;

import org.testng.annotations.Test;

public class SampleTestNG_Test_3 
{
	@Test
	public void sample5()
	{
		System.out.println("--testscript 5--");
	}
	@Test(groups= {"smoke","regression"})
	public void sample6()
	{
		System.out.println("--testscript 6--");
	}

}
