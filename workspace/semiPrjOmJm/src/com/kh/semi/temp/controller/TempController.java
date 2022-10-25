package com.kh.semi.temp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.temp.service.TempService;
import com.kh.semi.temp.vo.TempVo;

@WebServlet(urlPatterns = "/temp/temper")
@MultipartConfig(
	      // location = "/khtmp",
	      fileSizeThreshold = 1024 * 1024,
	      maxFileSize = 1024 * 1024 * 50,
	      maxRequestSize = 1024 * 1024 * 50 * 5
	      )
public class TempController extends HttpServlet{

	private final TempService ts = new TempService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.getRequestDispatcher("WEB-INF/views/temp/temper.jsp").forward(req, resp);
		
		/*
		 * if(req.getSession().getAttribute("adminLogin") == null) { // :: "" 안에 내용이 맞는지
		 * 모르겠음 req.setAttribute( "msg", "관리자 로그인후 이용해주세요."); //관리자 에러페이지 생성해야함
		 * req.getRequestDispatcher("WEB-INF/views/common/ErrorPage.jsp").forward(req,
		 * resp); return; }
		 */
	
		List<TempVo> tempList = ts.selectTempList();
		
		req.setAttribute("tempList", tempList);
		
		req.getRequestDispatcher("WEB-INF/views/temp/temper").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession hs = req.getSession();
		
		TempVo joinMember = (TempVo)hs.getAttribute("joinMember");
		PrintWriter out = resp.getWriter();
		
		
		
		//꺼내기
		String no = req.getParameter("no");
		String userNo = req.getParameter("userNo");
		String offNo = req.getParameter("offNo");
		String ppOff = req.getParameter("ppOff");
		String nppOff = req.getParameter("nppOff");
		String manner = req.getParameter("manner");
		
		joinMember.setNo(no);
		joinMember.setUserNo(userNo);
		joinMember.setPpOff(ppOff);
		joinMember.setNppOff(nppOff);
		joinMember.setManner(manner);
		
		

		ArrayList<TempVo> tempList = new ArrayList<TempVo>();
		tempList.add();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
