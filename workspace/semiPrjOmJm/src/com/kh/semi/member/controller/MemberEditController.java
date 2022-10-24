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

@WebServlet(urlPatterns = "/member/edit")
public class MemberEditController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		
		String nick = req.getParameter("mp-memberNick");
		String pwd = req.getParameter("mp-memberPwd");
		String phone = req.getParameter("mp-memberPhone");
		
		MemberVo vo = new MemberVo();
		vo.setNick(nick);
		vo.setPwd(pwd);
		vo.setPhone(phone);
		
		MemberVo loginMember = new MemberService().editProfile(vo);
		
	}
}
