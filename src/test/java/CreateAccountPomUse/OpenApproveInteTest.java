package CreateAccountPomUse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.ObjectRepo.ApprovePendingPage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.OpenAccountPage;
import com.onlinebanking.ObjectRepo.ReConfirmPage;
import com.onlinebanking.ObjectRepo.StaffHomePage;
import com.onlinebanking.ObjectRepo.StaffLoginPage;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class OpenApproveInteTest 
{
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
	//create object for generic classes
			FileUtility fLib = new FileUtility();
			ExcelUtility eLib = new ExcelUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
		
			//Enter the application
				driver=new ChromeDriver();
				wLib.maximizeWindow(driver);
				wLib.waitForPageLoad(driver);
				driver.get(fLib.getPropertyKeyValue("url"));
				
		   //create an account
				HomePage hp=new HomePage(driver);
				hp.clickOnOpenAccount();
		  //To enter details like name,mobile no,.. in open account page and click on submit	
				OpenAccountPage op=new OpenAccountPage(driver);
				op.textField(eLib.getList1("data", 0, 1), driver);
				op.dateOfBirthText();
				op.textField(eLib.getList1("state", 0, 1), driver);
				op.clickOnSubmitLink();
				
		 //click on reconfirm button
				ReConfirmPage rp=new ReConfirmPage(driver);
			    rp.clickOnReConfirm();
			    String applicationNo= rp.acceptAlertApplicationno(driver, wLib, jLib);
			    rp.insertAppliNoIntoExcel(applicationNo);
		
		//click on staff login
				hp.staffLoginLink();
		        StaffLoginPage slp=new StaffLoginPage(driver);
				slp.staffIdField();
				slp.passwordField();
				slp.clickOnLogin();
		
		//click on ApprovePendingAccount
				StaffHomePage shp=new StaffHomePage(driver);
				shp.clickOnApprovePend();
				ApprovePendingPage ap=new ApprovePendingPage(driver);
				ap.applicatioNoTextField(applicationNo);
				ap.clickOnSearchBtn();
				String data = driver.findElement(By.xpath("//tbody/tr[2]")).getText();
				System.out.println(data);
				String text1 = driver.findElement(By.xpath("//th[.='Mobile']/../..//td[.='8642817497']")).getText();
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
