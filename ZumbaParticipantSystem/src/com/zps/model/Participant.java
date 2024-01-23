package com.zps.model;

public class Participant {

	private int pid;
	private String name;
	private String email;
	private String phone;
	private int bid;
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Participant(int pid, String name, String email, String phone, int bid) {
		super();
		this.pid = pid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.bid = bid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
}
