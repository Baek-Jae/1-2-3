package com.kh.semi.temp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/temp/temper3")
public class CheckTempController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		  MemberVo loginMember =(MemberVo)s.getAttribute("loginMember");
		  
		  if(loginMember != null) {
			  //로그인됨
			  req.getRequestDispatcher("/Tempht/index.html").forward(req, resp);
		  }else {
			  
			  req.setAttribute("msg", "로그인 후 이용하여 주세요.");
			  req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		  } 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String follower = req.getParameter("follower");
		String ppoff = req.getParameter("ppOff");
		String nppoff = req.getParameter("nppOff");
		String manner = req.getParameter("manner");
		
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		MemberVo vo = new MemberVo();
		
		vo.setPpOff(ppoff);
		vo.setNppOff(nppoff);
		vo.setManner(manner);
		
		
		//????;
		
		
		
		
		
		
	}
}
