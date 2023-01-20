package com.onlinebanking.ObjectRepo;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.ExcelUtility;

public class OpenAccountPage 
{
	ExcelUtility eLib=new ExcelUtility();
	//declaration
	@FindBy(name="name")
	private WebElement nameText;
	
	@FindBy(name="mobile")
	private WebElement mobiletext;
	
	@FindBy(name="email")
	private WebElement emailtext;
	
	@FindBy(name="landline")
	private WebElement landlinetext;
	
	@FindBy(name="pan_no")
	private WebElement pannotext;
	
	@FindBy(name="citizenship")
	private WebElement citizenshiptext;
	
	@FindBy(name="homeaddrs")
	private WebElement homeaddrstext;
	
	@FindBy(name="officeaddrs")
	private WebElement officeaddrstext;
	
	@FindBy(name="pin")
	private WebElement pintext;
	
	@FindBy(name="arealoc")
	private WebElement arealoctext;
	
	@FindBy(name="nominee_name")
	private WebElement nomineenametext;
	
	@FindBy(name="nominee_ac_no")
	private WebElement nomineeacnotext;
	
	@FindBy(xpath="//input[@name='dob']")
	private WebElement dateOfBirthText;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitButton;
	
	//intialization
	public OpenAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getNameText() {
		return nameText;
	}
	
	public WebElement getMobiletext() {
		return mobiletext;
	}

	public WebElement getEmailtext() {
		return emailtext;
	}

	public WebElement getLandlinetext() {
		return landlinetext;
	}

	public WebElement getPannotext() {
		return pannotext;
	}

	public WebElement getCitizenshiptext() {
		return citizenshiptext;
	}

	public WebElement getHomeaddrstext() {
		return homeaddrstext;
	}

	public WebElement getOfficeaddrstext() {
		return officeaddrstext;
	}

	public WebElement getPintext() {
		return pintext;
	}

	public WebElement getArealoctext() {
		return arealoctext;
	}

	public WebElement getNominee_nametext() {
		return nomineenametext;
	}

	public WebElement getNominee_ac_notext() {
		return nomineeacnotext;
	}

	public WebElement getDateOfBirthText() {
		return dateOfBirthText;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//business library
	
	

	public void textFieldData(ExcelUtility eLib) throws Throwable
	{
		String name=eLib.getDataFromExcel("data", 0, 1);
		nameText.sendKeys(name);
		String mobile = eLib.getDataFromExcel("data", 1, 1);
		mobiletext.sendKeys(mobile);
		String email = eLib.getDataFromExcel("data", 2, 1);
		emailtext.sendKeys(email);
		String landline = eLib.getDataFromExcel("data", 3, 1);
		landlinetext.sendKeys(landline);
		String panno = eLib.getDataFromExcel("data", 4, 1);
		pannotext.sendKeys(panno);
		String citizenship = eLib.getDataFromExcel("data", 5, 1);
		citizenshiptext.sendKeys(citizenship);
		String homeaddrs = eLib.getDataFromExcel("data", 6, 1);
		homeaddrstext.sendKeys(homeaddrs);
		String officeaddrs = eLib.getDataFromExcel("data", 7, 1);
		officeaddrstext.sendKeys(officeaddrs);
		String pin = eLib.getDataFromExcel("data", 8, 1);
		pintext.sendKeys(pin);
		String arealoc = eLib.getDataFromExcel("data", 9, 1);
		arealoctext.sendKeys(arealoc);
		String nomineename = eLib.getDataFromExcel("data", 10, 1);
		nomineenametext.sendKeys(nomineename);
		String nomineeacno = eLib.getDataFromExcel("data", 11, 1);
		nomineeacnotext.sendKeys(nomineeacno);
		
		
	}
	
	public void textField(Map<String,String> ha,WebDriver driver)
	{
		for(Entry<String, String> h:ha.entrySet())
		{
			String name1 = h.getValue();
			
			driver.findElement(By.name(h.getKey())).sendKeys(name1);
		}
	}
	
	public void dateOfBirthText() throws Throwable
	{
		String date=eLib.getDataFromExcel("date", 0, 1);
		String month=eLib.getDataFromExcel("date", 1, 1);
		String year=eLib.getDataFromExcel("date", 2, 1);
		String dob = date+""+month+""+year;
		dateOfBirthText.click();
		dateOfBirthText.sendKeys(dob);
	}
	
	public void clickOnSubmitLink()
	{
		submitButton.click();
	}
	

}
