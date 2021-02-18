package com.valuemomentum.training.testing.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinsDemo {

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
			rs=stmt.executeQuery("SELECT c.id,c.first_name,s.name FROM candidates c INNER JOIN candidate_skills cs ON c.id=cs.candidate_id INNER JOIN skills s ON s.id=cs.skill_id ");
			
			//extract data from result set
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"		"+rs.getString(3));
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
