package com.kh.semi.member.service;



import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

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
		int  result = dao.editProfileById(conn, vo);
		
		MemberVo loginMember = null;
		
		if(result ==1) {
			commit(conn);
			//새로운 회원정보꺼내기 
			loginMember = dao.login(conn, vo);
		}else {
			rollback(conn);
		}
		close(conn);
		return loginMember;
	}

	public int editPlace(MemberVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.editPlace(vo, conn);
		if(result ==1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
}
