package com.kh.semi.member.data.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.member.service.MemberService;
import com.kh.semi.password.PasswordVo;

@WebServlet(urlPatterns = "/member/selectqabyid")
public class qaselectedByIdController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=UTF-8");

		String id = req.getParameter("memberId");
		
		PasswordVo passwordVo = new MemberService().selectPQById(id);
	
		Gson gson = new Gson();
		String str = gson.toJson(passwordVo);
		
		resp.getWriter().write(str);
		
	}
	

}
