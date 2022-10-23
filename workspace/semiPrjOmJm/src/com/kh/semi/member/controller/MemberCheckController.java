package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.vo.MemberVo;



@WebServlet(urlPatterns = "/member/check")
public class MemberCheckController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
	
		req.getRequestDispatcher("/WEB-INF/views/member/check.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String pwd = req.getParameter("checkPwd");
		
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		
		if(pwd.equals(loginMember.getPwd())) {
			resp.sendRedirect("/omjm/member/mypage");
		}else {
			req.setAttribute("alertMsg", "비밀번호가 일치하지 않습니다.");			
			req.getRequestDispatcher("/WEB-INF/views/member/check.jsp").forward(req, resp);
		}
		
		
	}
}
