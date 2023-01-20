package applydebit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class ApplyDebitReg_UsingGeneric_Test
{
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
			
			
			//Enter the application
			driver=new ChromeDriver();
			wLib.maximizeWindow(driver);
			//driver.manage().window().maximize();
			wLib.waitForPageLoad(driver);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Url);
			//Apply debit card
			driver.findElement(By.xpath("//li[.='Apply Debit Card']")).click();
			
	//get details from excel
			
			String name = eLib.getDataFromExcel("Open", 0, 1);
			String mob = eLib.getDataFromExcel("Open", 1, 1);
			String pan = eLib.getDataFromExcel("Open", 4, 1);
			String acc = eLib.getDataFromExcel("Application", 1, 1);
			
	//enter details into fields		
			driver.findElement(By.name("holder_name")).sendKeys(name);
			driver.findElement(By.name("dob")).click();
			driver.findElement(By.name("dob")).sendKeys("15-03-1990");
			driver.findElement(By.name("pan")).sendKeys( pan);
			driver.findElement(By.name("mob")).sendKeys(mob);
			driver.findElement(By.name("acc_no")).sendKeys(acc);
			driver.findElement(By.name("dbt_crd_submit")).click();
			
	//get text from popup
			
			String text3 = wLib.textAlert(driver);
			
	//to get debit card number and pin
		    String st1=jLib.getDebitNum(text3);
		    String st2 = jLib.getDebitPin(text3);
		    System.out.println(st1);
			System.out.println(st2);
	//to accept popup
			wLib.acceptAlert(driver);
		
	//to write in excel
			eLib.writeDataIntoExcel("Application", 3, 1, st1);
			eLib.writeDataIntoExcel("Application", 4, 1, st2);
			
    //click on  home button
			driver.findElement(By.xpath("//a[.='Home']")).click();

}
