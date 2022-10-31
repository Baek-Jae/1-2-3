package com.kh.semi.board.service;

import java.sql.Connection;

import com.kh.semi.board.dao.BoardDao;
import com.kh.semi.board.vo.AttachmentVo;
import com.kh.semi.board.vo.BoardVo;
import static com.kh.semi.common.JDBCTemplate.*;

public class BoardService {

	private final BoardDao dao = new BoardDao();
	
	//게시글 작성
	public int write(BoardVo vo, AttachmentVo attachmentVo) {
		
		Connection conn = getConnection();
		
		//게시글 insert
		int result = dao.insertBoard(conn , vo);
		
		//첨부파일 insert
		int result2 = 1;
		if(attachmentVo != null) {
			result2 = dao.insertAttachment(conn , attachmentVo);
		}
		if(result * result2 == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result * result2;
	}//write

	//목록조회(페이징)
	public int selectCount() {
		
		Connection conn = getConnection();
		
		int result = dao.selectCount(conn);
		
		close(conn);
		
		return result;
		
	}//selectCount

}//class






















