package com.mycom.member.service;

import java.util.List;

import com.mycom.member.domain.SimpleMember;

public interface MemberService {
	
	//회원가입 메소드
	public void setNewMember(SimpleMember simpleMember);
	
	//특정 회원 정보 조회 메소드
	public SimpleMember getMemberById(String id);
	
	//전체 회원 목록 조회
	public List<SimpleMember> getAllMemberList();
	
	//회원정보수정(이름, 비밀번호)
	public SimpleMember setMemberUpdate(String name, String pw, String id);
	
	
}
