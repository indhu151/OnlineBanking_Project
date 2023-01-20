package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class ReConfirmPage {
	
	ExcelUtility eLib=new ExcelUtility();
	//declaration
	@FindBy(xpath="//input[@name='cnfrm-submit']")
	private WebElement reconfirmbtn;
	
	//intialization
	public ReConfirmPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getReconfirmbtn() {
		return reconfirmbtn;
	}
	
	//business library
	public void clickOnReConfirm()
	{
		reconfirmbtn.click();
	}
	
	public String acceptAlertApplicationno(WebDriver driver,WebDriverUtility wLib,JavaUtility jLib)
	{
	String text = wLib.textAlert(driver);
	
	//to get only application number
	String str = jLib.getApplication(text);
	System.out.println("Application Number"+str);
	
	//click on accept on alert popup
	wLib.acceptAlert(driver);
	return str;
	}
	
	public void insertAppliNoIntoExcel(String applicationNo ) throws Throwable
	{
		eLib.writeDataIntoExcel("Application", 0, 1, applicationNo);
	}

	
	
	
	
	
	
	
	
	
	
	
}
