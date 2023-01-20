package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class HandlingMultipleExcelExTest 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("OrgName");
	    int count = sh.getLastRowNum();
	    
	    for(int i=1;i<=count;i++)
	    {
	    sh.createRow(i).createCell(2).setCellValue("indu");
	    }
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
	    	
	    
	}
}
