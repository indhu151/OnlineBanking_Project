package com.onlinebanking.genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
  
public class BaseClass
{
	/*static {
		 System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
	   }*/
	public WebDriver driver;
	public static WebDriver edriver;
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	
	
	@BeforeSuite
	public void connectDB() throws Throwable
	{
		//dLib.connectionToDB();
		System.out.println("--connect to DB--");
	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void configBC( ) throws Throwable
	{
		String BROWSER=fLib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			
		    driver=new EdgeDriver();
			System.out.println("--Launch the Browser edge--");
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("--Launch the Browser chrome--");
		}
		else
		{
			System.out.println("Invalid browser");
		}
		edriver=driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		String URL=fLib.getPropertyKeyValue("url");
		System.out.println(URL);
		driver.get(URL);
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("--login to app--");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("--logout from app");
	}
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	@AfterSuite
	public void closeDBConnection() throws Throwable
	{
		//dLib.closeDB();
		System.out.println("close DB connection");
	}
}
