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

import com.google.gson.Gson;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.temp.service.TempService;
import com.kh.semi.temp.vo.TempVo;

@WebServlet(urlPatterns = "/temp/temper")
@MultipartConfig(
		// location = "/khtmp",  
		fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
public class PPoffTempController extends HttpServlet {

	// private final TempService ts = new TempService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// req.getRequestDispatcher("WEB-INF/views/temp/temper.jsp").forward(req, resp);

		
//		  if(req.getSession().getAttribute("adminLogin") == null) { // :: "" 안에 내용이 맞는지모르겠음
//		   req.setAttribute( "msg", "관리자 로그인후 이용해주세요."); //관리자 에러페이지 생성해야함
//		  req.getRequestDispatcher("WEB-INF/views/common/ErrorPage.jsp").forward(req,
//		  resp); return; }
		 
		  HttpSession s = req.getSession();
		  MemberVo loginMember =(MemberVo)s.getAttribute("loginMember");
		  
		  if(loginMember != null) {
			  //로그인됨
			  req.getRequestDispatcher("/WEB-INF/views/temp/temper.jsp").forward(req, resp);
		  }else {
			  
			  req.setAttribute("msg", "로그인 후 이용하여 주세요.");
			  req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		  } 
		//List<TempVo> tempList = ts.selectTempList();
		  
		//req.setAttribute("tempList", tempList);

		//req.getRequestDispatcher("/WEB-INF/views/temp/temper.jsp").forward(req, resp);

		  
		  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//HttpSession hs = req.getSession();

		//MemberVo joinMember = (MemberVo) hs.getAttribute("joinMember");
		//PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession();
		
		// 꺼내기
		
		String ppOff = req.getParameter("ppOff");
		//String nppOff = req.getParameter("nppOff");
		String manner = req.getParameter("manner");

		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		// joinMember.setNo(no);
		// joinMember.setPpOff(ppOff);
		// joinMember.setNppOff(nppOff);
		// joinMember.setManner(manner);

		MemberVo vo = new MemberVo();
		vo.setNo(no);
		vo.setPpOff(ppOff);
		//vo.setNppOff(nppOff);
		vo.setManner(manner);

		MemberVo updatedMember = new TempService().edit(vo);

//		Gson gson = new Gson();
//		
//		String result = gson.toJson(no);
//		
//		resp.getWriter().write(result);
	

		
		
		
//		//화면선택
//		if(updatedMember != null) {
//			req.getSession().setAttribute("alertMsg", "온도 변경완료");
//			req.getSession().setAttribute("loginMember", updatedMember);
//			resp.sendRedirect("/omjm");
//		}else {
//			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
//		}
		
		
		
		
		//int result = ts.change(vo);

		// ArrayList<MemberVo> tempList = new ArrayList<MemberVo>();
		// tempList.add();

	}
}
