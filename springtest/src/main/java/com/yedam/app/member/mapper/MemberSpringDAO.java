package com.yedam.app.member.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yedam.app.member.MemberVO;

@Component
public class MemberSpringDAO implements MemberDAO{
	final static String INSERT_MEMBER = "insert into member(id, pw, job, gender, reason, mailyn, hobby, regdate) values(?,?,?,?,?,?,?, sysdate)";
	final static String DELETE_MEMBER = "delete member where id = ?";
	final static String SELECT_MEMBER = "SELECT * FROM MEMBER WHERE ID=?";
	final static String SELECT_ALL_MEMBER = "SELECT * FROM MEMBER";
	@Autowired JdbcTemplate template;
	
	
	@Override
	public int insert(MemberVO memberVo) {
		Object[] arg = {memberVo.getId(), memberVo.getPw(), 
					    memberVo.getJob(),memberVo.getGender(),
					    memberVo.getReason(),memberVo.getMailyn(), memberVo.getHobby()};
		
		return template.update(INSERT_MEMBER ,arg);
	}
	@Override
	public MemberVO selectOne(MemberVO memberVo) {
		Object[] args = {memberVo.getId()};
		return template.queryForObject(SELECT_MEMBER, args, new MemberRowMapper());
	}
	
	@Override
	public int delete(MemberVO memberVo) {
		return template.update(DELETE_MEMBER, memberVo.getId());
	}
	
	
	@Override
	public ArrayList<MemberVO> selectAll() {
		return (ArrayList<MemberVO>)template.query(SELECT_ALL_MEMBER, new MemberRowMapper());
	}

	

	

	@Override
	public int update(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public int getMailynCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> getGenderCnt() {
		// TODO Auto-generated method stub
		return null;
	}
	
	class MemberRowMapper implements RowMapper<MemberVO>{
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO member = new MemberVO();
			member.setId(rs.getString(1));
			member.setPw(rs.getString(2));
			member.setJob(rs.getString(3));
			member.setGender(rs.getString(4));
			member.setMailyn(rs.getString(5));
			member.setReason(rs.getString(6));
			member.setHobby(rs.getString(7));
			return member;
		}//end of class mapRow
		
	}//end of class MemberRowMapper
	
}//end of class MemberSpringDAO
