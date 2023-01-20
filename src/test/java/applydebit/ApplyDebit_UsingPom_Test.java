package applydebit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.onlinebanking.ObjectRepo.ApplyDebitPage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.InternetBankingRegPage;
import com.onlinebanking.genericutilities.BaseClass;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class ApplyDebit_UsingPom_Test extends BaseClass 
{
	@Test(priority=1)
	public void applyDebit() throws Throwable
	{
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
			System.out.println("debitnum="+debitnum);
			String debitpin=adb.acceptAlertDebitPin(driver, wLib, jLib);
			System.out.println("debitpin="+debitpin);
			adb.insertDebitNoIntoExcel(debitnum);
			adb.insertDebitPinIntoExcel(debitpin);
			hp.home();
		}

}
