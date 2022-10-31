package com.kh.semi.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.qna.service.QnAService;
import com.kh.semi.qna.vo.QnAVo;

@WebServlet(urlPatterns = "/QnA/detail")
public class QnADetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//디비 다녀오기
		QnAVo vo = new QnAService().selectQnAOne(no);
		
		//화면선택
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/QnA/detail.jsp").forward(req, resp);
		
	}//doGet
	
}//class


















