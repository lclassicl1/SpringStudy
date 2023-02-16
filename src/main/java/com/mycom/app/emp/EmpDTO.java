package com.mycom.app.emp;

//사원 관련 DTO 클래스
public class EmpDTO {
	private String empid;
	private String empname;
	private String emppassword;
	private int empsal;
	
	
	public EmpDTO() {
		
	}
	
	
	public EmpDTO(String empid, String empname, String emppassword, int empsal) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.emppassword = emppassword;
		this.empsal = empsal;
	}
	
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmppassword() {
		return emppassword;
	}
	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}
	public int getEmpsal() {
		return empsal;
	}
	public void setEmpsal(int empsal) {
		this.empsal = empsal;
	}


	@Override
	public String toString() {
		return "EmpDTO [empid=" + empid + ", empname=" + empname + ", emppassword=" + emppassword + ", empsal=" + empsal
				+ "]";
	}
	
	
}
