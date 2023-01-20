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

public class ApplyDebitSystem {
	public static void main(String[] args) throws Throwable 
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
				
		//click on approve
			
				driver.findElement(By.xpath("//input[@name='approve_cust']")).click();
				wLib.alertPresent(driver);
		//to get text from popup
				 String text2 = wLib.textAlert(driver);
				
		//to get only Account number
				String str1 = jLib.getAccountNum(text2);
				System.out.println(str1);
				
	   //close the popup
				wLib.acceptAlert(driver);
				
	  //to insert the value into excel
			 eLib.writeDataIntoExcel("Application", 1, 1, str1);
	
	 //click on home button of staff login
			driver.findElement(By.name("home")).click();
				
	 //click on credit customer
			 driver.findElement(By.name("credit_cust_ac")).click();
			 driver.findElement(By.name("customer_account_no")).sendKeys(str1);
			 driver.findElement(By.name("credit_amount")).sendKeys("10000");
			 driver.findElement(By.name("credit_btn")).click();
				
	 //click on accept popup 
				wLib.acceptAlert(driver);
				
	      //logout staff login
				driver.findElement(By.name("logout_btn")).click();
				
		 //home button of online banking
				driver.findElement(By.xpath("//a[.='Home']")).click();
				
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
				
				//move to internet banking
				WebElement move = driver.findElement(By.xpath("//div[@class='ebanking']"));
				wLib.mousehover(driver, move);
				
			//click on register
				driver.findElement(By.xpath("//li[.='Register']")).click();
				
				//enter details
				String name1 = eLib.getDataFromExcel("Open", 0, 1);
				String mob1 = eLib.getDataFromExcel("Open", 1, 1);
				 String pan1 = eLib.getDataFromExcel("Open", 4, 1);
				 String acc1 = eLib.getDataFromExcel("Application", 1, 1);
				 String pass = eLib.getDataFromExcel("Application", 2, 1);
				 String debnum = eLib.getDataFromExcel("Application", 3, 1);
				 String debpin = eLib.getDataFromExcel("Application", 4, 1);
				
				
				driver.findElement(By.name("holder_name")).sendKeys(name1);
				driver.findElement(By.name("accnum")).sendKeys(acc1);
				driver.findElement(By.name("dbtcard")).sendKeys(debnum);
				driver.findElement(By.name("dbtpin")).sendKeys(debpin);
				driver.findElement(By.name("mobile")).sendKeys(mob1);
				driver.findElement(By.name("pan_no")).sendKeys(pan1);
				driver.findElement(By.name("dob")).click();
				driver.findElement(By.name("dob")).sendKeys("15-03-1990");
				driver.findElement(By.name("last_trans")).sendKeys("10000");
				driver.findElement(By.name("password")).sendKeys(pass);
				driver.findElement(By.name("cnfrm_password")).sendKeys(pass);
						
				driver.findElement(By.name("submit")).click();
				
				//click on popup
				String text4 = wLib.textAlert(driver);
				
				//to get customer id
				
				char ch7[]=text4.toCharArray();
				char ch8[]=new char[7];
				int j=0;
				for(int i=0;i<ch7.length;i++)
				{
					if(ch7[i]>='0'&&ch7[i]<='9')
						
					{
						ch8[j]=(ch7[i]);
						j++;
					}
				}
				String st4 = new String(ch8);
				System.out.println(st4);
				
				//to write in excel
				eLib.writeDataIntoExcel("Application", 5, 1, st4);
				
				//click on alert accept
				wLib.acceptAlert(driver);
		
	}

}
