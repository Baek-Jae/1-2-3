package com.kh.semi.notice.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.common.PageVo;
import com.kh.semi.notice.vo.NoticeAttachment;
import com.kh.semi.notice.vo.NoticeVo;

public class NoticeDao {

	//공지사항 작성
	public int insertNotice(Connection conn, NoticeVo vo) {
		//SQL (준비 , 완성 , 실행)
		
		String sql = "INSERT INTO NOTICE ( NO ,TITLE ,CONTENT ,WRITER ) VALUES ( SEQ_NOTICE_NO.NEXTVAL , ? , ? , ? )";
		
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
		
	}//insertNotice

	//공지사항 목록 조회
	public List<NoticeVo> selectNoticeList(Connection conn, PageVo pv) {
		//SQL
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT N.NO , N.TITLE , N.CONTENT , N.HIT , M.NICK AS WRITER, N.ENROLL_DATE , N.DELETE_YN , N.MODIFY_DATE FROM NOTICE N JOIN MEMBER M ON N.WRITER = M.NO WHERE N.DELETE_YN = 'O' ORDER BY N.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoticeVo> voList = new ArrayList<NoticeVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String deleteYN = rs.getString("DELETE_YN");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				NoticeVo vo = new NoticeVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setDeleteYN(deleteYN);
				vo.setModifyDate(modifyDate);
				
				voList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, pstmt);
		}
		
		return voList;
		
	}//selectNoticeList

	//공지사항 상세조회
	public NoticeVo selectNoticeOne(Connection conn, String no) {
		//SQL (준비 , 완성 , 실행 및 결과저장)
		
		String sql = "SELECT N.NO , N.TITLE , N.CONTENT , N.HIT , N.ENROLL_DATE , N.MODIFY_DATE , N.DELETE_YN , M.NICK AS WRITER FROM NOTICE N JOIN MEMBER M ON N.WRITER = M.NO WHERE N.NO = ? AND N.DELETE_YN = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String deleteYN = rs.getString("DELETE_YN");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				vo = new NoticeVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setDeleteYN(deleteYN);
				vo.setModifyDate(modifyDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt, rs);
		}
		
		return vo;		
		
	}//selectNoticeOne
	
	//조회수 증가
	public int increaseHit(Connection conn, String no) {
		//SQL
		
		String sql = "UPDATE NOTICE SET HIT = HIT + 1 WHERE NO = ? AND DELETE_YN='O'";
		
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

	//공지사항 수정하기
	public int updateOneByNo(Connection conn, NoticeVo vo) {
		//SQL (준비, 완성, 실행)
		
		String sql = "UPDATE NOTICE SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";
		
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

	//공지사항 삭제하기
	public int delete(Connection conn, String no) {
		//SQL (준비 , 완성 , 실행)
		
		String sql = "UPDATE NOTICE SET DELETE_YN = 'X' WHERE NO = ?";
		
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

	//첨부파일 insert
	public static int insertAttachment(Connection conn, NoticeAttachment attachmentVo) {
		
		String sql = "INSERT INTO NOTICE_ATTACHMENT(NO, NOTICE_NO, ORIGIN_NAME, CHANGE_NAME, FILE_PATH) VALUES(SEQ_NOTICE_ATTACHMENT_NO.NEXTVAL, SEQ_NOTICE_NO.CURRVAL , ? , ? , ?)";
		
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

	//목록조회(페이징)
	public int selectCount(Connection conn) {
		
		String sql = "SELECT COUNT(*) AS CNT FROM NOTICE WHERE DELETE_YN = 'O'";
		
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
			close(rs, pstmt);
		}
		
		return result;
		
	}//selectCount

}//class

























