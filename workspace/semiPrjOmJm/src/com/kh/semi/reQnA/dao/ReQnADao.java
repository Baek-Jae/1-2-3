package com.kh.semi.reQnA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.qna.vo.QnAVo;
import com.kh.semi.reQnA.vo.ReQnAVo;

public class ReQnADao {

	//QnA 답글 작성
	public int insertReQnA(Connection conn, ReQnAVo vo) {
		
		//SQL
		String sql = "INSERT INTO REQNA(NO, WRITER, TITLE, B_NO, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getbNo());
			pstmt.setString(4, vo.getContent());
			
			System.out.println(vo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}//insertReQnA

	public List<ReQnAVo> selectList(Connection conn) {
		
		String sql = "SELECT R.NO , R.TITLE , Q.NO AS B_NO , M.NICK , R.CONTENT , R.ENROLL_DATE , R.MODIFY_DATE , R.DELETE_YN FROM REQNA R JOIN MEMBER M ON R.WRITER = M.NO JOIN QNA Q ON R.B_NO = Q.NO WHERE R.DELETE_YN = 'O' ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReQnAVo> rvoList = new ArrayList<ReQnAVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String bNo = rs.getString("B_NO");
				String nick = rs.getString("NICK");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				ReQnAVo rqv = new ReQnAVo();
				rqv.setNo(no);
				rqv.setTitle(title);
				rqv.setbNo(bNo);
				rqv.setWriter(nick);
				rqv.setContent(content);
				rqv.setEnrollDate(enrollDate);
				rqv.setModifyDate(modifyDate);
				rqv.setDeleteYn(deleteYn);
				
				rvoList.add(rqv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, pstmt);
		}
		return rvoList;
				
	}//selectList

	//조회수 증가
	public int increaseHit(Connection conn, String reqnaNo) {
		String sql = "UPDATE REQNA SET HIT = HIT + 1 WHERE NO = ? AND DELETE_YN='O'";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reqnaNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}//increaseHit

	//QnA 답글 상세조회
	public ReQnAVo selectQnAOne(Connection conn, String no) {
		String sql = "SELECT R.NO , M.NICK AS WRITER , R.TITLE , R.CONTENT , R.ENROLL_DATE , R.DELETE_YN , R.HIT FROM REQNA R LEFT OUTER JOIN MEMBER M ON R.WRITER = M.NO WHERE R.NO = ? AND R.DELETE_YN = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReQnAVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("알에스다음");
				String writer = rs.getString("WRITER");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				String hit = rs.getString("HIT");
				
				System.out.println(vo);
				vo = new ReQnAVo();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, pstmt);
		}
		
		return vo;
		
	}//selectQnAOne

	//QnA 답글 삭제
	public int delete(Connection conn, String no) {
		
		String sql = "UPDATE REQNA SET DELETE_YN = 'X' WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}//delete

	//QnA 답글 수정하기
	public int updateOneByNo(Connection conn, ReQnAVo vo) {
		
		String sql = "UPDATE REQNA SET TITLE = ? , CONTENT = ? WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}


}//class
















