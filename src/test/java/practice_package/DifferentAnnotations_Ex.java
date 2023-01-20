package practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DifferentAnnotations_Ex 
{
	@BeforeMethod
	public void loginToApp()
	{
		System.out.println("---Login to app---");
	}
	@AfterMethod
	public void logoutFromApp()
	{
		System.out.println("----Logout from app----");
	}
	@Test(invocationCount=2)
	public void createOrg()
	{
		System.out.println("Organisation is created");
	}
	
	@Test(dependsOnMethods = "createContacts")
	public void createPotential()
	{
		System.out.println("potential is created");
	}
	@Test(priority=1)
	public void createContacts()
	{
		System.out.println("Contact is created");
	}
	
	@BeforeClass
	public void openBrowser()
	{
		System.out.println("----Launch the browser----");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("---close the browser---");
	}
	@BeforeSuite
	public void connectToDB()
	{
		System.out.println("connect to database");
	}
	@AfterSuite
	public void disconnectDB()
	{
		System.out.println("disconnect database");
	}

}
