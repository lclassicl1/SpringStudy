package com.mycom.app.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mycom.app.emp.EmpDTO;
import com.mycom.app.emp.repository.EmpDAOImpl;

//service 역활을 하는 클래스
@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDAOImpl empDAO;

	@Override
	public EmpDTO getEmpDetaile(String id) {
		return empDAO.getEmpDetail(id);
	}

	@Override
	public List<String> getEmpName() {
		return empDAO.getEmpName();
	}

	@Override
	public List<EmpDTO> getEmpList() {
		return empDAO.getEmpList();
	}
	
	
}
