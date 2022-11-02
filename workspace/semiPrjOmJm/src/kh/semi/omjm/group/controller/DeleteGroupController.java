package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.omjm.group.service.GroupService;

@WebServlet(urlPatterns = "/group/deleteGroup")
public class DeleteGroupController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String groupNo = req.getParameter("groupNo");
		
		int delteGroup = new GroupService().deleteGroupByGno(groupNo);
		
		req.setAttribute("alertMsg", "모임이 삭제되었습니다.");
		req.getRequestDispatcher("/").forward(req, resp);
	}
}
