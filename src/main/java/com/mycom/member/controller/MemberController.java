package com.mycom.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.member.domain.SimpleMember;
import com.mycom.member.service.MemberService;

@Controller
public class MemberController {
	//자동으로 bean 생성 autowired
	@Autowired
	private MemberService memberServiceImpl;

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
	
	
	//(특정id)로 상세회원정보 조회
	@RequestMapping(value="member/Info", method=RequestMethod.GET)
	public String requestMemberByIdForm() {
		System.out.println("id조회 get");
		return "member/memberInfoForm";
	}
	
	@RequestMapping(value="member/Info", method=RequestMethod.POST)
	public String requestMemberById(@RequestParam("id") String id, Model model) {
		SimpleMember simpleMember = memberServiceImpl.getMemberById(id);
		model.addAttribute("member", simpleMember);
		return "member/memberInfo";
	}
	
	//전체 회원 목록 조회
	@RequestMapping(value="member/list", method=RequestMethod.GET)
	public ModelAndView getAllMemberList(ModelAndView mv) {
		List<SimpleMember> list = memberServiceImpl.getAllMemberList();
		mv.addObject("member", list);
		mv.setViewName("member/allMemberList");
		return mv;
	}
	
	//회원정보수정 폼
	@RequestMapping(value="member/update", method=RequestMethod.GET)
	public String memberInfoUpdateForm(@RequestParam("id") String id, Model model) {
		model.addAttribute("id",id);
		return "member/updateInfoForm";
	}
	
	//회원정보 수정 처리
	@RequestMapping(value="member/update", method=RequestMethod.POST)
	public String memberInfoUpdate(@RequestParam("name") String name, @RequestParam("pw") String pw, @RequestParam("id") String id) {
		System.out.println("넘어온값들:"+id+","+name+","+pw);
		return "member/memberInfo";
	}
	
	
	
	

	
	
}
