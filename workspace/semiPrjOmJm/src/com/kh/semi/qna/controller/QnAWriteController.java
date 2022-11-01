package com.kh.semi.qna.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.semi.common.FileUploader;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.notice.service.NoticeService;
import com.kh.semi.notice.vo.NoticeAttachment;
import com.kh.semi.qna.service.QnAService;
import com.kh.semi.qna.vo.QnAAttachment;
import com.kh.semi.qna.vo.QnAVo;

@WebServlet(urlPatterns = "/QnA/write")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 ,
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 * 5
	)
public class QnAWriteController extends HttpServlet{

	private final QnAService Qs = new QnAService();
	
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
		Part f = req.getPart("f");
		
		QnAAttachment attachmentVo = null;
		//--------------- 파일업로드 start -------------------
		
		//파일정보 디비에 저장(파일이 있을 때)
		String rootPath = req.getServletContext().getRealPath("/");	//최상단 경로
		if(f.getSubmittedFileName().length() > 0) {
			attachmentVo = FileUploader.QnAuploadFile(f , rootPath);			
		}
		
		//--------------- 파일업로드 end -------------------
		
		//데이터 뭉치기
		QnAVo vo = new QnAVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(loginMember.getNo());
		
		//디비 다녀오기
		int result = Qs.write(vo , attachmentVo);
		
		//화면선택
		if(result == 1) {
			//게시글 작성 성공 => 알람 , 게시글 목록
			s.setAttribute("alertMsg", "게시글 작성 성공!");
			resp.sendRedirect("/omjm/QnA/list?qno=1");
		}else {
			//게시글 작성 실패 => 메세지 , 에러페이지
			if(attachmentVo != null) {
				String savePath = rootPath + attachmentVo.getFilePath() + "/" + attachmentVo.getChangeName();
				new File("savePath").delete();
			}
			req.setAttribute("msg", "게시글 작성 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}//doPost
}//class


























