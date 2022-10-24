package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.vo.MemberVo;

import kh.semi.omjm.group.service.GroupService;

@WebServlet(urlPatterns = "/group/joinMember")
public class JoinGroupMemberController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		
		String mno = loginMember.getNo();
		String gno = req.getParameter("gno");
		
		int joinGroup = new GroupService().insertGroupMember(gno, mno);

		req.setAttribute("joinGroup", joinGroup);
	}
}
