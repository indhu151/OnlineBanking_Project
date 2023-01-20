package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcelTest
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException  
	{
		
	
			
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("OrgName").createRow(2).createCell(0).setCellValue("vinod");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		                                                                                                                                                                                           
		
	}

}
