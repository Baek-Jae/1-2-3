package kh.semi.omjm.group.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.OffMemberVo;

@WebServlet(urlPatterns = "/offgroup/member/list")
public class ListOffMemberController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String offGroupNo = req.getParameter("offNo");
		
		List<OffMemberVo> omvArr = new GroupService().selectOffMemeberByOno(offGroupNo);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(omvArr);
		
		resp.getWriter().write(result);
	}

}
