package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest
{
	public static void main(String[] args) throws SQLException 
	{
		
		Connection con=null;
		int result=0;
		try {
		Driver driver=new Driver();
		//step1:Register the database
		DriverManager.registerDriver(driver);
		
		//step2:get connection for the database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
		 
		 
		 //step3:Issue create statement
		 Statement state = con.createStatement();
		 String query = "insert into studentInfo values('nitish','BTM','Appium',1);";
		 
		 //step4:update query
		result = state.executeUpdate(query);
		}
		catch (Exception e) {
			
		}
		finally {
			
			if(result==1)
			{
				System.out.println("Dtata inserted Successfully");
			}
			else {
				System.out.println("Data not inseted");
			}
			//step5:close the database
			con.close();
			System.out.println("close the database connection successfully");
		}
		
		
		
	}

}
