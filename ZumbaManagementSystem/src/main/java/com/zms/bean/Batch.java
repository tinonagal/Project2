package com.zms.bean;

public class Batch {
	private int bid;	
	private String btype;
	private String btime;
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Batch(int bid, String btype, String btime) {
		super();
		this.bid = bid;
		this.btype = btype;
		this.btime = btime;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	
}
