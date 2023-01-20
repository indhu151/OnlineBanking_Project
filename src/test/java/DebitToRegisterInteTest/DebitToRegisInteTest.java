package DebitToRegisterInteTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DebitToRegisInteTest {
	public static void main(String[] args) throws Throwable
	{

		//Read data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData1.properties");
		Properties p = new Properties();
		p.load(fis);
		String Url = p.getProperty("url");
		String staffid = p.getProperty("staffid");
		String pwd = p.getProperty("password");
		System.out.println(Url);
		System.out.println(staffid);
		System.out.println(pwd);
		
		
		//Enter the application
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Url);
		
		//Read data from excel file
				FileInputStream fi = new FileInputStream("./src/test/resources/TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("Open");
				Sheet sh1 = wb.getSheet("state");
				
driver.findElement(By.xpath("//li[.='Apply Debit Card']")).click();
				
				String name = sh.getRow(0).getCell(1).getStringCellValue();
				 String mob = sh.getRow(1).getCell(1).getStringCellValue();
				 String pan = sh.getRow(4).getCell(1).getStringCellValue();
				 String acc = wb.getSheet("Application").getRow(1).getCell(1).getStringCellValue();
				
				
				driver.findElement(By.name("holder_name")).sendKeys(name);
				driver.findElement(By.name("dob")).click();
				driver.findElement(By.name("dob")).sendKeys("15-03-1990");
				driver.findElement(By.name("pan")).sendKeys( pan);
				driver.findElement(By.name("mob")).sendKeys(mob);
				driver.findElement(By.name("acc_no")).sendKeys(acc);
				driver.findElement(By.name("dbt_crd_submit")).click();
				
				String text3 = driver.switchTo().alert().getText();
				//System.out.println(text3);
				//to get debit card number and pin
			
				
				char ch5[]=text3.toCharArray();
				String st1 = " ";
				String st2 = " ";
				int count=0;
				for(int i=0;i<ch5.length;i++)
				{
					if(ch5[i]>='0'&&ch5[i]<='9')
					{
						if(count<12)
						{
							st1=st1+ch5[i];
						    count++;
						}
						else {
							st2=st2+ch5[i];
						}
					}
				}
				System.out.println(st1);
				System.out.println(st2);
				
				driver.switchTo().alert().accept();
			//to write in excel
				 wb.getSheet("Application").getRow(3).createCell(1).setCellValue(st1);
				 wb.getSheet("Application").getRow(4).createCell(1).setCellValue(st2); 
				 
				 FileOutputStream f1 = new FileOutputStream("./src/test/resources/TestData.xlsx");
				  wb.write(f1);
				
				
				
		//click on  home button
				
				driver.findElement(By.xpath("//a[.='Home']")).click();
				
		//click on internet banking
				Actions a=new Actions(driver);
				WebElement move = driver.findElement(By.xpath("//div[@class='ebanking']"));
				a.moveToElement(move).perform();
				
				//click on register
				driver.findElement(By.xpath("//li[.='Register']")).click();
				
				//enter details
				String name1 = sh.getRow(0).getCell(1).getStringCellValue();
				String mob1 = sh.getRow(1).getCell(1).getStringCellValue();
				 String pan1 = sh.getRow(4).getCell(1).getStringCellValue();
				 String acc1 = wb.getSheet("Application").getRow(1).getCell(1).getStringCellValue();
				 String pass = wb.getSheet("Application").getRow(2).getCell(1).getStringCellValue();
				 String debnum = wb.getSheet("Application").getRow(3).getCell(1).getStringCellValue();
				 String debpin = wb.getSheet("Application").getRow(4).getCell(1).getStringCellValue();
				
				
				driver.findElement(By.name("holder_name")).sendKeys(name1);
				driver.findElement(By.name("accnum")).sendKeys(acc1);
				driver.findElement(By.name("dbtcard")).sendKeys(debnum);
				driver.findElement(By.name("dbtpin")).sendKeys(debpin);
				driver.findElement(By.name("mobile")).sendKeys(mob1);
				driver.findElement(By.name("pan_no")).sendKeys(pan1);
				driver.findElement(By.name("dob")).click();
				driver.findElement(By.name("dob")).sendKeys("15-03-1990");
				driver.findElement(By.name("last_trans")).sendKeys("10000");
				driver.findElement(By.name("password")).sendKeys(pass);
				driver.findElement(By.name("cnfrm_password")).sendKeys(pass);
						
				driver.findElement(By.name("submit")).click();
				
				//click on popup
				String text4 = driver.switchTo().alert().getText();
				
				//to get customer id
				
				char ch7[]=text4.toCharArray();
				char ch8[]=new char[7];
				int j=0;
				for(int i=0;i<ch7.length;i++)
				{
					if(ch7[i]>='0'&&ch7[i]<='9')
					{
						ch8[j]=(ch7[i]);
						j++;
					}
				}
				String st4 = new String(ch8);
				System.out.println(st4);
				
				//to write in excel
				wb.getSheet("Application").getRow(5).createCell(1).setCellValue(st4);
				FileOutputStream f2 = new FileOutputStream("./src/test/resources/TestData.xlsx");
				wb.write(f2);
				
				driver.switchTo().alert().accept();
				
				
		
	}

}
