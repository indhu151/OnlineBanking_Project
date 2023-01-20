package practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripBusTest
{
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Actions a=new Actions(driver);
		a.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[text()='Buses']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).click();
		driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka']")).click();
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).click();
		driver.findElement(By.xpath("//span[text()='Chennai, Tamil Nadu']")).click();
		
	}

}
