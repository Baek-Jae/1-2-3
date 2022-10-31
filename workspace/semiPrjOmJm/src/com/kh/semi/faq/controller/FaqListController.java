package com.kh.semi.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.faq.service.FaqService;
import com.kh.semi.faq.vo.FaqVo;
import com.kh.semi.notice.service.NoticeService;
import com.kh.semi.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/FAQ/list")
public class FaqListController extends HttpServlet{

	//FAQ 목록 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 디비 다녀오기
		List<FaqVo> voList = new FaqService().selectFaqList();
		
		// 화면선택(데이터 담아서)
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/FAQ/list.jsp").forward(req, resp);
		
	}//doGet
	
}//class
