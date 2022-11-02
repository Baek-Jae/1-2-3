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

	public List<MemberVo> selectAdminList() {
		
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> voListt = dao.selectAdminList(conn);
		
		JDBCTemplate.close(conn);
		
		return voListt;
		
	}

	public List<MemberVo> selectSup() {
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> restMember = dao.selectSup(conn);
		
		JDBCTemplate.close(conn);
		
		return restMember;
	}

	public List<MemberVo> selectMember() {
		
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> memberList = dao.selectMember(conn);
		
		JDBCTemplate.close(conn);
		
		return memberList;
		
	}

	public List<MemberVo> selectTemp() {
		
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> memberTemp = dao.selectTemp(conn);
		
		JDBCTemplate.close(conn);
		
		return memberTemp;
		
	}

	public List<MemberVo> selectGender() {
		
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> memberGender = dao.selectGender(conn);
		
		JDBCTemplate.close(conn);
		
		return memberGender;
	}

	public List<MemberVo> selectAdminSupList() {	
		
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> supList = dao.selectAdminSupList(conn);
		
		JDBCTemplate.close(conn);
		
		return supList;
	}

	public int servive(String no) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().servive(conn,no);
		
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<MemberVo> reviceSup() {
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> reviveMember = dao.reviveSup(conn);
		
		JDBCTemplate.close(conn);
		
		return reviveMember;
		
	}

	public List<MemberVo> selectNormal() {
		
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> normalMember = dao.selectNormal(conn);
		
		JDBCTemplate.close(conn);
		
		return normalMember;
		
	}

	public List<MemberVo> selectSupMemberList() {
		
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> supMemberList = dao.selectSupMemberList(conn);
		
		JDBCTemplate.close(conn);
		
		return supMemberList;
		
	}



//	public MemberVo restt(MemberVo vo) {
//		
//		Connection conn = JDBCTemplate.getConnection();
//		MemberVo restMember = new AdminDao().supOne(conn,vo);
//		JDBCTemplate.close(conn);
//		return restMember;
//		
//	}

//	public MemberVo selectOne(String mno) {
//		
//		Connection conn = JDBCTemplate.getConnection();
//		
//		MemberVo vo = null;
//		
//		vo = dao.selectOne(conn, mno);
//		JDBCTemplate.commit(conn);
//		JDBCTemplate.close(conn);
//		
//		return vo;
//		
//	}

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


