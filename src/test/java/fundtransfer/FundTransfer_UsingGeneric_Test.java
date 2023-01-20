package fundtransfer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class FundTransfer_UsingGeneric_Test
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
			
			//move to internet banking
			WebElement move1 = driver.findElement(By.xpath("//div[@class='ebanking']"));
			wLib.mousehover(driver, move1);
			
			//login of internet banking
			driver.findElement(By.xpath("//li[.='Login ']")).click();
			
			//enter the details
			String id = eLib.getDataFromExcel("Application", 5, 1);
			driver.findElement(By.name("customer_id")).sendKeys(id);
			driver.findElement(By.name("password")).sendKeys(pass);
			driver.findElement(By.name("login-btn")).click();
	
			
			//click on fund transfer
	driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
	
//select beneficiary
	WebElement bene = driver.findElement(By.xpath("//select[@name='beneficiary']"));
	wLib.select(bene, 1);
	driver.findElement(By.name("trnsf_amount")).sendKeys("500");
	driver.findElement(By.name("fnd_trns_btn")).click();
//capture OTP		
	String Otp = driver.findElement(By.xpath("//label[@class='OTP_msg']")).getText();
	System.out.println(Otp);
//to get OTP number
	String st13 = jLib.getOtp(Otp);
	StringBuilder st14 = new StringBuilder(st13);
	st14.reverse();
	System.out.println(st14);
	
//verify OTP
	driver.findElement(By.name("otpcode")).sendKeys(st14);
	driver.findElement(By.name("verify-btn")).click();
	
//click on popup
	String text6 = wLib.textAlert(driver);
	System.out.println(text6);
	wLib.acceptAlert(driver);
}
}
