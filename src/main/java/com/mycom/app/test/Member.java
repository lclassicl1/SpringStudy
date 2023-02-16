package com.mycom.app.test;

import org.springframework.stereotype.Repository;



public class Member {
	private int id;
	private String pw;
	private String city;
	private String sex;
	private String[] hobby;
	private String addmember;
	
	
	public Member() {
		
	}
	
	
	public Member(int id, String pw, String city, String sex) {
		this.id = id;
		this.pw = pw;
		this.city = city;
		this.sex = sex;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", city=" + city + ", sex=" + sex + ", hobby=" + hobby + "]";
	}
	
	
}
