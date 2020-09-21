package com.yedam.app.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationcontext.xml")
public class MemberDAOClient {
	
	
	@Autowired MemberDAO dao;
	
	@Test
	public void insertTest() {
		MemberVO memberVO = MemberVO.builder().id("fff").pw("1111").build();
		dao.insert(memberVO);
//		dao.selectOne(memberVO);
//		assertEquals("ccc", memberVO.getId());  //ccc랑 멤버VO에있는 id가 같은지 확인
//		assertNotNull(memberVO); // 낫널인지 체크
	}	
	
	
	//@Ignore // 이그노어라고 해주면 제외하고 사용가능
	@Test
	public void selectTest() {
		MemberVO memberVO = MemberVO.builder().id("ccc").pw("1111").build();
		dao.selectOne(memberVO);
		assertEquals("1111", memberVO.getPw());  //ccc랑 멤버VO에있는 id가 같은지 확인
	}
	
}
