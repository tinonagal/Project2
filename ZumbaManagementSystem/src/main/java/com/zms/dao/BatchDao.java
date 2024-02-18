package com.zms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zms.bean.Batch;
import com.zms.bean.Participant;
import com.zms.resource.DbResource;

public class BatchDao {

	public int storeBatch(Batch bat) {
		try {
			Connection con =DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into batch values(?,?,?)");
			pstmt.setInt(1, bat.getBid());
			pstmt.setString(2, bat.getBtype());
			pstmt.setString(3, bat.getBtime());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public int updateBatch(Batch bat) {
		try {
			Connection con =DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("update batch set btime = ? where bid = ?");
			pstmt.setInt(2, bat.getBid());
			pstmt.setString(1, bat.getBtime());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public int deleteBatch(int bid) {
		try {
			Connection con =DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from batch where bid = ?");
			pstmt.setInt(1, bid);
			return pstmt.executeUpdate();
		}catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public List<Batch> showBatch() {
		List<Batch> listofBat = new ArrayList<>();
		try {
			Connection con =DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from batch");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Batch bat = new Batch();
				bat.setBid(rs.getInt(1));
				bat.setBtype(rs.getString(2));
				bat.setBtime(rs.getString(3));
				listofBat.add(bat);
			}
		}catch (Exception e) {
			System.err.println(e);
		}
		return listofBat;
	}
}
