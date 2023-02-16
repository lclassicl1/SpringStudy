package com.mycom.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.member.domain.SimpleMember;


//첫화면, Main Page 클래스
@Controller
public class MainController {
	
	//메인페이지 보여주는 mapping method
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("main", "ㅎㅇ ㅂㄱㅂㄱ");
		return "member/main";
	}
}
