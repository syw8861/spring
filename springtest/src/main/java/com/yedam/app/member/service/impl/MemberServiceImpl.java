package com.yedam.app.member.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.mapper.MemberDAO;
import com.yedam.app.member.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberDAO memberDAO;
	//@Autowired BoardDAO boardDAO; 이건 안만들어둔건데 이런식으로 여러가지의 DAO를 불러와서 
	
	@Override
	public List<MemberVO> selectAll() {
		return memberDAO.selectAll();
	}

	@Override
	public MemberVO selectOne(MemberVO memberVo) {
		return memberDAO.selectOne(memberVo);
	}

	@Override
	public int delete(MemberVO memberVo) {
		//boardDAO.delete(memberVO); 필드에 DAO하나 더 추가한거처럼 여기서 이런식으로 이거랑 밑에 retrun이랑 같이 쓸 수 있다.
		return memberDAO.delete(memberVo);
	}

	@Override
	public int update(MemberVO memberVo) {
		return memberDAO.update(memberVo);
	}

	@Override
	public int insert(MemberVO memberVo) {
		return memberDAO.insert(memberVo);
	}

	

}
