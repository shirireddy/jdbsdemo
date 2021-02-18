package com.valuemomentum.training.testing.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

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
			String sql = "Delete from candidates where rtrim(last_name) like\'Y%g\'"; // %any number of characters and g--ends with g
            System.out.println(" ");
            stmt=con.createStatement();
            cnt=stmt.executeUpdate(sql);
           
            if(cnt>0)
            {
                System.out.println("Record for Young is deleted");
            }
            else
            	System.out.println("RECORD NOT FOUND");
            con.close();

	}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
