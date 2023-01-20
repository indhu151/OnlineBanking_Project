package practice_package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class HandleMultipleDataExcel {

		public static void main(String[] args) throws Throwable 
		{
			FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
		    Sheet sh = wb.getSheet("OrgName");
		    int count = sh.getLastRowNum();
		 
		    for(int i=0;i<=count;i++)
		    {
		    String data = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
		    	}
		    	
		    }
		

	}



