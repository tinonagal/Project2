package com.zms.bean;

public class Participant {
private int pid;	
private String name;
private String email;
private String phone;
private int age;
private Integer bid;
public Participant() {
	super();
	// TODO Auto-generated constructor stub
}
public Participant(int pid, String name, String email, String phone, int age, Integer bid) {
	super();
	this.pid = pid;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.age = age;
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Integer getBid() {
	return bid;
}
public void setBid(Integer bid) {
	this.bid = bid;
}


}
