package practice_package;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice_DataProvider
{
	@Test(dataProvider = "data")
	public void travel(String src,String desc,int price)
	{
		
		
		System.out.println(src+" "+"---->"+" "+desc+" "+price);
		
	}
	
	 
	@DataProvider
	public Object[][] data()
	{  
		
		Object[][] objarr = new Object[3][3];
		objarr[0][0]="Bangalore";
		objarr[0][1]="Mysore";
		objarr[0][2]=200;
		
		objarr[1][0]="Mysore";
		objarr[1][1]="Bangalore";
		objarr[1][2]=250;
		
		objarr[2][0]="Bangalore";
		objarr[2][1]="chennai";
		objarr[2][2]=450;
		
		return objarr;
	}

}
