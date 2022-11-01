package com.kh.semi.member.data.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.service.MemberService;

@WebServlet(urlPatterns = "/member/phoneDoubleCheck")
public class phoneDoubleCheckController extends HttpServlet{

	//에이잭스 아이디 중복 확인하려고 ㅇ만듬
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String phone = req.getParameter("memberPhone");
		
		System.out.println(phone);
		int result = new MemberService().doubleCheckbyPhone(phone);
		
		resp.getWriter().write(result+ "");
		
		
	}
}
