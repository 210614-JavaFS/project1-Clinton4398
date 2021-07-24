package com.revature.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil 
{
	public static Connection getConn() throws SQLException
	{
	try 
	{
		Class.forName("org.postgresql.Driver");
	}
	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	
	String url = "jdbc:postgresql://demacia.cguuce19i0ea.us-east-2.rds.amazonaws.com:5432/";
	String user = "postgres";
	String pw = "password";
	return DriverManager.getConnection(url, user, pw);
	}
}
