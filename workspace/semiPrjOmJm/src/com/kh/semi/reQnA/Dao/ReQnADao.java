package com.kh.semi.reQnA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.reQnA.vo.ReQnAVo;

public class ReQnADao {

	//QnA 답글 작성
	public int insertReQnA(Connection conn, ReQnAVo vo) {
		
		//SQL
		String sql = "INSERT INTO REQNA(NO, TITLE, B_NO, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, ? , ? , ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getbNo());
			pstmt.setString(3, vo.getContent());
			
			System.out.println(vo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}//insertReQnA

}//class
