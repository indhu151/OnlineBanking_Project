package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.JavaUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class InternetBankingRegPage 
{
	ExcelUtility eLib=new ExcelUtility();
	//declaration
	
	@FindBy(name="holder_name")
	private WebElement accholdername;
	
	@FindBy(name="accnum")
	private WebElement accountno;
	
	@FindBy(name="dbtcard")
	private WebElement debitcardnum;
	
	@FindBy(name="dbtpin")
	private WebElement debitpin;
	
	@FindBy(name="mobile")
	private WebElement mobileno;
	
	@FindBy(name="pan_no")
	private WebElement pannofield;
	
	@FindBy(name="dob")
	private WebElement dateofbirth;
	
	@FindBy(name="last_trans")
	private WebElement lasttrans;
	
	@FindBy(name="password")
	private WebElement passwordfield;
	
	@FindBy(name="cnfrm_password")
	private WebElement confirmpassword;
	
	@FindBy(name="submit")
	private WebElement submitbtn;
	
	
	//intialization
	public InternetBankingRegPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization


	public WebElement getAccholdername() {
		return accholdername;
	}


	public WebElement getAccountno() {
		return accountno;
	}


	public WebElement getDebitcardnum() {
		return debitcardnum;
	}


	public WebElement getDebitpin() {
		return debitpin;
	}


	public WebElement getMobileno() {
		return mobileno;
	}


	public WebElement getPannofield() {
		return pannofield;
	}


	public WebElement getDateofbirth() {
		return dateofbirth;
	}


	public WebElement getLasttrans() {
		return lasttrans;
	}


	public WebElement getPasswordfield() {
		return passwordfield;
	}


	public WebElement getConfirmpassword() {
		return confirmpassword;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
	//business library
	
	public void accountHolderName(ExcelUtility eLib) throws Throwable
	{
		accholdername.sendKeys(eLib.getDataFromExcel("data", 0, 1));
	}
	public void accountNum(ExcelUtility eLib) throws Throwable
	{
		accountno.sendKeys(eLib.getDataFromExcel("Application", 1, 1));
	}
	public void DebitNum(ExcelUtility eLib) throws Throwable
	{
		debitcardnum.sendKeys(eLib.getDataFromExcel("Application", 3, 1));
	}
	public void debitPin(ExcelUtility eLib) throws Throwable
	{
		debitpin.sendKeys(eLib.getDataFromExcel("Application", 4, 1));
	}
	public void mobileNo(ExcelUtility eLib) throws Throwable
	{
		mobileno.sendKeys(eLib.getDataFromExcel("data", 1, 1));
	}
	public void panNoField(ExcelUtility eLib) throws Throwable
	{
		pannofield.sendKeys(eLib.getDataFromExcel("data", 4, 1));
	}
	public void dateOfBirth(ExcelUtility eLib) throws Throwable
	{
		String date=eLib.getDataFromExcel("date", 0, 1);
			String month=eLib.getDataFromExcel("date", 1, 1);
			String year=eLib.getDataFromExcel("date", 2, 1);
			String dob = date+""+month+""+year;
			dateofbirth.click();
			dateofbirth.sendKeys(dob);
		}
		
	
	public void lastTransField(ExcelUtility eLib) throws Throwable
	{
		lasttrans.sendKeys("10000");
	}
	public void passwordField(ExcelUtility eLib) throws Throwable
	{
		passwordfield.sendKeys(eLib.getDataFromExcel("Application", 2, 1));
	}
	public void confirmPasswordField(ExcelUtility eLib) throws Throwable
	{
		confirmpassword.sendKeys(eLib.getDataFromExcel("Application", 2, 1));
	}
	public void submitBtn()
	{
		submitbtn.click();
	}
	public String acceptAlertCustomerId(WebDriver driver,WebDriverUtility wLib,JavaUtility jLib)
	{
		String text4 = wLib.textAlert(driver);
		//to get customer id
		String st4 = jLib.getCustomerId(text4);
		//System.out.println(st4);
		//click on alert accept
		wLib.acceptAlert(driver);
		
		return st4;
	}
	
	public void insertCustIdIntoExcel(String customerId ) throws Throwable
	{
		eLib.writeDataIntoExcel("Application", 5, 1, customerId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
