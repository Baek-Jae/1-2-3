package com.kh.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.notice.service.NoticeService;

@WebServlet(urlPatterns = "/notice/delete")
public class NoticeDeleteController extends HttpServlet{

	//공지사항 삭제하기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//디비 다녀오기
		int result = new NoticeService().delete(no);
		
		//화면선택
		if(result == 1) {
			//성공 => 알림 , 리스트 조회
			req.getSession().setAttribute("alertMsg", "공지사항 삭제 성공!");
			resp.sendRedirect("/omjm/notice/list");
		}else {
			//실패 => 메시지 , 에러페이지
			req.setAttribute("msg", "공지사항 삭제 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}//doget
	
}//class




























