package com.kh.semi.board.service;

import java.sql.Connection;

import com.kh.semi.board.dao.BoardDao;
import com.kh.semi.board.vo.AttachmentVo;
import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.common.JDBCTemplate;

public class BoardService {

	private final BoardDao dao = new BoardDao();
	
	//게시글 작성
	public int write(BoardVo vo, AttachmentVo attachmentVo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 insert
		int result = dao.insertBoard(conn , vo);
		
		//첨부파일 insert
		int result2 = 1;
		if(attachmentVo != null) {
			result2 = dao.insertAttachment(conn , attachmentVo);
		}
		if(result * result2 == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result * result2;
	}//write

	public int selectCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}//class






















