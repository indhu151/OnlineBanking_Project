package approvetocredit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.onlinebanking.ObjectRepo.CreditCustPage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.StaffHomePage;
import com.onlinebanking.ObjectRepo.StaffLoginPage;
import com.onlinebanking.genericutilities.BaseClass;

public class CreditCust_UsingPom_Test extends BaseClass
{
	@Test(priority=0)
	public void creditCust() throws Throwable
	{
	//click on staff login
		HomePage hp=new HomePage(driver);
		hp.staffLoginLink();
	    StaffLoginPage slp=new StaffLoginPage(driver);
		slp.staffIdField();
		slp.passwordField();
		slp.clickOnLogin();
	
	//click on credit customer
		StaffHomePage shp=new StaffHomePage(driver);
		shp.clickOnCreditCust();
		
	//Enter the account number and amount and click on send
		CreditCustPage cp=new CreditCustPage(driver);
		cp.custAccNoField(eLib.getDataFromExcel("Application", 1, 1));
		cp.creditAmtField();
		cp.creditBtn();
		
	//click on accept popup
		String text=cp.acceptAlertCreditCust(driver, wLib);
		System.out.println(text);

	}
}
