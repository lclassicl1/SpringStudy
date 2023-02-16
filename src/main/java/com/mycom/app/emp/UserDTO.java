package com.mycom.app.emp;

import java.util.Arrays;
import java.util.List;

public class UserDTO {
	private String name;
	private String email;
	private int age;
	private String gender;
	private String[] hobby;
	
	
	public UserDTO() {
		
	}
	
	
	public UserDTO(String name, String email, int age, String gender) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String[] getHobby() {
		return hobby;
	}


	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}


	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", age=" + age + ", gender=" + gender + ", hobby="
				+ Arrays.toString(hobby) + "]";
	}


	
	
}
