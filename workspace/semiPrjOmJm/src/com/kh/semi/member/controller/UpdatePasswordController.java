package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.service.MemberService;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/updatepassword")
public class UpdatePasswordController extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("memberId");
		String pwd = req.getParameter("memberPwd2");
		
		
		MemberVo vo = new MemberVo(id, pwd);
		
		int result = new MemberService().updatePassword(vo);
		
		if(result ==1) {
			req.setAttribute("alertMsg", "비밀번호가 변경되었습니다. 로그인 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/omjm/member/finpwd");
		}
		
	}
	
	
	
}
