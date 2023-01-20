package approvepending;

import org.testng.annotations.Test;

import com.onlinebanking.ObjectRepo.ApprovePendingPage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.StaffHomePage;
import com.onlinebanking.ObjectRepo.StaffLoginPage;
import com.onlinebanking.genericutilities.BaseClass;

public class ApprovePending_Using_POM_Test extends BaseClass
{
	@Test(priority=-1)
	public void approvePending() throws Throwable
	{
	//click on staff login
	HomePage hp=new HomePage(driver);
	hp.staffLoginLink();
    StaffLoginPage slp=new StaffLoginPage(driver);
	slp.staffIdField();
	slp.passwordField();
	slp.clickOnLogin();

//click on ApprovePendingAccount
	StaffHomePage shp=new StaffHomePage(driver);
	shp.clickOnApprovePend();
	ApprovePendingPage ap=new ApprovePendingPage(driver);
	ap.applicatioNoTextField(eLib.getDataFromExcel("Application", 0, 1));
	ap.clickOnSearchBtn();
	
	//click on approve
	ap.clickOnApprove();
	wLib.alertPresent(driver);
	String accountNo=ap.acceptAlertAccountNo(driver, wLib, jLib);
	ap.insertAccNoIntoExcel(accountNo);
    shp.clickOnHomeBtn();
	}
}
