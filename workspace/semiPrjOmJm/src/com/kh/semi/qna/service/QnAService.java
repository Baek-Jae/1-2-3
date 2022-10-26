package com.kh.semi.qna.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.common.PageVo;
import com.kh.semi.qna.dao.QnADao;
import com.kh.semi.qna.vo.QnAVo;

public class QnAService {

	private final QnADao Qao = new QnADao();
	
	//QnA 글 작성
	public int write(QnAVo vo) {
		
		Connection conn = getConnection();
		
		//QnA insert
		int result = Qao.insertQnA(conn , vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//write

	//QnA 게시글 list
	public int selectCount() {
		
		Connection conn = getConnection();
		
		int result = Qao.selectCount(conn);
		
		close(conn);
		
		return result;
		
	}//selectCount

	//게시글 목록 조회
	public List<QnAVo> selectList(PageVo pv) {
		
		Connection conn = getConnection();
		
		List<QnAVo> x = Qao.selectList(conn , pv);
		
		close(conn);
		
		return x;
		
	}//selectList

	//QnA 글 상세조회
	public QnAVo selectOne(String qnaNo) {
		
		Connection conn = getConnection();
		
		int result = Qao.increaseHit(conn , qnaNo);
		QnAVo vo = null;
		
		if(result == 1) {
			commit(conn);
			vo = Qao.selectOne(conn , qnaNo);
		}
		
		close(conn);
		
		return vo;
		
	}//selectOne

	//상세조회
	public QnAVo selectQnAOne(String no) {
		
		Connection conn = getConnection();
		QnAVo vo = null;
		
		int result = Qao.increaseHit(conn, no);
		if(result == 1) {
			commit(conn);
			vo = Qao.selectQnAOne(conn, no);
		}
		
		close(conn);
		
		return vo;
				
	}//selectQnAOne

	//공지사항 수정하기
	public int edit(QnAVo vo) {
		
		Connection conn = getConnection();
		
		int result = Qao.updateOneByNo(conn, vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//edit

	//QnA 삭제하기
	public int delete(String no) {
		
		Connection conn = getConnection();
		
		int result = Qao.delete(conn , no);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//delete

}//class

















