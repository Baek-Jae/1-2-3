package com.kh.semi.member.service;



import java.sql.Connection;

import static com.kh.semi.common.JDBCTemplate.*;
import com.kh.semi.member.dao.MemberDao;
import com.kh.semi.member.vo.MemberVo;



public class MemberService {
	
private final MemberDao dao = new MemberDao();
	
	
	//회원가입 
	public int join(MemberVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.join(conn, vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//로그인
	public MemberVo login(MemberVo vo) {
		
		Connection conn = getConnection();
		
		MemberVo loginMember = dao.login(conn, vo);
		
		close(conn);
		
		return loginMember;
	}
	
	
	//회원정보 수정하기
	public MemberVo editProfile(MemberVo vo) {
		
		Connection conn = getConnection();
		//회원정보 넣기
		int  result = new MemberDao().editProfileById(conn, vo);
		
		MemberVo loginMember = null;
		
		if(result ==1) {
			commit(conn);
			//새로운 회원정보꺼내기 
			loginMember = new MemberDao().login(conn, vo);
		}else {
			rollback(conn);
		}
		close(conn);
		return loginMember;
	}
}
