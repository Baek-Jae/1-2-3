package com.kh.semi.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.semi.member.service.MemberService;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.member.vo.ProfileAttachVo;
import com.kh.semi.password.PasswordController;
import com.kh.semi.password.PasswordVo;


@WebServlet(urlPatterns = "/member/join")
@MultipartConfig(
		
		fileSizeThreshold = 1024* 1024
		, maxFileSize = 1024 * 1024 * 50
		, maxRequestSize = 1024 * 1024 * 50 * 5
		
		)
public class MemberJoinController extends HttpServlet{

	


		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//비밀번호 찾기 질문 가져와야함
			List<PasswordVo> pwdQList = new PasswordController().getQuestion();
			
			
			req.setAttribute("pwdQList", pwdQList);

			req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
			//데이터꺼내기
			String id = req.getParameter("memberId");
			String pwd = req.getParameter("memberPwd1");
			String nick = req.getParameter("memberNick");
			String name = req.getParameter("memberName");
			String phone = req.getParameter("memberPhone");
			String []place = req.getParameterValues("memberPlace");
			String []category = req.getParameterValues("memberCate");
			String gender = req.getParameter("memberGender");
			String pq = req.getParameter("memberPQ");
			String pa = req.getParameter("memberPA");
			Part f = req.getPart("f");
			
			//파일업로드 start
			ProfileAttachVo profileVo = null;
			//파일 정보 디비에 저장하기 (파일이 있을 때)
			
			
			//데이터 뭉치기
			MemberVo vo = new MemberVo();
			
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
			vo.setName(name);
			vo.setPhone(phone);
			vo.setPlace(String.join(",", place));
			vo.setCatg(String.join(",", category));
			vo.setGender(gender);
			vo.setPq(pq);
			vo.setPa(pa);
			
			int result = new MemberService().join(vo);
			
			
			//화면선택
			if(result == 1) {
				
				resp.sendRedirect("/omjm/member/login");
			}else {
				System.out.println("회원가입실패");
			}
			
			
		}
}
