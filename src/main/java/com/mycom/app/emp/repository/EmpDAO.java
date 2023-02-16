package com.mycom.app.emp.repository;

import java.util.List;

import com.mycom.app.emp.EmpDTO;

public interface EmpDAO {
	
	//사원 상세보기
	public abstract EmpDTO getEmpDetail(String id);
	
	//사원 이름조회
	public abstract List<String> getEmpName();
	
	
	//사원 목록조회
	public abstract List<EmpDTO> getEmpList();
}
