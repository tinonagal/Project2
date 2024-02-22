package com.zms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zms.bean.Participant;
import com.zms.resource.DbResource;

public class ParticipantDao {

	public int storeParticipant(Participant par) {
		try {
			Connection con =DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into participant(name,email,phone,age,bid) values(?,?,?,?,?)");
			
			pstmt.setString(1, par.getName());
			pstmt.setString(2, par.getEmail());
			pstmt.setString(3, par.getPhone());
			pstmt.setInt(4, par.getAge());
			pstmt.setInt(5, par.getBid());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public int updateParticipantBatch(Participant par) {
		try {
			Connection con =DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("update participant set bid = ? where name = ?");
			pstmt.setString(2, par.getName());
			pstmt.setInt(1, par.getBid());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public int deleteParticipant(int pid) {
		try {
			Connection con =DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from participant where pid = ?");
			pstmt.setInt(1, pid);
			return pstmt.executeUpdate();
		}catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public List<Participant> showParticipants() {
		List<Participant> listofPar = new ArrayList<>();
		try {
			Connection con =DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from participant");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Participant par = new Participant();
				par.setPid(rs.getInt(1));
				par.setName(rs.getString(2));
				par.setEmail(rs.getString(3));
				par.setPhone(rs.getString(4));
				par.setAge(rs.getInt(5));
				par.setBid(rs.getInt(6));
				listofPar.add(par);
			}
		}catch (Exception e) {
			System.err.println(e);
		}
		return listofPar;
	}
	
}
