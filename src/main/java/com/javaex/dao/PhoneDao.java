package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;

	/*
	 * @Autowired private DataSource dataSource;
	 */

	// 0. import java.sql.*;
	/*
	 * private Connection conn = null; private PreparedStatement pstmt = null;
	 * private ResultSet rs = null;
	 */

	public List<PersonVo> getPersonList() {
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		System.out.println("personList: "+personList);

		return personList;
	}

	
	// 사람 추가
	public void personInsert(PersonVo personVo) {
		System.out.println("personVo: "+personVo);
		sqlSession.insert("phonebook.personInsert", personVo);
	}

	
	// 사람 삭제
	public void personDelete(int personId) {
		System.out.println("personId: "+personId);
		sqlSession.delete("phonebook.personDelete", personId);
	}

	
	// 1명 정보 가져오기
	public PersonVo getPerson(int personId) {
		System.out.println("personId: "+personId);
		PersonVo personVo = sqlSession.selectOne("phonebook.getPerson", personId);
		
		return personVo;
	}

	// 사람 수정
	public void personUpdate(PersonVo personVo) {
		System.out.println("personVo: "+personVo);
		sqlSession.update("phonebook.personUpdate", personVo);
	}

}
