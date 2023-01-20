package OpenAccount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class StaffLogin {

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
		
		FileInputStream fi = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Open");
		Sheet sh1 = wb.getSheet("state");
				
				
		//Enter the application
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(Url);
		//staff login
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(staffid);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
		
		
		driver.findElement(By.name("logout_btn")).click();
		
		driver.findElement(By.xpath("//a[.='Home']")).click();
		
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
		driver.findElement(By.name("last_trans")).sendKeys("0");
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("cnfrm_password")).sendKeys(pass);
		
		//login of internet banking
		driver.findElement(By.xpath("//li[.='Login ']")).click();
		
		//enter the details
		String id = wb.getSheet("Application").getRow(5).getCell(1).getStringCellValue();
		
		
		 
		driver.findElement(By.name("customer_id")).sendKeys(id);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("login-btn")).click();
		
		
		//fund transfer
		driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
		
	}

}
