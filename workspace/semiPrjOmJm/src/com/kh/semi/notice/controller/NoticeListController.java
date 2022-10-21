package com.kh.semi.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.notice.service.NoticeService;
import com.kh.semi.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/list")
public class NoticeListController extends HttpServlet{

	//공지사항 목록 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 꺼내기
		// 데이터 뭉치기
		
		// 디비 다녀오기
		List<NoticeVo> voList = new NoticeService().selectNoticeList();
		
		// 화면선택(데이터 담아서)
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(req, resp);
		
	}//doGet
	
}//class

























