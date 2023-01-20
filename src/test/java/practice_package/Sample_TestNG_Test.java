package practice_package;

import org.testng.annotations.Test;

public class Sample_TestNG_Test 
{
	
	@Test()
	public void create()
	{
		System.out.println("created");
	}
	@Test(invocationCount=2)
	public void update()
	{
		System.out.println("updated");
	}
	@Test(priority=-2,dependsOnMethods = "create")
	public void delete()
	{
		System.out.println("deleted");
	}

}
