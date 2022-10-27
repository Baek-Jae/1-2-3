package com.kh.semi.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.common.PageVo;
import com.kh.semi.qna.service.QnAService;
import com.kh.semi.qna.vo.QnAVo;

@WebServlet(urlPatterns = "/QnA/list")
@MultipartConfig
public class QnAListController extends HttpServlet{

	//QnA 목록 조회 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//페이징처리
		int listCount;
		int currentPage;
		int pageLimit;
		int QnALimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new QnAService().selectCount();
		currentPage = Integer.parseInt(req.getParameter("qno"));
		pageLimit = 5;
		QnALimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / QnALimit);
		
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageVo pv = new PageVo();
		pv.setListCount(listCount);
		pv.setCurrentPage(currentPage);
		pv.setPageLimit(pageLimit);
		pv.setBoardLimit(QnALimit);
		pv.setMaxPage(maxPage);
		pv.setStartPage(startPage);
		pv.setEndPage(endPage);
		
		//디비다녀오기
		List<QnAVo> x = new QnAService().selectList(pv);
		
		req.setAttribute("voList", x);
		req.setAttribute("pv", pv);
		
		//화면선택
		req.getRequestDispatcher("/WEB-INF/views/QnA/list.jsp").forward(req, resp);
		
	}//doGet
	
}//class


























