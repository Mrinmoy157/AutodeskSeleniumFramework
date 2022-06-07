package com.crm.autodesk.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn=null;
	/**
	 * This method will establish a connection between java and database
	 */
	public void connectToDB()  {
		
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection(IPathConstants.DATABASE_URL,IPathConstants.DATABASE_USERNAME,IPathConstants.DATABASE_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method will close the database connection
	 */
	public void closeDB()  {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method will get the data from the database
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getAllData(String query) throws SQLException {
		ResultSet result=conn.createStatement().executeQuery(query);
		return result;
	}
	/**
	 * This method will return true if data is added to database
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public boolean insertData(String query) throws SQLException {
		int result=conn.createStatement().executeUpdate(query);
		boolean flag=false;
		if(result==1) {
			System.out.println("Data is added");
			flag=true;
			return flag;
		}else {
			System.out.println("Data is not added");
		}
		return flag;
	}

}
