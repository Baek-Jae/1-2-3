package com.kh.semi.temp.controller;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.temp.service.TempService;

@WebServlet(urlPatterns = "/temp/temper2")
public class NppOffTempController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession s = req.getSession();
		  MemberVo loginMember =(MemberVo)s.getAttribute("loginMember");
		  
		  if(loginMember != null) {
			  //로그인됨
			  req.getRequestDispatcher("/WEB-INF/views/temp/temper.jsp").forward(req, resp);
		  }else {
			  
			  req.setAttribute("msg", "로그인 후 이용하여 주세요.");
			  req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		  } 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// 꺼내기
		
		//String ppOff = req.getParameter("ppOff");
		String nppOff = req.getParameter("nppOff");
		String manner = req.getParameter("manner");

		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		// joinMember.setNo(no);
		// joinMember.setPpOff(ppOff);
		// joinMember.setNppOff(nppOff);
		// joinMember.setManner(manner);

		MemberVo vo = new MemberVo();
		vo.setNo(no);
		//vo.setPpOff(ppOff);
		vo.setNppOff(nppOff);
		vo.setManner(manner);

		MemberVo updatedMember = new TempService().edit(vo);
		
		//화면선택
		if(updatedMember != null) {
			req.getSession().setAttribute("alertMsg", "온도 변경완료");
			req.getSession().setAttribute("loginMember", updatedMember);
			resp.sendRedirect("/omjm");
		}else {
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
		//int result = ts.change(vo);

		// ArrayList<MemberVo> tempList = new ArrayList<MemberVo>();
		// tempList.add();
		
		
	}
}
