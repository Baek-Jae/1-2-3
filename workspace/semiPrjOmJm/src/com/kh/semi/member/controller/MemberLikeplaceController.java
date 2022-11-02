package com.kh.semi.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.common.PageVo;
import com.kh.semi.member.service.MemberService;
import com.kh.semi.member.vo.MemberVo;

import place.service.PlaceService;
import place.vo.PlaceVo;

@WebServlet(urlPatterns = "/member/likeplace")
public class MemberLikeplaceController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//관심지역 리스트 받아오기~ 번호 / 이름 
		List<PlaceVo> placeList = new PlaceService().selectPlace();
		req.setAttribute("placeList", placeList);
		
		//선택화면 보여주기
		req.getRequestDispatcher("/WEB-INF/views/member/likeplace.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		
		MemberVo vo = new MemberVo();
		
		String id = loginMember.getId();
		String pwd = loginMember.getPwd();
		String place = req.getParameter("likeplace");
		
		
		vo.setId(id);
		vo.setPlace(place);
		vo.setPwd(pwd);
		
		MemberVo editMember = new MemberService().editPlace(vo);
		req.setAttribute("pv", new PageVo());
		req.setAttribute("pvj", new PageVo());
		
		
		if(editMember != null) {
			session.setAttribute("loginMember", editMember);
			req.setAttribute("x", "4");
			req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
			System.out.println("정보수정성공~~");
		}else {
			System.out.println("정보수정실패");
		}
		
	}
	
}
