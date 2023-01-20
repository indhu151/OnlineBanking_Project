package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class FundTransferHomePage 
{
	//declaration
	@FindBy(name="add_beneficiary")
	private WebElement addbeneficiary;
	
	@FindBy(name="delete_beneficiary")
	private WebElement deletebeneficiary;
	
	@FindBy(name="view_beneficiary")
	private WebElement viewbeneficiary;
	
	@FindBy(xpath="//select[@name='beneficiary']")
	private WebElement selectbeneficiary;
	
	@FindBy(name="trnsf_amount")
	private WebElement amountfield;
	
	@FindBy(name="trnsf_remark")
	private WebElement remark;
	
	@FindBy(name="fnd_trns_btn")
	private WebElement sendbtn;
	
	@FindBy(xpath="//label[@class='OTP_msg']")
	private WebElement otp;
	
	@FindBy(name="otpcode")
	private WebElement otpcode;
	
	@FindBy(name="verify-btn")
	private WebElement verifybtn;
	
	//initialization
	public FundTransferHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getAddbeneficiary() {
		return addbeneficiary;
	}

	public WebElement getDeletebeneficiary() {
		return deletebeneficiary;
	}

	public WebElement getViewbeneficiary() {
		return viewbeneficiary;
	}

	public WebElement getSelectbeneficiary() {
		return selectbeneficiary;
	}

	public WebElement getAmountfield() {
		return amountfield;
	}

	public WebElement getRemark() {
		return remark;
	}

	public WebElement getSubmitbtn() {
		return sendbtn;
	}
	
	public WebElement getSendbtn() {
		return sendbtn;
	}
	

	public WebElement getOtp() {
		return otp;
	}

	public WebElement getOtpcode() {
		return otpcode;
	}

	public WebElement getVerifybtn() {
		return verifybtn;
	}

	//business library
	public void clickOnAddBeneficiary()
	{
		addbeneficiary.click();
	}
	public void selectBeneficiary(WebDriverUtility wLib)
	{
		wLib.select(selectbeneficiary, 1);
	}
	public void amountField()
	{
		amountfield.sendKeys("1000");
	}
	public void clickOnSendBtn()
	{
		sendbtn.click();
	}
	public String captureOtp(JavaUtility jLib)
	{
		String Otp=otp.getText();
		//to get OTP number
		String st13 = jLib.getOtp(Otp);
		StringBuilder st14 = new StringBuilder(st13);
		st14.reverse();
		System.out.println(st14);
		String st15=new String(st14);
		return st15;
		
	}
	
	public void verifyOtp(String OTP)
	{
		otpcode.sendKeys(OTP);
		verifybtn.click();
		
	}
	public String acceptAlertTransaction(WebDriverUtility wLib,WebDriver driver)
	{
		String text6 = wLib.textAlert(driver);
		//System.out.println(text6);
		wLib.acceptAlert(driver);
		return text6;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
