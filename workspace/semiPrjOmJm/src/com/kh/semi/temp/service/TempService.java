package com.kh.semi.temp.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.temp.dao.TempDao;
import com.kh.semi.temp.vo.TempVo;

public class TempService {

	//private final TempDao dao = new TempDao();

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
