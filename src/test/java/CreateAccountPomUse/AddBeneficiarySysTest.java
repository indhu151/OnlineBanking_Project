package CreateAccountPomUse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.ObjectRepo.AddBeneficiaryPage;
import com.onlinebanking.ObjectRepo.CustomerHomePage;
import com.onlinebanking.ObjectRepo.FundTransferHomePage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.InternetBankingLoginPage;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class AddBeneficiarySysTest 
{
	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		//login of internet banking
		driver.get(fLib.getPropertyKeyValue("url"));
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
