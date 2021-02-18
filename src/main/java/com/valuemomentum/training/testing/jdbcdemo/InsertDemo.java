package com.valuemomentum.training.testing.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt=0;
		try {
			// register jdbd driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creatind connection object
			System.out.println("Connection to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","root");
			// exceute a query
			
			String str="INSERT INTO skills(name)"+"VALUES('MYSQL')";
			stmt=con.createStatement();
			int rowcount=stmt.executeUpdate(str);
			if(rowcount>0) {
				System.out.println("RECORD INSERTED SUCCESSFULLY");
			}
			String st1="select count(id) from skills";
			rs=stmt.executeQuery(st1);
			while(rs.next()) {
				cnt=rs.getInt(1);
				System.out.println("TOTAL NUMBER OF RECORDS IS: "+cnt);				
			}
			con.close();

	}
		catch(Exception e) {
			System.out.println(e);
		}

}
}
