package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class ApplyDebitPage 
{
	ExcelUtility eLib=new ExcelUtility();
	//declaration
	@FindBy(name="holder_name")
	private WebElement accountholdernamefield;
	
	@FindBy(name="dob")
	private WebElement dateofbirthfield;
	
	@FindBy(name="pan")
	private WebElement panfield;
	
	@FindBy(name="mob")
	private WebElement mobilenofield;
	
	@FindBy(name="acc_no")
	private WebElement accountnofield;
	
	@FindBy(name="dbt_crd_submit")
	private WebElement debitsubmitbtn;
	//initialization
	
	public ApplyDebitPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getAccountholdernamefield() {
		return accountholdernamefield;
	}

	public WebElement getDateofbirthfield() {
		return dateofbirthfield;
	}

	public WebElement getPanfield() {
		return panfield;
	}

	public WebElement getMobilenofield() {
		return mobilenofield;
	}

	public WebElement getAccountnofield() {
		return accountnofield;
	}
	
	public WebElement getDebitsubmitbtn() {
		return debitsubmitbtn;
	}

	//business library
	public void accountNameField(ExcelUtility eLib) throws Throwable
	{
		accountholdernamefield.sendKeys(eLib.getDataFromExcel("data", 0, 1));
	}
	public void dobField() throws Throwable
	{
		String date=eLib.getDataFromExcel("date", 0, 1);
		String month=eLib.getDataFromExcel("date", 1, 1);
		String year=eLib.getDataFromExcel("date", 2, 1);
		String dob = date+""+month+""+year;
		dateofbirthfield.click();
		dateofbirthfield.sendKeys(dob);
	}
	public void panField(ExcelUtility eLib) throws Throwable
	{
		panfield.sendKeys(eLib.getDataFromExcel("data", 4, 1));
	}
	public void mobileNoField(ExcelUtility eLib) throws Throwable
	{
		mobilenofield.sendKeys(eLib.getDataFromExcel("data", 1, 1));
	}
	public void accountNoField(ExcelUtility eLib) throws Throwable
	{
		accountnofield.sendKeys(eLib.getDataFromExcel("Application", 1, 1));
	}
	
	public void clickOnDebitSubmitBtn()
	{
		debitsubmitbtn.click();
	}
	
	public String acceptAlertDebitNum(WebDriver driver,WebDriverUtility wLib,JavaUtility jLib)
	{
		String text3 = wLib.textAlert(driver);
		System.out.println(text3);
		String st1=jLib.getDebitNum(text3);
		String st2 = jLib.getDebitPin(text3);
		//System.out.println(st1);
		//System.out.println(st2);
		return st1;
	}
	public String acceptAlertDebitPin(WebDriver driver,WebDriverUtility wLib,JavaUtility jLib)
	{
		String text3 = wLib.textAlert(driver);
		String st1=jLib.getDebitNum(text3);
		String st2 = jLib.getDebitPin(text3);
		//System.out.println(st1);
		//System.out.println(st2);
		wLib.acceptAlert(driver);
		return st2;
	}
	public void insertDebitNoIntoExcel(String debitnum) throws Throwable
	{
		eLib.writeDataIntoExcel("Application", 3, 1,debitnum);
	}
	public void insertDebitPinIntoExcel(String debitpin) throws Throwable
	{
		eLib.writeDataIntoExcel("Application", 4, 1, debitpin);
	}

}
