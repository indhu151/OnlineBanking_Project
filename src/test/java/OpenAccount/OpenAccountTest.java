package OpenAccount;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class OpenAccountTest
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
				
		//To enter details like name,mobile no,.. in open account page	
				OpenAccountPage op=new OpenAccountPage(driver);
				op.textField(eLib.getList1("data", 0, 1), driver);
		//for date of birth field
				op.dateOfBirthText();
		//for fields gender,state,city,account type
				op.textField(eLib.getList1("state", 0, 1), driver);
				
		//click on submit button
				op.clickOnSubmitLink();
				
		//click on reconfirm button
				ReConfirmPage rp=new ReConfirmPage(driver);
			    rp.clickOnReConfirm();
		//click on popup and get text
			    String applicationNo= rp.acceptAlertApplicationno(driver, wLib, jLib);
			
		//to insert the value into excel
				eLib.writeDataIntoExcel("Application", 0, 1, applicationNo);
			
		//click on staff login
				hp.staffLoginLink();
		
		//staff loginpage
			    StaffLoginPage slp=new StaffLoginPage(driver);
				slp.staffIdField();
				slp.passwordField();
				slp.clickOnLogin();
		
		//click on ApprovePendingAccount
				StaffHomePage shp=new StaffHomePage(driver);
				shp.clickOnApprovePend();
				
		//To eneter application no and get approved
				ApprovePendingPage ap=new ApprovePendingPage(driver);
				ap.applicatioNoTextField(applicationNo);
				ap.clickOnSearchBtn();
				//click on approve
				ap.clickOnApprove();
				wLib.alertPresent(driver);
		//to get account no. from popup and close the popup
				String accountNo=ap.acceptAlertAccountNo(driver, wLib, jLib);
				 
		//to insert the value into excel
			 eLib.writeDataIntoExcel("Application", 1, 1, accountNo);
	
	   //click on home button of staff login
			 shp.clickOnHomeBtn();
			
	  //click on credit customer
			 shp.clickOnCreditCust();
			 CreditCustPage cp=new CreditCustPage(driver);
			 cp.custAccNoField(accountNo);
			 cp.creditAmtField();
			 cp.creditBtn();
			
	    //click on accept popup 
			 cp.acceptAlertCreditCust(driver, wLib);
				
	    //logout staff login
			 shp.clickOnLogoutBtn();
				
		//home button of online banking
			 hp.home();
			
		//Apply debit card
			 hp.clicOnApplyDebit();
		
		//get details from excel and enter the details into debit card page
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
				
		//to write in excel
				eLib.writeDataIntoExcel("Application", 3, 1,debitnum);
				eLib.writeDataIntoExcel("Application", 4, 1, debitpin);
				
        //click on  home button
				hp.home();
			
		//move to internet banking
				hp.clickOnInternetBanking(wLib, driver);
				
		//click on register
				hp.clickOnInternetReg();
				
		//enter details
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
				
		//to write in excel
				eLib.writeDataIntoExcel("Application", 5, 1, customerId);
				
		//click on home
				hp.home();
				
		//move to internet banking
				hp.clickOnInternetBanking(wLib, driver);
	
		//login of internet banking
				hp.clickOnInternetLogin();
		
		//enter the details
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
				
		// add beneficiary
				AddBeneficiaryPage abp=new AddBeneficiaryPage(driver);
				abp.beneficiaryAccNo(eLib);
				abp.beneficiaryName(eLib);
				abp.ifsccode(eLib);
				abp.beneficiaryAccType(eLib);
				abp.beneficiarybtn();
				
		//click on popup
				abp.acceptAlertBeneficiaryAdded(driver, wLib);
				
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
