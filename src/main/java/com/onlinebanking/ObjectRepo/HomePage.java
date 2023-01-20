package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.WebDriverUtility;

public class HomePage 
{
	//declaration
	@FindBy(xpath = "//li[text()='Open Account']")
	private WebElement OpenAccMod;
	
	@FindBy(xpath = "//li[.='Apply Debit Card']")
	private WebElement ApplyDebitMod;
	
	@FindBy(xpath= "//div[@class='ebanking'] ")
	private WebElement InternetBankingMod;
	
	@FindBy(linkText = "Fund Transfer")
	private WebElement fundTransferMod;
	
	@FindBy(linkText = "Home")
	private WebElement homeButton;
	
	@FindBy(linkText = "Register")
	private WebElement InternetRegMod;
	
	@FindBy(xpath="//li[text()='Login ']")
	private WebElement InternetLoginMod;
	
	@FindBy(linkText = "Staff Login")
	private WebElement StaffLoginLink;
	
	
	//intialization
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	
	}
	//utilization

	public WebElement getOpenAccMod() {
		return OpenAccMod;
	}

	public WebElement getApplyDebitMod() {
		return ApplyDebitMod;
	}

	public WebElement getInternetBankingMod() {
		return InternetBankingMod;
	}

	public WebElement getFundTransferMod() {
		return fundTransferMod;
	}

	public WebElement getHomeButton() {
		return homeButton;
	}

	public WebElement getInternetRegMod() {
		return InternetRegMod;
	}

	public WebElement getInternetLoginMod() {
		return InternetLoginMod;
	}

	public WebElement getStaffLoginLink() {
		return StaffLoginLink;
	}

	//business library
	
	

	public void clickOnOpenAccount() 
	{
		OpenAccMod.click();
	}
	public void clickOnApplyDebit()
	{
			ApplyDebitMod.click();
	}
	public void clickOnInternetBanking(WebDriverUtility wLib,WebDriver driver)
	{
		wLib.mousehover(driver, InternetBankingMod);
	}
	public void clickOnInternetReg()
	{
		InternetRegMod.click();
	}
	public void clickOnInternetLogin()
	{
		InternetLoginMod.click();
	}
	public void clickOnFundTransfer()
	{
		fundTransferMod.click();
	}
	public void home()
	{
		homeButton.click();
	}
	public void staffLoginLink()
	{
		StaffLoginLink.click();
	}
	
}
