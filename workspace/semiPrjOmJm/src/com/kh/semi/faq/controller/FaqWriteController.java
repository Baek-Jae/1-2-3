package com.kh.semi.faq.controller;

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
import com.kh.semi.faq.service.FaqService;
import com.kh.semi.faq.vo.FaqAttachment;
import com.kh.semi.faq.vo.FaqVo;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/FAQ/write")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 ,
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 * 5
	)
public class FaqWriteController extends HttpServlet{

	//FAQ 작성 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		boolean isAdmin = loginMember != null && loginMember.getId().equals("admin");
		
		if(isAdmin) {
			//관리자 일 때, 포워딩
			req.getRequestDispatcher("/WEB-INF/views/FAQ/write.jsp").forward(req, resp);
		}else {
			//관리자 아님 => 에러페이지
			req.setAttribute("msg", "권한이 없습니다.");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}//doGet
	
	//공지사항 작성 + 파일
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//세션
		HttpSession s = req.getSession();
		
		//로그인멤버
		MemberVo loginMember = (MemberVo) s.getAttribute("loginMember");
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Part f = req.getPart("f");
		
		FaqAttachment attachmentVo = null;
		//--------------- 파일업로드 start -------------------
		
		//파일정보 디비에 저장(파일이 있을 때)
		String rootPath = req.getServletContext().getRealPath("/");	//최상단 경로
		if(f.getSubmittedFileName().length() > 0) {
			attachmentVo = FileUploader.FaquploadFile(f , rootPath);			
		}
		
		//--------------- 파일업로드 end -------------------		
		
		//데이터 뭉치기
		FaqVo vo = new FaqVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(loginMember.getNo());
		
		//디비 다녀오고
		int result = new FaqService().write(vo , attachmentVo);
		
		//화면 선택
		if(result == 1) {
			//작성 성공 => 알람메세지 , 리스트 화면으로 리다이렉트
			s.setAttribute("alertMsg", "공지사항 작성 완료 !");
			resp.sendRedirect("/omjm/FAQ/list?fno=1");
		}else {
			//작성 실패 => 업로드된파일삭제 , 메세지 , 에러페이지 포워딩
			if(attachmentVo != null) {
				String savePath = rootPath + attachmentVo.getFilePath() + "/" + attachmentVo.getChangeName();
				new File("savePath").delete();
			}
			req.setAttribute("msg", "게시글 작성 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}//doPost
	
}//class