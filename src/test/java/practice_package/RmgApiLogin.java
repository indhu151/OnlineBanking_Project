package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgApiLogin 
{
	
	public static void main(String[] args) throws InterruptedException, SQLException
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("OnlineBank");
		
		driver.findElement(By.name("createdBy")).sendKeys("Indhu");
		
		WebElement status = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select[@name='status']"));
	    Select s=new Select(status);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		driver.close();
		
		
		//to check in database
		
		Connection con=null;
		try {
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query = "select * from project;";
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String actualProject = result.getString(4);
			System.out.println(actualProject);
			if(actualProject.equals("OnlineBank"))
			{
			flag=true;
			System.out.println("project is in database");
			break;
			}
			if(flag==false)
			{
				System.out.println("Project is not in database");
			}
		}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			con.close();
			System.out.println("close the database connection successfully");
		}
		
	}

}
