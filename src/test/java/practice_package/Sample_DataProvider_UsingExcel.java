package practice_package;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.onlinebanking.genericutilities.ExcelUtility;

public class Sample_DataProvider_UsingExcel 
{
	@Test(dataProvider = "readMultipleData")
	public void readData(String from,String to)
	{
		Reporter.log(from+"---->"+to, true);
		//System.out.println(from+"---->"+to);
	}
	
	@DataProvider
	public Object readMultipleData() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		Object value = eLib.getMultipleSetOfData("DataProvider");
		return value;
	}

}
