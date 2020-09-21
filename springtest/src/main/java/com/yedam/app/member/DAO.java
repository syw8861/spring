package com.yedam.app.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DAO {

	//전체조회
	ArrayList<MemberVO> selectAll(MemberVO memberVo);
	
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

	int getMailynCnt();

	List<HashMap<String, Object>> getGenderCnt();

}