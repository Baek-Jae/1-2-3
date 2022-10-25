package com.kh.semi.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.service.MemberService;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.password.PasswordController;
import com.kh.semi.password.PasswordVo;

@WebServlet(urlPatterns = "/member/edit")
public class MemberEditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		if(loginMember != null) {
			
			req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
		}else {
			req.setAttribute("alertMsg", "로그인 후 이용해 주세요");
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		}
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		//로그인 멤버에서 가져와도될지 아니면 화면에 있는 memberid를 받아와도될지
		
		MemberVo sessionMember = (MemberVo)s.getAttribute("loginMember");
		
		String nick = req.getParameter("mp-memberNick");
		String pwd = req.getParameter("mp-memberPwd");
		String phone = req.getParameter("mp-memberPhone");
		String pQ = req.getParameter("mp-memberPQ");
		String pA = req.getParameter("mp-memberPA");
		
		
		MemberVo vo = new MemberVo();
		vo.setId(sessionMember.getId());
		vo.setNick(nick);
		vo.setPwd(pwd);
		vo.setPhone(phone);
		vo.setPq(pQ);
		vo.setPa(pA);
		
		MemberVo editMember = new MemberService().editProfile(vo);
		//마이페이지 질문 다 가져오기
		List<PasswordVo> pwdQList = new PasswordController().getQuestion();
		req.setAttribute("pwdQList", pwdQList);
		
		if(editMember != null) {
			s.setAttribute("loginMember", editMember);
			
			req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
			
		}
		
		
	}
}
