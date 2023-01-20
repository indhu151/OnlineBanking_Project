package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class ApprovePendingPage
{
	ExcelUtility eLib=new ExcelUtility();
	//declaration
	@FindBy(name="application_no")
	private WebElement applicationNotextfield;
	
	@FindBy(name="search_application")
	private WebElement searchbtn;
	
	@FindBy(name="approve_cust")
	private WebElement approvebtn;
	
	//intialization
	public ApprovePendingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getApplicationNotextfield() {
		return applicationNotextfield;
	}
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public WebElement getApprovebtn() {
		return approvebtn;
	}
	//business library
	public void applicatioNoTextField(String str)
	{
		applicationNotextfield.sendKeys(str);
	}
	
	public void clickOnSearchBtn()
	{
		searchbtn.click();
	}
	public void clickOnApprove()
	{
		approvebtn.click();
	}
	public String acceptAlertAccountNo(WebDriver driver,WebDriverUtility wLib,JavaUtility jLib)
	{
		wLib.alertPresent(driver);
		String text2 = wLib.textAlert(driver);
		String str1 = jLib.getAccountNum(text2);
		System.out.println("Account no="+str1);
	//close the popup
		wLib.acceptAlert(driver);
		return str1;
		
	}
	
	public void insertAccNoIntoExcel(String accountNo) throws Throwable
	{
		eLib.writeDataIntoExcel("Application", 1, 1, accountNo);
	}
	
}
