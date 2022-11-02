package com.kh.semi.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.common.PageVo;
import com.kh.semi.qna.vo.QnAAttachment;
import com.kh.semi.qna.vo.QnAVo;
import com.kh.semi.qna.vo.TotalQnAVo;

public class QnADao {

	//QnA 작성
	public int insertQnA(Connection conn, QnAVo vo) {
		
		//SQL
		String sql = "INSERT INTO QNA(NO, WRITER, PWD, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, ? , ? , ? , ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}//insertQnA
	
	//QnA 게시글 작성
	public int selectCount(Connection conn) {
		
		String sql = "SELECT COUNT(*) AS CNT FROM QNA WHERE DELETE_YN = 'O'";
//		SELECT SUM(CNT) FROM ( SELECT COUNT(*) AS CNT FROM QNA WHERE DELETE_YN = 'O' UNION SELECT COUNT(*) AS CNT FROM REQNA WHERE DELETE_YN = 'O' )
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("CNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, pstmt);
		}
		
		return result;
		
	}//selectCount

	//QnA 글 목록조회
	public List<TotalQnAVo> selectList(Connection conn, PageVo pv) {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT Q.NO , R.NO AS R_NO , R.B_NO , M.NICK AS WRITER , M2.NICK AS REWRITER , Q.PWD , Q.TITLE , R.TITLE AS RETITLE , Q.CONTENT , R.CONTENT AS RECONTENT , Q.ENROLL_DATE , R.ENROLL_DATE AS REENROLL_DATE , Q.DELETE_YN , R.DELETE_YN AS REDELETE_YN , Q.HIT , R.HIT AS REHIT FROM QNA Q JOIN MEMBER M ON Q.WRITER = M.NO LEFT OUTER JOIN REQNA R ON R.B_NO = Q.NO LEFT OUTER JOIN MEMBER M2 ON M2.NO = R.WRITER WHERE Q.DELETE_YN = 'O' ORDER BY Q.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TotalQnAVo> trvoList = new ArrayList<TotalQnAVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String rNo = rs.getString("R_NO");
				String bNo = rs.getString("B_NO");
				String writer = rs.getString("WRITER");
				String rewriter = rs.getString("REWRITER");
				String pwd = rs.getString("PWD");
				String title = rs.getString("TITLE");
				String retitle = rs.getString("RETITLE");
				String content = rs.getString("CONTENT");
				String recontent = rs.getString("RECONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String reenrollDate = rs.getString("REENROLL_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				String redeleteYn = rs.getString("REDELETE_YN");
				String hit = rs.getString("HIT");
				String rehit = rs.getString("REHIT");

				TotalQnAVo vo = new TotalQnAVo();
				vo.setNo(no);
				vo.setRno(rNo);
				vo.setBno(bNo);
				vo.setWriter(writer);
				vo.setRewriter(rewriter);
				vo.setPwd(pwd);
				vo.setTitle(title);
				vo.setRetitle(retitle);
				vo.setContent(content);
				vo.setRecontent(recontent);
				vo.setEnrollDate(enrollDate);
				vo.setReenrollDate(reenrollDate);
				vo.setDeleteYn(deleteYn);
				vo.setRedeleteYn(redeleteYn);
				vo.setHit(hit);
				vo.setRehit(rehit);
								
				trvoList.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, pstmt);
		}
				
		return trvoList;
		
	}//selectList

	//조회수 증가
	public int increaseHit(Connection conn, String qnaNo) {
		
		String sql = "UPDATE QNA SET HIT = HIT + 1 WHERE NO = ? AND DELETE_YN='O'";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qnaNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}//increaseHit

	public QnAVo selectOne(Connection conn, String qnaNo) {
		
		String sql = "SELECT Q.NO , Q.WRITER , Q.PWD , Q.TITLE , Q.CONTENT , Q.ENROLL_DATE , Q.DELETE_YN , Q.HIT , Q.ANS_CONTENT FROM QNA Q JOIN MEMBER M ON Q.WRITER = M.NO WHERE Q.NO = ? AND Q.DELETE_YN = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnAVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qnaNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String writer = rs.getString("WRITER");
				String pwd = rs.getString("PWD");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				String hit = rs.getString("HIT");
				String ansContent = rs.getString("ANS_CONTENT");
				
				vo = new QnAVo();
				vo.setNo(no);
				vo.setWriter(writer);
				vo.setPwd(pwd);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setDeleteYn(deleteYn);
				vo.setHit(hit);
				vo.setAnsContent(ansContent);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, pstmt);
		}
		
		return vo;
		
	}//selectOne

	//QnA 수정하기
	public int updateOneByNo(Connection conn, QnAVo vo) {
		
		String sql = "UPDATE QNA SET TITLE = ? , CONTENT = ? WHERE NO = ?";
				
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

	//QnA 상세조회
	public QnAVo selectQnAOne(Connection conn, String no) {
		
		String sql = "SELECT Q.NO , M.NICK AS WRITER , Q.PWD , Q.TITLE , Q.CONTENT , Q.ENROLL_DATE , Q.DELETE_YN , Q.HIT , Q.ANS_CONTENT FROM QNA Q JOIN MEMBER M ON Q.WRITER = M.NO WHERE Q.NO = ? AND Q.DELETE_YN = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnAVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String writer = rs.getString("WRITER");
				String pwd = rs.getString("PWD");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				String hit = rs.getString("HIT");
				String ansContent = rs.getString("ANS_CONTENT");
				
				vo = new QnAVo();
				vo.setNo(no);
				vo.setWriter(writer);
				vo.setPwd(pwd);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setDeleteYn(deleteYn);
				vo.setHit(hit);
				vo.setAnsContent(ansContent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, pstmt);
		}
		
		return vo;
		
	}//selectQnAOne

	//QnA 삭제
	public int delete(Connection conn, String no) {
		//SQL (준비 , 완성 , 실행)
		
		String sql = "UPDATE QNA SET DELETE_YN = 'X' WHERE NO = ?";
		
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

	public int insertAttachment(Connection conn, QnAAttachment attachmentVo) {
		
		String sql = "INSERT INTO QNA_ATTACHMENT(NO, QNA_NO, ORIGIN_NAME, CHANGE_NAME, FILE_PATH) VALUES(SEQ_QNA_ATTACHMENT_NO.NEXTVAL, SEQ_QNA_NO.CURRVAL , ? , ? , ?)";
		
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

}//class

















