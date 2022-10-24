package kh.semi.omjm.group.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.GroupMemberVo;
import kh.semi.omjm.group.vo.GroupVo;

@WebServlet(urlPatterns = "/group/memberlist")
public class ListGroupMemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GroupVo gv = (GroupVo)req.getAttribute("groupInfo");
		String groupNo = gv.getNo();
		
		List<GroupMemberVo> groupMemberList = new GroupService().GroupMemberByGno(groupNo);
		
		req.setAttribute("groupMemberList", groupMemberList);
	}
}
