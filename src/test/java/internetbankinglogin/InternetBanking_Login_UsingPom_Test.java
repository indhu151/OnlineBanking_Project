package internetbankinglogin;

import org.testng.annotations.Test;

import com.onlinebanking.ObjectRepo.HomePage;
import com.onlinebanking.ObjectRepo.InternetBankingLoginPage;
import com.onlinebanking.genericutilities.BaseClass;

public class InternetBanking_Login_UsingPom_Test  extends BaseClass
{
	@Test
	public void internetLogin() throws Throwable
	{
		
			//login of internet banking
			HomePage hp=new HomePage(driver);
			hp.clickOnInternetBanking(wLib, driver);
			hp.clickOnInternetLogin();
			InternetBankingLoginPage iblp=new InternetBankingLoginPage(driver);
			iblp.customerIdField(eLib);
			iblp.passwordText(eLib);
			iblp.clickOnLoginBtn();
	}
}
