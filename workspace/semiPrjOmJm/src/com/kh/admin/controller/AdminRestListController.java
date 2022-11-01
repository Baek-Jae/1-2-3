package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.dao.AdminVo;
import com.kh.admin.service.AdminService;
import com.kh.semi.member.vo.MemberVo;



@WebServlet(urlPatterns = "/admin/list")
public class AdminRestListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String lno = req.getParameter("lno");
		HttpSession session = req.getSession();
		
//		MemberVo vo = new AdminService().selectOne(lno);
		List<MemberVo> voList = new AdminService().selectList();
	
		
		req.setAttribute("session", session);
//		req.setAttribute("vo", vo);
		req.setAttribute("voList", voList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/admin/restlist.jsp").forward(req, resp);
		
		
		

	}
}
