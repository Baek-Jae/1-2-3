package com.kh.semi.qna.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.common.PageVo;
import com.kh.semi.qna.dao.QnADao;
import com.kh.semi.qna.vo.QnAVo;

public class QnAService {

	private final QnADao Qao = new QnADao();
	
	//QnA 글 작성
	public int write(QnAVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//QnA insert
		int result = Qao.insertQnA(conn , vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}//write

	//QnA 게시글 list
	public int selectCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = Qao.selectCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}//selectCount

	//게시글 목록 조회
	public List<QnAVo> selectList(PageVo pv) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<QnAVo> x = Qao.selectList(conn , pv);
		
		JDBCTemplate.close(conn);
		
		return x;
		
	}//selectList

	//QnA 글 상세조회
	public QnAVo selectOne(String qnaNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = Qao.increaseHit(conn , qnaNo);
		QnAVo vo = null;
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			vo = Qao.selectOne(conn , qnaNo);
		}
		
		JDBCTemplate.close(conn);
		
		return vo;
		
	}//selectOne

}//class

















