package com.mycom.member.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycom.member.domain.SimpleMember;

@Repository
public class MemberRepositoryImpl {
	//jdbcTemplate 사용하려면 반드시 필드에 선언먼저 해줘야한다
	private JdbcTemplate template;

    @Autowired 
    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource); 
    }
	
	public void setNewMember(SimpleMember simpleMember) {
		System.out.println("dao 호출");
		System.out.println(simpleMember.toString());
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into testmember(id, pw, name, gender, regdate)");
		sql.append(" values(?,?,?,?,?)");
		
		//JDBCTemplate 사용
		this.template.update(sql.toString(),simpleMember.getId(),
											simpleMember.getPw(),
											simpleMember.getName(),
											simpleMember.getGender(),
											simpleMember.getRegdate());
		
		
		
		
	}

	
}
