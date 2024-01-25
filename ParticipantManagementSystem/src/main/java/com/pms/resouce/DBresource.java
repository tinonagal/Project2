package com.pms.resouce;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBresource {
	static Connection con;
	static {
		System.out.println("This block call only once");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data", "root", "Shitball$447");
		}catch (Exception e) {
			System.err.println("Database connection issue" + e.toString());
		}
		
	}

	public static Connection getDBConnection() {
		try {
			
			return con;
		}catch (Exception e) {
			System.err.println("Getting connection" + e.toString());
		}
		return null;
	}
	public static void close() {
		try {
			con.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
