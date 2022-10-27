package com.kh.semi.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
}
