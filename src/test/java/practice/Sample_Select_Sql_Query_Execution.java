package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_Select_Sql_Query_Execution {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
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
		String query="select * from student_info";
		ResultSet result = stat.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
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
