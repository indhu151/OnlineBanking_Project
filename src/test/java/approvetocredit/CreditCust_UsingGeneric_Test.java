package approvetocredit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class CreditCust_UsingGeneric_Test {
public static void main(String[] args) throws Throwable {
	

	WebDriver driver=null;
	//create object for generic classes
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
	
	
	//Read data from property file
			String Url = fLib.getPropertyKeyValue("url");
			String staffid = fLib.getPropertyKeyValue("staffid");
			String pwd = fLib.getPropertyKeyValue("password");
			String browser = fLib.getPropertyKeyValue("browser");
			System.out.println(Url);
			System.out.println(staffid);
			System.out.println(pwd);
			
			
			//Enter the application
			driver=new ChromeDriver();
			wLib.maximizeWindow(driver);
			//driver.manage().window().maximize();
			wLib.waitForPageLoad(driver);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Url);
			//staff login
			driver.findElement(By.xpath("//a[.='Staff Login']")).click();
			driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(staffid);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
			
			
			 //click on credit customer
			 driver.findElement(By.name("credit_cust_ac")).click();
			 driver.findElement(By.name("customer_account_no")).sendKeys(eLib.getDataFromExcel("Application", 1, 1));
			 driver.findElement(By.name("credit_amount")).sendKeys("10000");
			 driver.findElement(By.name("credit_btn")).click();
				
	 //click on accept popup 
				wLib.acceptAlert(driver);
			
}
}
