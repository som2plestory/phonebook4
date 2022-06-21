package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;


@Service
public class PhoneService {

	//필드
	@Autowired
	private PhoneDao phoneDao;
	
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	
	//전화번호 리스트
	public List<PersonVo> getPersonList(){
		List<PersonVo> personList = phoneDao.getPersonList();
		
		return personList;
	}
	
	//전화번호 등록
	public void personInsert(PersonVo personVo) {
		phoneDao.personInsert(personVo);
	}
	
	
	//전화번호 등록(map을 사용하는 가상의 상황: 문법설명)
	/*
	public void personInsert2() {
		System.out.println("controller>personInsert2");
		
		//map을 만들어 사용한다*		1회성
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("name", "황일영");
		pMap.put("hp", "010-3333-3333");
		pMap.put("company", "02-3333-3333");
		
		phoneDao.personInsert2(pMap);
	}
	*/
	
	
	//전화번호 삭제
	public void personDelete(int no) {
		phoneDao.personDelete(no);
	}
	
	
	//전화번호 수정폼(정보가져오기)
	public PersonVo getPerson(int no) {
		PersonVo personVo = phoneDao.getPerson(no);
		
		return personVo;
	}
	
	
	//전화번호 수정폼2(정보가져오기)
	/*
	public Map<String, Object> getPerson2(int no){
		System.out.println("PhoneService>getPerson2()");
		Map<String, Object> pMap = phoneDao.getPerson2(no);
		
		return pMap;
	}
	*/
	
	
	//전화번호 수정
	public void personUpdate(PersonVo personVo) {
		phoneDao.personUpdate(personVo);
	}
}
