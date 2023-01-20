package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.ExcelUtility;

public class InternetBankingLoginPage 
{
	//declaration
	@FindBy(name="customer_id")
	private WebElement customerId;
	
	@FindBy(name="password")
	private WebElement passwordtext;
	
	@FindBy(name="login-btn")
	private WebElement loginbtn;
	
	//initialization
	public InternetBankingLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getCustomerId() {
		return customerId;
	}

	public WebElement getPasswordtext() {
		return passwordtext;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	//business library
	
	public void customerIdField(ExcelUtility eLib) throws Throwable
	{
		customerId.sendKeys(eLib.getDataFromExcel("Application",5, 1));
	}
	public void passwordText(ExcelUtility eLib) throws Throwable
	{
		passwordtext.sendKeys(eLib.getDataFromExcel("Application", 2, 1));
	}
	public void clickOnLoginBtn()
	{
		loginbtn.click();
	}

}
