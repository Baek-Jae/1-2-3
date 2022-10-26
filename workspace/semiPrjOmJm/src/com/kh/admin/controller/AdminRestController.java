package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.service.AdminService;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/admin/rest")
public class AdminRestController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/rest.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		//데이터 꺼내기
		
		MemberVo restMember = (MemberVo)session.getAttribute("restMember");
		String no = restMember.getNo();
		
		int result = new AdminService().quit(no);
		
		if(result==1) {
			session.invalidate();
			resp.sendRedirect("/omjm");
		}else {
			req.setAttribute("msg", "제제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	
}
