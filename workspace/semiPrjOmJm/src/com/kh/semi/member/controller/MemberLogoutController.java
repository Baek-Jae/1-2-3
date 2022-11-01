package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.vo.MemberVo;


@WebServlet(urlPatterns = "/member/logout")
public class MemberLogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		if(loginMember != null) {
			
			//세션 만료
			req.getSession().invalidate();
			resp.sendRedirect("/omjm");
		}else {
			req.setAttribute("alertMsg", "로그인 하신 후 이용해주세요.");
			req.getRequestDispatcher("/").forward(req, resp);
		}
		
		
	}
}
