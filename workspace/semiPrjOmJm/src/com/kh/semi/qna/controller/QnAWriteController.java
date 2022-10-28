package com.kh.semi.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.qna.service.QnAService;
import com.kh.semi.qna.vo.QnAVo;

@WebServlet(urlPatterns = "/QnA/write")
@MultipartConfig
public class QnAWriteController extends HttpServlet{

	private static final QnAService Qs = new QnAService();
	
	//QnA 작성하기(화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//로그인상태 검사(로그인 안된상태면 QnA 글 작성 안되니까)
		if(req.getSession().getAttribute("loginMember") == null) {
			req.setAttribute("msg", "로그인 후 이용해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		//화면선택
		req.getRequestDispatcher("/WEB-INF/views/QnA/write.jsp").forward(req, resp);
		
	}//doGet
	
	//게시글 작성하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//세션 가져오기
		HttpSession s = req.getSession();
		
		//로그인멤버 가져오기
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//데이터 뭉치기
		QnAVo vo = new QnAVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(loginMember.getNo());
		System.out.println(vo);
		
		//디비 다녀오기
		int result = Qs.write(vo);
		
		//화면선택
		if(result == 1) {
			//게시글 작성 성공 => 알람 , 게시글 목록
			s.setAttribute("alertMsg", "게시글 작성 성공!");
			resp.sendRedirect("/omjm/QnA/list?qno=1");
		}else {
			//게시글 작성 실패 => 메세지 , 에러페이지
			req.setAttribute("msg", "게시글 작성 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}//doPost
}//class


























