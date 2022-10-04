package com.jdbc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class JdbcDao {

	public static void main(String[] args) {
//		StudentDao dao = new StudentDao();
//		Student s1 = dao.getStudent(12);
//		System.out.println(s1.sname);

		StudentDao s2 = new Student();
		s2.rollno = 12;
		s2.sname = "Yvvone";
		dao.connect();
		dao.addStudent(s2);

	}

	class StudentDao {
		Connection con = null;

		public void connect() {
			try {
				String url = "jdbc:mysql://localhost:3306/jdbcdaolearning";
				String uname = "root";
				String pass = "root";

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, uname, pass);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		public Student getStudent(int rollno) {
			try {
				String url = "jdbc:mysql://localhost:3306/jdbcdaolearning";
				String uname = "root";
				String pass = "root";
				String query = "Select name from daotable where rollno=" + rollno;
				Student s = new Student();
				s.rollno = rollno;

				Statement st = con.createStatement();
				ResultSet rs = st.excuteQuery(query);
				rs.next();
				String name = rs.getString("1");
				s.name = name;
				return s;
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
	}

	public void addStudent(Student s) {
		String query = "insert into daotable vales (?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, s.rollno);
			pst.setString(2, s.name);
			pst.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	class Student {
		int rollno;
		String name;
	}

}
