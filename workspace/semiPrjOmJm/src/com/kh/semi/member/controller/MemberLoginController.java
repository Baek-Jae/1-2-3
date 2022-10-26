package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.service.MemberService;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/login")
public class MemberLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("memberId");
		String pwd = req.getParameter("memberPwd");
		
		MemberVo vo = new MemberVo(id, pwd);
	
		
		MemberVo loginMember = new MemberService().login(vo);
		
		
		if(loginMember != null) {
			
			HttpSession s = req.getSession();
			s.setAttribute("loginMember", loginMember);
			resp.sendRedirect("/omjm");
		}else {
			req.setAttribute("alertMsg", "로그인 정보가 잘못되었습니다.");
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		}
}
}
