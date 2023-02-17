package com.mycom.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.member.domain.SimpleMember;
import com.mycom.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	//자동 의존성 주입
	@Autowired
	private MemberRepository memberRepositoryImpl;
	
	//인터페이스에서 상속받은 메서드
	@Override
	public void setNewMember(SimpleMember simpleMember) {
		//DAO 호출
		memberRepositoryImpl.setNewMember(simpleMember);
		
	}

	@Override
	public SimpleMember getMemberById(String id) {
		SimpleMember simpleMember = memberRepositoryImpl.getMemberById(id);
		
		return simpleMember;
	}

	
	@Override
	public List<SimpleMember> getAllMemberList() {
		List<SimpleMember> list = memberRepositoryImpl.getAllMemberList();
		return list;
	}
	
	//회원정보 수정
	@Override
	public SimpleMember setMemberUpdate(String name, String pw, String id) {
		memberRepositoryImpl.setMemberUpdate(name, pw, id);
		return null;
	}
	
	
	
}
