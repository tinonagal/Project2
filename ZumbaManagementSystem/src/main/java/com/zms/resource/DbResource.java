package com.zms.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbResource {
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_app","root","Shitball$447");
		}catch (Exception e) {
			System.out.println("Db Connection error "+e);
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
		con.close();
	}catch (Exception e) {
		System.err.println("Close connection error "+e);
	}
  }
}
