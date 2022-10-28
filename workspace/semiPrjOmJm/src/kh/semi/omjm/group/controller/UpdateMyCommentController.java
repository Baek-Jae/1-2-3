package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.OffCommentVo;

@WebServlet(urlPatterns = "/offgroup/comment/update")
public class UpdateMyCommentController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String commentNo = req.getParameter("commentNo");
		String content = req.getParameter("content");
		
		OffCommentVo ofv = new OffCommentVo();
		ofv.setNo(commentNo);
		ofv.setContent(content);
		
		int updateMyComment = new GroupService().updateMyCommentByCno(ofv);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(updateMyComment);
		
		
		resp.getWriter().write(result);
	}
}
