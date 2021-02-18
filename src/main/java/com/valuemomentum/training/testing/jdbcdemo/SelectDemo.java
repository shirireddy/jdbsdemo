package com.valuemomentum.training.testing.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		try {
			// register jdbd driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creatind connection object
			System.out.println("Connection to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","root");
			// exceute a query
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from candidates");
			
			//extract data from result set
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
