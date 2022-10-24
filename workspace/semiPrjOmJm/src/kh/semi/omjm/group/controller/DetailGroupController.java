package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.GroupVo;

@WebServlet(urlPatterns = "/group/main")
public class DetailGroupController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String groupNo = req.getParameter("gno");
		
		GroupVo groupInfo = new GroupService().selectGroupByNo(groupNo);
		
		req.setAttribute("groupInfo", groupInfo);
		req.getRequestDispatcher("/WEB-INF/views/group/groupMain.jsp").forward(req, resp);
	}
	
	
	
}
