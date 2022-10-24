package kh.semi.omjm.group.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.vo.MemberVo;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.GroupMemberVo;
import kh.semi.omjm.group.vo.GroupVo;

@WebServlet(urlPatterns = "/group/exclude")
public class ExcludeGroupMemberController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GroupMemberVo gmv = (GroupMemberVo)req.getAttribute("groupMemberList");
		String groupMemberNo = gmv.getNo();
		
		int excludeGroupMember = new GroupService().ExcludeGroupMember(groupMemberNo);
		
		req.setAttribute("excludeGroup", excludeGroupMember);
	}
}
