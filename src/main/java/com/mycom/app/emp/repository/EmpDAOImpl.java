package com.mycom.app.emp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycom.app.emp.EmpDTO;

//DAO 역활을 하는 클래스
@Repository
public class EmpDAOImpl implements EmpDAO{
	
	//사원상세조회
	@Override
	public EmpDTO getEmpDetail(String id) {
		return new EmpDTO("faker","이상혁","1234",5000);
	}

	//사원이름목록조회
	@Override
	public List<String> getEmpName() {
		List<String> empNameList = new ArrayList<String>();
			
		empNameList.add(new String("조코딩"));
		empNameList.add(new String("조무새"));
		empNameList.add(new String("조온나"));
		empNameList.add(new String("조알이"));
		empNameList.add(new String("조더럽"));
		
		return empNameList;
	}

	//사원목록조회
	@Override
	public List<EmpDTO> getEmpList() {
		List<EmpDTO> empList = new ArrayList<EmpDTO>();
		
		empList.add(new EmpDTO("admin","관리자","1234",10000));
		empList.add(new EmpDTO("deft","데프트","1234",6000));
		empList.add(new EmpDTO("keria","케리아","1234",8000));
		empList.add(new EmpDTO("pyosik","표식","1234",4000));
		
		return empList;
	}
}
