package com.mycom.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.member.domain.SimpleMember;
import com.mycom.member.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	//자동으로 bean 생성 autowired
	@Autowired
	private MemberServiceImpl memberServiceImpl;

	//회원가입 폼을 보여주는 mapping method
	@RequestMapping(value="member/add", method=RequestMethod.GET)
	public String requestAddMemberForm(@ModelAttribute("newMember") SimpleMember simpleMember) {
		
		return "member/addMember";
	}
	//회원가입 폼에서 post로 요청이 들어오면 결과창으로 보내주는 method
	@RequestMapping(value="member/add",method=RequestMethod.POST)
	public String submitAddMember(Model model, @ModelAttribute("newMember") SimpleMember simpleMember) {
		
		memberServiceImpl.setNewMember(simpleMember);
		model.addAttribute("newMember",simpleMember);
		
		return "member/addresult";
	}
}
