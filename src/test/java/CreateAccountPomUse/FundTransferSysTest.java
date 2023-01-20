package CreateAccountPomUse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.ObjectRepo.CustomerHomePage;
import com.onlinebanking.ObjectRepo.FundTransferHomePage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.InternetBankingLoginPage;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class FundTransferSysTest 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		CustomerHomePage chp=new CustomerHomePage(driver);
		FundTransferHomePage fhp=new FundTransferHomePage(driver);
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		driver.get(fLib.getPropertyKeyValue("url"));
		HomePage hp=new HomePage(driver);
		hp.clickOnInternetBanking(wLib, driver);
		hp.clickOnInternetLogin();
		InternetBankingLoginPage iblp=new InternetBankingLoginPage(driver);
		iblp.customerIdField(eLib);
		iblp.passwordText(eLib);
		iblp.clickOnLoginBtn();
		
		//click on fund transfer
				chp.clickOnFundTransfer();
				
		//select beneficiary
				fhp.selectBeneficiary(wLib);
				fhp.amountField();
				fhp.clickOnSendBtn();
				
		//to capture the text and get OTP number
				String OTP=fhp.captureOtp(jLib);
			
		//verify OTP
				fhp.verifyOtp(OTP);
				
		//click on popup
				String text6=fhp.acceptAlertTransaction(wLib, driver);
				System.out.println(text6);
		
	}

}
