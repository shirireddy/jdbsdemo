package com.valuemomentum.training.testing.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CallableDemo {
	Connection con;
	CallableStatement cstmt;
	ResultSet rs;
	
	CallableDemo(){
		
	}
	void createConnection() {
		try {
					// register jdbd driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// creatind connection object
					System.out.println("Connection to database");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","root");
		}
		catch(Exception e) {
					System.out.println(e);
		}
	}
	public void getSkills(int candidateId) {
		try {
			String query="{ call get_candidate_skill(?) }";
			cstmt=con.prepareCall(query);
			cstmt.setInt(1,candidateId);
			rs=cstmt.executeQuery();
			while(rs.next()) {
				System.out.println(String.format("%s-%s",
						rs.getString("first_name")+" "
						+rs.getString("last_name"),
						rs.getString("skill")));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		CallableDemo cd1=new CallableDemo();
		cd1.createConnection();
		cd1.getSkills(133);
		

	}

}
