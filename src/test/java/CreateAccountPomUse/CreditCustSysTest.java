package CreateAccountPomUse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.ObjectRepo.ApprovePendingPage;
import com.onlinebanking.ObjectRepo.CreditCustPage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.StaffHomePage;
import com.onlinebanking.ObjectRepo.StaffLoginPage;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class CreditCustSysTest
{
	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		ApprovePendingPage ap=new ApprovePendingPage(driver);
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		StaffHomePage shp=new StaffHomePage(driver);
		HomePage hp=new HomePage(driver);
		driver.get(fLib.getPropertyKeyValue("url"));
		hp.staffLoginLink();
        StaffLoginPage slp=new StaffLoginPage(driver);
		slp.staffIdField();
		slp.passwordField();
		slp.clickOnLogin();

		//click on credit customer
 		shp.clickOnCreditCust();
 		CreditCustPage cp=new CreditCustPage(driver);
 		cp.custAccNoField(eLib.getDataFromExcel("Application", 1, 1));
 		cp.creditAmtField();
 		cp.creditBtn();
 		cp.acceptAlertCreditCust(driver, wLib);
 		shp.clickOnLogoutBtn();
 	 //home button of online banking
 			hp.home();
}
		
	}


