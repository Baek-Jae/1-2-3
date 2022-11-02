package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.service.AdminService;
import com.kh.semi.board.service.BoardService;
import com.kh.semi.member.vo.MemberVo;


@WebServlet(urlPatterns = "/admin/rest")
public class AdminRestController extends HttpServlet{

	private final AdminService as = new AdminService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		List<MemberVo> voListt = new AdminService().selectAdminList();
		
		req.setAttribute("voListt", voListt);
		
//		req.setAttribute("sup", sup);
		List<MemberVo> restMember = new AdminService().selectSup();
//		restMember.setSup("X");
		req.setAttribute("restMember", restMember);
		
		
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/admin/rest.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("jeje");
		System.out.println(no);
		
		
		HttpSession session = req.getSession();
		
		int result = new AdminService().quit(no);
		
		
//		MemberVo restMember = (MemberVo)session.getAttribute("restMember");
//		no = req.getParameter("no");
//		String sup = req.getParameter("sup");
//		String Nick = req.getParameter("nick");
//		
//		MemberVo vo = new MemberVo();
//		
//		vo.setNo(no);
//		vo.setSup(sup);
//		vo.setNick(Nick);
//		

				
		
		if(result==1) {
//			session.invalidate();
			
//			resp.sendRedirect("/omjm/");
			
			
			req.getSession().setAttribute("alertMsg", "제제 성공");
//			req.getRequestDispatcher("/WEB-INF/views/admin/rest.jsp").forward(req, resp);
			resp.sendRedirect("/omjm/admin/rest");
			
			
		}else {
			req.setAttribute("msg", "제제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		///////////////////////
		
		
//		String mno = req.getParameter("mno");
//		
//		MemberVo vo = new AdminService().selectOne(mno);
//		req.setAttribute("vo", vo);
//		
//		String no = restMember.getNo();
//		String nick = restMember.getNick();
//		String sup = restMember.getSup();
//		String no = req.getParameter("no");
//		
//		String sup = req.getParameter("sup");
//		MemberVo restMember = new MemberVo();
//		
//	
//		restMember.setSup(sup);
//		
//		req.getSession().setAttribute("restMember", restMember);

//		String sup = req.getParameter("sup");
////		String no = req.getParameter("no");
//		
//		MemberVo vo = new MemberVo();
//		vo.setSup(sup);
//		
//		MemberVo restMember = new AdminService().spp(vo);
//		
//		session.setAttribute("restMember", restMember);
//		
		
//		 restMember = (MemberVo)session.getAttribute("restMember");
//		String no = restMember.getNo();
//		String sup = restMember.getSup();
		
		
		
//		req.setAttribute("restMember", restMember);
//		req.setAttribute("sup",sup );
		
		
		
		
//		MemberVo restMember = (MemberVo)session.getAttribute("restMember");
		
//		req.setAttribute("session", session);
		
//		MemberVo restMember = new MemberVo();
		
	
		
		
//		int result = new AdminService().quit(no);
//		
//		
//		if(result==1) {
//			session.invalidate();
////			resp.sendRedirect("/omjm/");
			
		
		
		
		
		
	}
	
	
	
}
