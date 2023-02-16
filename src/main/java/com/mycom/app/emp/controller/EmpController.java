package com.mycom.app.emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.app.emp.EmpDTO;
import com.mycom.app.emp.service.EmpService;
import com.mycom.app.emp.service.EmpServiceImpl;

import jdk.nashorn.internal.objects.annotations.Getter;

//사원관련 컨트롤러 클래스임을 나타내주는 어노테이션
@Controller
@RequestMapping(value="emp") //클래스 level의 @RequestMapping
public class EmpController {
	
	//객체 빈 이용(자동주입)
	@Autowired
	private EmpServiceImpl eService;
	
	
	//요청메서드 @requestMapping 선언(사원상세보기)
	@RequestMapping(value="empDetail.do") //메소드 level의 @RequestMapping
	public String getEmpDetail(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("empId");
		
		
		EmpDTO empDTO = eService.getEmpDetaile(id);
		
		model.addAttribute("empList", empDTO);
		
		return "emp/empDetail";
	}
	
	@RequestMapping(value="empNameList", method=RequestMethod.GET)
	public String getEmpNameList(Model model) {
		
		List<String> nameList = eService.getEmpName();
		model.addAttribute("nameList",nameList);
		
		return "emp/empNameList";
	}
	
	@RequestMapping("empList")
	public String getEmpList(Model model) {
		List<EmpDTO> empList = eService.getEmpList();
		model.addAttribute("empList", empList);
		return "emp/empList";
	}
	

	
}
