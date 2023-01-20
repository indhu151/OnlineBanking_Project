package practice_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.StaffHomePage;
import com.onlinebanking.ObjectRepo.StaffLoginPage;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class deleteCustomerTest 
{
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
				//Enter the application
				driver=new ChromeDriver();
				wLib.maximizeWindow(driver);
				wLib.waitForPageLoad(driver);
				driver.get(Url);
				HomePage hp=new HomePage(driver);
				hp.staffLoginLink();
				
		//staff login
				StaffLoginPage slp=new StaffLoginPage(driver);
				slp.staffIdField();
				slp.passwordField();
				slp.clickOnLogin();
			//click on active customer
				StaffHomePage shp=new StaffHomePage(driver);
				shp.clickOnViewActiveCust();
				List<WebElement> cid = driver.findElements(By.xpath("//tbody/tr/td[3]"));
				ArrayList<String> al=new ArrayList<String>();
				for(WebElement id:cid)
				{
					String custid=id.getText();
					System.out.println(custid);
					//System.out.println(custid);
					
					al.add(custid);
				}
				System.out.println(al);
				for(int i=0;i<al.size();i++)
				{
						
					
					System.out.println();
				}
				
				
				/* List<WebElement> acc = driver.findElements(By.xpath("//tbody/tr/td[4]"));
				for( WebElement accno:acc)
				{
					String accnum = accno.getText();
					eLib.writeDataIntoExcel("delete", 1, 1, accnum);
				}*/
				
				
		//click on delete customer	
				
				
		
				
				
				
				
	}
				
				
				
				
	}
	


