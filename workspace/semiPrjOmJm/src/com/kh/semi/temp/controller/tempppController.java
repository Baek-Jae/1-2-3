package com.kh.semi.temp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.temp.service.TempService;

@WebServlet(urlPatterns = "/temp/temppp")
public class tempppController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		List<MemberVo> tempList = new TempService().tempMemberList();
		req.setAttribute("tempList", tempList);
		
		List<MemberVo> ppMember = new TempService().ppUpMember();
		
		req.setAttribute("ppMember", ppMember);
		
		HttpSession s = req.getSession();
		
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		if(loginMember != null) {
			req.getRequestDispatcher("/WEB-INF/views/temp/temppp.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "로그인 후 사용하여 주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("upp");
		System.out.println(no);
		
		HttpSession session = req.getSession();
		
		int result = new TempService().ppupp(no);
		
		if(result ==1) {
			req.getSession().setAttribute("alertMsg", "온도 상승!!");
			resp.sendRedirect("/omjm/temp/temppp");
		}else {
			req.setAttribute("msg", "제제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
	}
	
	
}
