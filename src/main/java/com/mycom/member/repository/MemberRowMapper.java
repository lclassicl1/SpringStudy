package com.mycom.member.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mycom.member.domain.SimpleMember;

//jdbctemplate에서 쿼리의 실행 결과를 객체화 해줄때 필요한 클래스
public class MemberRowMapper implements RowMapper<SimpleMember>{

	@Override
	public SimpleMember mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleMember simpleMember = new SimpleMember();
			simpleMember.setId(rs.getString("id"));
			simpleMember.setPw(rs.getString("pw"));
			simpleMember.setName(rs.getString("name"));
			simpleMember.setGender(rs.getString("gender"));
			simpleMember.setRegdate(rs.getString("regdate"));
		return simpleMember;
	}

}
