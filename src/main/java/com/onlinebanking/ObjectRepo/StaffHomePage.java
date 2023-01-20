package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class StaffHomePage 
{
	//declaration
	@FindBy(name="apprvac")
	private WebElement approvePendingMod;
	
	@FindBy(name="credit_cust_ac")
	private WebElement creditCustMod;
	
	@FindBy(name="viewdet")
	private WebElement viewActiveCustMod;
	
	@FindBy(name="view_cust_by_ac")
	private WebElement viewCustByAccnoMod;
	
	@FindBy(name="del_cust")
	private WebElement deleteCustMod;
	
	@FindBy(name="home")
	private WebElement homebtn;
	
	@FindBy(name="logout_btn")
	private WebElement logoutbtn;
	
	//intialization
	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getApprovePendingMod() {
		return approvePendingMod;
	}

	public WebElement getCreditCustMod() {
		return creditCustMod;
	}

	public WebElement getViewActiveCustMod() {
		return viewActiveCustMod;
	}

	public WebElement getViewCustByAccnoMod() {
		return viewCustByAccnoMod;
	}

	public WebElement getDeleteCustMod() {
		return deleteCustMod;
	}

	public WebElement getHomebtn() {
		return homebtn;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	//business library
	public void clickOnApprovePend()
	{
		approvePendingMod.click();
	}
	
	public void clickOnCreditCust() 
	{
		creditCustMod.click();
	}
	public void clickOnViewCustByAccno()
	{
		viewCustByAccnoMod.click();
	}
	public void clickOnDeleteCust()
	{
		deleteCustMod.click();
	}
	public void clickOnHomeBtn()
	{
		homebtn.click();
	}
	public void clickOnLogoutBtn()
	{
		logoutbtn.click();
	}
	public void clickOnViewActiveCust()
	{
		viewActiveCustMod.click();
	}

}
