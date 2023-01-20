package OpenAccountGeneric;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class OpenToPendingInteTest
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
				
				//create an account
				driver.findElement(By.xpath("//li[text()='Open Account']")).click();
				
				
				
				ArrayList<String> list = new ArrayList<String>();
				list.add("name");
				list.add("mobile");
				list.add("email");
				list.add("landline");
				list.add("pan_no");
				list.add("citizenship");
				list.add("homeaddrs");
				list.add("officeaddrs");
				list.add("pin");
				list.add("arealoc");
				list.add("nominee_name");
				list.add("nominee_ac_no");
				
				
				//To get datas from excel and fill fields name,mobile,email
				int count=eLib.getLastRowNo("Open");
				for(int i=0;i<count;i++)
				{
				String value = eLib.getDataFromExcel("Open", i, 1);
				driver.findElement(By.name(list.get(i))).sendKeys(value);
				}
				
				//for date of birth field
				driver.findElement(By.xpath("//input[@name='dob']")).click();
			    driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("15-03-1990");
				
				
			    //for fields gender,state,city,account type
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("//input[@name='name']/../..//select[@name='gender']");
				list1.add("//select[@name='state']");
				list1.add("//select[@name='city']");
				list1.add("//select[@name='acctype']");
				
				for(int i=0;i<=eLib.getLastRowNo("state");i++)
				{
				String value1 = eLib.getDataFromExcel("state", i, 1);
				WebElement state = driver.findElement(By.xpath(list1.get(i)));
				wLib.select(state, value1);
				}
				
				//click on submit button
				driver.findElement(By.xpath("//input[@name='submit']")).click();
				
				//click on reconfirm button
				driver.findElement(By.xpath("//input[@name='cnfrm-submit']")).click();
			    
				//click on popup and get text
				String text = wLib.textAlert(driver);
				//to get only application number
				String str = jLib.getApplication(text);
				System.out.println(str);
				
				//click on accept on alert popup
				wLib.acceptAlert(driver);
				
				//to insert the value into excel
				eLib.writeDataIntoExcel("Application", 0, 1, str);
		//staff login
				driver.findElement(By.xpath("//a[.='Staff Login']")).click();
				driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(staffid);
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
				driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
		
		//ApprovePendingAccount
				driver.findElement(By.xpath("//input[@name='apprvac']")).click();
				driver.findElement(By.xpath("//input[@name='application_no']")).sendKeys(str);
				driver.findElement(By.xpath("//input[@name='search_application']")).click();
				String data = driver.findElement(By.xpath("//tbody/tr[2]")).getText();
				System.out.println(data);
				String text1 = driver.findElement(By.xpath("//th[.='Mobile']/../..//td[.='8947376497']")).getText();
				String actual = eLib.getDataFromExcel("data", 1, 1);
				if(text1.equals(actual))
				{
					System.out.println("details are displayed");
				}
				else {
					System.out.println("details are not displayed");
				}
				//click on approve
			
				driver.findElement(By.xpath("//input[@name='approve_cust']")).click();
				
		
	}

}
