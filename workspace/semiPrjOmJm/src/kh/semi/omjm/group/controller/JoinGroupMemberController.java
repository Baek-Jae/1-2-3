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

@WebServlet(urlPatterns = "/group/joinMember")
public class JoinGroupMemberController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String joinMemberNo = req.getParameter("joinMemberNo"); 
		String groupNo = req.getParameter("groupNo");
		
		int joinGroup = new GroupService().insertGroupMember(groupNo, joinMemberNo);
		Gson gson = new Gson();
		
		String result = gson.toJson(joinGroup);
		
		resp.getWriter().write(result);
	}
}
