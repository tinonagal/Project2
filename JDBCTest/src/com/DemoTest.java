package com;
import java.sql.*;
import java.util.Scanner;

public class DemoTest {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data","root","Shitball$447");
			System.out.println("connected successfully");
			Statement stmt = con.createStatement();
			System.out.println("Statement created");
			
			// insert query
			/*int result = stmt.executeUpdate("insert into participant values(3,'Max Tram','mat@gmail.com','021546465',1)");
			if(result>0) {
				System.out.println("New participant recorded");
			}*/
			
			// delete query
			
			/*
			 * int result = stmt.executeUpdate("delete from participant where pid=3");
			 * if(result>0) { System.out.println("Record deleted"); }else {
			 * System.out.println("Record not present"); }
			 */
			 
			
			// update query
			
			/*
			 * int result = stmt.executeUpdate("update participant set bid=1 where pid=2");
			 * if(result>0) { System.out.println("Record updated"); }else {
			 * System.out.println("Record not present"); }
			 */
			
			//retrieve Query
			/*
			 * ResultSet rs = stmt.executeQuery("select * from participant");
			 * while(rs.next()) { System.out.println("PID: "+rs.getInt("pid")
			 * +" Name: "+rs.getString("name")+" Email: "+rs.getString("email")+" Phone: "
			 * +rs.getString("phone")+" Batch ID: "+rs.getInt("bid")); }
			 */
			
			//creating reference of preparedStatement
			
			  Scanner sc = new Scanner(System.in); 
//			  PreparedStatement pstmt = con.prepareStatement("insert into participant values(?,?,?,?,?)");
//			  System.out.println("Enter the Participant ID"); 
//			  int pid = sc.nextInt();
//			  pstmt.setInt(1, pid); 
//			  System.out.println("Enter Name"); 
//			  String name = sc.next(); 
//			  pstmt.setString(2, name); 
//			  System.out.println("Enter Email");
//			  String email = sc.next(); 
//			  pstmt.setString(3, email);
//			  System.out.println("Enter Phone number"); 
//			  String phone = sc.next();
//			  pstmt.setString(4, phone); 
//			  System.out.println("Enter Batch Number"); 
//			  int bid = sc.nextInt(); 
//			  pstmt.setInt(5, bid);
//			  
//			  int result = pstmt.executeUpdate(); 
//			  if(result>0) {
//			  System.out.println("New record entered successfully"); 
//			  }
			 
			// Delete Query using PreparedStatement
//			  PreparedStatement pstmt = con.prepareStatement("delete from participant where pid=?");
//			  System.out.println("Enter the Participant ID to delete"); 
//			  int pid = sc.nextInt();
//			  pstmt.setInt(1, pid); 
//			  
//			  int result = pstmt.executeUpdate(); 
//			  if(result>0) {
//			  System.out.println("Record deleted successfully"); 
//			  } else {
//				  System.out.println("Record not present");
//			  }
			  
		   // Update Query using PreparedStatement
//			  PreparedStatement pstmt = con.prepareStatement("update participant set name=? , bid=? where pid=?");
//			  System.out.println("Enter the Participant ID to update"); 
//			  int pid = sc.nextInt();
//			  pstmt.setInt(3, pid);
//			  
//			  System.out.println("Enter the Participant new Name"); 
//			  String name = sc.next();
//			  pstmt.setString(1, name);
//			  
//			  System.out.println("Enter the Participant new Batch ID"); 
//			  int bid = sc.nextInt();
//			  pstmt.setInt(2, bid);
//			  
//			  int result = pstmt.executeUpdate(); 
//			  if(result>0) {
//			  System.out.println("Record updated successfully"); 
//			  } else {
//				  System.out.println("Record not present");
//			  }
			
			// Retrieve Query using PreparedStatement
			  PreparedStatement pstmt = con.prepareStatement("select * from participant where bid=?");
			  System.out.println("Please enter the Batch ID to show");
			  int bid = sc.nextInt();
			  pstmt.setInt(1,bid);
			  ResultSet rs = pstmt.executeQuery();
			  while(rs.next()) {
				  System.out.println("PID: "+rs.getInt("pid") +" Name: "+rs.getString("name")+" Email: "+rs.getString("email")+" Phone: " +rs.getString("phone")+" Batch ID: "+rs.getInt("bid"));
			  }
			
	}	catch(Exception e){
			System.out.println(e.toString());
	}
		
	}

}
