package com.kh.semi.reQnA.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;

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

}//class
