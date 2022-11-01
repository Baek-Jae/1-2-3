package com.kh.semi.faq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.faq.vo.FaqAttachment;
import com.kh.semi.faq.vo.FaqVo;
import com.kh.semi.notice.vo.NoticeVo;

public class FaqDao {

	//FAQ 작성
	public int insertFaq(Connection conn, FaqVo vo) {
		
		String sql = "INSERT INTO FAQ ( NO ,TITLE ,CONTENT ,WRITER ) VALUES ( SEQ_NOTICE_NO.NEXTVAL , ? , ? , ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}//insertFaq

	//첨부파일 insert
	public int insertAttachment(Connection conn, FaqAttachment attachmentVo) {
		
		String sql = "INSERT INTO FAQ_ATTACHMENT(NO, FAQ_NO, ORIGIN_NAME, CHANGE_NAME, FILE_PATH) VALUES(SEQ_FAQ_ATTACHMENT_NO.NEXTVAL, SEQ_FAQ_NO.CURRVAL , ? , ? , ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, attachmentVo.getOriginName());
			pstmt.setString(2, attachmentVo.getChangeName());
			pstmt.setString(3, attachmentVo.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}//insertAttachment

	//FAQ 목록 조회
	public List<FaqVo> selectFaqList(Connection conn) {
		
		String sql = "SELECT F.NO , F.TITLE , F.CONTENT , F.HIT , F.ENROLL_DATE , F.ANS_CONTENT , F.DELETE_YN , M.NICK AS WRITER FROM FAQ F JOIN MEMBER M ON F.WRITER = M.NO WHERE F.DELETE_YN = 'O' ORDER BY NO DESC";
		//여기부터
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FaqVo> voList = new ArrayList<FaqVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String hit = rs.getString("HIT");
				String writer = rs.getString("WRITER");
				String enrollDate = rs.getString("ENROLL_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				String ansContent = rs.getString("ANS_CONTENT");
				
				FaqVo vo = new FaqVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setHit(hit);
				vo.setWriter(writer);
				vo.setEnrollDate(enrollDate);
				vo.setDeleteYn(deleteYn);
				vo.setAnsContent(ansContent);
				
				voList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, pstmt);
		}
		
		return voList;
		
	}//selectFaqList

	//FAQ 삭제하기
	public int delete(Connection conn, String no) {
		
		String sql = "UPDATE FAQ SET DELETE_YN = 'X' WHERE NO = ?";
		
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

	//조회수 증가
	public int increaseHit(Connection conn, String no) {
		
		String sql = "UPDATE FAQ SET HIT = HIT + 1 WHERE NO = ?";
		
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
		
	}//increaseHit

	//FAQ 상세조회
	public FaqVo selectFaqOne(Connection conn, String no) {
		
		
		String sql = "SELECT F.NO , F.TITLE , F.CONTENT , F.HIT , F.ENROLL_DATE , F.ANS_CONTENT , F.DELETE_YN , M.NICK AS WRITER FROM FAQ F JOIN MEMBER M ON F.WRITER = M.NO WHERE F.NO = ? AND F.DELETE_YN = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FaqVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String hit = rs.getString("HIT");
				String writer = rs.getString("WRITER");
				String enrollDate = rs.getString("ENROLL_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				String ansContent = rs.getString("ANS_CONTENT");
				
				vo = new FaqVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setDeleteYn(deleteYn);
				vo.setAnsContent(ansContent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt, rs);
		}
		
		return vo;	
	}

	//FAQ 수정하기
	public int updateOneByNo(Connection conn, NoticeVo vo) {
		
		String sql = "UPDATE FAQ SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";
		
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
		
	}//updateOneByNo

}//class























