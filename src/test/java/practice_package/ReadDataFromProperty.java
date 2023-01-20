package practice_package;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadDataFromProperty {

	public static void main(String[] args) throws Throwable
	{
		//step1:get object representation for physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		//step2:create object
		Properties p = new Properties();
		//step3:Load the file
		p.load(fis);
		//step4:To get the data from property file
		String Url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		//step5:To display the data
		System.out.println(Url);
		System.out.println(un);
		System.out.println(pwd);
		
		
	}

}
