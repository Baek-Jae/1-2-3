package com.kh.admin.service;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.dao.AdminDao;
import com.kh.admin.dao.AdminVo;
import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.member.vo.MemberVo;


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
	
//	
//	public MemberVo selectOne(String lno) {
//		
//		
//		Connection conn = JDBCTemplate.getConnection();
//		
//		int result = dao.increaseHit(conn,lno);
//		
//		MemberVo vo = null;
//		if(result ==1) {
//			JDBCTemplate.commit(conn);
//			vo = dao.selectOne(conn,lno);
//		}
//		JDBCTemplate.close(conn);
//		
//		return vo;
//		
//	}

	public List<MemberVo> selectList() {
		 
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> voList = dao.selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

//	public List<MemberVo> selectList() {
//		
//	    Connection conn = getConnection();
//		List<MemberVo> voList = dao.selectList(conn);
//		
//		close(conn);
//		
//		return voList;
//		
//	}
}


