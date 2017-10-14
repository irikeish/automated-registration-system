
package com.automated_student_registration.utility;

import java.sql.*;

public  class DbUtil {
	
	static Connection conn=null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";//driver name
	static final String DB_URL = "jdbc:mysql://localhost:3306/asrs";//driver address
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	public static Connection getConnect()
	{
		if(conn!=null)
			return conn;
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void closeConnection()
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}



