package com.mycom.member.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycom.member.domain.SimpleMember;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	//jdbcTemplate 사용하려면 반드시 필드에 선언먼저 해줘야한다
	private JdbcTemplate template;
    @Autowired 
    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource); 
    } //여기까지 반드시 선언해줘야하는 jdbcTemplate 선언부
    
    
    
	@Override
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
	
	
	//parameter id에 맞는 회원 정보 상세조회
	@Override
	public SimpleMember getMemberById(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select id, pw, name, gender, regdate"); 
		sql.append(" from testmember"); 
		sql.append(" where id = ?");
		
		/*queryForObject():select쿼리문 실행결과를 특정객체(도메인객체)로 매핑하여 리턴.
	     -select실행결과가 0 또는 2개이상이면 IncorrectResultSizeDataAccessException 발생
	     -select실행결과가 특정객체(도메인객체)로 매핑하려면 
	      RowMapper인터페이스를 구현한 rowMapper클래스가 있어야 한다.
	     -RowMapper인터페이스에서 제공하는 mapRow()의 내부에는
	      select실행결과로 받은 각 행(row)의 정보를  
	        어떤 특정객체(도메인객체)로 매핑할 것인지를 작성하면 된다.
	    
	    *문법
	     queryForObject(String sql)
	     queryForObject(String sql,RowMapper<T> rowMapper)
	     queryForObject(String sql,RowMapper<T> rowMapper,Object...args)
	    *파라미터 
	     String sql:실행쿼리문
	     RowMapper<T> rowMapper: 실행결과객체
	     Object...args:?에 해당하는 부분
	    *동작 : 스프링컨테이너는 sql문을 실행 -> 자동으로  RowMapper객체의 mapRow()를 호출
	    */
		
		
		MemberRowMapper mapper = new MemberRowMapper(); 
		SimpleMember simpleMember = this.template.queryForObject(sql.toString(), mapper, id);
		
		
		
		//this.template.queryForObject(sql.toString(), new SimpleMember(), );
		
		return simpleMember;
	}


	//전체회원 목록 조회
	@Override
	public List<SimpleMember> getAllMemberList() {
		StringBuffer sql = new StringBuffer();
		sql.append("select id, pw, name, gender, regdate"); 
		sql.append(" from testmember");
		
		List<SimpleMember> list = this.template.query(sql.toString(), new MemberRowMapper());
		return list;
	}



	@Override
	public SimpleMember setMemberUpdate(String name, String pw, String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("update testmember"); 
		sql.append(" set pw = ?, name=?"); 
		sql.append(" where id=?");
		
		return null;
	}
	
		
	
}
