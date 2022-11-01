package kh.semi.omjm.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.vo.MemberVo;

import kh.semi.omjm.group.service.GroupService;
import kh.semi.omjm.group.vo.GroupMemberVo;
import kh.semi.omjm.group.vo.GroupVo;
import kh.semi.omjm.group.vo.OffGroupVo;
import kh.semi.omjm.group.vo.OffMemberVo;

@WebServlet(urlPatterns = "/offgroup/create")
public class CreateOffGroupController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/group/createOffGroup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		String no = loginMember.getNo();
		
		GroupVo gv = (GroupVo)req.getSession().getAttribute("groupInfo");
		String groupNo = gv.getNo();
		
		String name = req.getParameter("off_name");
		String date = req.getParameter("off_date");
		String userCnt = req.getParameter("user_cnt");
		String content = req.getParameter("off_content");
		
		OffGroupVo ofg = new OffGroupVo();
		ofg.setName(name);
		ofg.setOffDate(date);
		ofg.setUserCnt(userCnt);
		ofg.setContent(content);
		ofg.setLeaderNo(no);
		ofg.setGroupNo(groupNo);
		
		//오프라인 모임 생성
		int insertOffGroup = new GroupService().insertOffGroup(ofg);
		
		//오프라인멤버추가 
		String ono = new GroupService().selectOffNumber(ofg);
		OffMemberVo omv = new OffMemberVo();
		omv.setOffNo(ono);
		omv.setUserNo(no);
		
		int insertOffMember = new GroupService().insertOffMemberByOno(omv); 
		
		if(insertOffGroup*insertOffMember != 1 ) {
			resp.sendRedirect("/omjm");
			return;
		}
		
		resp.sendRedirect("/omjm/group/main?gno="+ groupNo);
		
	}
}
