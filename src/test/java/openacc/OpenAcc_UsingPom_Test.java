package openacc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.onlinebanking.ObjectRepo.ApprovePendingPage;
import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.OpenAccountPage;
import com.onlinebanking.ObjectRepo.ReConfirmPage;
import com.onlinebanking.ObjectRepo.StaffHomePage;
import com.onlinebanking.ObjectRepo.StaffLoginPage;
import com.onlinebanking.genericutilities.BaseClass;
import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.FileUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;
//@Listeners(com.onlinebanking.genericutilities.ListenerImplementationClass.class)
public class OpenAcc_UsingPom_Test extends BaseClass
{
	@Test(priority=-2)
	public void openAcc() throws Throwable
	{
		  //create an account
				HomePage hp=new HomePage(driver);
				hp.clickOnOpenAccount();
		  //To enter details like name,mobile no,.. in open account page and click on submit	
				OpenAccountPage op=new OpenAccountPage(driver);
				op.textField(eLib.getList1("data", 0, 1), driver);
				op.dateOfBirthText();
				 Assert.fail();
				op.textField(eLib.getList1("state", 0, 1), driver);
				
				op.clickOnSubmitLink();
				
		 //click on reconfirm button
				ReConfirmPage rp=new ReConfirmPage(driver);
			    rp.clickOnReConfirm();
			    String applicationNo= rp.acceptAlertApplicationno(driver, wLib, jLib);
			    rp.insertAppliNoIntoExcel(applicationNo);
			    }
	@Test(dependsOnMethods = "openAcc")
	public void sample1()
	{
		System.out.println("test1");
	}
	@Test
	public void sample2()
	{
		System.out.println("test2");
	}
	
	
	

}
