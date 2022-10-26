package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.OffComentVo;

@WebServlet(urlPatterns = "/offgroup/comment/write")
public class WriteCommentOffGroupController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String offNo = req.getParameter("offNo");
		String memberNo = req.getParameter("memberNo");
		String content = req.getParameter("content");

		OffComentVo ocv = new OffComentVo();
		ocv.setOffNo(offNo);
		ocv.setGmemberNo(memberNo);
		ocv.setContent(content);
		
		int myComment = new GroupService().insertOffComment(ocv);
		
		OffComentVo lastInsertComment = new GroupService().selectMyCommentByNo(ocv);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(lastInsertComment);
		
		
		resp.getWriter().write(result);
	}
}
