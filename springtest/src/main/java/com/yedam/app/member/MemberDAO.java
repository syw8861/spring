package com.yedam.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dev.common.ConnectionManager;

@Component
public class MemberDAO implements DAO {
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;
	
	//싱글톤 (한번 만들어놓고 객체를 불러와서 쓰는방식) ****중요함*****
	//싱글톤= Date나 Calendar이런것들도 싱글톤으로 불러와서 쓰는 방식이다.
	static DAO instance;
	public static DAO getInstance() {
		if(instance==null) {
			instance=new MemberDAO();
		}
		return instance;
	}
	
	
	
	
	//전체조회
		@Override
		public ArrayList<MemberVO> selectAll(MemberVO memberVo) {
			ArrayList<MemberVO> list = new ArrayList<MemberVO>();
			
			rs = null;
			MemberVO rsAll = null;
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "SELECT id,pw,job,gender,reason,mailyn,hobby,regdate FROM MEMBER";
				psmt = conn.prepareStatement(sql);
				rs  = psmt.executeQuery();
				while(rs.next()) {
					rsAll = MemberVO.builder().build();
					rsAll.setId(rs.getString(1));
					rsAll.setPw(rs.getString(2));
					rsAll.setJob(rs.getString(3));
					rsAll.setGender(rs.getString(4));
					rsAll.setReason(rs.getString(5));
					rsAll.setMailyn(rs.getString(6));
					rsAll.setHobby(rs.getString(7));
					rsAll.setRegdate(rs.getString(8));
					list.add(rsAll);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(rs,psmt,conn);
			}
		return list;
		
		
		}
		//단건조회
		@Override
		public MemberVO selectOne(MemberVO memberVo) {
			MemberVO rsOne = null;
			rs = null;
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "SELECT ID, PW, JOB, GENDER, MAILYN,hobby,reason FROM MEMBER WHERE ID=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, memberVo.getId());
				rs  = psmt.executeQuery();
				while(rs.next()) {
					rsOne = MemberVO.builder().build();
					rsOne.setId(rs.getString(1));
					rsOne.setPw(rs.getString(2));
					rsOne.setJob(rs.getString(3));
					rsOne.setGender(rs.getString(4));
					rsOne.setMailyn(rs.getString(5));
					rsOne.setHobby(rs.getString(6));
					rsOne.setReason(rs.getString(7));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(rs,psmt,conn);
			}
		return rsOne;
		}
		
		//삭제
		@Override
		public int delete(MemberVO memberVo) {
			int t=0;
			try {
				
				conn = ConnectionManager.getConnnect();
				String sql = "delete member where id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, memberVo.getId());
				t = psmt.executeUpdate();
				System.out.println(t +" 건이 삭제됨");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				ConnectionManager.close(conn);
			}
			return t;
		}
		
		
		//preparedstatement사용
		//업데이트
		@Override
		public int update(MemberVO memberVo) {
			int t=0;
			try {
				
				conn = ConnectionManager.getConnnect();
				String sql = "update member set pw = ? where id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, memberVo.getPw());
				psmt.setString(2, memberVo.getId());
				t = psmt.executeUpdate();
				System.out.println(t +" 건이 처리됨");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				ConnectionManager.close(conn);
			}
			return t;
		}
		
		
		
		
		
		//statement사용
		//한건 입력
		@Override
		public int insert(MemberVO memberVo) 
		{
			int r=0;
			try {
				//1. DB연결
				conn = ConnectionManager.getConnnect();
				
				//2. sql구문 실행
				String sql = "insert into member(id, pw, job, gender, reason, mailyn, hobby, regdate) values(?,?,?,?,?,?,?, sysdate)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, memberVo.getId());
				psmt.setString(2, memberVo.getPw());
				psmt.setString(3, memberVo.getJob());
				psmt.setString(4, memberVo.getGender());
				psmt.setString(5, memberVo.getReason());
				psmt.setString(6, memberVo.getMailyn());
				psmt.setString(7, memberVo.getHobby());
				r = psmt.executeUpdate();
				
				//3. 결과 처리
				System.out.println(r+" 건이 처리됨");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//4. 연결 해제
				ConnectionManager.close(conn);
			}

			return r;
			
		}
		
		@Override
		public int getMailynCnt() {
			int cnt = 0;
			try {
				conn = ConnectionManager.getConnnect();
				String sql ="select count(id) from member where mailyn='on'";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				cnt = rs.getInt(1);
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				ConnectionManager.close(conn);
			}
			return cnt;
		}
		
		@Override
		public List<HashMap<String, Object>> getGenderCnt(){
			List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
			conn = ConnectionManager.getConnnect();
			String sql = "select gender, count(id) as cnt from member group by gender";
			try {
				psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("gender", rs.getString("gender"));
					map.put("cnt", rs.getInt("cnt"));
					list.add(map);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list; 
		}
		
}
