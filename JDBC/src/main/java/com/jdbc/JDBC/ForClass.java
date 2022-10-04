package com.jdbc.JDBC;

import java.sql.SQLException;

public class ForClass {

	public static void main(String[] args)throws ClassNotFoundException,InstantiationException,IllegalAccessException,SQLException{

		Class.forName("checker"); // load the class loading the class will call the static block
		Class.forName("checker").newInstance(); //  load the class , loading the class will call the static block + call the object
	}

}
	class checker
	{
		//static block executed once the class is loaded
		static {
			System.out.println("In Static");
		}
		// instance block
		{
			System.out.println("In Instance ");
		}
	}
