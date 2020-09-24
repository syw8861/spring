package com.yedam.app.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yedam.app.member.MemberVO;

public interface MemberService {

	//전체조회
	ArrayList<MemberVO> selectAll();
	
	//단건조회
	MemberVO selectOne(MemberVO memberVo);

	//삭제
	int delete(MemberVO memberVo);

	//preparedstatement사용
	//업데이트
	int update(MemberVO memberVo);

	//statement사용
	//한건 입력
	int insert(MemberVO memberVo);


}