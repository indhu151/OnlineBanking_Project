package CreateAccountPomUse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebanking.ObjectRepo.AddBeneficiaryPage;
import com.onlinebanking.ObjectRepo.ApplyDebitPage;
import com.onlinebanking.ObjectRepo.ApprovePendingPage;
import com.onlinebanking.ObjectRepo.CreditCustPage;
import com.onlinebanking.ObjectRepo.CustomerHomePage;
import com.onlinebanking.ObjectRepo.FundTransferHomePage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.InternetBankingLoginPage;
import com.onlinebanking.ObjectRepo.InternetBankingRegPage;
import com.onlinebanking.ObjectRepo.OpenAccountPage;
import com.onlinebanking.ObjectRepo.ReConfirmPage;
import com.onlinebanking.ObjectRepo.StaffHomePage;
import com.onlinebanking.ObjectRepo.StaffLoginPage;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class CreateAccSysTest 
{
	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=null;
		//create object for generic classes
			FileUtility fLib = new FileUtility();
			ExcelUtility eLib = new ExcelUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
		
		//Read data from property file
			  String Url = fLib.getPropertyKeyValue("url");
			  String staffid = fLib.getPropertyKeyValue("staffid");
			  String pwd = fLib.getPropertyKeyValue("password");
			  String browser = fLib.getPropertyKeyValue("browser");
			  System.out.println(Url);
			  System.out.println(staffid);
			  System.out.println(pwd);
				
		//Enter the application
			  driver=new ChromeDriver();
			  wLib.maximizeWindow(driver);
			  wLib.waitForPageLoad(driver);
			  driver.get(Url);
				
		//create an account
			  HomePage hp=new HomePage(driver);
			  hp.clickOnOpenAccount();
			  OpenAccountPage op=new OpenAccountPage(driver);
			  op.textFieldData(eLib);
			 // op.textField(eLib.getList1("data", 0, 1), driver);
		      op.dateOfBirthText();
		      op.textField(eLib.getList1("state", 0, 1), driver);
			  op.clickOnSubmitLink();
				
		//click on reconfirm button
			  ReConfirmPage rp=new ReConfirmPage(driver);
			  rp.clickOnReConfirm();
		      String applicationNo= rp.acceptAlertApplicationno(driver, wLib, jLib);
		      rp.insertAppliNoIntoExcel(applicationNo);
				
	    //staff loginpage
			 hp.staffLoginLink();
			 StaffLoginPage slp=new StaffLoginPage(driver);
			 slp.staffIdField();
			 slp.passwordField();
			 slp.clickOnLogin();
		
		//click on ApprovePendingAccount
			 StaffHomePage shp=new StaffHomePage(driver);
			 shp.clickOnApprovePend();
			 ApprovePendingPage ap=new ApprovePendingPage(driver);
			 ap.applicatioNoTextField(applicationNo);
			 ap.clickOnSearchBtn();
			 ap.clickOnApprove();
			 wLib.alertPresent(driver);
		     String accountNo=ap.acceptAlertAccountNo(driver, wLib, jLib);
			 ap.insertAccNoIntoExcel(accountNo);
		     shp.clickOnHomeBtn();
			
	  //click on credit customer
			 shp.clickOnCreditCust();
			 CreditCustPage cp=new CreditCustPage(driver);
			 cp.custAccNoField(accountNo);
			 cp.creditAmtField();
			 cp.creditBtn();
			 cp.acceptAlertCreditCust(driver, wLib);
			 shp.clickOnLogoutBtn();
			 hp.home();
			
		//Apply debit card
			    hp.clickOnApplyDebit();
			 	ApplyDebitPage adb=new ApplyDebitPage(driver);
				adb.accountNameField(eLib);
				adb.dobField();
				adb.panField(eLib);
				adb.mobileNoField(eLib);
				adb.accountNoField(eLib);
				adb.clickOnDebitSubmitBtn();
				String debitnum=adb.acceptAlertDebitNum(driver, wLib, jLib);
				System.out.println(debitnum);
				String debitpin=adb.acceptAlertDebitPin(driver, wLib, jLib);
				System.out.println(debitpin);
				adb.insertDebitNoIntoExcel(debitnum);
				adb.insertDebitPinIntoExcel(debitpin);
				hp.home();
			
		//move to internet banking and click on register
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
				
		//move to internet banking and login
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
		
		//click on fund transfer
				chp.clickOnFundTransfer();
				fhp.selectBeneficiary(wLib);
				fhp.amountField();
				fhp.clickOnSendBtn();
				String OTP=fhp.captureOtp(jLib);
				fhp.verifyOtp(OTP);
				String text6=fhp.acceptAlertTransaction(wLib, driver);
				System.out.println(text6);
	}

}
