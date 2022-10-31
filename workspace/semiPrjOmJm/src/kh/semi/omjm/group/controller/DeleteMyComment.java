package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.semi.omjm.group.service.GroupService;


@WebServlet(urlPatterns = "/offgroup/comment/del")
public class DeleteMyComment extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String commentNo = req.getParameter("commentNo");
		
		int UpdateCommentDeletion = new GroupService().UpdateCommentDeletionByCno(commentNo);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(UpdateCommentDeletion);
		
		resp.getWriter().write(result);
	}
}
