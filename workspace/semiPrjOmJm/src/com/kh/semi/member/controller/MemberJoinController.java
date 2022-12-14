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
			String phone = req.getParameter("memberPhone");
			//임시
			String category = req.getParameter("memberCate");
			String place = req.getParameter("memberPlace");
			//String []category = req.getParameterValues("memberCate");
			String gender = req.getParameter("memberGender");
			String pq = req.getParameter("memberPQ");
			String pa = req.getParameter("memberPA");
			
			
			//데이터 뭉치기
			MemberVo vo = new MemberVo();
			
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
			vo.setPhone(phone);
			//vo.setPlace(String.join(",", place));
			//vo.setCatg(String.join(",", category));
			//임시
			vo.setPlace(place);
			vo.setGender(gender);
			vo.setPq(pq);
			vo.setPa(pa);
			
			int result = new MemberService().join(vo);
			
			
			//화면선택
			if(result == 1) {
				
				resp.sendRedirect("/omjm/member/login");
			}else {
				//비밀번호 찾기 질문 가져와야함
				List<PasswordVo> pwdQList = new PasswordController().getQuestion();
				
				req.setAttribute("pwdQList", pwdQList);
				req.setAttribute("alertMsg", "회원가입실패");
				
				req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
			}
			
			
		}
}
