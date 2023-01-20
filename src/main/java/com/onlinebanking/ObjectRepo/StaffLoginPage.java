package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.FileUtility;

public class StaffLoginPage 
{
	FileUtility fLib=new FileUtility();
	//declaration
	@FindBy(name="staff_id")
	private WebElement Staffid;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="staff_login-btn")
	private WebElement loginbtn;
	//intialization
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	
	public WebElement getStaffid() {
		return Staffid;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//business library
	public void staffIdField() throws Throwable
	{
		Staffid.sendKeys(fLib.getPropertyKeyValue("staffid"));
	}
	public void passwordField() throws Throwable
	{
		password.sendKeys(fLib.getPropertyKeyValue("password"));
	}
	public void clickOnLogin()
	{
		loginbtn.click();
	}

}
