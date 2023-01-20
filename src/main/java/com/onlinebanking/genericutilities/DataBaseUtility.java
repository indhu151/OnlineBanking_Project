package com.onlinebanking.genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{
	Connection con=null;
	public void connectionToDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DBUSERNAME, IpathConstants.DBEPASSWORD);
		
	}
	
	public String executeQueryAndGetData(String query,int columIndex,String expData) throws Throwable
	{
		 ResultSet result = con.createStatement().executeQuery(query);
		 boolean flag=false;
		 while(result.next())
		 {
			 String data = result.getString(columIndex);
			 System.out.println(data);
			 if(data.equalsIgnoreCase(expData))
			 {
				 flag=true;
				 break;
			 }
		}
		 
		if(flag)
		{
			System.out.println(expData+"Project is created");
			return expData;
		}
		else {
			System.out.println("project not created");
			return "";
		}
	}
	
	public void closeDB() throws Throwable
	{
		con.close();
	}

}
