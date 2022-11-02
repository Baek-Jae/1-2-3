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

@WebServlet(urlPatterns = "/offgroup/comment/write")
public class WriteCommentOffGroupController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8;");
		
		String offNo = req.getParameter("offNo");
		String gmemberNick = req.getParameter("gmemberNick");
		String content = req.getParameter("content");
		
		String gmemberNo = new GroupService().selectGmemberNoByNick(gmemberNick);
		
		OffCommentVo ocv = new OffCommentVo();
		
		ocv.setOffNo(offNo);
		ocv.setGmemberNo(gmemberNo);
		ocv.setContent(content);
		
		
		int myComment = new GroupService().insertOffComment(ocv);
		if(myComment == 1) {
			OffCommentVo lastInsertComment = new GroupService().selectMyCommentByNo(ocv);
			
			Gson gson = new Gson();
			
			String result = gson.toJson(lastInsertComment);
			
			resp.getWriter().write(result);
		}
	}
}
