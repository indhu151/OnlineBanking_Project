package internetbankingregister;

import org.testng.annotations.Test;

import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.InternetBankingRegPage;
import com.onlinebanking.genericutilities.BaseClass;

public class InternetBanking_Register_UsingPom_Test extends BaseClass
{
	@Test(priority=2)
	public void internetRegister() throws Throwable
	{
		//click on internet banking Register
		HomePage hp=new HomePage(driver);
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
		System.out.println("customer ID="+customerId);
		ibrp.insertCustIdIntoExcel(customerId);
	    hp.home();
		
	}

}
