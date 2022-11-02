package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.service.AdminService;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/admin/resup")
public class AdminRestOnController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<MemberVo> supList = new AdminService().selectAdminSupList();
		
		req.setAttribute("supList", supList);
		
		
		List<MemberVo> reviceMember = new AdminService().reviceSup();
		
		req.setAttribute("reviceMember", reviceMember);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/resup.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("jeje2");
		System.out.println(no);
		
		HttpSession session = req.getSession();
		
		int result = new AdminService().servive(no);
		
		if(result ==1) {
			req.getSession().setAttribute("alertMsg", "제제 복구성공");
			resp.sendRedirect("/omjm/admin/resup");
		}else {
			req.setAttribute("msg", "제제실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
	}
	
	
}


