package com.valuemomentum.training.testing.jdbcdemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DataBaseMetaDataDemo {

	public static void main(String[] args) {
		Connection con;
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database...");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/mysqljdbc","root","root");
	
			DatabaseMetaData dbmd=con.getMetaData();
			System.out.println("database server name:"+dbmd.getDatabaseProductName());
			System.out.println("database server version:"+dbmd.getDatabaseProductVersion());
			System.out.println("driver server version:"+dbmd.getDriverVersion());
			System.out.println("driver server name:"+dbmd.getDriverName());
			System.out.println("max columns:"+dbmd.getMaxColumnsInTable());
	
	con.close();
		}
		catch(Exception e){ System.out.println(e);}  

	}

}
