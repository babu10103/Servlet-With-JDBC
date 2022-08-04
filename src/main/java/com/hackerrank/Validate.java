package com.hackerrank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Validate {
	
	private static String query = "select password from Users where username = ";
	
	public static boolean checkUser(String user,String pass) throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/Users";
		String username = "root";
		String password = "root123";
		String res = "";
		Connection connection = null;
		Statement statement = null;
		
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 connection  = DriverManager.getConnection(url, username, password);
			 statement = connection.createStatement();
			 
			 String q= query+ "\"" + user +"\";"; 
			 
			 ResultSet rs = statement.executeQuery(q);
			 
			 rs.next();			 
			 res = rs.getString(1);
		 } catch(SQLException se) {
			 se.printStackTrace();
		 }
		return pass.equals(res);
	}

}
