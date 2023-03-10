package com.mycom.member.domain;

public class SimpleMember {
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String regdate;
	
	public SimpleMember() {};
	
	public SimpleMember(String id, String pw, String name, String gender, String regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.regdate = regdate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "SimpleMember [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", regdate="
				+ regdate + "]";
	}
	
	
	
	
}
