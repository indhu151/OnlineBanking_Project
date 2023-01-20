package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RmgInsertQueryTest 
{
	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		int result=0;
		
		try{
		Driver driver=new Driver();
		//step1:Register the database
		DriverManager.registerDriver(driver);
		
		//step2:get a connection for the database
		 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		 
		 //step3:Issue create statement
		 Statement state = con.createStatement();
		 String query = "insert into project values('TY_Project_005','Indhu','21/12/22','sdet45','created',3);";
		 
		 //step4:update query
		 result = state.executeUpdate(query);
		}
		catch (Exception e) {
			
			
		}
		finally {
			if(result==1)
			{
				System.out.println("data inserted successsfully");
			}
			else 
			{
				System.out.println("data not inserted");
			}
			//step5:close the database connection
			con.close();
			System.out.println("close the database connection successfully");
		}
	}

}
