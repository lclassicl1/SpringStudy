package com.mycom.member.repository;

import java.util.List;

import com.mycom.member.domain.SimpleMember;

public interface MemberRepository {
	
	//회원가입 DAO 기능 메서드
	public void setNewMember(SimpleMember simpleMember);
	
	//특정 회원 정보 조회 기능 메서드 컨트롤러에서 넘어온 id
	public SimpleMember getMemberById(String id);
	
	//전체 회원 목록 조회
	public List<SimpleMember> getAllMemberList();
	
	//회원정보 수정(이름, 비밀번호)
	public SimpleMember setMemberUpdate(String name, String pw, String id);
}
