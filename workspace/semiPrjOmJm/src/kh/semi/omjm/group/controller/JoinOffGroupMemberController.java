package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.member.vo.MemberVo;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.OffGroupVo;
import kh.semi.omjm.group.vo.OffMemberVo;

@WebServlet(urlPatterns = "/offgroup/join")
public class JoinOffGroupMemberController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginMemberNo = req.getParameter("loginMemberNo"); 
		String offNo = req.getParameter("offNo");
		OffMemberVo omv = new OffMemberVo();
		omv.setOffNo(offNo);
		omv.setUserNo(loginMemberNo);
		
		int joinOffGroup = new GroupService().insertOffMemberByOno(omv);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(joinOffGroup);
		
		resp.getWriter().write(result);
	}
}
