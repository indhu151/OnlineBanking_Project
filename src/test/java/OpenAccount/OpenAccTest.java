package OpenAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenAccTest {
	

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
				
				//create an account
				driver.findElement(By.xpath("//li[text()='Open Account']")).click();
				
				
				
				ArrayList<String> list = new ArrayList<String>();
				list.add("name");
				list.add("mobile");
				list.add("email");
				list.add("landline");
				list.add("pan_no");
				list.add("citizenship");
				list.add("homeaddrs");
				list.add("officeaddrs");
				list.add("pin");
				list.add("arealoc");
				list.add("nominee_name");
				list.add("nominee_ac_no");
				
				
				//Read data from excel file
				FileInputStream fi = new FileInputStream("./src/test/resources/TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("Open");
				Sheet sh1 = wb.getSheet("state");
				
				//for fields name,mobile,email
					
				for(int i=0;i<sh.getLastRowNum();i++)
				{
				String value = sh.getRow(i).getCell(1).getStringCellValue();
				driver.findElement(By.name(list.get(i))).sendKeys(value);
				
				}
			    
				
				//for date of birth
				driver.findElement(By.xpath("//input[@name='dob']")).click();
			    driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("15-03-1990");
				
				
			    //for fields gender,state,city,account type
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("//input[@name='name']/../..//select[@name='gender']");
				list1.add("//select[@name='state']");
				list1.add("//select[@name='city']");
				list1.add("//select[@name='acctype']");
				
				for(int i=0;i<=sh1.getLastRowNum();i++)
				{
				String value1 = sh1.getRow(i).getCell(1).getStringCellValue();
				WebElement state = driver.findElement(By.xpath(list1.get(i)));
				Select s = new Select(state);
				s.selectByValue(value1);
				}
				
				//click on submit
				driver.findElement(By.xpath("//input[@name='submit']")).click();
				
				//click on reconfirm
				driver.findElement(By.xpath("//input[@name='cnfrm-submit']")).click();
			    
				//click on popup
				String text = driver.switchTo().alert().getText();
				//System.out.println(text);
				char ch[]=text.toCharArray();
				char ch1[]=new char[9];
				int j=0;
				for(int i=0;i<ch.length;i++)
				{
					if(ch[i]>='0'&&ch[i]<='9')
					{
						ch1[j]=(ch[i]);
						j++;
					}
				}
				String str = new String(ch1);
				System.out.println(str);
				
				driver.switchTo().alert().accept();
				
				//to insert the value into excel
			
		      wb.getSheet("Application").getRow(0).createCell(1).setCellValue(str);
			  FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
			  wb.write(fos);
			  //wb.close();

				//staff login
						driver.findElement(By.xpath("//a[.='Staff Login']")).click();
						driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(staffid);
						driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
						driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
				
				//ApprovePendingAccount
						driver.findElement(By.xpath("//input[@name='apprvac']")).click();
						driver.findElement(By.xpath("//input[@name='application_no']")).sendKeys(str);
						driver.findElement(By.xpath("//input[@name='search_application']")).click();
						String data = driver.findElement(By.xpath("//tbody/tr[2]")).getText();
						System.out.println(data);
						String text1 = driver.findElement(By.xpath("//th[.='Mobile']/../..//td[.='8987676763']")).getText();
						String actual = sh.getRow(1).getCell(1).getStringCellValue();
						if(text1.equals(actual))
						{
							System.out.println("details are displayed");
						}
						else {
							System.out.println("details are not displayed");
						}
		
		}
		
	    
		}

