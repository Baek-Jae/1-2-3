package com.kh.admin.service;

import java.sql.Connection;

import com.kh.admin.dao.AdminDao;
import com.kh.admin.dao.AdminVo;
import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.board.vo.BoardVo;

public class AdminService {

	private final AdminDao dao = new AdminDao();
	
	public int quit(String no) {
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().quit(conn,no);
		
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	//제
	public MemberVo selectOne(String lno) {
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.increaseHit(conn,lno);
		
		MemberVo vo = null;
		if(result ==1) {
			JDBCTemplate.commit(conn);
			vo = dao.selectOne(conn,lno);
		}
		JDBCTemplate.close(conn);
		
		return vo;
		
	}

}
