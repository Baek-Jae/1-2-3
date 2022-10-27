package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.dao.AdminVo;
import com.kh.admin.service.AdminService;


@WebServlet(urlPatterns = "/admin/list")
public class AdminRestListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String lno = req.getParameter("lno");
		
		AdminVo vo = new AdminService().selectOne(lno);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/views/admin/list.jsp").forward(req, resp);
		
	}
}
