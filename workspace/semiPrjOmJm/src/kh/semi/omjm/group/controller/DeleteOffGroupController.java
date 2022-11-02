package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.semi.omjm.group.service.GroupService;

@WebServlet(urlPatterns = "/delete/offgroup")
public class DeleteOffGroupController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String offNo = req.getParameter("offNo");
		
		int deleteOff = new GroupService().deleteOffGroupByNo(offNo);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(deleteOff);
		
		resp.getWriter().write(result);
	}
}
