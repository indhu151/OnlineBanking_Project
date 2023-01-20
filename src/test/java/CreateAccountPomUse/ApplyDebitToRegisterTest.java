package CreateAccountPomUse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.ObjectRepo.ApplyDebitPage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.InternetBankingRegPage;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class ApplyDebitToRegisterTest
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		driver.get(fLib.getPropertyKeyValue("url"));
		//Apply debit card
		HomePage hp=new HomePage(driver);
		hp.clickOnApplyDebit();
		ApplyDebitPage adb=new ApplyDebitPage(driver);
		adb.accountNameField(eLib);
		adb.dobField();
		adb.panField(eLib);
		adb.mobileNoField(eLib);
		adb.accountNoField(eLib);
		adb.clickOnDebitSubmitBtn();
			
	//get debit num and pin from popup and accept the popup
			String debitnum=adb.acceptAlertDebitNum(driver, wLib, jLib);
			System.out.println(debitnum);
			String debitpin=adb.acceptAlertDebitPin(driver, wLib, jLib);
			System.out.println(debitpin);
			adb.insertDebitNoIntoExcel(debitnum);
			adb.insertDebitPinIntoExcel(debitpin);
			hp.home();
		
	//click on internet banking Register
			hp.clickOnInternetBanking(wLib, driver);
			hp.clickOnInternetReg();
			InternetBankingRegPage ibrp=new InternetBankingRegPage(driver);
			ibrp.accountHolderName(eLib);
			ibrp.accountNum(eLib);
			ibrp.DebitNum(eLib);
			ibrp.debitPin(eLib);
			ibrp.mobileNo(eLib);
			ibrp.panNoField(eLib);
			ibrp.dateOfBirth(eLib);
			ibrp.lastTransField(eLib);
			ibrp.passwordField(eLib);
			ibrp.confirmPasswordField(eLib);
			ibrp.submitBtn();
			
	//click on popup and get customerID and accept it
			String customerId=ibrp.acceptAlertCustomerId(driver, wLib, jLib);
			ibrp.insertCustIdIntoExcel(customerId);
		    hp.home();
		
	}

}
