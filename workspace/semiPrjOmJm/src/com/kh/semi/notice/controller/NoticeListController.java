package com.kh.semi.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.service.BoardService;
import com.kh.semi.common.PageVo;
import com.kh.semi.notice.service.NoticeService;
import com.kh.semi.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/list")
public class NoticeListController extends HttpServlet{

	//공지사항 목록 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//페이징처리
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new NoticeService().selectCount();
		currentPage = Integer.parseInt(req.getParameter("nno"));
		pageLimit = 5;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageVo pv = new PageVo();
		pv.setListCount(listCount);
		pv.setCurrentPage(currentPage);
		pv.setPageLimit(pageLimit);
		pv.setBoardLimit(boardLimit);
		pv.setMaxPage(maxPage);
		pv.setStartPage(startPage);
		pv.setEndPage(endPage);
		
		// 디비 다녀오기
		List<NoticeVo> voList = new NoticeService().selectNoticeList(pv);
		
		// 화면선택(데이터 담아서)
		req.setAttribute("voList", voList);
		req.getSession().setAttribute("pv", pv);
		req.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(req, resp);
		
	}//doGet
	
}//class

























