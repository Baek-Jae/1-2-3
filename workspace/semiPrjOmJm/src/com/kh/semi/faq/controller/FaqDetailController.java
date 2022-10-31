package com.kh.semi.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.faq.service.FaqService;
import com.kh.semi.faq.vo.FaqVo;

@WebServlet(urlPatterns = "/FAQ/detail")
public class FaqDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//디비 다녀오기
		FaqVo vo = new FaqService().selectFaqOne(no);
		
		//화면선택 (데이터 담아서)
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/FAQ/detail.jsp").forward(req, resp);
		
	}//doGet
	
}//class
