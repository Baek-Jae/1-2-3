package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.service.MemberService;

@WebServlet(urlPatterns = "/member/findid")
public class MemberFindIdController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/findId.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String phone = req.getParameter("fiphone");
		
		String fiId = new MemberService().selectIdByPhone(phone);
		
		if(fiId != "") {
			
			req.setAttribute("id", fiId);
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		}else {
			req.setAttribute("alertMsg", "아이디를 찾을 수 없습니다.");
			req.getRequestDispatcher("/WEB-INF/views/member/findId.jsp").forward(req, resp);
		}
		
	}
}
