package com.kh.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.member.vo.MemberVo;

public class AdminDao {

	public int quit(Connection conn, String no) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET SUP = 'X' WHERE NO =?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	
	//제제 상세조회
	public AdminVo selectOne(Connection conn, String lno) {
		
		String sql = "SELECT B.NO , B.CONTENT , B.HIT , B.STATUS , M.NICK AS WRITER , FROM BOARD B JOIN MEMBER M WHERE B.NO = ? AND M.SUP = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminVo vo = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, lno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String content = rs.getString("CONTENT");
				String hit = rs.getString("HIT");
				//String sup = rs.getString("SUP");
				String writer = rs.getString("WRITER");
				String status = rs.getString("STATUS");
				
				vo = new AdminVo();
				vo.setNo(no);
				vo.setContent(content);
				vo.setHit(hit);
				vo.setWriter(writer);
				vo.setStatus(status);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		
		return vo;
		
		
	}


	public int increaseHit(Connection conn, String lno) {
		
		
		return 0;
		
	}




}
