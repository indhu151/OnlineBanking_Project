package addbeneficiary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.onlinebanking.ObjectRepo.AddBeneficiaryPage;
import com.onlinebanking.ObjectRepo.CustomerHomePage;
import com.onlinebanking.ObjectRepo.FundTransferHomePage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.InternetBankingLoginPage;
import com.onlinebanking.genericutilities.BaseClass;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class LoginToAddBeneficiary_UsingPom_Test extends BaseClass
{
	@Test(priority=3)
	public void login() throws Throwable
	{
		
		//login of internet banking
		HomePage hp=new HomePage(driver);
		hp.clickOnInternetBanking(wLib, driver);
		hp.clickOnInternetLogin();
		InternetBankingLoginPage iblp=new InternetBankingLoginPage(driver);
		iblp.customerIdField(eLib);
		iblp.passwordText(eLib);
		iblp.clickOnLoginBtn();
		
//fund transfer
		CustomerHomePage chp=new CustomerHomePage(driver);
		chp.clickOnFundTransfer();
	
//click on add beneficiary
		FundTransferHomePage fhp=new FundTransferHomePage(driver);
		fhp.clickOnAddBeneficiary();
		AddBeneficiaryPage abp=new AddBeneficiaryPage(driver);
		abp.beneficiaryAccNo(eLib);
		abp.beneficiaryName(eLib);
		abp.ifsccode(eLib);  
		 abp.beneficiaryAccType(eLib);
		abp.beneficiarybtn();
		abp.acceptAlertBeneficiaryAdded(driver, wLib);
		}

}
