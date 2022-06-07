package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_NonSelect_Sql_Query_Execution {

	public static void main(String[] args) throws Throwable {
				Connection conn=null;
				int result=0;
		
		        try {
		        //Step 1:- Load/register the database
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				
				//Step2:- Connect to database
				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
				System.out.println("done");
				
				//Step3:- Issue Sql Query
				Statement stat = conn.createStatement();
				
				//Step4:- Execute Query
				String query="insert into student_info values(12,'deep','hindu','h')";
				 result = stat.executeUpdate(query);
				if(result==1)
				{
					System.out.println("Success");
				}
		        }catch(Exception e)
		        {
		        	System.err.println("Handle the errors");
		        }finally {
				
				//Step5:- Close the db connection
				conn.close();
		        }

	}

}
