package addbeneficiary;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class AddBeneficiary_Generic_Test {
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
				
				//fund transfer
				driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
				
				//click on add beneficiary
				driver.findElement(By.name("add_beneficiary")).click();
				
				//get values from excel
				ArrayList<String> li = new ArrayList<String>();
				li.add("beneficiary_name");
				li.add("beneficiary_acno");
				li.add("Ifsc_code");
				
				for(int i=0;i<eLib.getLastRowNo("beneficiary");i++)
				{
					String data1 = eLib.getDataFromExcel("beneficiary", i, 1);
					driver.findElement(By.name(li.get(i))).sendKeys(data1);
				}
				
		//click on add beneficiary
				String type1 = eLib.getDataFromExcel("beneficiary", 3, 1);
				WebElement atype = driver.findElement(By.xpath("//select[@name='beneficiary_acc_type']"));
				wLib.select(atype, type1);
				driver.findElement(By.name("add_beneficiary_btn")).click();
		
		//click on popup
				wLib.acceptAlert(driver);
				
				
				
	}
}
