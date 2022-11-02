package com.kh.semi.temp.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.temp.dao.TempDao;
import com.kh.semi.temp.vo.TempVo;

public class TempService {

	//private final TempDao dao = new TempDao();

	//Temp온도 수정
	public MemberVo edit(MemberVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new TempDao().updateOneByNo(conn,vo);
		
		MemberVo updatedTemp = null;
		if(result == 1) {
			JDBCTemplate.commit(conn);
			updatedTemp = new TempDao().selectOne(conn,vo);
			return updatedTemp;
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return updatedTemp;
		
		
	}

	public int ppupp(String no) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new TempDao().ppupp(conn,no);
		
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public List<MemberVo> tempMemberList() {
		
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> tempList = TempDao.tempMemberList(conn);
		
		JDBCTemplate.close(conn);
		
		return tempList;
		
	}

	public List<MemberVo> ppUpMember() {
		
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> ppMember = TempDao.ppUpMember(conn);
		
		JDBCTemplate.close(conn);
		
		return ppMember;
		
	}
	
	
	/*
	 * public List<TempVo> selectTempList() {
	 * 
	 * Connection conn = JDBCTemplate.getConnection();
	 * 
	 * List<TempVo> templist = new TempDao().selectTempList(conn);
	 * 
	 * JDBCTemplate.close(conn);
	 * 
	 * return templist; }
	 */


//	public int change(MemberVo vo) {
//		
//		Connection conn = JDBCTemplate.getConnection();
//		
//		int result = dao.changeTemp(vo);
//		
//		int result2 = -1;
//		
//		if(MemberVo != null) {
//			result2 = dao.insertMember(conn, memberVo);	
//		}
		
		
		
		
		
	//}

}
