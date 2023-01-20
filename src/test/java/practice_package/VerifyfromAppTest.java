package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class VerifyfromAppTest
{
	public static void main(String[] args) throws SQLException, InterruptedException 
	{
		//Insert data into database
		Connection con=null;
		try {
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query = "insert into project values('TY_Project_005','Ind','21/12/22','sdet','created',3);";
		int result = state.executeUpdate(query);
	    }
		catch (Exception e) {
			
		}
		finally {
			con.close();
			System.out.println("close the database connection successfully");
		}
		//Verify
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		
		
		
	
	
	
	}
	
	
	

		
	}


