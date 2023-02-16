package com.mycom.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.member.domain.SimpleMember;
import com.mycom.member.repository.MemberRepositoryImpl;

@Service
public class MemberServiceImpl {
	
	//자동 의존성 주입
	@Autowired
	private MemberRepositoryImpl memberRepositoryImpl;
	
	//회원등록
	public void setNewMember(SimpleMember simpleMember) {
		
		//DAO 호출
		memberRepositoryImpl.setNewMember(simpleMember);
	}
	
	
}
