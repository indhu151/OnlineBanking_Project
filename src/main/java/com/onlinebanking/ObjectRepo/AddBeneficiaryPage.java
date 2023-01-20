package com.onlinebanking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.genericutilities.ExcelUtility;
import com.onlinebanking.genericutilities.WebDriverUtility;

public class AddBeneficiaryPage
{
	//declaration
	@FindBy(name="beneficiary_name")
	private WebElement beneficiaryname;
	
	@FindBy(name="beneficiary_acno")
	private WebElement beneficiaryaccno;
	
	@FindBy(name="Ifsc_code")
	private WebElement ifsccode;
	
	@FindBy(name="beneficiary_acc_type")
	private WebElement beneficiaryacctype;
	
	@FindBy(name="add_beneficiary_btn")
	private WebElement beneficiarybtn;
	
	//initialization
	public AddBeneficiaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getBeneficiaryname() {
		return beneficiaryname;
	}

	public WebElement getBeneficiaryaccno() {
		return beneficiaryaccno;
	}

	public WebElement getIfsccode() {
		return ifsccode;
	}

	public WebElement getBeneficiaryacctype() {
		return beneficiaryacctype;
	}

	public WebElement getBeneficiarybtn() {
		return beneficiarybtn;
	}
	
	
	
	//business library
	
	public void beneficiaryName(ExcelUtility eLib) throws Throwable
	{
		beneficiaryname.sendKeys(eLib.getDataFromExcel("beneficiary", 0, 1));
	}
	
	public void beneficiaryAccNo(ExcelUtility eLib) throws Throwable
	{
		beneficiaryaccno.sendKeys(eLib.getDataFromExcel("beneficiary", 1, 1));
	}
	
	public void ifsccode(ExcelUtility eLib) throws Throwable
	{
		ifsccode.sendKeys(eLib.getDataFromExcel("beneficiary", 2, 1));
	}
	
	public void beneficiaryAccType(ExcelUtility eLib) throws Throwable
	{
		beneficiaryacctype.sendKeys(eLib.getDataFromExcel("beneficiary", 3, 1));
	}
	
	public void beneficiarybtn()
	{
		beneficiarybtn.click();
	}
	public void acceptAlertBeneficiaryAdded(WebDriver driver,WebDriverUtility wLib)
	{
		String text=wLib.textAlert(driver);
		wLib.acceptAlert(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
