package com.valuemomentum.training.testing.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionsDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		try {
			// register jdbd driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creatind connection object
			System.out.println("Connection to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","root");
			 stmt=con.createStatement();
			 con.setAutoCommit(false);
			 try {
				int i1=stmt.executeUpdate("insert into candidate_skills values(50,3)") ;
				int i2=stmt.executeUpdate("update skills set name='Ruby' where id=1");
				int i3=stmt.executeUpdate("delete from candidates where id=7");
				con.commit();
				System.out.println("Transaction is success");
			 }
			 catch(Exception e1) {
				 try {
					 con.rollback();
					 System.out.println("Transaciton is failed");
				 }
				 catch(Exception e2) {
					 System.out.println(e2);
				 }
			 }
			 stmt.close();
			 con.close();
			 System.out.println("connection is closed");

	}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
