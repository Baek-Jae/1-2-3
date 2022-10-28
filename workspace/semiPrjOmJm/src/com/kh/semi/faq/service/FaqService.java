package com.kh.semi.faq.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.faq.dao.FaqDao;
import com.kh.semi.faq.vo.FaqAttachment;
import com.kh.semi.faq.vo.FaqVo;
import com.kh.semi.notice.dao.NoticeDao;
import com.kh.semi.notice.vo.NoticeVo;

public class FaqService {

	private FaqDao Fao = new FaqDao();
	
	//FAQ 작성
	public int write(FaqVo vo, FaqAttachment attachmentVo) {
		
		//커넥션 준비
		//SQL
		//트랜잭션 , 자원반납
		
		Connection conn = getConnection();
		
		//게시글 insert
		int result = Fao.insertFaq(conn , vo);
		
		//첨부파일 insert
		int result2 = 1;
		if(attachmentVo != null) {
			result2 = Fao.insertAttachment(conn , attachmentVo);
		}
		if(result * result2 == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result * result2;
		
	}//write

	//FAQ 목록 조회
	public List<FaqVo> selectFaqList() {
		
		Connection conn = getConnection();
		
		List<FaqVo> voList = Fao.selectFaqList(conn);
		
		close(conn);
		
		return voList;
	}//selectFaqList

	//FAQ 삭제하기
	public int delete(String no) {
		
		Connection conn = getConnection();
		
		int result = Fao.delete(conn , no);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//delete

	//상세조회
	public FaqVo selectFaqOne(String no) {
		
		Connection conn = getConnection();
		FaqVo vo = null;
		
		int result = Fao.increaseHit(conn , no);
		if(result == 1) {
			commit(conn);
			vo = Fao.selectFaqOne(conn , no);
		}
		
		close(conn);
		
		return vo;
				
	}//selectFaqOne

}//class

























