package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripTest
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Actions a=new Actions(driver);
		a.moveByOffset(10, 10).click().perform();
		//driver.findElement(By.xpath("//span[text()='Buses']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).click();
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//p[text()='11'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		driver.findElement(By.xpath("(//p[text()='9'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
	}

}
