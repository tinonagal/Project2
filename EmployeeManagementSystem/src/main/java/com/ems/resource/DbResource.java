package com.ems.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbResource {
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db_info","root","Shitball$447");
		}catch (Exception e){
			System.out.println("Db connection error"+e);
			
		}
	}
	public static Connection getDbConnection() {
		try {
			return con;
		}catch (Exception e) {
			System.err.println("While getting connection "+e);
			return null;
		}
	}
	public static void close() {
		try {
			con.close();;
		}catch (Exception e) {
			System.err.println("Close connection error "+e);
		}
	}
	
}

