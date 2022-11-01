package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.service.MemberService;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/quit")
public class MemberQuitController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		String id = loginMember.getId();
		//진짜루 탈퇴할꺼니? 물어보는 화면 만들기 
		//진짜 탈퇴할거면 비밀번호 치게하자
		
		req.getRequestDispatcher("/WEB-INF/views/member/quitmember.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("checkId");
		String pwd = req.getParameter("checkPwd");
		
		MemberVo vo = new MemberVo(id, pwd);
		
		int result = new MemberService().quitMember(vo);
		
		if(result ==1 ) {
			req.setAttribute("alertMsg", "회원탈퇴 완료되었습니다. 그동안 사용해주셔서 감사합니다.");
			req.getRequestDispatcher("/").forward(req, resp);
		}else {
			req.setAttribute("alertMsg", "비밀번호를 잘못 입력하셨습니다. 탈퇴를 원하시면 다시 입력해주세요");
			req.getRequestDispatcher("/WEB-INF/views/member/quitmember.jsp").forward(req, resp);
		}
	}
	
	
}
