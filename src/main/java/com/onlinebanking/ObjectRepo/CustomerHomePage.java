package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerHomePage 
{
	//declaration
	@FindBy(xpath = "//li[.='Fund Transfer']")
	private WebElement fundtransfer;
	
	@FindBy(linkText = "My Account")
	private WebElement myaccount;
	
	@FindBy(linkText = "My Profile")
	private WebElement myprofile;
	
	@FindBy(linkText = "Change Password")
	private WebElement changepassword;
	
	@FindBy(linkText = "Statement")
	private WebElement statement;
	
	//intialization
	public CustomerHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getFundtransfer() {
		return fundtransfer;
	}

	public WebElement getMyaccount() {
		return myaccount;
	}

	public WebElement getMyprofile() {
		return myprofile;
	}

	public WebElement getChangepassword() {
		return changepassword;
	}

	public WebElement getStatement() {
		return statement;
	}
	
	
	//business library
	public void clickOnFundTransfer()
	{
		fundtransfer.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
