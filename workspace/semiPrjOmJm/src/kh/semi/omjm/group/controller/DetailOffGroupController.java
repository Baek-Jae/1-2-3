package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.OffGroupVo;

@WebServlet(urlPatterns = "/group/off")
public class DetailOffGroupController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String offNo = req.getParameter("ono");
		
		OffGroupVo offGroup = new GroupService().selectOffGroupByNo(offNo);
		
		req.setAttribute("offGroup", offGroup);
		req.getRequestDispatcher("/WEB-INF/views/group/offGroup,jsp").forward(req, resp);
		
	}
}
