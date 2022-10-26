package com.kh.semi.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.qna.service.QnAService;
import com.kh.semi.qna.vo.QnAVo;

@WebServlet(urlPatterns = "/QnA/edit")
public class QnAEditController extends HttpServlet{
	
	//QnA 수정하기 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//디비 다녀오기
		QnAVo vo = new QnAService().selectQnAOne(no);
		
		//화면 선택
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/QnA/edit.jsp").forward(req, resp);
		
	}//doGet
	
	//QnA 수정하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		
		//데이터 뭉치기
		QnAVo vo = new QnAVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(no);
		
		//디비 다녀오기
		int result = new QnAService().edit(vo);
		
		//화면선택
		if(result == 1) {
			//성공 => QnA 상세조회 //성공 알람
			req.getSession().setAttribute("alertMsg", "QnA 수정 성공!");
			resp.sendRedirect("/omjm");
//			/QnA/detail?no=" + no
		}
	}//doPost
	
	
	
}//class



















