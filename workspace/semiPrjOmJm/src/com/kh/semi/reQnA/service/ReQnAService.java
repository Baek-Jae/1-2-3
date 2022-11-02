package com.kh.semi.reQnA.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.qna.vo.QnAVo;
import com.kh.semi.reQnA.dao.ReQnADao;
import com.kh.semi.reQnA.vo.ReQnAVo;

public class ReQnAService {

	private final ReQnADao Rqd = new ReQnADao();
	
	//QnA 답글 작성
	public int write(ReQnAVo vo) {
		
		Connection conn = getConnection();
		
		//QnA 답글 insert
		int result = Rqd.insertReQnA(conn , vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//write

	//게시글 목록 조회
	public List<ReQnAVo> selectList() {
		
		Connection conn = getConnection();
		
		List<ReQnAVo> rvoList = Rqd.selectList(conn);
		
		close(conn);
		
		return rvoList;
		
	}//selectList

	//QnA 댓글 상세조회
	public ReQnAVo selectQnAOne(String no) {
		
		Connection conn = getConnection();
		ReQnAVo vo = null;
		
		System.out.println(no);
		
		int result = Rqd.increaseHit(conn, no);
		if(result == 1) {
			commit(conn);
			vo = Rqd.selectQnAOne(conn, no);
		}
		close(conn);
		return vo;
				
	}//selectQnAOne

	//QnA 답글 삭제
	public int delete(String no) {
		
		Connection conn = getConnection();
		
		int result = Rqd.delete(conn , no);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//delete

	//QnA 답글 수정하기
	public int edit(ReQnAVo vo) {
		
		Connection conn = getConnection();
		
		int result = Rqd.updateOneByNo(conn, vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//edit

}//class



















