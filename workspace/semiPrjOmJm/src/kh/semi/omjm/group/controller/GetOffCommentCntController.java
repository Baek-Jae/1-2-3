package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.semi.omjm.group.service.GroupService;

@WebServlet(urlPatterns = "/offgroup/comment/cnt")
public class GetOffCommentCntController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String offNo = req.getParameter("offNo");
		
		String OffCommentCnt = new GroupService().selectOffCommentCnt(offNo);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(OffCommentCnt);
		
		resp.getWriter().write(result);
	}
}
