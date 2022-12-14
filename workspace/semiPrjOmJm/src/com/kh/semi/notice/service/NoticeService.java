package com.kh.semi.notice.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.common.PageVo;
import com.kh.semi.notice.dao.NoticeDao;
import com.kh.semi.notice.vo.NoticeAttachment;
import com.kh.semi.notice.vo.NoticeVo;

public class NoticeService {

	private NoticeDao nao = new NoticeDao();
	
	//공지사항 작성
	public int write(NoticeVo vo , NoticeAttachment attachmentVo) {
		
		//커넥션 준비
		//SQL
		//트랜잭션 , 자원반납
		
		Connection conn = getConnection();
		
		//게시글 insert
		int result = nao.insertNotice(conn , vo);
		
		//첨부파일 insert
		int result2 = 1;
		if(attachmentVo != null) {
			result2 = nao.insertAttachment(conn , attachmentVo);
		}
		if(result * result2 == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result * result2;
		
	}//write
	
	//공지사항 목록 조회
	public List<NoticeVo> selectNoticeList(PageVo pv) {
		
		Connection conn = getConnection();
		
		List<NoticeVo> voList = nao.selectNoticeList(conn , pv);
		
		close(conn);
		
		return voList;
		
	}//selectNoticeList

	//상세조회
	public NoticeVo selectNoticeOne(String no) {
		
		//커넥션 준비
		//SQL (조회수증가 , 상세조회)
		//트랜잭션 처리 , 자원반납
		
		Connection conn = getConnection();
		NoticeVo vo = null;
		
		int result = nao.increaseHit(conn , no);
		if(result == 1) {
			commit(conn);
			vo = nao.selectNoticeOne(conn , no);
		}
		
		close(conn);
		
		return vo;
		
	}//selectNoticeOne

	//공지사항 수정하기
	public int edit(NoticeVo vo) {
		// 커넥션 준비
		// SQL
		// 트랜잭션 , 자원반납
		
		Connection conn = getConnection();
				
		int result = nao.updateOneByNo(conn , vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//edit

	//공지사항 삭제하기
	public int delete(String no) {
		
		// 커넥션 준비
		// SQL
		// 트랜잭션 처리 , 자원반납
		
		Connection conn = getConnection();
		
		int result = nao.delete(conn , no);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//delete

	//목록조회(페이징)
	public int selectCount() {
		
		Connection conn = getConnection();
		
		int result = nao.selectCount(conn);
		
		close(conn);
		
		return result;
		
	}//selectCount
	
}//class





















