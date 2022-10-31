package com.kh.semi.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.semi.board.vo.AttachmentVo;
import com.kh.semi.board.vo.BoardVo;
import static com.kh.semi.common.JDBCTemplate.*;

public class BoardDao {

	public int insertBoard(Connection conn, BoardVo vo) {
		
		String sql = "INSERT INTO BOARD ( NO ,TYPE ,CATEGORY ,TITLE ,CONTENT ,WRITER ) VALUES ( SEQ_BOARD_NO.NEXTVAL , 1 , ? , ? , ? , ? )";
		
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
			close(pstmt);
		}
		
		return result;
		
	}//insertBoard

	public int insertAttachment(Connection conn, AttachmentVo attachmentVo) {
		
		String sql = "INSERT INTO ATTACHMENT ( NO ,BOARD_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , SEQ_BOARD_NO.CURRVAL , ? , ? , ? )";
		
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
			close(pstmt);
		}
		
		return result;
		
	}//insertAttachment
	
	//목록조회(페이징)
	public int selectCount(Connection conn) {
		
		String sql = "SELECT COUNT(*) AS CNT FROM BOARD WHERE DELETE_YN = 'O'";
		
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





















