package com.jdbc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import
//load and register the driver: com.
//create connection
//create a statement
//execute the query
//process the result
//close

public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		*********************************For Connecting to database via JDBC and using select query *************************************
		/*
		 * String url="jdbc:mysql://localhost:3306/schoool"; String uname="root"; String
		 * pass="root"; String query="Select name from students where name= 'Shantanu'";
		 * 
		 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
		 * DriverManager.getConnection(url,uname,pass);
		 * 
		 * Statement st =con.createStatement(); ResultSet rs =st.executeQuery(query);
		 * rs.next(); String name= rs.getString("name");
		 * 
		 * System.out.println(name); st.close(); con.close();
		 */
//		*********************************For Connecting to database via JDBC and using select query for all *************************************
		String url = "jdbc:mysql://localhost:3306/schoool";
		String uname = "root";
		String pass = "root";
		String query = "Select name from studento";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		String userdata = "";
		while (rs.next()) {
			userdata = rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getString(3);
			System.out.println(userdata);
		}
		st.close();
		con.close();

	}
}
