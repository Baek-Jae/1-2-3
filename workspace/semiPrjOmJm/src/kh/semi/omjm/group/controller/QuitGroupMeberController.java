package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.vo.MemberVo;

import kh.semi.omjm.group.service.GroupService;

@WebServlet(urlPatterns = "/group/quit")
public class QuitGroupMeberController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		
		String userNo = loginMember.getNo();
		
		int quitGroup = new GroupService().quitGroupByNo(userNo);
		
		req.setAttribute("quitGroup", quitGroup);
		
	}
}
