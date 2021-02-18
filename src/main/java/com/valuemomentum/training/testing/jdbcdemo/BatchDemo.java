package com.valuemomentum.training.testing.jdbcdemo;


import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDemo {
	
	public static void main(String[] args) throws SQLException {
		Connection con;
		//ResultSet rs;
		Statement stmt;
		try {
			// register jdbd driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creatind connection object
			System.out.println("Connection to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","root");
			 stmt=con.createStatement();
			// create batch
				
				stmt.addBatch("insert into candidate_skills values(100,5)");
				stmt.addBatch("update skills set name='Ajax' where id=3");
				
				//disable auto commit
				con.setAutoCommit(false);
				try {
					stmt.executeBatch();
					con.commit();
					System.out.println("Batch is successfully executed");
				}
				catch(Exception e2) {
					try {
						con.rollback();
						System.out.println("batch is failed");
						System.out.println("exception is: "+e2);
					}
					catch(Exception e1) {
						System.out.println(e1);
					}
				}
				stmt.close();
				con.close();
				
		}
		catch(Exception e) {
			System.out.println(e);
		}
				
		
		}
		
}

	


