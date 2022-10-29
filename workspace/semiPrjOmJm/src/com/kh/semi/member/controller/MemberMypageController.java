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
import com.kh.semi.member.vo.MemberLikeVo;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/mypage")
public class MemberMypageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String x = req.getParameter("x");
		
		//찜한모임 가져오기 > 세션에 이미 있잖아?  찜한 모임 목록을 가져와야지 그러면 세션에 있는 찜한 모임을 가져와야겠네
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		String no = loginMember.getNo();
		String LG = loginMember.getLikeGroup();
		String [] LGArr = LG.split(",");
		
		MemberVo vo = new MemberVo();

		vo.setNo(no);
		vo.setLikeGroup(LG);
		vo.setlGArr(LGArr);
		
		//찜한 모임 페이지들어가기
//		세션의 로그인 정보를 받아 찜한 모임을 배열로 가져오고 조인해서 그룹의이름 가져오고 그룹의 카테고리를 가져와야한다.  
		//페이징처리
		 
		List<MemberLikeVo> likeVo = new MemberService().selectLikeGroupByNo(vo);  
		
		int listCount = likeVo.size();
		int currentPage = Integer.parseInt(req.getParameter("lgpno"));
		int pageLimit = 5; // 내가 정함
		int boardLimit = 10; // 내가 정함
		
		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
		int startPage = (currentPage -1) / pageLimit * pageLimit + 1 ;
		int endPage = startPage + pageLimit -1;
		
		if(endPage > maxPage) {
			endPage=maxPage;
		}
		PageVo pv = new PageVo();
		
		pv.setListCount(listCount);
		pv.setCurrentPage(currentPage);
		pv.setPageLimit(pageLimit);
		pv.setBoardLimit(boardLimit);
		pv.setMaxPage(maxPage);
		pv.setStartPage(startPage);
		pv.setEndPage(endPage);
		
		
		System.out.println(pv);
		
		req.setAttribute("likeVo", likeVo);
		req.setAttribute("x", x);
		req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
	}
	
	
}
