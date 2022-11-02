package com.kh.semi.reQnA.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.qna.vo.TotalQnAVo;
import com.kh.semi.reQnA.service.ReQnAService;

@WebServlet(urlPatterns = "/reQnA/detail")
@MultipartConfig
public class ReQnADetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//디비 다녀오기
		TotalQnAVo vo = new ReQnAService().selectQnAOne(no);
		
		//화면선택
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/reQnA/detail.jsp").forward(req, resp);
		
	}//doGet
}
