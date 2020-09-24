package com.yedam.app.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.mapper.MemberSpringDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationcontext.xml","classpath:config/datasource-context.xml"})
public class MemberDAOClient {
	
	
	@Autowired MemberSpringDAO dao;
	
	
	@Test
	public void insertTest() {
		MemberVO memberVO = MemberVO.builder().id("ggggg").pw("1212").hobby("도서").gender("male").reason("로올오롱").build();
		dao.insert(memberVO);
//		dao.selectOne(memberVO);
//		assertEquals("ccc", memberVO.getId());  //ccc랑 멤버VO에있는 id가 같은지 확인
//		assertNotNull(memberVO); // 낫널인지 체크
	}	
	
	@Ignore
	@Test
	public void selectAllTest() {
		dao.selectAll();
	}
	
	@Ignore// 이그노어라고 해주면 제외하고 사용가능
	@Test
	public void deleteTest() {
		MemberVO memberVO = MemberVO.builder().id("ggggg").build();
		dao.delete(memberVO);
	}
	
	@Ignore
	@Test
	public void selectTest() {
		MemberVO memberVO = MemberVO.builder().id("aabb").build();
		dao.selectOne(memberVO);
		assertEquals("1111", memberVO.getPw());  //ccc랑 멤버VO에있는 id가 같은지 확인
	}
	
}
