package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.service.AdminService;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/admin/memberSit")
public class AdminController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<MemberVo> memberList  = new AdminService().selectMember();
		
		req.setAttribute("memberList", memberList);
		
		
		
		
		List<MemberVo> memberTemp = new AdminService().selectTemp();
		
		req.setAttribute("memberTemp", memberTemp);
		
		List<MemberVo> memberGender = new AdminService().selectGender();
		
		req.setAttribute("memberGender", memberGender);
		
		List<MemberVo> voList = new AdminService().selectList();
		
		req.setAttribute("voList", voList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/admin/memberSit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//인코딩
		//req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		
		
	}
	
	
	
}
