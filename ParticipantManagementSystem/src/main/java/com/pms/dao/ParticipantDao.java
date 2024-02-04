package com.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pms.bean.Participant;
import com.pms.resouce.DBresource;

public class ParticipantDao {

	public int createParticipant (Participant participant) {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data", "root", "Shitball$447");
			Connection con = DBresource.getDBConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into participant values(?,?,?,?,?)");
			pstmt.setInt(1,participant.getPid());
			pstmt.setString(2, participant.getName());
			pstmt.setString(3, participant.getEmail());
			pstmt.setString(4, participant.getPhone());
			pstmt.setInt(5, participant.getBid());
			
			int res = pstmt.executeUpdate();
			return res;
			
		} catch(Exception e){
			System.err.println(e.toString());
			return 0;
		}
	}
		
	public int updateParticipantName (Participant participant) {
		try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data", "root", "Shitball$447");
			    Connection con = DBresource.getDBConnection();
			    PreparedStatement pstmt = con.prepareStatement("update participant set name = ? where pid =?");
				pstmt.setInt(2,participant.getPid());
				pstmt.setString(1, participant.getName());
				
				
				int res = pstmt.executeUpdate();
				return res;
				
			} catch(Exception e){
				System.err.println(e.toString());
				return 0;
			}
		
		}
	
	public int deleteParticipant (int pid) {
		try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data", "root", "Shitball$447");
			    Connection con = DBresource.getDBConnection();
			    PreparedStatement pstmt = con.prepareStatement("delete from participant where pid =?");
				pstmt.setInt(1,pid);
				int res = pstmt.executeUpdate();
				return res;
				
			} catch(Exception e){
				System.err.println(e.toString());
				return 0;
			}
		
		}
	
	public Participant findParticipant (int pid) {
		
		       try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data", "root", "Shitball$447");
		    	Connection con = DBresource.getDBConnection();
		    	PreparedStatement pstmt = con.prepareStatement("select * from participant where pid =?");
				pstmt.setInt(1,pid);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					Participant p = new Participant();
					p.setPid(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setEmail(rs.getString(3));
					p.setPhone(rs.getString(4));
					p.setBid(rs.getInt(5));
					return p;
				}
				
		       } catch(Exception e){
				System.err.println(e.toString());
				
		       }
		       return null;
		
		}
	
	

	

public List<Participant> Batch1Participant () {
	List<Participant> batch1Participant = new ArrayList<>();
    try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data", "root", "Shitball$447");
    	Connection con = DBresource.getDBConnection();
    	PreparedStatement pstmt = con.prepareStatement("select * from participant where bid=1");
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Participant p = new Participant();
			p.setPid(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setEmail(rs.getString(3));
			p.setPhone(rs.getString(4));
			p.setBid(rs.getInt(5));
			batch1Participant.add(p);
		}
		
    } catch(Exception e){
		System.err.println(e.toString());
		
    }
    return batch1Participant;

}
public List<Participant> Batch2Participant () {
	List<Participant> batch2Participant = new ArrayList<>();
    try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data", "root", "Shitball$447");
    	Connection con = DBresource.getDBConnection();
    	PreparedStatement pstmt = con.prepareStatement("select * from participant where bid=2");
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Participant p = new Participant();
			p.setPid(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setEmail(rs.getString(3));
			p.setPhone(rs.getString(4));
			p.setBid(rs.getInt(5));
			batch2Participant.add(p);
		}
		
    } catch(Exception e){
		System.err.println(e.toString());
		
    }
    return batch2Participant;

}
public List<Participant> findallParticipant () {
	List<Participant> listofParticipant = new ArrayList<>();
    try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data", "root", "Shitball$447");
    	Connection con = DBresource.getDBConnection();
    	PreparedStatement pstmt = con.prepareStatement("select * from participant");
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Participant p = new Participant();
			p.setPid(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setEmail(rs.getString(3));
			p.setPhone(rs.getString(4));
			p.setBid(rs.getInt(5));
			listofParticipant.add(p);
		}
		
    } catch(Exception e){
		System.err.println(e.toString());
		
    }
    return listofParticipant;

}
}
