package kh.semi.omjm.group.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.OffGroupVo;


@WebServlet(urlPatterns = "/offgroup/list")
public class ListOffController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String groupNo = req.getParameter("gno");
		
		List<OffGroupVo> ogv = new GroupService().OffGroupListByGno(groupNo);
		
		req.setAttribute("offList", ogv);
	}
}
