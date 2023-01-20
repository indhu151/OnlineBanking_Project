package fundtransfer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.onlinebanking.ObjectRepo.CustomerHomePage;
import com.onlinebanking.ObjectRepo.FundTransferHomePage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.InternetBankingLoginPage;
import com.onlinebanking.genericutilities.BaseClass;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class FundTrasfer_UsingPom_Test extends BaseClass
{
	@Test(priority=4)
	public void fundTransfer() throws Throwable 
	{
		CustomerHomePage chp=new CustomerHomePage(driver);
		FundTransferHomePage fhp=new FundTransferHomePage(driver);
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
