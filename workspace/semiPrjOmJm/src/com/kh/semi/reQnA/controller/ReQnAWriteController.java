package com.kh.semi.reQnA.controller;

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
import com.kh.semi.reQnA.service.ReQnAService;
import com.kh.semi.reQnA.vo.ReQnAVo;

@WebServlet(urlPatterns = "/reQnA/write")
@MultipartConfig
public class ReQnAWriteController extends HttpServlet{

	private final ReQnAService Rqs = new ReQnAService();
	
	//QnA 답글 작성하기(화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//디비 다녀오기
		QnAVo vo = new QnAService().selectQnAOne(no);
		
		//화면선택
		req.setAttribute("vo",vo);
		req.getRequestDispatcher("/WEB-INF/views/reQnA/write.jsp").forward(req, resp);
		
	}//doGet
	
	//답글 작성하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//세션 가져오기
		HttpSession s = req.getSession();
		
		//로그인멤버 가져오기
		MemberVo loginMembr = (MemberVo)s.getAttribute("loginMember");
		
		//글번호 && 글제목 가져오기
//		QnAVo bno = (QnAVo)s.getAttribute("bno");
//		QnAVo title = (QnAVo)s.getAttribute("title");
//		System.out.println(title);
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//데이터 꺼내기
//		String content = req.getParameter("content");
		
		//데이터 뭉치기
		ReQnAVo vo = new ReQnAVo();	
		vo.setWriter(loginMembr.getNo());
		vo.setbNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		
		//디비 다녀오기
		int result = Rqs.write(vo);
		
//		req.getSession().setAttribute("vo", vo);
		
		//화면선택
		if(result == 1) {
			//게시글 작성 성공 => 알람 , 게시글 목록
			s.setAttribute("alertMsg", "답글 작성 성공!");
			resp.sendRedirect("/omjm/QnA/list?qno=1");
		}else {
			//게시글 작성 실패 => 메세지 , 에러페이지
			req.setAttribute("msg", "게시글 작성 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}//doPost
	
}//class



























