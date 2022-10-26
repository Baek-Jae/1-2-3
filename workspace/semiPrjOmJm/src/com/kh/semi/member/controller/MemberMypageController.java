package com.kh.semi.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.vo.MemberVo;

import kh.semi.omjm.group.controller.ListGroupController;
import kh.semi.omjm.group.vo.GroupVo;

@WebServlet(urlPatterns = "/member/mypage")
public class MemberMypageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String x = req.getParameter("x");
		
		//찜한모임 가져오기 > 세션에 이미 있잖아?  찜한 모임 목록을 가져와야지 그러면 세션에 있는 찜한 모임을 가져와야겠네
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		//찜한 모임 리스트를 보여줘야함
		//List<GroupVo> likeGList = new ListGroupController().selectLiked(loginMember);
		
		
	
		
		req.setAttribute("x", x);
		req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
	}
	
	
}
