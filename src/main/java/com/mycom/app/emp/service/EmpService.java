package com.mycom.app.emp.service;

import java.util.List;

import com.mycom.app.emp.EmpDTO;

public interface EmpService {
	
	//사원 상세 조회
	public abstract EmpDTO getEmpDetaile(String id);
	
	//사원이름목록조회
	public abstract List<String> getEmpName();
	
	//사원목록조회
	public abstract List<EmpDTO> getEmpList();
}
