package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.service.MemberService;
import com.kh.semi.member.vo.MemberVo;


@WebServlet(urlPatterns = "/member/findpwd")
public class MemberFindPwdController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/findPwd.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("fpId");
		String qNo = req.getParameter("fpqNo");
		String qA = req.getParameter("fpa");
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPq(qNo);
		vo.setPa(qA);
		
		int result = new MemberService().checkPQA(vo);
		
		if(result == 1) {
			req.setAttribute("id", id);
			req.getRequestDispatcher("/WEB-INF/views/member/updatePassword.jsp").forward(req, resp);
		}else {
			req.setAttribute("alertMsg", "답이 맞지 않습니다. 다시 진행해 주세요");
			req.getRequestDispatcher("/WEB-INF/views/member/findPwd.jsp").forward(req, resp);
		}
		
	}
	
}
