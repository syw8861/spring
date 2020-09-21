package com.yedam.app.member;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberVO {

	private String id;
	private String pw;
	private String gender;
	private String job;
	private String reason;
	private String mailyn;
	private String hobby;
	private String regdate;
	
}




