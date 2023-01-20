package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.WebDriverUtility;

public class CreditCustPage 
{
	//declaration
	@FindBy(name="customer_account_no")
	private WebElement custaccnofield;
	
	@FindBy(name="credit_amount")
	private WebElement creditAmtfield;
	
	@FindBy(name="credit_btn")
	private WebElement creditbtn;
	//intialization
	public CreditCustPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCustaccnofield() {
		return custaccnofield;
	}
	public WebElement getCreditAmtfield() {
		return creditAmtfield;
	}
	public WebElement getCreditbtn() {
		return creditbtn;
	}
	
	//businedss library
	
	public void custAccNoField(String str1)
	{
		custaccnofield.sendKeys(str1);
	}
	
	public void  creditAmtField()
	{
		creditAmtfield.sendKeys("10000");
	}
	
	public void creditBtn()
	{
		creditbtn.click();
		
	}

	public String acceptAlertCreditCust(WebDriver driver,WebDriverUtility wLib)
	{
		String text=wLib.textAlert(driver);
		wLib.acceptAlert(driver);
		return text;
	}
}
